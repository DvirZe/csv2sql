package com.github.dvirze.column.types;

import com.github.dvirze.column.ColumnBase;

public class ColumnNone extends ColumnBase {

    public ColumnNone(String name, ColumnType type, int pos) {
        super(name, type, pos);
    }

    @Override
    public String getWithType(String s) {
        return String.format("%s", s);
    }
}
