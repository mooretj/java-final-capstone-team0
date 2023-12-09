BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('brewer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
INSERT INTO users (username,password_hash,role,is_brewer) VALUES ('test','$2a$10$sfLRfv5JTn8RHm1i.MNz6OX0OveA3hEuwj39g2U2hokawUCSp31nG','ROLE_USER',false);

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Immigrant Son', 'https://www.immigrantsonbrewing.com/', 'https://www.cleveland.com/resizer/YfH5HU8fR1I34UEC8EontY6nK2o=/arc-anglerfish-arc2-prod-advancelocal/public/GGK433FUAZHENAWO2ZUHT5ZMYA.jpg', 'Immigrant Son is not just about a place, a thing, or a single person, it is an ongoing tale about ALL of us as one coming to the table to break bread, share the best of ourselves and what we’ve learned along the way while toasting to the road ahead. Meticulously weaving traditional classic recipes with imaginative flair, we will share our tale with you in the most authentic way we know how to share: at our table, in a glass, and in a can.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Masthead Brewing Co.','https://www.mastheadbrewingco.com/,','https://ohio.org/static/uploads/068t000000DFFSHAA5.jpg','Masthead Brewing Company is located in the historic Bryant Building at 1261 Superior Avenue in downtown Cleveland. Our building was originally built in 1921 as an automotive dealership and is now listed on the National Register of Historic Places. The taproom features 300 seats, a 100’ long bar, and an additional 50 seat dog friendly patio with a view of downtown Cleveland. We’ve become known for our ever evolving lineup of juicy New England IPAs, Neapolitan-style pizza, and our barrel aged beer utilizing exclusively allocated whiskey barrels from top-rated distilleries.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Goldhorn Brewery','https://www.goldhornbrewery.com/','https://i0.wp.com/ohiocraftbeer.org/wp-content/uploads/2016/01/Goldhorn_Header1.jpg?fit=800%2C533&ssl=1','Located in St. Clair Superior’s Hub 55 complex, Goldhorn Brewery - named for the famed mountain goat of Slovenian folklore in homage to our neighborhood roots - began operations in July 2016. With a robust rotating draft list, hearty feel-good food, and private event spaces, we aim to be a community staple for visitors and residents alike. We’re not trying to reinvent beer, because there’s no reason to reinvent beer. Wer’e exploring and connecting the rich heritage and traditions of our Cleveland neighborhood to craft beers that bring people together, inspire stories, and make you proud to say, "I’ll have a Goldhorn."');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Collision Bend Brewing Company','https://www.collisionbendbrewery.com/','https://images.squarespace-cdn.com/content/v1/533ca37fe4b089b274aa2d6e/1580327611827-16WLO0X577OA9JP5QI00/16-00-140_Collision-Bend_01-resized.jpg','For over a century, large barges and commercial vessels have painstakingly navigated these twists and turns with surgical precision in order to receive and deliver their precious industrial cargo to foundries and mills. We celebrate the crooked river and its large vessel passengers today as a toast to our city’s past and the progress that Cleveland has through its industrial roots. Come see this feat of skill yourself while enjoying a cold hand-crafted beverage and tantalizing small plates at Collision Bend Brewing Company.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Noble Beast Brewing Co.','https://www.noblebeastbeer.com/','https://s3-media0.fl.yelpcdn.com/bphoto/q81OFIO92UWosuqrbkIBZA/348s.jpg','Wer''e a small and independently owned business run by regular people. Shaun brews a mix of traditional and experimental beers, manages social media, and fixes the plumbing. His wife, JoLyn, runs operations, HR, and accounting and keeps everything by the book. Chef James creates a farm fresh and seasonal menu with an intensely creative eye that punches well above regular "brewery" food. They could’nt do it without a fantastic staff highlighted by GM Bill and Brewer Erik.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Southern Tier Brewery','https://taprooms.stbcbeer.com/southern-tier-brewery-cleveland-5b6c1b355dcb','https://i0.wp.com/ohiocraftbeer.org/wp-content/uploads/2018/11/SouthernTier_Header_2.jpg?fit=800%2C533&ssl=1','Southern Tier Brewing Company started in 2002 on a wooded property down a quiet road in Lakewood, NY. Since its humble beginnings, Southern Tier has grown into an industry leader and one of the top craft beer producers in the US. Our handcrafted ales are now available in more than thirty states and beyond. We continue to deliver consistent and quality beers while innovating to bring new bold flavors and formulas.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Market Garden Brewery','https://www.marketgardenbrewery.com','https://ohio.org/static/uploads/068t0000006uhB8AAI.jpg','Since 2011, Market Garden Brewery has brewed bold, award-winning beers in the beautiful Ohio City neighborhood of Cleveland. Our Brewpub & Restaurant features a creative, chef-driven food menu that changes with the seasonality of organic and local ingredients. With plenty of beers on our rotating draft list and a curated wine & cocktail program, we have drink options aplenty to be enjoyed at our 3 bars, event spaces, 3 fireplaces, and our leafy beer garden.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Saucy Brew Works','https://www.saucybrewworks.com/ohio-city/','https://www.saucybrewworks.com/wp-content/uploads/2021/10/DSC_3974-scaled.jpg','Our quest for high-quality beer led us to a high-tech brewery complete with a “BrauKon” brewing system that is efficient, exact, and eliminates waste. It’s here that we’ve brewed over 200 different beers and produced the very first of a new style known as Lachancea Tart. The brewpub is a premier craft beer destination offering a full-service restaurant experience complete with a  comfortable all-weather patio. Our 16+ taps serve a wide range of craft beers, including classic German styles, Hazy IPAs, Barrel-aged stouts, and our unique Lachancea Tart Drifter Series.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Terrestrial Brewing Company','https://terrestrialbrewing.com/','https://weare.techohio.ohio.gov/wp-content/uploads/2018/04/04-tbc1.jpg','The brewery is located in the Battery Park neighborhood of Cleveland, Ohio. The Taproom houses an American-made, five barrel brewhouse from Portland Kettle Works. All house beers are made by Brewmaster, Ralph Sgro, and Head Brewer, Drew Lang. The tap list has two, mainstay beers, Canopy Crusher IPA and Public Pilsner, while the rest of the taps constantly rotate with new and exciting brews. The Taproom offers a casual vibe and two large patios with epic views of Lake Erie. Perfect for the warmer months! The Taproom is also 100% dog-friendly and has an adjacent dog park next to us for the dogs to play and meet some friends.');

INSERT INTO brewery (brewery_name,website,brewery_main_img,history) VALUES ('Great Lakes Brewing Company','https://www.greatlakesbrewing.com/','https://img.bizbash.com/files/base/bizbash/bzb/image/2018/12/great_lakes_brewing_company_c5d2.png?auto=format%2Ccompress&fit=max&q=70&w=1200','Founded in 1988 by brothers Patrick and Daniel Conway in Cleveland’s Ohio City neighborhood, Great Lakes Brewing Co. (GLBC) is Ohio’s original craft brewery. Independent for over 30 years and employee owned since 2018, we are proud to serve 14 states and Washington D.C. with an award-winning and beloved selection of fresh, flavorful, and innovative craft beers. From year-round favorites like Dortmunder Gold Lager and Hazecraft IPA to seasonal classics like Christmas Ale and Oktoberfest, to our innovative limited releases and pub exclusive offerings, we hope you’ll crack one open with us soon, because we remain committed to the craft.');

INSERT INTO brewer (brewery_id,user_id) VALUES (1,3);

--’

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

INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (1, 'info@immigrantsonbrewing.com', '2166004483', '18120 Sloane Ave Lakewood, OH 44107');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (2,'info@mastheadbrewingco.com','2162066176','1261 Superior Ave, Cleveland, OH 44114');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (3,'info@goldhornbrewery.com','2162737001','1361 E 55th St, Cleveland, OH 44103');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (4,'info@collisionbendbrewry.com','2162737879','1250 Old River Rd, Cleveland, OH 44113');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (5,'info@noblebeastbeer.com','2164178588','1470 Lakeside Ave E, Cleveland, OH 44114');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (6,'info@stbcbeer.com','4404844045','811 Prospect Ave E, Cleveland, OH 44115');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (7,'info@marketgardenbrewery.com','2166214000','1947 W 25th St, Cleveland, OH 44113');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (8,'info@saucybrewworks.com','2166662568','2885 Detroit Ave, Cleveland, OH 44113');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (9,'info@terrestrialbrewing.com','2164659999','7524 Father Frascati, Cleveland, OH 44102');
INSERT INTO brewery_contact (brewery_id,email,phone,brewery_address) VALUES (10,'info@greatlakesbrewing.com','2167714404','2516 Market Ave, Cleveland, OH 44113');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (1,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (2,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (3,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (4,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (5,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (6,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (7,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (8,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (9,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');
INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (10,'01:00','02:00','03:00','04:00','05:00','06:00','00:00','12:00','19:00','19:30','20:00','21:00','22:00','23:00');

COMMIT TRANSACTION;
