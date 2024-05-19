CREATE DATABASE AmritaDB;

USE AmritaDB;

CREATE TABLE students (
    roll_no VARCHAR(20) PRIMARY KEY,
    school VARCHAR(50),
    branch VARCHAR(50),
    sgpa1 DOUBLE,
    sgpa2 DOUBLE,
    beforeFee DOUBLE
);
