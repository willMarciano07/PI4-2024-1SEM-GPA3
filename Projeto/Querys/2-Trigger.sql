USE ThinkySys_Senac_GPA3;
-- Atualiza tabela Compras --------------------------

DELIMITER //
CREATE TRIGGER atualizaCompra2 
AFTER INSERT ON Vendas 
	FOR EACH ROW
		BEGIN
			INSERT INTO 
            Compras (id_produto, id_pessoaUsuario, id_vendaProduto, quantidadeProduto, valorTotal)
			VALUES 
            (NEW.id_produto, NEW.id_pessoaUsuario, NEW.id_vendaProduto, NEW.quantidadeProduto, NEW.valorTotal);
		END; //
DELIMITER ;

-- --------------------------------------------------

