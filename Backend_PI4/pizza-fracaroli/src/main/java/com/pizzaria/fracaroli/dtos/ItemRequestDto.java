package com.pizzaria.fracaroli.dtos;

import lombok.Data;

@Data
public class ItemRequestDto {
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private String imagem;
	
	private String preco;
	
	private CategoriaRequestDto categoria;
	
}
