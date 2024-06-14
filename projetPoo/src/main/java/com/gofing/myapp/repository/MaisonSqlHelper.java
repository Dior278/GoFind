package com.gofing.myapp.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class MaisonSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("adresse", table, columnPrefix + "_adresse"));
        columns.add(Column.aliased("chemin_photo_maison", table, columnPrefix + "_chemin_photo_maison"));
        columns.add(Column.aliased("nbre_piece", table, columnPrefix + "_nbre_piece"));
        columns.add(Column.aliased("disponibilite", table, columnPrefix + "_disponibilite"));
        columns.add(Column.aliased("prix_location", table, columnPrefix + "_prix_location"));
        columns.add(Column.aliased("proprietaire", table, columnPrefix + "_proprietaire"));

        columns.add(Column.aliased("application_user_id", table, columnPrefix + "_application_user_id"));
        columns.add(Column.aliased("utilisateur_id", table, columnPrefix + "_utilisateur_id"));
        return columns;
    }
}
