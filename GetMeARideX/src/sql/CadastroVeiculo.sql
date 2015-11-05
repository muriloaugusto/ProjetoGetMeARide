CREATE  TABLE IF NOT EXISTS CadastroGetMeARide.cadastroVeiculo(

  carro VARCHAR(50) NULL DEFAULT NULL ,

  placa VARCHAR(50) NULL DEFAULT NULL ,

  marca VARCHAR(50) NULL DEFAULT NULL ,

  cor VARCHAR(50) NULL DEFAULT NULL ,

  renavam Float(12),

  id INT(11) NOT NULL AUTO_INCREMENT ,

  PRIMARY KEY (id)
  )