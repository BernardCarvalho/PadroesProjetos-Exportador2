package com.mycompany.projetofactorysimple.v2.exportador;

import com.mycompany.projetofactorysimple.v2.coluna.Coluna;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    private List<T> lista;
    private List<Coluna<T>> colunas;

    public AbstractExportadorLista(List<T> lista) {
        this.lista = Objects.requireNonNull(lista);
        if(lista.isEmpty())
            return;

        var obj = lista.get(0);
        Field[] fields = obj.getClass().getDeclaredFields();
        colunas = new ArrayList<>(fields.length);
        Arrays.stream(fields).forEach(this::addColuna);
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public List<Coluna<T>> getColunas() {
        return colunas;
    }

    public void setColunas(List<Coluna<T>> colunas) {
        this.colunas = colunas;
    }



    public void addColuna(Field field) {
        this.addColuna(newColuna(field));
    }

    public void addColuna(Coluna<T> coluna) {
        colunas.add(coluna);
    }

}
