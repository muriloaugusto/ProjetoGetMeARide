

CREATE  TABLE IF NOT EXISTS cadastrogetmearide.cadastroCliente(

  nome VARCHAR(50) NULL DEFAULT NULL ,

  endereco VARCHAR(50) NULL DEFAULT NULL ,

  telefone VARCHAR(20) NULL DEFAULT NULL ,

  email VARCHAR(50) NULL DEFAULT NULL ,

  CPF Varchar(50) NULL DEFAULT NULL ,

  senha VARCHAR(50) NULL DEFAULT NULL ,

  id INT(11) NOT NULL AUTO_INCREMENT ,

  PRIMARY KEY (id) 
  )