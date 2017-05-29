CREATE table BEGINNER(SEQ number primary key, MEAN varchar2(60), WORD varchar2(10));
CREATE SEQUENCE beginner_seq;
CREATE table INTERMEDIATE(SEQ number primary key, MEAN varchar2(60), WORD varchar2(10));
CREATE SEQUENCE intermediate_seq;
CREATE table ADVANCED(SEQ number primary key, MEAN varchar2(100), WORD varchar2(20));
CREATE SEQUENCE advanced_seq;
CREATE table IMAGESOUND(SEQ number primary key, IMAGE blob, SOUND blob);
CREATE SEQUENCE imagesound_seq;


Create Table grade (id varchar2(20),
HIREDATE date CONSTRAINT grade_HIREDATE_NN NOT null,
SCORE number(9) CONSTRAINT grade_score_NN NOT NULL,
LEVELTEST varchar2(20) CONSTRAINT grade_level_NN NOT NULL);

CREATE table RESULT (ID varchar2(20),
HIREDATE date CONSTRAINT RESULT_HIREDATE_NN NOT null, 
Score number(10) CONSTRAINT RESULT_SCORE_NN NOT null,
resultTime number(7) CONSTRAINT RESULT_RESULTTIME_NN NOT NULL,
LEVELTEST varchar2(20) CONSTRAINT grade_LEVELTEST_NN NOT NULL );

Create table HumanChange(id varchar2(20), password varchar2(20));

Create Table Human (id varchar2(20) CONSTRAINT Human_id_PK primary key,
password varchar2(20) CONSTRAINT Human_password_NN not null, 
name varchar2(20) CONSTRAINT Human_name_NN not null,
age number(3) CONSTRAINT Human_age_NN not null, 
 gender number(1) CONSTRAINT Human_gender_NN NOT NULL CONSTRAINT Human_gender_CK check (gender in(1,2)));
