package com.agendador.agenda.domain.entities;

import com.agendador.agenda.enums.ClienteTipoDocumento;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cad_cliente")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cli_id")
	private UUID id;

	@Column(name = "cli_nome")
	private String nome;

	@Column(name = "cli_sobrenome")
	private String sobrenome;

	@Column(name = "cli_razao_social")
	private String razaoSocial;

	@Column(name = "cli_rg")
	private String rg;

	@CPF
	@Column(name = "cli_cpf")
	private String cpf;

	@CNPJ
	@Column(name = "cli_cnpj")
	private String cnpj;

	@Column(name = "cli_tipo")
	private ClienteTipoDocumento tipo;

}
