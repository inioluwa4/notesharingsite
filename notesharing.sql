drop table login cascade constraints;


-------Sequences-----

drop sequence login_seq;



create sequence login_seq nocache;




create table login(
    user_id varchar2(50) PRIMARY KEY,
    user_password varchar2(50)


);



-------USERS-------------
insert into login (user_id, user_password)
        values('user','password');
        
    
    
commit;