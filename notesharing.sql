drop table uzer cascade constraints;


-------Sequences-----

drop sequence login_seq;



create sequence login_seq nocache;




create table employee(
    employee_id number(3) PRIMARY KEY,
    employee_name varchar2(20)
);

create table sales(
    sales_id number(3) PRIMARY KEY,
    emp_id number(3),
    sales_amt number(5),
    sales_date varchar(50),
    foreign key (emp_id) references employee(employee_id)


);



-------USERS-------------
insert into login (user_id, firstname, lastname, username, user_password)
        values(1,'Ibrahim', 'Hamadi', 'IHamadi', 'password');
        
    
    
commit;