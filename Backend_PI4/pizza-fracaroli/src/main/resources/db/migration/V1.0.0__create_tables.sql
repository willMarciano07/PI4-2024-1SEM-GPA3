CREATE TABLE IF NOT EXISTS `pizza-fracaroli`.`categoria` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` TEXT NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pizza-fracaroli`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(400) NOT NULL,
  `descricao` TEXT NOT NULL,
  `imagem` TEXT NOT NULL,
  `preco` VARCHAR(400) NOT NULL,
  `categoria_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_categoria_item_idx` (`categoria_id` ASC) VISIBLE,
  CONSTRAINT `fk_categoria_item`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `pizza-fracaroli`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;