package com.gofing.myapp.repository.rowmapper;

import com.gofing.myapp.domain.ObjetVole;
import io.r2dbc.spi.Row;
import java.time.Instant;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link ObjetVole}, with proper type conversions.
 */
@Service
public class ObjetVoleRowMapper implements BiFunction<Row, String, ObjetVole> {

    private final ColumnConverter converter;

    public ObjetVoleRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link ObjetVole} stored in the database.
     */
    @Override
    public ObjetVole apply(Row row, String prefix) {
        ObjetVole entity = new ObjetVole();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setNom(converter.fromRow(row, prefix + "_nom", String.class));
        entity.setType(converter.fromRow(row, prefix + "_type", String.class));
        entity.setDateVole(converter.fromRow(row, prefix + "_date_vole", Instant.class));
        entity.setCheminPhotoObjet(converter.fromRow(row, prefix + "_chemin_photo_objet", String.class));
        entity.setCheminFacture(converter.fromRow(row, prefix + "_chemin_facture", String.class));
        entity.setEtat(converter.fromRow(row, prefix + "_etat", String.class));
        entity.setAdresseProprietaire(converter.fromRow(row, prefix + "_adresse_proprietaire", String.class));
        entity.setApplicationUserId(converter.fromRow(row, prefix + "_application_user_id", Long.class));
        entity.setUtilisateurId(converter.fromRow(row, prefix + "_utilisateur_id", Long.class));
        return entity;
    }
}
