CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(50),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id)
	
);

INSERT INTO category (name,description,image_url,is_active) VALUES ('Laptop','This is description of Laptop','CAT_1.png','TRUE');
INSERT INTO category (name,description,image_url,is_active) VALUES ('Television','This is description of Television','CAT_2.png','TRUE');
INSERT INTO category (name,description,image_url,is_active) VALUES ('Mobile','This is description of Mobile','CAT_3.png','TRUE');

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number) VALUES ('Eleena','Kayastha','ADMIN','true','admin','kayasthaeleena@gmail.com','9843462746');
INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number) VALUES ('Ram','Sharma','SUPPLIER','true','12345','ram@gmail.com','9888888888');
INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number) VALUES ('Ayush','Krishna','SUPPLIER','true','12345','ayush@gmail.com','9843462746');

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchase INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	 

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchase,views) VALUES ('PRDABC123DEFX','iPhone 7','apple','this is one of the most popular moblie phone','70000','4','TRUE','3','1','0','3');
INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchase,views) VALUES ('PRDDSDFC123DEFX','SONY LED TV','SONY','this is one of the most popular TV','170000','2','TRUE','2','2','1','1');
INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchase,views) VALUES ('PRDHISJG12LLOP','DELL Inspiron','Dell','this is one of the most popular Laptop','80000','3','TRUE','1','1','0','2');


-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);
-- the cart line table to store the cart details

CREATE TABLE cart_line (
	id IDENTITY,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES cart(id),
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);



