package com.github.dvirze.table;

import com.github.dvirze.column.Column;
import com.github.dvirze.column.ColumnBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class TableBase implements Table {

    private String tableName;
    private int columnCount;
    private ArrayList<Column> columns;
    private ArrayList<String> dataRows;
    private Boolean errFlag = false;

    public TableBase() {
        this.columns = new ArrayList<>();
        this.dataRows = new ArrayList<>();
    }

    @Override
    public void readTableFromFile(String filePath) {
        this.tableName = filePath.substring(filePath.lastIndexOf('\\') + 1, filePath.length() - 4);
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Create object for each column
            fillColumnsArray(scanner.nextLine().split(","));
            this.columnCount = columns.size();

            // Save each row and convert by column type
            while (scanner.hasNext()) {
                dataRows.add(setDataRowForWithType(scanner.nextLine()));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println(String.format("The file %s not found, please fix it and try again.", filePath));
            errFlag = true;
        }
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public void saveInsertToFile(String filePath) {
        if (!errFlag) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

                // Create base insert line
                String baseLine = String.format("insert into %s (%s)\n", tableName, buildColumnsLine(columns));

                for (String line : dataRows) {
                    bufferedWriter.write(baseLine);
                    bufferedWriter.write(String.format("values (%s)\n\n", line));
                }

                bufferedWriter.close();

                System.out.println(String.format("Table %s has finished successfully", this.tableName));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void fillColumnsArray(String[] columnsLine) {
        for (int i = 0; i < columnsLine.length; i++) {
            String columnName = columnsLine[i].substring(0, columnsLine[i].indexOf('('));
            String columnType = columnsLine[i].substring(columnsLine[i].indexOf('(') + 1, columnsLine[i].length() - 1);
            columns.add(ColumnBuilder.buildColumnObject(columnName, columnType, i));
        }
    }

    @Override
    public String setDataRowForWithType(String Line) {
        String[] rowData = Line.split(",");
        StringBuilder row = new StringBuilder(100);
        for (int i = 0; i < columnCount; i++) {
            row.append(columns.get(i).getWithType(rowData[i])).append(", ");
        }
        return row.substring(0, row.lastIndexOf(","));
    }

    @Override
    public String buildColumnsLine(ArrayList<Column> columns) {
        StringBuilder stringBuilder = new StringBuilder(columnCount * 10);
        columns.forEach(column -> stringBuilder.append(column.getColumnName()).append(", "));
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

}
