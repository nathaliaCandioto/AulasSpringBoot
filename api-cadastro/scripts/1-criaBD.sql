-- Tabela PESSOA
CREATE TABLE pessoa (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15)
);

-- Tabela PAGAMENTO
CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

-- Tabela CLIENTE
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    pedido VARCHAR(100),
    pagamento_id INT,
    pessoa_cpf VARCHAR(11) NOT NULL,
    CONSTRAINT fk_cliente_pessoa FOREIGN KEY (pessoa_cpf)
        REFERENCES pessoa (cpf)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_cliente_pagamento FOREIGN KEY (pagamento_id)
        REFERENCES pagamento (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Tabela VENDEDOR
CREATE TABLE vendedor (
    id SERIAL PRIMARY KEY,
    comissao NUMERIC(10,2),
    salario NUMERIC(10,2),
    pessoa_cpf VARCHAR(11) NOT NULL,
    CONSTRAINT fk_vendedor_pessoa FOREIGN KEY (pessoa_cpf)
        REFERENCES pessoa (cpf)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

ALTER TABLE cliente
    DROP COLUMN pedido,
    DROP COLUMN pagamento_id;

--    SELECT*FROM cliente
--    SELECT*FROM pedido

    create table pedido(
    id serial primary key,
    quantidade int not null,
    descricao varchar (100) not null,
    cliente_id int not null,
    vendedor_id int not null,
    pagamento_id int not null,
    foreign key (cliente_id) references cliente(id),
    foreign key (vendedor_id) references vendedor(id),
    foreign key (pagamento_id) references pagamento(id)
    );

