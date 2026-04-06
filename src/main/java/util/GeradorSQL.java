package util;

import anotacoes.Descricao;

public class GeradorSQL {

    public static String gerarSelect(Class<?> classe) {

        if (classe.isAnnotationPresent(Descricao.class)) {
            Descricao d = classe.getAnnotation(Descricao.class);

            return "SELECT * FROM " + d.descricao();
        }

        return "Sem descricao";
    }
}