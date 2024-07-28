CREATE TABLE IF NOT EXISTS endereco
(
    cep        VARCHAR(10) PRIMARY KEY,
    logradouro VARCHAR(255),
    bairro     VARCHAR(255),
    cidade     VARCHAR(255),
    uf         VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS cliente
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome         VARCHAR(255) NOT NULL,
    endereco_cep VARCHAR(10),
    FOREIGN KEY (endereco_cep) REFERENCES endereco (cep)
);
