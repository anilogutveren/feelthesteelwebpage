insert into webusers(id, password, role, username) values(1, '12345', 'ADMIN', 'anil');
insert into webusers(id, password, role, username) values(2, '12345', 'USER', 'dominik');
insert into webusers(id, password, role, username) values(1, '12345', 'USER', 'axel');
insert into webusers(id, password, role, username) values(1, '12345', 'USER', 'rene');
insert into webusers(id, password, role, username) values(1, '12345', 'USER', 'patrick');

insert into musicians(id, name, equipments) values (1, 'Anil', 1);
insert into musicians(id, name, equipments) values (2, 'Axel', 2);

insert into equipment(id, instrument, musician_id) values (1, 'DRUMS', 1);
insert into equipment(id, instrument, musician_id) values (2, 'ElectroGuitar', 2);