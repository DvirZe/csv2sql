package com.github.dvirze.column;

import com.github.dvirze.column.typs.ColumnType;

public abstract class ColumnBase implements Column {

    private String name;
    private ColumnType type;
    private int pos;

    public ColumnBase(String name, ColumnType type, int pos) {
        this.name = name;
        this.type = type;
        this.pos = pos;
    }

    public String getColumnName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public ColumnType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ColumnBase{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", pos=" + pos +
                '}';
    }
}
