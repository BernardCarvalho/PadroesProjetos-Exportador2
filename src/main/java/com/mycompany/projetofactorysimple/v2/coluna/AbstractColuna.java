package com.mycompany.projetofactorysimple.v2.coluna;

import com.mycompany.projetofactorysimple.v2.model.Produto;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public abstract class AbstractColuna<T> implements Coluna<T> {
    private final Field field;
    private String titulo;

    public AbstractColuna(Field field) {
        this.field = field;
        field.setAccessible(true);
        this.titulo = field.getName();
    }

    @Override
    public String exportarCabecalho(){
        return "";
    }
    @Override
    public String exportarDado(T objeto){
        try {
            return field.get(objeto).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
