BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('brewer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);

INSERT INTO brewery (brewery_name,website,open_hour,close_hour,history) VALUES ('Immigrant Son', 'testbrewery.com', '5:00', '1:00', 'Immigrated sons from other place.');

INSERT INTO brewer (brewery_id,user_id) VALUES (1,3);

INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'Good Shit','picture of beer','It''s good shit','6.9','IPA',true);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (1,1);

INSERT INTO user_contact (user_id,email,phone,user_address) VALUES (1,'email@email.com','1111111111','123 Place St.');

INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (1, 'brewery@email.com', '2222222222', '456 Location Ave.');

COMMIT TRANSACTION;
