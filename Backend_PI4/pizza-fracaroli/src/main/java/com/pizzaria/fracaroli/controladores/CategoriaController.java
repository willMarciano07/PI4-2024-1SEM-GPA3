package com.pizzaria.fracaroli.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.fracaroli.dtos.CategoriaRequestDto;
import com.pizzaria.fracaroli.dtos.CategoriaResponseDto;
import com.pizzaria.fracaroli.negocio.CategoriaNegocio;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("categorias")
@AllArgsConstructor
public class CategoriaController {

	private CategoriaNegocio categoriaNegocio;
	
	@GetMapping
	public ResponseEntity<List<CategoriaResponseDto>> lista(
			@RequestParam(name = "embedItens", defaultValue = "true", required = false) boolean embedItens) {
		return ResponseEntity.ok(this.categoriaNegocio.listar(embedItens));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaResponseDto> salvar(@RequestBody CategoriaRequestDto request) {
		if(request.getId() == null)
			return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaNegocio.salvar(request));
		else
			return ResponseEntity.ok(this.categoriaNegocio.salvar(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaResponseDto> obter(@PathVariable("id") Long id) {
		var dto = this.categoriaNegocio.obter(id);
		if(dto != null)
			return ResponseEntity.ok(dto);
		else
			return ResponseEntity.noContent().build();
			
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.categoriaNegocio.deletar(id);
	}
}
