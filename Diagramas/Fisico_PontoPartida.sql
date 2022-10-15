/* Logico_PontoPartida: */

CREATE DATABASE PONTOPARTIDA;

USE PONTOPARTIDA;

CREATE TABLE PERMISSAO (
    idPermissao INT NOT NULL UNIQUE AUTO_INCREMENT,
    tipoPermissao VARCHAR(20),
	PRIMARY KEY (idPermissao)
);

CREATE TABLE ENDERECO (
    idEndereco INT NOT NULL UNIQUE AUTO_INCREMENT,
    numero VARCHAR(10),
    logradouro VARCHAR(50),
    estadoUF VARCHAR(2),
    bairro VARCHAR(20),
    cidade VARCHAR(20),
	PRIMARY KEY (idEndereco)
);

CREATE TABLE PESSOA (
    idPessoa INT NOT NULL UNIQUE AUTO_INCREMENT,
    cpf VARCHAR(11),
    nomePessoa VARCHAR(50),
    dataNascimento DATE,
    sexo VARCHAR(10),
    email VARCHAR(20),
    telefone VARCHAR(20),
	idEndereco INT,
	idPermissoes INT,
	PRIMARY KEY (idPessoa),
	FOREIGN KEY (idEndereco)
	REFERENCES ENDERECO(idEndereco),
	FOREIGN KEY (idPermissoes)
	REFERENCES PERMISSOES(idPermissoes)
    );
	
	CREATE TABLE PARTIDA (
    idPartida INT NOT NULL UNIQUE AUTO_INCREMENT,
    dataPartida DATE,
    nomeCampeonato VARCHAR(10),
    timeCasa VARCHAR(10),
    timeConvidado VARCHAR(10),
	PRIMARY KEY(idPartida)
);

CREATE TABLE PACOTEPARTIDA (
    idPacotePartida INT NOT NULL UNIQUE AUTO_INCREMENT,
    dataSaida DATE,
    dataRetorno DATE,
    valorPacote DECIMAL,
    nomePacote VARCHAR(20),
    idPartida INT,
	PRIMARY KEY (idPacotePartida),
	FOREIGN KEY (idPartida)
	REFERENCES PARTIDA(idPartida)
);

CREATE TABLE COMPRA (
    idCompra INT NOT NULL UNIQUE AUTO_INCREMENT,
    valorCompra DECIMAL,
    quantPacotes INTEGER,
    dataCompra DATE,
    idPessoa INT,
	PRIMARY KEY(idCompra),
	FOREIGN KEY (idPessoa)
	REFERENCES PESSOA(idPessoa)
);


CREATE TABLE ITENSCOMPRA (
    idItemCompra INT NOT NULL UNIQUE AUTO_INCREMENT,
	idCompra INT,
    idPacotePartida INT,
	PRIMARY KEY(idItemCompra),
	FOREIGN KEY (idCompra)
	REFERENCES COMPRA(idCompra),
	FOREIGN KEY (idPacotePartida)
	REFERENCES PACOTEPARTIDA(idPacotePartida)		
);

