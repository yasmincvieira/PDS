drop database if exists cadastro_db;
create database cadastro_db;

USE cadastro_db;

CREATE TABLE IF NOT EXISTS usuarios (
	id int auto_increment primary key,
    nome varchar(255) not null,
    cpf varchar(11) not null unique
);

INSERT INTO usuarios (nome, cpf) VALUES
('Yasmin Vieira', '12345678900');
