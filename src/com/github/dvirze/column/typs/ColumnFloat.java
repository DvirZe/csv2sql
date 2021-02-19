package com.github.dvirze.column.typs;

import com.github.dvirze.column.ColumnBase;

public class ColumnFloat extends ColumnBase {

    public ColumnFloat(String name, ColumnType type, int pos) {
        super(name, type, pos);
    }

    @Override
    public Float getWithType(String s) {
        return Float.valueOf(s);
    }
}
