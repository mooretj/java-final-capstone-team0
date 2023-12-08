BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('brewer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('test','$2a$10$sfLRfv5JTn8RHm1i.MNz6OX0OveA3hEuwj39g2U2hokawUCSp31nG','ROLE_USER',false);

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Immigrant Son', 'https://www.immigrantsonbrewing.com/', 'https://www.cleveland.com/resizer/YfH5HU8fR1I34UEC8EontY6nK2o=/arc-anglerfish-arc2-prod-advancelocal/public/GGK433FUAZHENAWO2ZUHT5ZMYA.jpg', 'Immigrant Son is not just about a place, a thing, or a single person, it is an ongoing tale about ALL of us as one coming to the table to break bread, share the best of ourselves and what we’ve learned along the way while toasting to the road ahead. Meticulously weaving traditional classic recipes with imaginative flair, we will share our tale with you in the most authentic way we know how to share: at our table, in a glass, and in a can.');
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Masthead Brewing Co.','https://www.mastheadbrewingco.com/,','https://ohio.org/static/uploads/068t000000DFFSHAA5.jpg','Masthead Brewing Company is located in the historic Bryant Building at 1261 Superior Avenue in downtown Cleveland. Our building was originally built in 1921 as an automotive dealership and is now listed on the National Register of Historic Places.') +
('The taproom features 300 seats, a 100’ long bar, and an additional 50 seat dog friendly patio with a view of downtown Cleveland. We’ve become known for our ever evolving lineup of juicy New England IPAs, Neapolitan-style pizza, and our barrel aged beer utilizing exclusively allocated whiskey barrels from top-rated distilleries.')
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Goldhorn Brewery', 'https://www.goldhornbrewery.com','','')
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES
INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES

INSERT INTO brewer (brewery_id,user_id) VALUES (1,3);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'American Pilsner','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/pilsner-500x650.png','Our American Pilsner is a crisp, bright, easy drinking lager with subtle hoppiness. German inspired and very crushable.','4.5','Pilsner',true);

INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'IPA','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/ipa-500x650.png','Our ISB IPA is YOUR Midwest IPA. Pouring pale orange in color, this IPA is all about hop flavor, aroma, and bitterness. Our hop blend gives generous notes of citrus, pine,& stone fruit supported by a light malt backbone and dry finish – Like a walk through the woods of Ohio.','7','IPA',true);

INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'Hungarian Pearl','https://immigrantsonbrewing.com/wp-content/uploads/2022/03/12oz-Cans-SingleCan_Kolsch-R1-500x650.png','Our crisp and clear kölsch pours golden in color and has a light malty sweetness with subtle fruit and hop character. You’ll get a kick out of this beer that can appease any palate or occasion. It’s summer in a glass!','5','Kolsch',true);

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

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (1,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');

COMMIT TRANSACTION;
