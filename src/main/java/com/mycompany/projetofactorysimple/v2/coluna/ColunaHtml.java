package com.mycompany.projetofactorysimple.v2.coluna;

import com.mycompany.projetofactorysimple.v2.coluna.AbstractColuna;
import com.mycompany.projetofactorysimple.v2.model.Produto;

import java.lang.reflect.Field;

public class ColunaHtml<T> extends AbstractColuna<T> {
    public ColunaHtml(Field field) {
        super(field);
    }

    @Override
    public String abrir() {
        return "<td>";
    }

    @Override
    public String fechar() {
        return "</td>";
    }
}
