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
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.fracaroli.dtos.ItemRequestDto;
import com.pizzaria.fracaroli.dtos.ItemResponseDto;
import com.pizzaria.fracaroli.negocio.ItemNegocio;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("itens")
@AllArgsConstructor
public class ItemController {

	private ItemNegocio itemNegocio;
	
	@GetMapping
	public ResponseEntity<List<ItemResponseDto>> lista() {
		return ResponseEntity.ok(this.itemNegocio.listar());
	}
	
	@PostMapping
	public ResponseEntity<ItemResponseDto> salvar(@RequestBody ItemRequestDto request) {
		if(request.getId() == null)
			return ResponseEntity.status(HttpStatus.CREATED).body(this.itemNegocio.salvar(request));
		else
			return ResponseEntity.ok(this.itemNegocio.salvar(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemResponseDto> obter(@PathVariable("id") Long id) {
		var dto = this.itemNegocio.obter(id);
		if(dto != null)
			return ResponseEntity.ok(dto);
		else
			return ResponseEntity.noContent().build();
			
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.itemNegocio.deletar(id);
	}
}
