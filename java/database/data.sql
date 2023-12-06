BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('brewer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);

INSERT INTO brewery (brewery_name,website,open_hour,close_hour,history) VALUES ('Immigrant Son', 'https://immigrantsonbrewing.com/', '3:00', '10:00', 'Immigrant Son is not just about a place, a thing, or a single person, it is an ongoing tale about ALL of us as one coming to the table to break bread, share the best of ourselves and what we’ve learned along the way while toasting to the road ahead. Meticulously weaving traditional classic recipes with imaginative flair, we will share our tale with you in the most authentic way we know how to share: at our table, in a glass, and in a can.

You’ll come across our brew house’s homage to classic beer recipes while in tandem experiencing
the integrative path of creative experimental and locally inspired brews– each beer An integral part of telling our tale.

Our kitchen will reintroduce you to comfort foods with an incomparable
Immigrant Son wist and captivate you with remarkable creations as the seasons change.

Like most tales, the community plays a pivotal part in our business.
In order to build a strong and sustainable neighborhood, we partner with our neighbors and local vendors whenever possible, to support their wisdoms and expertise to bring you the freshest and most unique creations.

We are a culmination of our “ancestors’ wildest dreams.”*
We have set our sights on creating an unequivocal, brighter present and future by honoring the
best of our collective heritage and our roots. We will bring you on this journey by cultivating that dream and crafting it into the beer and food we have designed for you.

We are one through our beer and food.');

INSERT INTO brewer (brewery_id,user_id) VALUES (1,3);

INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'American Pilsner','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/pilsner-500x650.png','Our American Pilsner is a crisp, bright, easy drinking lager with subtle hoppiness. German inspired and very crushable.','4.5','Pilsner',true);

INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'IPA','hthttps://immigrantsonbrewing.com/wp-content/uploads/2021/05/ipa-500x650.png','Our ISB IPA is YOUR Midwest IPA. Pouring pale orange in color, this IPA is all about hop flavor, aroma, and bitterness. Our hop blend gives generous notes of citrus, pine,& stone fruit supported by a light malt backbone and dry finish – Like a walk through the woods of Ohio.','7','IPA',true);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (1,1);

INSERT INTO user_contact (user_id,email,phone,user_address) VALUES (1,'email@email.com','1111111111','123 Place St.');

INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (1, 'info@immigrantsonbrewing.com', '2166004483', '18120 Sloane Ave
Lakewood, OH 44107');

COMMIT TRANSACTION;
