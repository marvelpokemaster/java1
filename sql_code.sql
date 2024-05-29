CREATE DATABASE AmritaDB;

USE AmritaDB;

CREATE TABLE students (
    roll_no VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    school VARCHAR(50),
    branch VARCHAR(50),
    sgpa1 DOUBLE,
    sgpa2 DOUBLE,
    beforefee DOUBLE
);
