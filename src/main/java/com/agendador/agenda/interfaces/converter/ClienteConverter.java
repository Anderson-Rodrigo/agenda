package com.agendador.agenda.interfaces.converter;

import com.agendador.agenda.domain.entities.Cliente;
import com.agendador.agenda.interfaces.dto.ClienteDto;
import org.mapstruct.Mapper;

@Mapper
public abstract class ClienteConverter {

	public abstract Cliente createEntity(ClienteDto dto);

	public abstract ClienteDto createDto(Cliente cliente);

}
