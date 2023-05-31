package com.mycompany.projetofactorysimple.v1;
import java.util.List;

import com.mycompany.projetofactorysimple.v1.interfaces.ExportadorListaProduto;
import com.mycompany.projetofactorysimple.v1.model.Produto;

import javax.naming.OperationNotSupportedException;


public class ProjetoFactorySimple {

    public static void main(String[] args) throws OperationNotSupportedException {
    	List<Produto> produtos = List.of(
                new Produto("TV", "LG", "132-A", 120),
                new Produto("Notebook", "Asus", "New age", 341),
                new Produto("Smartphone", "Samsung", "Galaxy S10", 214));
    	
    	System.out.println("Lista de Produtos em HTML \n");
    	ExportadorListaProduto exportadorHtml = ExportadorListaProduto.newInstance(".html");
    	System.out.println(exportadorHtml.exportar(produtos));
    	
    	System.out.println("\nLista de Produtos em Markdown");
    	ExportadorListaProduto exportadorMark = ExportadorListaProduto.newInstance("markdown");
    	System.out.print(exportadorMark.exportar(produtos));

		System.out.println("\nLista de Produtos em Csv");
		ExportadorListaProduto exportadorCsv = ExportadorListaProduto.newInstance(".csv");
		System.out.print(exportadorCsv.exportar(produtos));

		System.out.println("\nLista de Produtos em PDF");
		ExportadorListaProduto exportadorPDF = ExportadorListaProduto.newInstance("pdf");
		System.out.print(exportadorMark.exportar(produtos));
    }
}
