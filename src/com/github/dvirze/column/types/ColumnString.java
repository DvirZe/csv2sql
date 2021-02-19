package com.github.dvirze.column.types;

import com.github.dvirze.column.ColumnBase;

public class ColumnString extends ColumnBase {

    public ColumnString(String name, ColumnType type, int pos) {
        super(name, type, pos);
    }

    @Override
    public String getWithType(String s) {
        return String.format("'%s'", s);
    }
}
