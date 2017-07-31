SHOW DATABASES ;
DROP DATABASE IF EXISTS db_1702B;
CREATE DATABASE db_1702B;

DROP TABLE IF EXISTS db_1702B.student;
CREATE TABLE db_1702B.student(
  stuid INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
  stuname CHAR(10) NOT NULL ,
  stuclass CHAR(10)
);

  DROP TABLE IF EXISTS db_1702B.result;
CREATE TABLE db_1702B.result(
  id INT PRIMARY KEY NOT NULL ,
  java INT NOT NULL ,
  mysql INT NOT NULL ,
  oracle INT NOT NULL ,
  studentid INT
);

ALTER TABLE db_1702B.result
    ADD CONSTRAINT
  result_fk_studentid
FOREIGN KEY (studentid)
  REFERENCES db_1702B.student(stuid);

INSERT INTO db_1702B.student VALUE (NULL ,'小王','1班');
INSERT INTO db_1702B.student VALUE (NULL ,'小杜','2班');
INSERT INTO db_1702B.student VALUE (NULL ,'小杨','3班');

INSERT INTO db_1702B.result VALUE (1,100,45,78,1);
INSERT INTO db_1702B.result VALUE (2,89,67,76,2);
INSERT INTO db_1702B.result VALUE (3,45,45,45,3);

SELECT s.stuname,r.java
FROM db_1702B.student s INNER JOIN db_1702B.result r
ON s.stuid = r.studentid
WHERE r.java = 100;

SELECT s.stuname,r.oracle
FROM db_1702B.student s INNER JOIN db_1702B.result r
ON s.stuid = r.studentid
WHERE r.oracle < 60;