create table cad_cliente (

    cli_id uuid not null,
    cli_nome varchar(60) not null,
    cli_sobrenome varchar(60),
    cli_razao_social varchar(60),
    cli_cpf varchar(11),
    cli_cnpj varchar(14),
    cli_tipo varchar(2),

    constraint pk_cli_id primary key (cli_id)
)