package com.github.dvirze.column.typs;

import com.github.dvirze.column.ColumnBase;

public class ColumnInt extends ColumnBase {

    public ColumnInt(String name, ColumnType type, int pos) {
        super(name, type, pos);
    }

    @Override
    public Integer getWithType(String s) {
        return Integer.valueOf(s);
    }
}
