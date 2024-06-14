package com.gofing.myapp.repository.rowmapper;

import com.gofing.myapp.domain.Maison;
import io.r2dbc.spi.Row;
import java.math.BigDecimal;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Maison}, with proper type conversions.
 */
@Service
public class MaisonRowMapper implements BiFunction<Row, String, Maison> {

    private final ColumnConverter converter;

    public MaisonRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Maison} stored in the database.
     */
    @Override
    public Maison apply(Row row, String prefix) {
        Maison entity = new Maison();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setAdresse(converter.fromRow(row, prefix + "_adresse", String.class));
        entity.setCheminPhotoMaison(converter.fromRow(row, prefix + "_chemin_photo_maison", String.class));
        entity.setNbrePiece(converter.fromRow(row, prefix + "_nbre_piece", Integer.class));
        entity.setDisponibilite(converter.fromRow(row, prefix + "_disponibilite", Boolean.class));
        entity.setPrixLocation(converter.fromRow(row, prefix + "_prix_location", BigDecimal.class));
        entity.setProprietaire(converter.fromRow(row, prefix + "_proprietaire", String.class));
        entity.setApplicationUserId(converter.fromRow(row, prefix + "_application_user_id", Long.class));
        entity.setUtilisateurId(converter.fromRow(row, prefix + "_utilisateur_id", Long.class));
        return entity;
    }
}
