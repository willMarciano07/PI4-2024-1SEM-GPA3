package com.pizzaria.fracaroli.negocio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.pizzaria.fracaroli.dtos.ItemRequestDto;
import com.pizzaria.fracaroli.dtos.ItemResponseDto;
import com.pizzaria.fracaroli.entidades.Item;
import com.pizzaria.fracaroli.repositorios.ItemRepositorio;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemNegocio {

	private ItemRepositorio itemRepositorio;
	
	public List<ItemResponseDto> listar(){
		return this.itemRepositorio
				.findAll()
				.stream()
				.map(item -> DozerBeanMapperBuilder.buildDefault().map(item, ItemResponseDto.class))
				.collect(Collectors.toList());
	}

	public ItemResponseDto obter(Long id){
		return this.itemRepositorio
				.findById(id)
				.map(item -> DozerBeanMapperBuilder.buildDefault().map(item, ItemResponseDto.class))
				.orElse(null);
	}
	
	public ItemResponseDto salvar(ItemRequestDto requestDto){
		var categoria = this.itemRepositorio
				.save(DozerBeanMapperBuilder.buildDefault().map(requestDto, Item.class));
		return DozerBeanMapperBuilder.buildDefault().map(categoria, ItemResponseDto.class);
	}

	@Transactional
	public void deletar(Long id){
		this.itemRepositorio.deleteById(id);
	}
	
}
