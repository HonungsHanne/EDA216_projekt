PRAGMA foreign_keys=OFF;

DROP TABLE IF EXISTS pallets;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS recipes;
DROP TABLE IF EXISTS materials;
DROP TABLE IF EXISTS trucks;
DROP TABLE IF EXISTS palletorders;

PRAGMA foreign_keys=ON;

CREATE TABLE pallets (
		pallet_nbr	INT,
		timestamp		DATE NOT NULL,
		blocked			BOOLEAN NOT NULL,
		recipe_name	TEXT NOT NULL,
		pallet_order_id INT NOT NULL,
		
		FOREIGN KEY (recipe_name) REFERENCES recipes(recipe_name),
		FOREIGN KEY (pallet_order_id) REFERENCES palletorders(pallet_order_id),
		PRIMARY KEY(pallet_nbr)
);
		
CREATE TABLE palletorders (
		pallet_order_id		INT NOT NULL,
		order_id					INT NOT NULL,
		recipe_name TEXT 	NOT NULL,
		amount 						INT NOT NULL,
		
		PRIMARY KEY (pallet_order_id),
		FOREIGN KEY (order_id) REFERENCES orders(order_id),
		FOREIGN KEY (recipe_name) REFERENCES recipes(recipe_name)
);
		
CREATE TABLE orders (
		order_id INT,
		delivery_date DATE NOT NULL,
		customer_name TEXT NOT NULL,
		customer_address TEXT NOT NULL,
		
		PRIMARY KEY (order_id),
		FOREIGN KEY (customer_name, customer_address) REFERENCES customers(customer_name, customer_address)
);

CREATE TABLE recipes (
		recipe_name TEXT NOT NULL,
		amount DOUBLE NOT NULL,
		material_name TEXT NOT NULL,
		
		PRIMARY KEY (recipe_name, material_name),
		FOREIGN KEY (material_name) REFERENCES materials(material_name)
);

CREATE TABLE materials (
		material_name TEXT NOT NULL,
		amount DOUBLE NOT NULL,
		timestamp DATE NOT NULL,
		
		PRIMARY KEY (material_name, timestamp)
);

CREATE TABLE trucks (
		truck_id INT NOT NULL,
		pallet_order_id INT NOT NULL,
		
		FOREIGN KEY (pallet_order_id),
		PRIMARY KEY (truck_id, pallet_order_id)
);

CREATE TABLE customers(
		customer_address TEXT NOT NULL,
		customer_name TEXT NOT NULL,
		
		PRIMARY KEY (customer_name, customer_address)
);

INSERT INTO recipes VALUES('Nut ring', 450, 'Flour');
INSERT INTO recipes VALUES('Nut ring', 450, 'Butter');
INSERT INTO recipes VALUES('Nut ring', 190, 'Icing sugar');
INSERT INTO recipes VALUES('Nut ring', 225, 'Roasted, chopped nuts');
INSERT INTO recipes VALUES('Nut cookie', 750, 'Fine-ground nuts');
INSERT INTO recipes VALUES('Nut cookie', 625, 'Ground, roasted nuts');
INSERT INTO recipes VALUES('Nut cookie', 125, 'Bread crumbs');
INSERT INTO recipes VALUES('Nut cookie', 375, 'Sugar');
INSERT INTO recipes VALUES('Nut cookie', 3.5, 'Egg whites');
INSERT INTO recipes VALUES('Nut cookie', 50, 'Chocolate');
INSERT INTO recipes VALUES('Amneris', 750, 'Marzipan');
INSERT INTO recipes VALUES('Amneris', 250, 'Butter');
INSERT INTO recipes VALUES('Amneris', 250, 'Eggs');
INSERT INTO recipes VALUES('Amneris', 25, 'Potato starch');
INSERT INTO recipes VALUES('Amneris', 25, 'Wheat flour');
INSERT INTO recipes VALUES('Tango', 200, 'Butter');
INSERT INTO recipes VALUES('Tango', 250, 'Sugar');
INSERT INTO recipes VALUES('Tango', 300, 'Flour');
INSERT INTO recipes VALUES('Tango', 4, 'Sodium bicarbonate');
INSERT INTO recipes VALUES('Tango', 2, 'Vanilla');
INSERT INTO recipes VALUES('Almond delight', 400, 'Butter');
INSERT INTO recipes VALUES('Almond delight', 270, 'Sugar');
INSERT INTO recipes VALUES('Almond delight', 279, 'Chopped almonds');
INSERT INTO recipes VALUES('Almond delight', 400, 'Flour');
INSERT INTO recipes VALUES('Almond delight', 10, 'Cinnamon');
INSERT INTO recipes VALUES('Berliner', 350, 'Flour');
INSERT INTO recipes VALUES('Berliner', 250, 'Butter');
INSERT INTO recipes VALUES('Berliner', 100, 'Icing sugar');
INSERT INTO recipes VALUES('Berliner', 50, 'Eggs');
INSERT INTO recipes VALUES('Berliner', 5, 'Vanilla sugar');
INSERT INTO recipes VALUES('Berliner', 50, 'Chocolate');


INSERT INTO customers VALUES('Finkakor AB', 'Helsingborg');
INSERT INTO customers VALUES('Småbröd AB', 'Malmö');
INSERT INTO customers VALUES('Kaffebröd AB', 'Landskrona');
INSERT INTO customers VALUES('Bjudkakor AB', 'Ystad');
INSERT INTO customers VALUES('Kalaskakor AB', 'Trelleborg');
INSERT INTO customers VALUES('Partykakor AB', 'Kristianstad');
INSERT INTO customers VALUES('Gästkakor AB', 'Hässleholm');
INSERT INTO customers VALUES('Skånekakor AB', 'Perstorp');


