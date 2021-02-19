package com.github.dvirze.table;

public class TableBuilderImpl implements TableBuilder {

    TableBase tableBase;

    @Override
    public TableBuilder readTableFromFile(String filePath) {
        tableBase = new TableBase();
        tableBase.readTableFromFile(filePath);
        return this;
    }

    @Override
    public void saveInsertToFile(String filePath) {
        if (tableBase == null) {
            System.err.println("The table not initialized.");
        } else {
            tableBase.saveInsertToFile(filePath);
        }
    }

    @Override
    public String getTableName() {
        return tableBase.getTableName();
    }

}
