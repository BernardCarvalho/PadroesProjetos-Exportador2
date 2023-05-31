package com.mycompany.projetofactorysimple.v2.coluna;

public interface Coluna<T> {
    public String getTitulo();
    public void setTitulo(String titulo);
    public String abrir();
    public String fechar();
    public String exportarCabecalho();
    public String exportarDado(T objeto);

}
