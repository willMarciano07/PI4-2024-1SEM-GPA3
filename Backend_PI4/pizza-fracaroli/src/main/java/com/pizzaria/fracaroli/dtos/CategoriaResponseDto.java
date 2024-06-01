package com.pizzaria.fracaroli.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CategoriaResponseDto {
	
	private Long id;
	
	private String nome;
	
	private List<ItemResponseDto> itens = new ArrayList<>();
	
}
