INSERT INTO app_user (authority, email, enabled , username, password, first_name, last_name) VALUES ('ROLE_ADMIN', 'EMAIL1@MAIL.RU','true','USERNAME1','$2a$10$4fR.sc.W92v.UqltCmUIcu1IkMtncGNfmIBk/hsciTcNA2Af68w46','FIRST NAME1', 'LAST NAME1');
INSERT INTO app_user (authority, email, enabled , username, password, first_name, last_name) VALUES ('ROLE_USER', 'EMAIL2@MAIL.RU','true','USERNAME2','$2a$10$4fR.sc.W92v.UqltCmUIcu1IkMtncGNfmIBk/hsciTcNA2Af68w46','FIRST NAME2', 'LAST NAME2');
INSERT INTO app_user (authority, email, enabled , username, password, first_name, last_name) VALUES ('ROLE_TRAINER', 'EMAIL3@MAIL.RU','true','USERNAME3','$2a$10$4fR.sc.W92v.UqltCmUIcu1IkMtncGNfmIBk/hsciTcNA2Af68w46','FIRST NAME3', 'LAST NAME3');

INSERT INTO room (area) VALUES (123);
INSERT INTO room_request (requester_id, room_id, approved) VALUES (3,1,'false');
INSERT INTO trainer_request (requester_id, trainer_id, approved) VALUES (2,3,'false');
