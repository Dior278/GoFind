package com.gofing.myapp.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class ApplicationUserSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("additional_field", table, columnPrefix + "_additional_field"));

        columns.add(Column.aliased("internal_user_id", table, columnPrefix + "_internal_user_id"));
        return columns;
    }
}
