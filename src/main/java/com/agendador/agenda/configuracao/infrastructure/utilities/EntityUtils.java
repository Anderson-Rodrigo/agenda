package com.agendador.agenda.configuracao.infrastructure.utilities;

import lombok.SneakyThrows;

public final class EntityUtils {

    @SneakyThrows
    public static boolean isUpdateMode(Object entity) {
        return (IdUtils.getValue(entity) != null);
    }

    @SneakyThrows
    public static boolean isInsertMode(Object entity) {
        return (IdUtils.getValue(entity) == null);
    }

}
