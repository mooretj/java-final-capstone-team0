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


INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'American Pilsner','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/pilsner-500x650.png','Our American Pilsner is a crisp, bright, easy drinking lager with subtle hoppiness. German inspired and very crushable.','4.5','Pilsner',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 1, 'Crisp and Refreshing', 'The American Pilsner is a classic! Its crispness and bright character make it a go-to for any occasion. Highly recommended.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 1, 'Easy-Drinking Lager', 'I love the easy-drinking nature of this American Pilsner. The subtle hoppiness adds a nice touch. A great choice for a casual drink.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'IPA','https://immigrantsonbrewing.com/wp-content/uploads/2021/05/ipa-500x650.png','Our ISB IPA is YOUR Midwest IPA. Pouring pale orange in color, this IPA is all about hop flavor, aroma, and bitterness. Our hop blend gives generous notes of citrus, pine,& stone fruit supported by a light malt backbone and dry finish – Like a walk through the woods of Ohio.','7','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 2, 'Hoppy Delight', 'The ISB IPA is a hop lover’s dream. The citrus and pine notes are pronounced, creating a flavorful and bitter experience. Fantastic!', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 2, 'Walk in the Woods', 'Like taking a walk through the woods of Ohio indeed! The hop blend in this IPA is outstanding. A must-try for IPA enthusiasts.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (1,'Hungarian Pearl','https://immigrantsonbrewing.com/wp-content/uploads/2022/03/12oz-Cans-SingleCan_Kolsch-R1-500x650.png','Our crisp and clear kölsch pours golden in color and has a light malty sweetness with subtle fruit and hop character. You’ll get a kick out of this beer that can appease any palate or occasion. It’s summer in a glass!','5','Kolsch',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 3, 'Summer in a Glass', 'Hungarian Pearl lives up to its name - it’s like having summer in a glass. The light malty sweetness and subtle fruit notes are delightful. Cheers!', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 3, 'Crisp Kölsch', 'A crisp and clear kölsch that hits the mark. The golden color and light hop character make it a refreshing choice. Perfect for warm days.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (2,'Company Culture','your image here','Our Belgian style witbier aged in wine barrels along with wild cultures and apricot purée for 2 years. Cheers to a new company culture!','6','Sour',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 4, 'Barrel-Aged Beauty', 'Company Culture is a barrel-aged masterpiece! The combination of Belgian witbier with wild cultures and apricot purée creates a unique and delightful flavor profile.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 4, 'Cheers to Innovation', 'An innovative take on a Belgian witbier. The aging process and addition of apricot purée elevate the flavor. Truly a celebration of company culture!', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (2,'SUNKILLER','your image here','The leaves begin to fall, the daylight shortens, the shadows lengthen. Many are unsettled by the chill in the air as the wind whips the barren landscape. A select few embrace it. One of our most monstrous stouts has hibernated in Weller Wheated Bourbon Barrels for 18 months, only to awaken as the sun begins to take its bow. Enter Sunkiller, embrace the night.','15.3','Stout',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 5, 'Monstrous Stout', 'SUNKILLER is a beast of a stout! The hibernation in Weller Wheated Bourbon Barrels adds depth and richness. A bold choice for stout lovers.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 5, 'Embrace the Night', 'As the leaves fall, embrace the night with SUNKILLER. The 18-month aging process results in a complex and satisfying stout. Highly recommended for winter nights.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (2,'Shower Beer','your image here','Shower Beer is as crisp and refreshing as the Canadian Rockies. Whether it’s your favorite sporting event or an everyday activity like taking a shower, this Canadian Style Lager is sure to pair perfectly.','5.1','Lager',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 6, 'Refreshing Lager', 'Shower Beer is as refreshing as the Canadian Rockies. It’s crisp, clean, and pairs perfectly with any activity. A great choice for everyday enjoyment.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 6, 'Perfect Pairing', 'Whether it’s a shower or a sports event, Shower Beer is the perfect pairing. The Canadian Style Lager is a delightful and easy-drinking choice.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (2,'The Cleveland Experiment Vol. 2','your image here','While this experimental IPA might not send you into different dimensions, the hop character will certainly transport your taste buds through time. We hopped this edition of The Cleveland Experiment with our select Mosaic, Simcoe, Nectaron and Nelson CGX.','7','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 7, 'Not My Cup of Tea', 'The experimental nature of The Cleveland Experiment Vol. 2 didn’t resonate with me. The hop character was overpowering, and the flavor journey felt disjointed.', 2);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 7, 'Interesting Hop Blend', 'While not my usual preference, I found The Cleveland Experiment Vol. 2 intriguing. The blend of Mosaic, Simcoe, Nectaron, and Nelson CGX hops created a unique hop character.', 3);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 7, 'Hop Transporter', 'As a fan of hoppy beers, The Cleveland Experiment Vol. 2 was a journey through time for my taste buds. The hop character was bold and distinctive, creating a memorable experience.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (2,'Robot Santa’s Christmas Ale','your image here','After the robot uprising you’ll be leaving Robot Santa a Christmas Ale brewed with cinnamon, ginger, nutmeg, coriander, honey and orange peel.','7.6','Winter Ale',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 8, 'Spices Overwhelm', 'Robot Santa’s Christmas Ale was a bit too heavy on the spices for my liking. The combination of cinnamon, ginger, nutmeg, coriander, honey, and orange peel felt overpowering.', 2);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 8, 'Festive and Warming', 'A festive treat! Robot Santa’s Christmas Ale is like a holiday celebration in a glass. The blend of spices and the hint of sweetness from honey create a warming experience.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 8, 'Christmas in a Bottle', 'Robot Santa’s Christmas Ale truly captures the holiday spirit. The combination of spices adds depth, making it a perfect brew for the festive season.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (3,'Polka City','your image here','Crisp, clean, straw-colored lager, with a crisp bitter finish. Brewed with Slovenian hops.','5.4','Pilsner',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 9, 'Not Crisp Enough', 'Polka City did not deliver the crispness I expected from a pilsner. The bitter finish overshadowed the overall drinking experience.', 2);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 9, 'Straw-Colored Refreshment', 'A decent lager with a crisp, clean taste. The straw-colored appearance adds to its appeal. A good choice for those who enjoy a bitter finish.', 3);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 9, 'Refreshing Lager', 'Polka City is a refreshing lager with a crisp bitter finish. The Slovenian hops contribute to its unique flavor profile. A solid choice for a relaxing drink.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (3,'The Beer of the Goat','your image here','Our crisp and clear kölsch pours golden in color and has a light malty sweetness with subtle fruit and hop character. You’ll get a kick out of this beer that can appease any palate or occasion. It’s summer in a glass!','5','Bock',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 10, 'Not My Favorite Bock', 'The Beer of the Goat didn’t quite meet my expectations for a bock. The malty sweetness was too light, and it lacked the robust character I anticipated.', 2);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 10, 'Golden Kölsch', 'The Beer of the Goat, with its golden appearance, offers a light malty sweetness. It’s a pleasant kölsch that can suit various occasions.', 3);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 10, 'Summer Vibes in a Glass', 'The Beer of the Goat lives up to its description. It’s like summer in a glass, with its golden color and light malty sweetness. A good choice for warm days.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (3,'Dead Man’s Curve','your image here','Heavily hopped American IPA with citrusy, tropical fruit aroma and a pleasant, bitter finish. Brewed with warrior, azacca, and el dorado.','8','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 11, 'Too Bitter for Me', 'Dead Man’s Curve was overly bitter for my taste. The citrusy and tropical fruit notes were overshadowed by the intense bitterness, making it a challenging IPA.', 2);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 11, 'Hoppy Delight', 'If you love hop-forward IPAs, Dead Man’s Curve delivers. The combination of warrior, azacca, and el dorado hops creates a bold and bitter experience.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 11, 'Hophead’s Dream', 'As a hophead, Dead Man’s Curve is a dream come true. The citrusy and tropical fruit aroma, along with the bitter finish, satisfies the craving for a robust IPA.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (3,'Evil Spirits','your image here','Unlike a stout or a porter, this black lager is brewed to be much lighter in body with a smooth crisp finish and light notes of chocolate and malt, making it a perfect patio beer.','5.6','Schwarzbier',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 12, 'Light and Crisp', 'Evil Spirits, a black lager, is surprisingly light with a smooth crisp finish. The subtle notes of chocolate and malt make it a perfect patio beer, especially for those who enjoy lighter dark beers.', 3);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 12, 'Not Your Typical Dark Beer', 'Unlike typical stouts or porters, Evil Spirits offers a lighter body with hints of chocolate. It’s a unique black lager that defies expectations.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 12, 'Patio-Perfect Brew', 'Evil Spirits is a patio-perfect black lager with a smooth crisp finish. The light notes of chocolate and malt add to its appeal, making it an enjoyable choice.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (4,'Bollard Pull','your image here','This porter has flavors of dark chocolate and espresso. Finished with Centennial hops, to give it just a touch of fruitiness.','5.8','Porter',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 13, 'Chocolatey Delight', 'Bollard Pull delivers on the promise of dark chocolate and espresso flavors. The touch of fruitiness from Centennial hops adds a delightful twist to this porter.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 13, 'Rich and Decadent', 'An indulgent treat! 8 Crazy Nights Aged In Apple Brandy Barrels is rich, decadent, and perfect for the holiday season. The combination of cinnamon, honey, and apple brandy aging creates a delightful warmth.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 13, 'Semi-Sweet Surprise', 'Blackberry Shandy is a semi-sweet hard cider with a pleasant mix of blackberries and apples. The 6.9% ABV provides a balanced and enjoyable drinking experience.', 3);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (4,'8 Crazy Nights Aged In Apple Brandy Barrels ','your image here','Our holiday ale is brewed with cinnamon, honey, and Ohio-grown apples from our friends at Quarry Hill Orchards in Berlin Heights Ohio. We then aged it for at least six months in apple brandy barrels.','8.5','Warmer',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 14, 'Holiday Happiness', '8 Crazy Nights Aged In Apple Brandy Barrels is a holiday delight! The combination of cinnamon, honey, and Ohio-grown apples, aged in apple brandy barrels, creates a festive and rich flavor profile.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 14, 'Warm and Cozy', 'This holiday ale is a warm and cozy experience. The cinnamon, honey, and apple brandy barrel aging add layers of flavor that make it perfect for festive celebrations.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 14, 'Barrel-Aged Bliss', 'The six months of aging in apple brandy barrels truly elevates 8 Crazy Nights. It’s a barrel-aged bliss with a perfect balance of sweetness and warmth.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (4,'Blackberry Shandy','your image here','A heavy dose of blackberries make it sweet with a hint of tart. This semi-sweet hard cider comes in at 6.9%. Notes of apple, and blackberry.','6.9','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 15, 'Fruity Delight', 'This semi-sweet hard cider is a fruity delight! The notes of apple and blackberry create a refreshing and enjoyable drinking experience.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 15, 'Perfectly Balanced', 'Blackberry Shandy achieves a perfect balance of sweetness and tartness. It’s a well-crafted semi-sweet hard cider that’s perfect for any occasion.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (5,'Union Pils','your image here','Traditionally brewed with a double-decoction mash to enhance malt flavor and balanced with Czech Saaz hops for a delightfully floral and spicy aroma. Lagered horizontally for two months for clarity of flavor.','4.9','Bohemian Lager',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 16, 'Traditional Delight', 'Union Pils, brewed traditionally with a double-decoction mash, offers a delightful balance of malt flavor and floral, spicy aroma from Czech Saaz hops. A classic choice for pilsner lovers.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 16, 'Floral and Spicy Notes', 'The floral and spicy notes of Union Pils make it stand out. The double-decoction mash enhances the malt flavor, creating a well-rounded and enjoyable Bohemian Lager.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 16, 'Smooth Lager Experience', 'Union Pils delivers a smooth lager experience with vibrant malt flavors and a floral, spicy aroma. Lagered horizontally for two months, it showcases clarity of flavor.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (5,'Evil Motives','your image here','Double dry-hopped IPA, brewed with big hop additions of Citra, Simcoe, and Mosaic. Smooth bitterness, big aroma, and a clean finish.','7.2','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 17, 'Double Dry-Hopped Bliss', 'Evil Motives is a double dry-hopped IPA that lives up to its name. Big hop additions of Citra, Simcoe, and Mosaic create a blissful combination of smooth bitterness and intense aroma.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 17, 'Aromatic Experience', 'For hop enthusiasts, Evil Motives offers an aromatic delight. The clean finish complements the big hop additions, making it a well-balanced and enjoyable IPA.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 17, 'Bold and Aromatic', 'Evil Motives is bold, aromatic, and delivers on the promise of a double dry-hopped IPA. The combination of Citra, Simcoe, and Mosaic hops creates a memorable drinking experience.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (5,'SAF Stroopwaffel','your image here','Our original silky stout brewed with copious amounts of flaked oats for a rich and smooth character packed with caramel and cinnamon. Infused with pure nitrogen during the pour for maximum creaminess.','6.2','Nitro Oatmeal Stout',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 18, 'Silky Stout Perfection', 'SAF Stroopwaffel is a silky stout perfection with copious amounts of flaked oats. The infusion of caramel and cinnamon, along with pure nitrogen, creates a creamy and delightful experience.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 18, 'Smooth and Creamy', 'The nitro-infused SAF Stroopwaffel delivers a smooth and creamy stout experience. The rich character, infused with caramel and cinnamon, makes it a must-try for stout lovers.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 18, 'Maximum Creaminess Achieved', 'SAF Stroopwaffel achieves maximum creaminess with its nitro infusion. The rich character, combined with caramel and cinnamon, makes it a standout nitro oatmeal stout.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (6,'Cleveland Brew’d Brown Ale','your image here','Classic brown, with a balance of sweet and roasted malt flavors. Nutty, coffee like finish. Just a hint of peppery rye.','6','Brown Ale',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 19, 'Classic and Balanced', 'Cleveland Brew’d Brown Ale is a classic brown ale with a balanced blend of sweet and roasted malt flavors. The nutty, coffee-like finish adds to its appeal.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 19, 'Hint of Peppery Rye', 'An enjoyable brown ale with a hint of peppery rye. Cleveland Brew’d Brown Ale offers a classic experience with a balanced mix of sweet and roasted malt flavors.', 3);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 19, 'Balanced and Nutty', 'Cleveland Brew’d Brown Ale is a balanced brew with nutty and coffee-like flavors. The hint of peppery rye adds a unique twist, making it a solid choice for brown ale enthusiasts.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (6,'Cinnamon Roll','your image here','In this brew, lightly toasted malts with subtly spicy hops blend into cinnamon flavors and creamy lactose sugar. Their coalescence is so uncannily close to fresh baked cinnamon rolls that it was impossible to name this beer anything other than Cinnamon Roll Imperial Ale','8.6','Imperial Ale',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 20, 'Uncanny Cinnamon Rolls', 'Cinnamon Roll Imperial Ale lives up to its name. The blend of toasted malts, spicy hops, and creamy lactose sugar creates an uncanny resemblance to fresh-baked cinnamon rolls.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 20, 'Spicy and Creamy', 'Incredible! Cinnamon Roll Imperial Ale blends spicy hops with creamy lactose sugar, achieving a perfect balance. It’s a delightful brew that captures the essence of cinnamon rolls.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 20, 'Spiced Perfection', 'Cinnamon Roll Imperial Ale is spiced perfection in a bottle. The combination of toasted malts, spicy hops, and creamy lactose sugar creates a unique and enjoyable imperial ale.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (6,'Juice Jolt','your image here','This Extra Juicy IPA is bursting with tropical fruit flavor at an easy drinking 6.8% ABV. Juice Jolt delivers a punch of delicious fruit juice with an intense aroma to match. Caution this IPA is Too Juicy!','6.8','IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 21, 'Tropical Burst', 'Juice Jolt lives up to its name with a burst of tropical fruit flavor. At 6.8% ABV, it delivers a punch of delicious fruit juice with an intense aroma. A caution well heeded!', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 21, 'Easy-Drinking IPA', 'For an Extra Juicy IPA, Juice Jolt is surprisingly easy to drink. The tropical fruit flavor is refreshing, and the 6.8% ABV doesn’t overpower the overall experience.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 21, 'Too Juicy to Resist', 'Juice Jolt is indeed too juicy to resist! The tropical fruit flavor and intense aroma make it a standout IPA. Caution is right; it’s a juicy delight!', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (7,'Airing of Grievances','your image here','This lively beer will embolden and inspire you, as you regale your loved ones with the slights of the preceding year. Three varieties of rye malts provide a spicy backbone, while whole cone Simcoe and Centennial hops are added to the boil for an aggressive, resinous and piney hop flavor.','7','Red Rye IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 22, 'Bold and Inspiring', 'Airing of Grievances is a bold and inspiring beer. The rye malts provide a spicy backbone, and the Simcoe and Centennial hops add an aggressive, resinous, and piney hop flavor.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 22, 'Resinous Hop Delight', 'For hop enthusiasts, Airing of Grievances is a delight. The resinous and piney hop flavor, coupled with the spicy backbone from rye malts, creates a memorable Red Rye IPA.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 22, 'Dominate with Delight', 'A beer to dominate with! Airing of Grievances has a delicate malt body, snappy hop finish, and an overall refreshing quality. It keeps you dominating all day with its delightful flavor.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (7,'The OG','your image here','Crisp, light, brilliant and refreshing with a delicate malt body and a snappy hop finish, this beer keeps you dominating all day.','4.3','Light Lager',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 23, 'Crisp and Refreshing', 'The OG lives up to its name. Crisp, light, and refreshing, with a delicate malt body and a snappy hop finish. A go-to beer for those who enjoy a clean and easy-drinking lager.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 23, 'All-Day Dominance', 'The OG is an all-day dominator! With its crisp, light, and brilliant profile, it’s a refreshing choice that keeps you dominating. A must-try for lager enthusiasts.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 23, 'Sessionable Delight', 'The OG is a sessionable delight. Crisp, refreshing, and easy to dominate all day. The delicate malt body and snappy hop finish make it a go-to choice for a light lager.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (8,'B.F.heFe','your image here','Well balanced between a soft wheat body & banana clove character from a special yeast strain.','5.5','Hefeweizen',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 24, 'Banana Clove Balance', 'B.F.heFe achieves a well-balanced profile with a soft wheat body and prominent banana clove character. A delightful hefeweizen for those who appreciate the classic style.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 24, 'Classic Hefeweizen Experience', 'For a classic hefeweizen experience, B.F.heFe hits the mark. The balance between the soft wheat body and banana clove character makes it a refreshing and enjoyable brew.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 24, 'Hefeweizen Harmony', 'B.F.heFe achieves harmony with its well-balanced blend of a soft wheat body and banana clove character. A delightful choice for hefeweizen enthusiasts.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (8,'Fauxbia','your image here','Dripping with rich coffee and sweet vanilla flavor. Full bodied with a chocolatey finish.','5.9','White Stout',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 25, 'Rich Coffee Delight', 'Fauxbia is dripping with rich coffee and sweet vanilla flavor. The full-bodied experience and chocolatey finish make it a delightful choice.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 25, 'White Stout Heaven', 'As a white stout enthusiast, Fauxbia exceeded my expectations. The blend of coffee and vanilla creates a heavenly experience with a chocolatey finish.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (8,'Boo Thang','your image here','Brewed with pumpkin purée and spices. Taste hints of caramel with cinnamon, nutmeg and ginger.','8.5','Imperial Pumpkin Ale',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 26, 'Pumpkin Spice Bliss', 'Boo Thang is a pumpkin spice bliss! The hints of caramel, cinnamon, nutmeg, and ginger create a perfect harmony in this Imperial Pumpkin Ale.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 26, 'Fall in a Glass', 'Brewed with pumpkin purée and spices, Boo Thang captures the essence of fall. The rich flavors and warming spices make it a seasonal favorite.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (9,'Space Chimp Wit OG','your image here','Our original gangster, Space Chimp Wit, brewed with bitter orange and coriander.','5','Witbier',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 27, 'Original Gangster', 'Space Chimp Wit OG, the original gangster, is a refreshing witbier brewed with bitter orange and coriander. It’s a classic that never disappoints.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 27, 'Citrusy Delight', 'The citrusy notes from bitter orange in Space Chimp Wit OG are delightful. A great choice for those who appreciate a crisp and flavorful witbier.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (9,'Fresh Hop Big Black Furry Creature From Mars','your image here','This cuddly, but muscular, Black IPA is loaded with crazy tropical top notes from FRESH Simcoe hops enhanced with @phantasm.nz powder. Although dark in appearance, this IPA is full of extremely, bright flavors. When you get outta work, what do you do? You crush a BBFCFM!','6.6','Black IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 28, 'Crazy Tropical Top Notes', 'Fresh Hop BBFCFM is a black IPA with crazy tropical top notes. The combination of Simcoe hops and @phantasm.nz powder creates an extremely bright and flavorful experience.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 28, 'Crush-Worthy', 'This cuddly but muscular Black IPA is indeed crush-worthy! The vibrant flavors make it a go-to choice after a day of work.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (9,'Catching Smoke','your image here','A cozy lager brewed with beechwood smoked malt for a complex, sophisticated taste! This is a brewer’s beer!','6','Smoked Ale',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 29, 'Cozy Lager', 'Catching Smoke is a cozy lager brewed with beechwood smoked malt, providing a complex and sophisticated taste. A true brewer’s beer!', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 29, 'Smokey Excellence', 'The beechwood smoked malt in Catching Smoke adds a layer of complexity, creating a brewer’s beer with a sophisticated and excellent taste.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (9,'Blazin’ Blue Raspberry','your image here','Brewed with Blue Raspberry Lemonade Kool-Aid packets. This tart refreshing wheat beer will bring past memories of summer days.','4','Sour',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 30, 'Summer Memories', 'Blazin’ Blue Raspberry brings back past memories of summer days with its tart and refreshing wheat beer brewed with Blue Raspberry Lemonade Kool-Aid packets.', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 30, 'Tart Refreshment', 'Brewed with Blue Raspberry Lemonade Kool-Aid packets, Blazin’ Blue Raspberry offers tart refreshment and a hint of nostalgia.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (10,'Oktoberfest','your image here','Our take on this classic German style is a real malt party, packed with toasty autumnal flavors perfect for hearty hoisting. Über smooth with vibrant malt flavors and a festive flourish of noble hops (lederhosen not included).','4.3','Festbier',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 31, 'Classic German Vibes', 'Oktoberfest is a true classic German style beer. The toasty autumnal flavors and vibrant malt make it a perfect choice for hearty hoisting.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 31, 'Festive Celebration', 'With its festive flourish of noble hops, Oktoberfest is lederhosen-worthy indeed. It’s a malt party in a glass that deserves a celebration.', 4);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (10,'Arctic Ancient','your image here','This frothy forecast calls for extreme conditions! Take cover by the fire and brace yourself for an epic Imperial IPA packed with chill-busting juicy hop notes.','8.5','Imperial IPA',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 32, 'Extreme Conditions', 'Arctic Ancient is an epic Imperial IPA packed with chill-busting juicy hop notes. Perfect for sipping by the fire in extreme conditions!', 4);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 32, 'Hoppy Bliss', 'The chill-busting juicy hop notes in Arctic Ancient create a hoppy bliss that makes it perfect for a cozy evening by the fire.', 5);



INSERT INTO beer (brewery_id,beer_name,beer_img,beer_description,abv,beer_type,is_available) VALUES (10,'Dortmunder Gold','your image here','A classic award-winning balance of sweet malt and dry hop flavors, proudly waving the flag for Cleveland and refreshing beer drinkers everywhere since 1988.','5.8','Light Lager',true);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 33, 'Award-Winning Classic', 'Dortmunder Gold is a classic award-winning balance of sweet malt and dry hop flavors. Proudly waving the flag for Cleveland and refreshing beer drinkers everywhere since 1988.', 5);

INSERT INTO review (user_id, beer_id, title, body, rating) VALUES (1, 33, 'Smooth and Refreshing', 'The smooth and refreshing taste of Dortmunder Gold is a testament to its award-winning balance of sweet malt and dry hop flavors. A timeless classic.', 4);

--’

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (1,1);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (2,1);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (3,1);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (4,2);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (5,2);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (6,2);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (7,2);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (8,2);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (9,3);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (10,3);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (11,3);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (12,3);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (13,4);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (14,4);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (15,4);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (16,5);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (17,5);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (18,5);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (19,6);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (20,6);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (21,6);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (22,7);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (23,7);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (24,8);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (25,8);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (26,8);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (27,9);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (28,9);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (29,9);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (30,9);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (31,10);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (32,10);

INSERT INTO brewery_beer (beer_id,brewery_id) VALUES (33,10);


INSERT INTO user_contact (user_id,email,phone,user_address) VALUES (1,'user@user.com','1111111111','123 User St.');

INSERT INTO user_contact (user_id,email,phone,user_address) VALUES (2,'admin@admin.com','2222222222','123 Admin St.');

INSERT INTO user_contact (user_id,email,phone,user_address) VALUES (3,'brewer@brewer.com','3333333333','123 Brewer St.');


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


INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (1,'10:00','21:00','15:00','22:00','15:00','22:00','15:00','22:00','15:00','22:00','15:00','23:00','10:00','23:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (2,'12:00','20:00','00:00','00:00','11:30','22:00','11:30','22:00','11:30','22:00','11:30','23:00','11:30','23:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (3,'12:00','21:00','00:00','00:00','00:00','00:00','00:00','00:00','15:00','21:00','12:00','22:00','12:00','22:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (4,'11:30','17:00','11:30','21:00','11:30','21:00','11:30','21:00','11:30','21:00','11:30','23:00','11:30','23:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (5,'11:30','22:00','00:00','00:00','11:30','23:00','11:30','23:00','11:30','23:00','11:30','00:00','11:30','00:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (6,'11:00','21:00','11:00','22:00','11:00','22:00','11:00','22:00','11:00','22:00','11:00','00:00','11:00','00:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (7,'11:00','18:00','00:00','00:00','00:00','00:00','11:00','18:00','11:00','18:00','11:00','18:00','11:00','18:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (8,'11:00','22:00','11:00','22:00','11:00','22:00','11:00','22:00','11:00','00:00','11:00','00:00','11:00','00:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (9,'10:00','22:00','16:00','23:00','16:00','23:00','16:00','23:00','16:00','23:00','16:00','00:00','11:00','00:00');

INSERT INTO brewery_hours (brewery_id, sunday_open, sunday_close, monday_open, monday_close, tuesday_open, tuesday_close, wednesday_open, wednesday_close, thursday_open, thursday_close, friday_open, friday_close, saturday_open, saturday_close) VALUES (10,'11:00','17:00','12:00','23:00','12:00','23:00','12:00','23:00','12:00','23:00','12:00','00:00','11:30','12:00');


COMMIT TRANSACTION;
