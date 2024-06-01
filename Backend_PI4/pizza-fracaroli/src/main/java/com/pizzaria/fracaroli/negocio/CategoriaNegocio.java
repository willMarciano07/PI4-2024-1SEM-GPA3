package com.pizzaria.fracaroli.negocio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.pizzaria.fracaroli.dtos.CategoriaRequestDto;
import com.pizzaria.fracaroli.dtos.CategoriaResponseDto;
import com.pizzaria.fracaroli.dtos.ItemResponseDto;
import com.pizzaria.fracaroli.entidades.Categoria;
import com.pizzaria.fracaroli.repositorios.CategoriaRepositorio;
import com.pizzaria.fracaroli.repositorios.ItemRepositorio;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaNegocio {

	private CategoriaRepositorio categoriaRepositorio;
	
	private ItemRepositorio itemRepositorio;
	
	public List<CategoriaResponseDto> listar(boolean embedItens){
		return this.categoriaRepositorio
				.findAll()
				.stream()
				.map(categoria -> {
					var categoriaDto = DozerBeanMapperBuilder.buildDefault().map(categoria, CategoriaResponseDto.class);
					if(embedItens)
						this.itemRepositorio
						.findByCategoria(categoria)
						.stream()
						.map(item -> DozerBeanMapperBuilder.buildDefault().map(item, ItemResponseDto.class))
						.forEach(itemDto -> categoriaDto.getItens().add(itemDto))
						;
					return categoriaDto;
				}).collect(Collectors.toList());
	}

	public CategoriaResponseDto obter(Long id){
		return this.categoriaRepositorio
				.findById(id)
				.map(categoria -> {
					var categoriaDto = DozerBeanMapperBuilder.buildDefault().map(categoria, CategoriaResponseDto.class);
					this.itemRepositorio
					.findByCategoria(categoria)
					.stream()
					.map(item -> DozerBeanMapperBuilder.buildDefault().map(item, ItemResponseDto.class))
					.forEach(itemDto -> categoriaDto.getItens().add(itemDto));
					return categoriaDto;
				})
				.orElse(null);
	}
	
	public CategoriaResponseDto salvar(CategoriaRequestDto requestDto){
		var categoria = this.categoriaRepositorio
				.save(DozerBeanMapperBuilder.buildDefault().map(requestDto, Categoria.class));
		return DozerBeanMapperBuilder.buildDefault().map(categoria, CategoriaResponseDto.class);
	}

	@Transactional
	public void deletar(Long id){
		//deleta todos os itens vinculados a categoria
		this.itemRepositorio.deleteAllByCategoriaId(id);
		//deleta a categoria
		this.categoriaRepositorio.deleteById(id);
	}
	
}
