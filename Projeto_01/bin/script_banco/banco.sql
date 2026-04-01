CREATE DATABASE IF NOT EXISTS cadastro_db;

USE cadastro_db;

CREATE TABLE IF NOT EXISTS usuarios (
	id int auto_increment primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique
);

INSERT INTO usuarios (nome, email) VALUES
('Yasmin Vieira', 'vieiracyasmin@gmail.com');
