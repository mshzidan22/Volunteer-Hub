

INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('1', 'Cairo', '1990-05-15', '0', 'admin@gmail.com', 'Admin', '0108465421');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('2', 'Alexandria', '1988-08-20', '25', 'ahmed@gmail.com', 'Ahmed Shaban', '01091180634');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('3', 'Giza', '1995-03-10', '25', 'ziad@gmail.com', 'Ziad', '01091140634');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('4', 'Luxor', '1985-11-25', '25', 'karem@gmail.com', 'Karem', '01091280634');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('5', 'Aswan', '1992-07-08', '0', 'amin@gmail.com', 'Amin', '0109150634');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('6', 'Hurghada', '1998-01-30', '0', 'user6@gmail.com', 'User 6', '010184567');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('7', 'Sharm El Sheikh', '1993-12-12', '0', 'user7@gmail.com', 'User 7', '010565678');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('8', 'Mansoura', '1987-06-05', '0', 'user8@gmail.com', 'User 8', '010556789');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('9', 'Asyut', '1991-09-18', '0', 'user9@gmail.com', 'User 9', '010452390');
INSERT INTO users (id, address, birth, credits, email, name, phone) VALUES ('10', 'Tanta', '1986-04-03', '0', 'user10@gmail.com', 'User 10', '010778901');


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
VALUES ('1', '50', '2023-12-13 20:18:04.088', 'This is a test initiative description', 'Green Initiative A', 'Pending', '2');

-- Initiative 2
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('2', '30', '2024-12-14 15:45:00.000', 'Another initiative for a better planet', 'Eco Project B', 'Active', '3');

-- Initiative 3
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('3', '20', '2023-12-15 09:30:00.000', 'Let us make a positive impact on the environment', 'Green Action C', 'Pending', '4');

-- Initiative 4
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('4', '40', '2024-12-26 12:00:00.000', 'Supporting sustainability with initiative four', 'Eco Friendly D', 'Denied', '5');

-- Initiative 5
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('5', '25', '2023-12-27 18:20:00.000', 'Taking steps towards a cleaner world', 'Green Effort E', 'Active', '6');

-- Initiative 6
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('6', '35', '2023-12-28 10:05:00.000', 'Promoting environmental sustainability with initiative six', 'Eco Initiative F', 'Pending', '7');

-- Initiative 7
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('7', '45', '2024-12-29 14:30:00.000', 'Encouraging green practices through initiative seven', 'Green Project G', 'Pending', '8');

-- Initiative 8
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('8', '15', '2023-12-20 08:45:00.000', 'Join us in making a difference with initiative eight', 'Sustainable H', 'Active', '9');

-- Initiative 10
INSERT INTO initiative (id, credit_points, date_time, description, name, status, initiator_id)
VALUES ('10', '25', '2023-12-22 11:55:00.000', 'Initiative ten: Together for a greener planet', 'Green Initiative X', 'Denied', '4');


insert into initiative_volunteers (volunteering_jobs_id,volunteers_id) values ('5','2');
insert into initiative_volunteers (volunteering_jobs_id,volunteers_id) values ('5','3');
insert into initiative_volunteers (volunteering_jobs_id,volunteers_id) values ('5','4');


