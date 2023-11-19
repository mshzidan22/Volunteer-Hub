

insert into users (id,address,birth,credits,email,name,phone) values ('1','abotable','2002-09-23','0','admin@gmail.com','Admin','0108465421');
insert into users (id,address,birth,credits,email,name,phone) values ('2','abotable','2002-09-23','25','ahemd@gmail.com','ahmed shaban','01091180634');
insert into users (id,address,birth,credits,email,name,phone) values ('3','abotable','2002-09-23','25','ahemd3@gmail.com','Ziad','01091140634');
insert into users (id,address,birth,credits,email,name,phone) values ('4','abotable','2002-09-23','25','ahemd4@gmail.com','Karem','01091280634');
insert into users (id,address,birth,credits,email,name,phone) values ('5','abotable','2002-09-23','0','ahemd5@gmail.com','Amin','0109150634');
insert into users (id, address, birth, credits, email, name, phone) values ('6', 'abotable', '2002-09-23', '0', 'user6@gmail.com', 'User 6', '010184567');
insert into users (id, address, birth, credits, email, name, phone) values ('7', 'abotable', '2002-09-23', '0', 'user7@gmail.com', 'User 7', '010565678');
insert into users (id, address, birth, credits, email, name, phone) values ('8', 'abotable', '2002-09-23', '0', 'user8@gmail.com', 'User 8', '010556789');
insert into users (id, address, birth, credits, email, name, phone) values ('9', 'abotable', '2002-09-23', '0', 'user9@gmail.com', 'User 9', '010452390');
insert into users (id, address, birth, credits, email, name, phone) values ('10', 'abotable', '2002-09-23', '0', 'user10@gmail.com', 'User 10', '010778901');


insert into account (id,password,role,username,user_id) values ('1','$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq','ADMIN','admin','1');
insert into account (id,password,role,username,user_id) values ('2','$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq','USER','ahmed','2');
insert into account (id,password,role,username,user_id) values ('3','$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq','USER','ziad','3');
insert into account (id,password,role,username,user_id) values ('4','$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq','USER','karem','4');
insert into account (id,password,role,username,user_id) values ('5','$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq','USER','amin','5');
insert into account (id, password, role, username, user_id) values ('6', '$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq', 'USER', 'user6', '6');
insert into account (id, password, role, username, user_id) values ('7', '$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq', 'USER', 'user7', '7');
insert into account (id, password, role, username, user_id) values ('8', '$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq', 'USER', 'user8', '8');
insert into account (id, password, role, username, user_id) values ('9', '$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq', 'USER', 'user9', '9');
insert into account (id, password, role, username, user_id) values ('10', '$2a$10$2ItTUELaSShJN3aMonkSkuLAv0OYnlaX9N2cWc85uh2bcVFALgvfq', 'USER', 'user10', '10');


-- Initiative 1
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('1', '50', '2023-11-13 20:18:04.088', 'This is a test initiative description', 'Green Initiative A', 'Pending', '2');

-- Initiative 2
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('2', '30', '2023-12-14 15:45:00.000', 'Another initiative for a better planet', 'Eco Project B', 'Active', '3');

-- Initiative 3
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('3', '20', '2023-12-15 09:30:00.000', 'Let us make a positive impact on the environment', 'Green Action C', 'Pending', '4');

-- Initiative 4
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('4', '40', '2023-12-26 12:00:00.000', 'Supporting sustainability with initiative four', 'Eco Friendly D', 'Denied', '5');

-- Initiative 5
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('5', '25', '2023-12-27 18:20:00.000', 'Taking steps towards a cleaner world', 'Green Effort E', 'Active', '6');

-- Initiative 6
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('6', '35', '2023-12-28 10:05:00.000', 'Promoting environmental sustainability with initiative six', 'Eco Initiative F', 'Pending', '7');

-- Initiative 7
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('7', '45', '2023-12-29 14:30:00.000', 'Encouraging green practices through initiative seven', 'Green Project G', 'Pending', '8');

-- Initiative 8
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('8', '15', '2023-12-20 08:45:00.000', 'Join us in making a difference with initiative eight', 'Sustainable H', 'Active', '9');

-- Initiative 10
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('10', '25', '2023-12-22 11:55:00.000', 'Initiative ten: Together for a greener planet', 'Green Initiative X', 'Denied', '4');
insert into initiative_volunteers (volunteering_jobs_id,volunteers_id) values ('5','2');
insert into initiative_volunteers (volunteering_jobs_id,volunteers_id) values ('5','3');
insert into initiative_volunteers (volunteering_jobs_id,volunteers_id) values ('5','4');


