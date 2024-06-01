package com.pizzaria.fracaroli.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.fracaroli.entidades.Categoria;
import com.pizzaria.fracaroli.entidades.Item;

public interface ItemRepositorio extends JpaRepository<Item, Long>{
	
	List<Item> findByCategoria(Categoria categoria);
	void deleteAllByCategoriaId(Long id);

}
