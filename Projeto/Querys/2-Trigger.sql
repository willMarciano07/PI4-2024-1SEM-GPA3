-- Atualiza tabela Compras --------------------------

DELIMITER //
CREATE TRIGGER atualizaCompra
AFTER INSERT ON Vendas
FOR EACH ROW
BEGIN
	UPDATE Compras
    SET id_produto = NEW.id_produto,	
		id_pessoaUsuario = NEW.id_pessoaUsuario
	WHERE id_vendaProduto = NEW.id_vendaProduto;
END; //
DELIMITER ;

-- --------------------------------------------------

