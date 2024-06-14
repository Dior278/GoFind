package com.gofing.myapp.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class TrajetSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("lieu_depart", table, columnPrefix + "_lieu_depart"));
        columns.add(Column.aliased("lieu_arrivee", table, columnPrefix + "_lieu_arrivee"));
        columns.add(Column.aliased("date_depart", table, columnPrefix + "_date_depart"));
        columns.add(Column.aliased("heure_depart", table, columnPrefix + "_heure_depart"));
        columns.add(Column.aliased("place_disp", table, columnPrefix + "_place_disp"));
        columns.add(Column.aliased("chemin_photo_voiture", table, columnPrefix + "_chemin_photo_voiture"));
        columns.add(Column.aliased("conducteur", table, columnPrefix + "_conducteur"));
        columns.add(Column.aliased("liste_passager", table, columnPrefix + "_liste_passager"));

        columns.add(Column.aliased("application_user_id", table, columnPrefix + "_application_user_id"));
        columns.add(Column.aliased("utilisateur_id", table, columnPrefix + "_utilisateur_id"));
        return columns;
    }
}
