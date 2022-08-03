package com.agendador.agenda.domain.service;

import com.agendador.agenda.domain.entities.Cliente;
import com.agendador.agenda.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente insert(Cliente cliente){
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> getById(UUID id){
		return clienteRepository.findById(id);
	}

	public void delete(Cliente cliente){
		clienteRepository.delete(cliente);
	}

	public Optional<List<Cliente>> getAll(){
		return Optional.of(clienteRepository.findAll());
	}

	public Cliente update(Cliente cliente){
		return clienteRepository.save(cliente);
	}
}
