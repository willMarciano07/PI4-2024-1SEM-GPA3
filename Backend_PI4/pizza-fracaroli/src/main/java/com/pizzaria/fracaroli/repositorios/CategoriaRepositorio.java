package com.pizzaria.fracaroli.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.fracaroli.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
	
}
