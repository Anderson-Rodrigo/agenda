package com.agendador.agenda.interfaces.dto;

import com.agendador.agenda.enums.ClienteTipoDocumento;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ClienteDto implements Serializable {

	private UUID id;

	private String nome;

	private String sobrenome;

	private String razaoSocial;

	private String rg;

	private String cpf;

	private String cnpj;

	private ClienteTipoDocumento tipo;

}
