CREATE TABLE Peca (
    idPeca SERIAL PRIMARY KEY,
    descricao VARCHAR(100) not null,
    codigoPeca VARCHAR(50)  not null unique,
    quantidade INT not null,
    precoUnitario DECIMAL(10, 2) not null
);

CREATE TABLE Cliente (
    idCliente SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    ddi1 VARCHAR(5) not null,
    ddd1 VARCHAR(5) not null,
    numero1 VARCHAR(15) not null,
	unique(ddi1, ddd1, numero1),
    ddi2 VARCHAR(5) null,
    ddd2 VARCHAR(5) null,
    numero2 VARCHAR(15) null,
	unique(ddi2, ddd2, numero2),
    email VARCHAR(100) not null unique,
    logradouro VARCHAR(50) null,
    complemento VARCHAR(50) null,
	bairro VARCHAR(50) null,
    cep VARCHAR(10) null,
    municipio VARCHAR(50) null,
    uf VARCHAR(2) null
);

CREATE TABLE PessoaFisica (
    cpf VARCHAR(11) not null unique,
    idCliente SERIAL not null unique,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE PessoaJuridica (
    cnpj VARCHAR(14) not null unique,
    inscricaoEstadual VARCHAR(50) not null unique,
    contato VARCHAR(50) not null,
    razaoSocial VARCHAR(100) not null unique,
    idCliente INT not null unique,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE Marca (
    idMarca SERIAL PRIMARY KEY,
    descricao VARCHAR(50) not null
);

CREATE TABLE Modelo (
    idModelo SERIAL PRIMARY KEY,
    descricao VARCHAR(50) not null,
    idMarca INT not null,
    FOREIGN KEY (idMarca) REFERENCES Marca(idMarca)
);

CREATE TABLE Acessorio (
    idAcessorio SERIAL PRIMARY KEY,
    descricao VARCHAR(150) not null,
    idVeiculo int not null
	-- travou kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
    --FOREIGN KEY (placaFK) REFERENCES Veiculo(placa) -- posivelmente vai travar aqui, pq veiculo ta em baixo.
);

CREATE TABLE Veiculo (
	idVeiculo SERIAL PRIMARY KEY,
    placa VARCHAR(10) not null unique,
    chassi VARCHAR(50) null unique,
    kilometragem INT null,
    nPatrimonio VARCHAR(50) null unique,
    ano INT not null,
    idAcessorio INT null,
    idModelo INT not null,
    FOREIGN KEY (idAcessorio) REFERENCES Acessorio(idAcessorio),
    FOREIGN KEY (idModelo) REFERENCES Modelo(idModelo)
);

CREATE TABLE Propriedade (
    idPropriedade SERIAL PRIMARY KEY,
    dataInicio DATE not null,
    dataFim DATE null,
    idVeiculo int not null,
    idCliente INT not null,
    FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo),
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE OrdemServico (
    numeroOS SERIAL PRIMARY KEY,
    inicio DATE not null,
    fim DATE null,
    totalPago DECIMAL(10, 2) null,
    precoFinal DECIMAL(10, 2) null,
    status VARCHAR(50) not null, -- Isso aqui vai virar Enum
    idVeiculo int not null,
    FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo)
);

CREATE TABLE Funcionario (
    idFuncionario SERIAL PRIMARY KEY,
    nome VARCHAR(50) not null,
    especialidade VARCHAR(50) not null
);

CREATE TABLE Servico (
    idServico SERIAL PRIMARY KEY,
    descricao VARCHAR(100) not null unique,
    precoUnitario DECIMAL(10, 2) not null
);

CREATE TABLE ItensServico (
    idItensServicos SERIAL PRIMARY KEY,
    quantidade INT not null,
    precoUnitario DECIMAL(10, 2) not null,
    precoFinal DECIMAL(10, 2) not null,
    idFuncionario INT not null,
    idServico INT null null,
    numeroOSFK INT not null,
    FOREIGN KEY (idFuncionario) REFERENCES Funcionario(idFuncionario),
    FOREIGN KEY (idServico) REFERENCES Servico(idServico),
    FOREIGN KEY (numeroOSFK) REFERENCES OrdemServico(numeroOS)
);

CREATE TABLE ItensPeca (
    idItensPeca SERIAL PRIMARY KEY,
    quantidade INT not null,
    precoUnitario DECIMAL(10, 2) not null,
    precoFinal DECIMAL(10, 2) not null,
    idPeca INT not null,
    numeroOSFK INT not null,
    FOREIGN KEY (idPeca) REFERENCES Peca(idPeca),
    FOREIGN KEY (numeroOSFK) REFERENCES OrdemServico(numeroOS)
);

CREATE TABLE Oficina (
    idOficina SERIAL PRIMARY KEY,
    email VARCHAR(100) not null unique,
    telefone VARCHAR(20) not null unique,
    endereco VARCHAR(150) not null,
    nomeFantasia VARCHAR(100) not null,
    razaoSocial VARCHAR(100) not null unique
);

ALTER TABLE Acessorio ADD FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo);