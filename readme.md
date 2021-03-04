![CSV2SQL](csv2sql.png)

***Simple way to convert .csv files into .sql file***
***
This simple tool will convert .csv file in known format into sql file.
This tool build to solve a routine task at my workplace when we have to insert massive records into the DB.

# How to use
This tool build for using from the comment line by sending CSV file as parameter (see the format below)
For now, the tool only support in creating insert commends.

# Input parameter
The input parameter is CSV file with the name of the table as the name of the file.

The format of the CSV file should look like this:


|colName1(type)| colName2(type)|colName3(type)| ...
|--|--|--|--|
| col1row1data | col2row1data | col3row3data | ... |
| col1row2data | col2row2data | col3row2data | ... |


## Types
For creating valid insert text in the .sql file, you have to supply the type of the column.

The supported types are:
 - Strings
 - Int
 - Float

# Example
**input:**

Filename: table.csv

File data:

| col1 (string) | col2(float) |
|--|--|
|1234|1234|

**output**:

Filename: table.sql (with the same location as the .csv file)

file date:

```sql
insert into table (col1, col2)
values ('1234', 1234.0)
```
