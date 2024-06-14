package com.gofing.myapp.repository;

import com.gofing.myapp.domain.PieceALouer;
import com.gofing.myapp.repository.rowmapper.ApplicationUserRowMapper;
import com.gofing.myapp.repository.rowmapper.PieceALouerRowMapper;
import com.gofing.myapp.repository.rowmapper.UtilisateurRowMapper;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Condition;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoinCondition;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.data.relational.repository.support.MappingRelationalEntityInformation;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC custom repository implementation for the PieceALouer entity.
 */
@SuppressWarnings("unused")
class PieceALouerRepositoryInternalImpl extends SimpleR2dbcRepository<PieceALouer, Long> implements PieceALouerRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final ApplicationUserRowMapper applicationuserMapper;
    private final UtilisateurRowMapper utilisateurMapper;
    private final PieceALouerRowMapper piecealouerMapper;

    private static final Table entityTable = Table.aliased("piece_a_louer", EntityManager.ENTITY_ALIAS);
    private static final Table applicationUserTable = Table.aliased("application_user", "applicationUser");
    private static final Table utilisateurTable = Table.aliased("utilisateur", "utilisateur");

    public PieceALouerRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        ApplicationUserRowMapper applicationuserMapper,
        UtilisateurRowMapper utilisateurMapper,
        PieceALouerRowMapper piecealouerMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(PieceALouer.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.applicationuserMapper = applicationuserMapper;
        this.utilisateurMapper = utilisateurMapper;
        this.piecealouerMapper = piecealouerMapper;
    }

    @Override
    public Flux<PieceALouer> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<PieceALouer> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = PieceALouerSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(ApplicationUserSqlHelper.getColumns(applicationUserTable, "applicationUser"));
        columns.addAll(UtilisateurSqlHelper.getColumns(utilisateurTable, "utilisateur"));
        SelectFromAndJoinCondition selectFrom = Select.builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(applicationUserTable)
            .on(Column.create("application_user_id", entityTable))
            .equals(Column.create("id", applicationUserTable))
            .leftOuterJoin(utilisateurTable)
            .on(Column.create("utilisateur_id", entityTable))
            .equals(Column.create("id", utilisateurTable));
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, PieceALouer.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<PieceALouer> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<PieceALouer> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private PieceALouer process(Row row, RowMetadata metadata) {
        PieceALouer entity = piecealouerMapper.apply(row, "e");
        entity.setApplicationUser(applicationuserMapper.apply(row, "applicationUser"));
        entity.setUtilisateur(utilisateurMapper.apply(row, "utilisateur"));
        return entity;
    }

    @Override
    public <S extends PieceALouer> Mono<S> save(S entity) {
        return super.save(entity);
    }
}
