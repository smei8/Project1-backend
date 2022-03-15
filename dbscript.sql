create database ers

CREATE TABLE roles (
    role_id serial PRIMARY KEY,
    role_name varchar(255) UNIQUE NOT NULL
);

CREATE TABLE users (
    user_id  serial PRIMARY KEY,
    username varchar(50) UNIQUE NOT NULL,
    password varchar(50) NOT NULL,
    full_name varchar(100) NOT NULL,
    email varchar(255) UNIQUE NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT fk_user_role FOREIGN KEY(role_id) REFERENCES roles(role_id)
);

CREATE TABLE request_type(
    type_id serial PRIMARY KEY,
    req_type TEXT NOT NULL
);

CREATE TABLE request_status(
    status_id serial PRIMARY KEY,
    req_status varchar(50) NOT NULL
);

CREATE TABLE request_details(
    req_id serial PRIMARY KEY,
    user_id INT NOT NULL,
    type INT NOT NULL,
    request_amount INT NOT NULL,
    submit_date DATE NOT NULL DEFAULT CURRENT_DATE,
    approve_date DATE NOT NULL DEFAULT CURRENT_DATE,
    manager INT,
    status INT NOT NULL,
    CONSTRAINT fk_req_user FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT fk_req_manager FOREIGN KEY(manager) REFERENCES users(user_id),
    CONSTRAINT fk_req_status FOREIGN KEY(status) REFERENCES request_status(status_id),
    CONSTRAINT fk_req_type FOREIGN KEY(type) REFERENCES request_type(type_id)
); 

INSERT INTO roles(role_name) VALUES('manager');
INSERT INTO roles(role_name) VALUES('associate');

INSERT INTO users(username, password, full_name, email, role_id) VALUES('bruno', 'bruno123', 'Bruno Fly', 'bruno@business.com', 1);
INSERT INTO users(username, password, full_name, email, role_id) VALUES('levi', 'levi631', 'Levi Arckerman', 'levi@business.com', 1);
INSERT INTO users(username, password, full_name, email, role_id) VALUES('ymith', 'leo2', 'Snake Ymith', 'snake@business.com', 2);
INSERT INTO users(username, password, full_name, email, role_id) VALUES('cool', '4563', 'Gojo Satoru', 'gojo@business.com', 2);

INSERT INTO request_type(req_type) VALUES( 'travel');
INSERT INTO request_type(req_type) VALUES('certification');

INSERT INTO request_status(req_status) VALUES('pending');
INSERT INTO request_status(req_status) VALUES('approved');
INSERT INTO request_status(req_status) VALUES('denied');


