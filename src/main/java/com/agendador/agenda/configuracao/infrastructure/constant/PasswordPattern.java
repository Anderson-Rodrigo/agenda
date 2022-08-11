package com.agendador.agenda.configuracao.infrastructure.constant;

public interface PasswordPattern {

    String VALUE = "(?=.*[0-9])((?=.*[a-z])||(?=.*[A-Z])).{8,}";
    String MESSAGE = "deve ter um tamanho mínimo de 8 caracteres incluindo letras e números";

}
