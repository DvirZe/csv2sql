package com.github.dvirze;

import com.github.dvirze.table.TableBuilderImpl;

public class Main {

    /*
       Args: CSV file path

       CSV File Format
       File Name: SQL Table Name
       Data:
            First row is the columns name
            the other rows is the data

        +------------+------------+------------+------------+
        | Col1(type) | Col2(type) | Col3(type) | Col4(type) |
        +------------+------------+------------+------------+
        |         11 |         12 |         13 |         14 |
        |         21 |         22 |         23 |         24 |
        |         31 |         32 |         33 |         34 |
        |         41 |         42 |         43 |         44 |
        +------------+------------+------------+------------+
        type = text, integer, float
     */

    public static void main(String[] args) {

        String filePath = args[0];

        new TableBuilderImpl()
                .readTableFromFile(filePath)
                .saveInsertToFile(args[0].replaceAll("\\.(CSV|csv)", ".sql"));
    }

}