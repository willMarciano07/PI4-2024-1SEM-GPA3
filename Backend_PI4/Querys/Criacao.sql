CREATE DATABASE ThinkySys_Senac_GPA3;

USE ThinkySys_Senac_GPA3;

CREATE TABLE Pessoa_Vendedora(
id_pessoaVendedora INT NOT NULL AUTO_INCREMENT,
nomeUsuario VARCHAR(50),
nomeLogin VARCHAR(50),
senhaUsuario VARCHAR(50),
enderecoUsuario VARCHAR(50),
PRIMARY KEY (id_pessoaVendedora)
);

CREATE TABLE Pessoa_Usuario(
id_pessoaUsuario INT NOT NULL AUTO_INCREMENT,
nomeUsuario VARCHAR(50),
nomeLogin VARCHAR(50),
senhaUsuario VARCHAR(50),
enderecoUsuario VARCHAR(50),
PRIMARY KEY (id_pessoaUsuario)
);

CREATE TABLE Produto(
id_produto INT NOT NULL AUTO_INCREMENT,
nomeProduto VARCHAR(50),
precoUnitario DOUBLE,
PRIMARY KEY (id_produto)
);

CREATE TABLE Vendas(
id_vendaProduto INT NOT NULL AUTO_INCREMENT,
id_produto INT,
id_pessoaUsuario INT,
quantidadeProduto INT,
valorTotal DOUBLE,
PRIMARY KEY (id_vendaProduto),
FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
);

CREATE TABLE Compras(
id_compra INT NOT NULL AUTO_INCREMENT, 
id_produto INT,
id_pessoaUsuario INT,
id_vendaProduto INT,
quantidadeProduto INT,
valorTotal DOUBLE,
PRIMARY KEY (id_compra),
FOREIGN KEY (id_produto) REFERENCES Produto(id_produto),
FOREIGN KEY (id_pessoaUsuario) REFERENCES Pessoa_Usuario(id_pessoaUsuario),
FOREIGN KEY (id_vendaProduto) REFERENCES Vendas(id_vendaProduto)
);
