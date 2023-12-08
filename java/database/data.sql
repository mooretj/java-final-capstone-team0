BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('brewer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Immigrant Son', 'https://immigrantsonbrewing.com/', 'https://www.cleveland.com/resizer/YfH5HU8fR1I34UEC8EontY6nK2o=/arc-anglerfish-arc2-prod-advancelocal/public/GGK433FUAZHENAWO2ZUHT5ZMYA.jpg', 'Immigrant Son is not just about a place, a thing, or a single person, it is an ongoing tale about ALL of us as one coming to the table to break bread, share the best of ourselves and what we’ve learned along the way while toasting to the road ahead. Meticulously weaving traditional classic recipes with imaginative flair, we will share our tale with you in the most authentic way we know how to share: at our table, in a glass, and in a can.');

INSERT INTO brewer (brewery_id,user_id) VALUES (1,3);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'American Pilsner','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/pilsner-500x650.png','Our American Pilsner is a crisp, bright, easy drinking lager with subtle hoppiness. German inspired and very crushable.','4.5','Pilsner',true);

INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'IPA','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/ipa-500x650.png','Our ISB IPA is YOUR Midwest IPA. Pouring pale orange in color, this IPA is all about hop flavor, aroma, and bitterness. Our hop blend gives generous notes of citrus, pine,& stone fruit supported by a light malt backbone and dry finish – Like a walk through the woods of Ohio.','7','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating)
                    VALUES (1,1,'Natural perfection in a glass',
                    	   'Alpine Amber Harmony is a symphony of malt and hops that dance together in perfect balance. The amber hues mirror the scenic mountains, and each sip is a serene hike through flavor.',
                    	   5);

INSERT INTO review (user_id, beer_id, title, body, rating)
                    VALUES (1,1,'Natural perfection in a glass',
                    	   'Alpine Amber Harmony is a symphony of malt and hops that dance together in perfect balance. The amber hues mirror the scenic mountains, and each sip is a serene hike through flavor.',
                    	   5);
INSERT INTO review (user_id, beer_id, title, body, rating)
                    VALUES (1,1,'Natural perfection in a glass',
                    	   'Alpine Amber Harmony is a symphony of malt and hops that dance together in perfect balance. The amber hues mirror the scenic mountains, and each sip is a serene hike through flavor.',
                    	   5);
INSERT INTO review (user_id, beer_id, title, body, rating)
                    VALUES (1,1,'Natural perfection in a glass',
                    	   'Alpine Amber Harmony is a symphony of malt and hops that dance together in perfect balance. The amber hues mirror the scenic mountains, and each sip is a serene hike through flavor.',
                    	   5);
INSERT INTO review (user_id, beer_id, title, body, rating)
                    VALUES (1,1,'Natural perfection in a glass',
                    	   'Alpine Amber Harmony is a symphony of malt and hops that dance together in perfect balance. The amber hues mirror the scenic mountains, and each sip is a serene hike through flavor.',
                    	   5);
INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (1,1);

INSERT INTO user_contact (user_id,email,phone,user_address) VALUES (1,'email@email.com','1111111111','123 Place St.');

INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (1, 'info@immigrantsonbrewing.com', '2166004483', '18120 Sloane Ave
Lakewood, OH 44107');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (1,'00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00','00:00');

COMMIT TRANSACTION;
