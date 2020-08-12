insert into users(id, email, password, role, status) values (100,'test@test.com','Test12345','ADMINISTRATOR', 'ACCEPTED');
insert into users(id, email, password, role, status) values (101,'user@user.com', 'User123', 'ENDUSER', 'ACCEPTED');
insert into users(id, email, password, role, status) values (102,'agent@agent.com', 'Agent123', 'AGENT', 'ACCEPTED');
insert into users(id, email, password, role, status) values (120,'asd@test.com','Test1','ENDUSER', 'ACCEPTED');
insert into users(id, email, password, role, status) values (121,'kjk@test.com','Test2','ENDUSER', 'BLOCKED');
insert into users(id, email, password, role, status) values (122,'szpj@test.com','Test3','ENDUSER', 'REMOVED');
insert into users(id, email, password, role, status) values (123,'aaa@test.com','Test4','ENDUSER', 'AWAITING_APPROVAL');
insert into users(id, email, password, role, status) values (400,'gazda@email.com', 'gazda', 'ENDUSER', 'ACCEPTED');

insert into car_brand(id, brand) values (111, 'Audi');
insert into car_brand(id, brand) values (112, 'BMW');
insert into car_brand(id, brand) values (113, 'Opel');
insert into car_brand(id, brand) values (114, 'VW');
insert into car_brand(id, brand) values (115, 'Aston Martin');

insert into car_model(id, model) values (211, 'A6 S-line');
insert into car_model(id, model) values (212, 'Passat B8');
insert into car_model(id, model) values (213, 'Insignia');
insert into car_model(id, model) values (214, 'Polo');
insert into car_model(id, model) values (215, 'A7 Sportback');

insert into car_type(id, type) values (311, 'Minivan');
insert into car_type(id, type) values (312, 'SUV');
insert into car_type(id, type) values (313, 'Sport car');
insert into car_type(id, type) values (314, 'Wagon');



insert into transmission_type(id, serial_number, type) values (511, 'tr45', 'Automatik');
insert into transmission_type(id, serial_number, type) values (512, 'tr12-2k', 'Manuelni 6');
insert into transmission_type(id, serial_number, type) values (513, 'tr12-1k', 'Manuelni 5');

insert into client(id, ad_counter,address,email,first_name,jmbg,last_name,password,personalid,phone_number,pib,role,allow_reservation) values (500,0,'Asd 123','user@user.com','User','1234567893695','Useric','User123','','061111111111','','ENDUSER',true);
insert into client(id, ad_counter,address,email,first_name,jmbg,last_name,password,personalid,phone_number,pib,role,allow_reservation) values (501,0,'Dsa 321','agent@agent.com','Agent','','Agentic','Agent123','258963','061111111111','','AGENT',true);
insert into fuel_type(id, serial_number, type) values(277, '123b86', 'jeriDizel');
insert into fuel_type(id, serial_number, type) values(300, '253ac', 'benzin');
insert into fuel_type(id, serial_number, type) values(305, '152ca', 'plin');
insert into fuel_type(id, type, serial_number) values(411, 'BMB 95', '12b89k');
insert into fuel_type(id, type, serial_number) values(412, 'GDrive', '53-3k');
insert into fuel_type(id, type, serial_number) values(413, 'TNG', 'Xk-92k');

insert into transmission_type(id, serial_number, type) values(222, 'km32', 'automatik');

insert into car_type(id, type) values (333, 'city_car');
insert into car_type(id, type) values (334, 'minivan');
insert into car_type(id, type) values (335, 'wagon');

insert into car_model(id, model) values (555, 'A6 2016');
insert into car_model(id, model) values (556, 'Insignia 2020');
insert into car_model(id, model) values (557, 'S500 2014');
insert into car(id,average_rating,car_status,car_type_id,child_seats,collision_damage_waiver,discount,distance_allowed,fuel_type_id,mileage,transmission_type_id,car_model_id,car_brand_id, comment_count) values (100,2,'RENTED',333,0,'false',10,100,277,60000,222,555,113, 1);
insert into car(id,average_rating,car_status,car_type_id,child_seats,collision_damage_waiver,discount,distance_allowed,fuel_type_id,mileage,transmission_type_id,car_model_id,car_brand_id, comment_count) values (101,4,'RENTED',333,0,'false',10,100,277,80000,222,555,114, 3);
insert into ad(id,description,end_of_ad,is_active,place,profile_picture,start_of_ad,title,car_id,client_id,current_driver_id)values(600,'dobar','2020-06-19 13:42:00',true,'Sabac',0,'2020-06-14 16:42:00','Audi', 100,501,null);
insert into ad(id,description,end_of_ad,is_active,place,profile_picture,start_of_ad,title,car_id,client_id,current_driver_id)values(601,'dobar','2020-06-19 13:42:00',true,'Sabac',0,'2020-06-14 16:42:00','Audi', 101,501,null);
insert into comment(id,approved,comment,ad_id,commenter_id, car_rating) values(800,true,'odlican',600,101,2);
insert into message(id, message_time, subject, text, receiver_id, sender_id) values(111, '2020-07-16 13:11:00', 'Proba', 'Kolko je ovo dobra', 122, 123);
insert into message(id, message_time, subject, text, receiver_id, sender_id) values(112, '2020-07-01 14:11:00', 'Proba2', 'Kolko je ovo dobra fora', 123, 122);

