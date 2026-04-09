drop database if exists cadastro_db;
create database cadastro_db;

USE cadastro_db;

CREATE TABLE IF NOT EXISTS usuarios (
	id int auto_increment primary key,
    nome varchar(255) not null,
    cpf varchar(11) not null unique,
    ind boolean not null
);

SELECT * FROM cadastro_db.usuarios;

CREATE TABLE IF NOT EXISTS produtos (
	id int auto_increment primary key,
    nome varchar(255) not null,
    preco decimal(0.00) not null,
    qtd int(100) not null
);

SELECT * FROM cadastro_db.produtos;
