package com.github.dvirze.table;

public interface TableBuilder {

    TableBuilder readTableFromFile(String filePath);

    void saveInsertToFile(String filePath);

    String getTableName();

}