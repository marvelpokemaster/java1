DROP DATABASE IF EXISTS mydatabase;
CREATE DATABASE mydatabase;

USE mydatabase;

CREATE TABLE mytable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50),
    password VARCHAR(50),
    name VARCHAR(50),
    roll VARCHAR(50),
    school VARCHAR(50),
    specialisation VARCHAR(50),
    fee_initial INT,
    sgpa1 INT,
    sgpa2 INT,
    lib DATE,   
);
