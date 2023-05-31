package com.mycompany.projetofactorysimple.v1.model;

import java.util.Random;
import java.util.UUID;

public class Produto {
    private String id;
    private String descricao;
    private String marca;
    private String modelo;
    private int estoque;

    public Produto() {}

    public Produto(String descricao, String marca, String modelo, int estoque) {
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.estoque = estoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    } 
}
