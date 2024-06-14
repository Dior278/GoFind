package com.gofing.myapp.repository.rowmapper;

import com.gofing.myapp.domain.ApplicationUser;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link ApplicationUser}, with proper type conversions.
 */
@Service
public class ApplicationUserRowMapper implements BiFunction<Row, String, ApplicationUser> {

    private final ColumnConverter converter;

    public ApplicationUserRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link ApplicationUser} stored in the database.
     */
    @Override
    public ApplicationUser apply(Row row, String prefix) {
        ApplicationUser entity = new ApplicationUser();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setAdditionalField(converter.fromRow(row, prefix + "_additional_field", Integer.class));
        entity.setInternalUserId(converter.fromRow(row, prefix + "_internal_user_id", Long.class));
        return entity;
    }
}
