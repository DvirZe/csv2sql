package com.github.dvirze.table;

import com.github.dvirze.column.Column;

import java.util.ArrayList;

interface Table {

    void readTableFromFile(String filePath);

    String getTableName();

    void saveInsertToFile(String filePath);

    void fillColumnsArray(String[] columnsLine);

    String setDataRowForWithType(String Line);

    String buildColumnsLine(ArrayList<Column> columns);


}
