package com.gofing.myapp.repository.rowmapper;

import com.gofing.myapp.domain.PieceALouer;
import io.r2dbc.spi.Row;
import java.math.BigDecimal;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link PieceALouer}, with proper type conversions.
 */
@Service
public class PieceALouerRowMapper implements BiFunction<Row, String, PieceALouer> {

    private final ColumnConverter converter;

    public PieceALouerRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link PieceALouer} stored in the database.
     */
    @Override
    public PieceALouer apply(Row row, String prefix) {
        PieceALouer entity = new PieceALouer();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setAdresse(converter.fromRow(row, prefix + "_adresse", String.class));
        entity.setCheminPhotoPiece(converter.fromRow(row, prefix + "_chemin_photo_piece", String.class));
        entity.setDisponibilite(converter.fromRow(row, prefix + "_disponibilite", Boolean.class));
        entity.setPrixLocation(converter.fromRow(row, prefix + "_prix_location", BigDecimal.class));
        entity.setProprietaire(converter.fromRow(row, prefix + "_proprietaire", String.class));
        entity.setApplicationUserId(converter.fromRow(row, prefix + "_application_user_id", Long.class));
        entity.setUtilisateurId(converter.fromRow(row, prefix + "_utilisateur_id", Long.class));
        return entity;
    }
}
