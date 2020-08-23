drop table login cascade constraints;
drop table course cascade constraints;
drop table school cascade constraints;



-------Sequences-----

drop sequence login_seq;
drop sequence course_seq;
drop sequence school_seq;





create sequence login_seq nocache;
create sequence course_seq nocache;
create sequence school_seq nocache;






create table login(
    user_id number(3) PRIMARY KEY,
    username varchar(10),
    user_password varchar2(50),
    firstname varchar2(50),
    lastname varchar2(50),
    dob date,
    gender varchar2(50),
    email varchar2(50),
    school_name varchar2(100),
    school_city varchar(100),
    school_state varchar(2),
    education_level varchar2(50)

);
create table school(
    school_id number(3) PRIMARY KEY,
    school_name varchar(10),
    school_city varchar2(50),
    school_state varchar2(2)
);
create table course(
    course_id varchar2(50) PRIMARY KEY,
    title varchar(10),
    instructor varchar2(50),
    course_days varchar2(50),
    course_start TIMESTAMP,
    course_user_id number(3),
    course_school_id number(3),
    foreign key (course_user_id) references login(user_id),
    foreign key (course_school_id) references school(school_id)

);

-------USERS-------------
insert into login (user_id, username, user_password)
        values(1,'user','password');
        
    
    
commit;