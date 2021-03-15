CREATE DATABASE demo;
USE demo;
CREATE TABLE emp(
    EMPNO    int(4) NOT NULL AUTO_INCREMENT,
    ENAME    varchar(10),
    JOB      varchar(9),
    MGR      int(4),
    HIREdate date,
    SAL      double(7, 2),
    COMM     double(7, 2),
    DEPTNO   int(4),
    PRIMARY KEY (EMPNO)
);
INSERT INTO emp
(EMPNO, ENAME, JOB, MGR, HIREdate, SAL, COMM, DEPTNO)
values
(null,'TOM','CODING',0,now(),1000.0,100.0,1);

UPDATE emp
SET ENAME=?,JOB=?,MGR=?,HIREdate=?,SAL=?,COMM=?,DEPTNO=?
WHERE EMPNO=?;

CREATE TABLE dept(
    DEPTNO INT(6) NOT NULL AUTO_INCREMENT,
    DNAME VARCHAR(20),
    LOCATION VARBINARY(20),
    PRIMARY KEY (DEPTNO)
);
INSERT INTO dept (DEPTNO, DNAME, LOCATION)
    VALUES (null,'java','北京');
INSERT INTO dept (DEPTNO, DNAME, LOCATION)
VALUES (null,'c++','天坛');
SELECT EMPNO,ENAME,DNAME FROM emp e left join dept d on e.DEPTNO = d.DEPTNO