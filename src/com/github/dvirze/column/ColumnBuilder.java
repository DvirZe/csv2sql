package com.github.dvirze.column;

import com.github.dvirze.column.types.ColumnFloat;
import com.github.dvirze.column.types.ColumnInt;
import com.github.dvirze.column.types.ColumnString;
import com.github.dvirze.column.types.ColumnType;

public class ColumnBuilder {

    public static Column buildColumnObject(String columnName, String type, int pos) {
        switch (ColumnType.valueOf(type.toUpperCase())) {
            case STRING:
                return new ColumnString(columnName, ColumnType.STRING, pos);
            case INT:
                return new ColumnInt(columnName, ColumnType.INT, pos);
            case FLOAT:
                return new ColumnFloat(columnName, ColumnType.FLOAT, pos);
            default:
                return null;
        }
    }
}
