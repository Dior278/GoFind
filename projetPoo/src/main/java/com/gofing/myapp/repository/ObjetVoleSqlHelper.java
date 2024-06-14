package com.gofing.myapp.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class ObjetVoleSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("nom", table, columnPrefix + "_nom"));
        columns.add(Column.aliased("type", table, columnPrefix + "_type"));
        columns.add(Column.aliased("date_vole", table, columnPrefix + "_date_vole"));
        columns.add(Column.aliased("chemin_photo_objet", table, columnPrefix + "_chemin_photo_objet"));
        columns.add(Column.aliased("chemin_facture", table, columnPrefix + "_chemin_facture"));
        columns.add(Column.aliased("etat", table, columnPrefix + "_etat"));
        columns.add(Column.aliased("adresse_proprietaire", table, columnPrefix + "_adresse_proprietaire"));

        columns.add(Column.aliased("application_user_id", table, columnPrefix + "_application_user_id"));
        columns.add(Column.aliased("utilisateur_id", table, columnPrefix + "_utilisateur_id"));
        return columns;
    }
}
