CREATE DATABASE IF NOT EXISTS DB_donation_tracker;

USE DB_donation_tracker;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    yearsOld INT,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE payment_methods(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL UNIQUE
    );

CREATE TABLE donations(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method_id INT,
    donation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (payment_method_id) REFERENCES payment_methods(id)
);

INSERT INTO payment_methods (name) VALUES ("Cartão de Crédito");
INSERT INTO payment_methods (name) VALUES ("Boleto");
INSERT INTO payment_methods (name) VALUES ("MercadoPago");
INSERT INTO payment_methods (name) VALUES ("Paypal");
INSERT INTO payment_methods (name) VALUES ("Transferência Bancária");

INSERT INTO users (full_Name, email, password) VALUES ("João", "joao@example.com", "password123");
INSERT INTO users (full_Name, email, password) VALUES ("Charles", "charles@example.com", "password123");
INSERT INTO users (full_Name, email, password) VALUES ("Juan", "teste@example.com", "password");

INSERT INTO donations (user_id, amount, payment_method_id) VALUES (1, 100, 2);
INSERT INTO donations (user_id, amount, payment_method_id) VALUES (2, 1000, 3);
INSERT INTO donations (user_id, amount, payment_method_id) VALUES (3, 1000, 1);

select * from users;
select * from payment_methods;
select * from donations;