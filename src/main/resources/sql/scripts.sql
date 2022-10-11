insert into user_table (user_id, password, role, name) values(1,'54321','ROLE_ADMIN','Anil');
insert into user_table (user_id, password, role, name) values(2,'12345','ROLE_USER','Dominik');
insert into user_table (user_id, password, role, name) values(3,'12345','ROLE_USER','Axel');
insert into user_table (user_id, password, role, name) values(4,'12345','ROLE_USER','Rene');
insert into user_table (user_id, password, role, name) values(5,'12345','ROLE_USER','Patrick');

INSERT INTO authorities(role, user_id) values ('WRITE', 1);
INSERT INTO authorities(role, user_id) values ('READ' , 2);


/*INSERT INTO roles(id, name) values (1, 'USER');
INSERT INTO roles(id, name) values (2, 'ADMIN');*/