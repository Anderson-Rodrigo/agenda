package com.agendador.agenda.interfaces.controllers;

import com.agendador.agenda.domain.entities.Cliente;
import com.agendador.agenda.domain.service.ClienteService;
import com.agendador.agenda.interfaces.converter.ClienteConverter;
import com.agendador.agenda.interfaces.dto.ClienteDto;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	public final ClienteService clienteService;
	public final ClienteConverter clienteConverter = Mappers.getMapper(ClienteConverter.class);;

	public ClienteController (ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody ClienteDto dto){
		Cliente cliente = clienteConverter.createEntity(dto);
		if(cliente != null){
			cliente = clienteService.insert(cliente);
			return new ResponseEntity<>(cliente.getId(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable UUID id, @RequestBody ClienteDto dto){
		Cliente cliente = clienteConverter.createEntity(dto);

		if(clienteService.getById(id).isPresent()){
			cliente = clienteService.update(cliente);
			ClienteDto clienteDtoCoverted = clienteConverter.createDto(cliente);
			return new ResponseEntity<>(clienteDtoCoverted.getId(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id){
		Optional<Cliente> cliente = clienteService.getById(id);
		if(cliente.isPresent()){
			clienteService.delete(cliente.get());
			return new ResponseEntity<>( HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable UUID id){
		Optional<Cliente> cliente = clienteService.getById(id);
		if(cliente.isPresent()){
			return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<?> getAll(){
		Optional<List<Cliente>> clientes = clienteService.getAll();
		if(clientes.isPresent()){
			return new ResponseEntity<>(clientes, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
