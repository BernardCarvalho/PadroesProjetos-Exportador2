package com.mycompany.projetofactorysimple.v2;

import com.mycompany.projetofactorysimple.v2.exportador.AbstractExportadorLista;
import com.mycompany.projetofactorysimple.v2.exportador.ExportadorLista;
import com.mycompany.projetofactorysimple.v2.model.Produto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("TV", "LG", "132-A", 120),
                new Produto("Notebook", "Asus", "New age", 341),
                new Produto("Smartphone", "Samsung", "Galaxy S10", 214));

        System.out.println("Lista de Produtos em HTML \n");
        var exportadorHtml = ExportadorLista.newInstance(produtos);
        System.out.println(exportadorHtml.exportar());

//        System.out.println("\nLista de Produtos em Markdown");
//        ExportadorListaProduto exportadorMark = ExportadorListaProduto.newInstance("markdown");
//        System.out.print(exportadorMark.exportar(produtos));
//
//        System.out.println("\nLista de Produtos em Csv");
//        ExportadorListaProduto exportadorCsv = ExportadorListaProduto.newInstance(".csv");
//        System.out.print(exportadorCsv.exportar(produtos));

        System.out.println("\nLista de Produtos em PDF");
        var exportadorPDF = ExportadorLista.newInstance(produtos,"pdf");
        System.out.print(exportadorPDF.exportar());
    }
}
