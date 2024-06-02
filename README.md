# java1

Javaproject.java      : is the main class

Amrita.java           : is amrita class ,top abstract class

MyDatabaseHelper.java : is the class which helps you with the sql code given in sql_code.sql
                        (help_display is just instructions for implementation)
                        
GUI_linker.java       : is the class which links to the UI (login,register), the main class deals with display_gui part


The class MyDatabaseHelper has 4 functions:
- saveStudentToDatabase()    : it updates table by adding a whole new row (new student)
- selectRow()    : it gets a student detail by providing email to it
- updateRow()    : it modifies student detail for a given email
- isRollNoExists()  : it checks if a given roll exists in the database

Date format : `yyyy-mm-dd`
