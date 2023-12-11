BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_contact, brewery, brewer, brewery_contact, brewery_hours, beer, brewery_beer, review;

CREATE TABLE users (
	user_id SERIAL UNIQUE,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	is_brewer boolean DEFAULT FALSE,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE user_contact (
	user_id int,
	email varchar(100) UNIQUE,
	phone varchar(10) UNIQUE,
	user_address varchar(200),
	CONSTRAINT FK_user_user_contact FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE brewery (
	brewery_id SERIAL UNIQUE,
	brewery_name varchar(50) NOT NULL,
	brewery_main_img varchar(150),
	website varchar(200),
	history varchar(5000)
);

CREATE TABLE brewer (
	user_id int NOT NULL,
	brewery_id int NOT NULL,
	CONSTRAINT PK_brewer PRIMARY KEY (user_id, brewery_id),
	CONSTRAINT FK_user_brewery FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT FK_brewery_id_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE brewery_contact (
	brewery_id int,
	email varchar(100) NOT NULL,
	phone varchar(10) NOT NULL,
	brewery_address varchar(200) NOT NULL UNIQUE,
	CONSTRAINT FK_brewery_brewery_contact FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE brewery_hours (
    brewery_id int,
    sunday_open time,
    sunday_close time,
    monday_open time,
    monday_close time,
    tuesday_open time,
    tuesday_close time,
    wednesday_open time,
    wednesday_close time,
    thursday_open time,
    thursday_close time,
    friday_open time,
    friday_close time,
    saturday_open time,
    saturday_close time,
    CONSTRAINT FK_brewery_brewery_hours FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE beer (
	beer_id SERIAL UNIQUE,
	brewery_id int NOT NULL,
	beer_name varchar(50) NOT NULL,
	beer_img varchar(200) NOT NULL,
	beer_description varchar(500) NOT NULL,
	abv decimal(3, 1) NOT NULL,
	beer_type varchar(50),
	is_available boolean
);

CREATE TABLE brewery_beer (
	beer_id int,
	brewery_id int,
	CONSTRAINT PK_brewery_beer PRIMARY KEY (beer_id, brewery_id),
	CONSTRAINT FK_brewery_beer_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id),
	CONSTRAINT FK_brewery_beer_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE review (
	review_id SERIAL UNIQUE,
	user_id int,
	beer_id int,
	title varchar(50);
	body varchar(500),
	rating int CHECK (rating >= 1 AND rating <= 5),
	CONSTRAINT FK_review_users FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT FK_review_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);

COMMIT TRANSACTION;