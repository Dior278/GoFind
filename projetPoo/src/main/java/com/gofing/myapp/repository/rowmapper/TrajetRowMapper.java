package com.gofing.myapp.repository.rowmapper;

import com.gofing.myapp.domain.Trajet;
import io.r2dbc.spi.Row;
import java.time.Instant;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Trajet}, with proper type conversions.
 */
@Service
public class TrajetRowMapper implements BiFunction<Row, String, Trajet> {

    private final ColumnConverter converter;

    public TrajetRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Trajet} stored in the database.
     */
    @Override
    public Trajet apply(Row row, String prefix) {
        Trajet entity = new Trajet();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setLieuDepart(converter.fromRow(row, prefix + "_lieu_depart", String.class));
        entity.setLieuArrivee(converter.fromRow(row, prefix + "_lieu_arrivee", String.class));
        entity.setDateDepart(converter.fromRow(row, prefix + "_date_depart", Instant.class));
        entity.setHeureDepart(converter.fromRow(row, prefix + "_heure_depart", Instant.class));
        entity.setPlaceDisp(converter.fromRow(row, prefix + "_place_disp", Integer.class));
        entity.setCheminPhotoVoiture(converter.fromRow(row, prefix + "_chemin_photo_voiture", String.class));
        entity.setConducteur(converter.fromRow(row, prefix + "_conducteur", String.class));
        entity.setListePassager(converter.fromRow(row, prefix + "_liste_passager", String.class));
        entity.setApplicationUserId(converter.fromRow(row, prefix + "_application_user_id", Long.class));
        entity.setUtilisateurId(converter.fromRow(row, prefix + "_utilisateur_id", Long.class));
        return entity;
    }
}
