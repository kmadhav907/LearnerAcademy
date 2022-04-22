Create table classes (id int auto_increment primary key, section int, teacher int, subject int, time varchar(50));
Create table students(id int auto_increment primary key, fname varchar(50), lname varchar(50), age int, class int);
Create table subjects(id int auto_increment primary key, name varchar(50));
Create table teachers(id int auto_increment primary key, fname varchar(50), lname varchar(50), age int, subjectID int);