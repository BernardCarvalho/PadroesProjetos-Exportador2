
package com.mycompany.projetofactorysimple.v1.abstrata;

import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.projetofactorysimple.v1.interfaces.ExportadorListaProduto;
import com.mycompany.projetofactorysimple.v1.model.Produto;


public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {
	private final List<String> TITULOS = List.of("ID", "Descrição", "Marca", "Modelo", "Estoque");
	
    @Override
    public String exportar(List<Produto> listaProdutos) {
		StringBuilder sb = new StringBuilder();
    	 	sb	.append(abrirTabela())
				.append("\n")
				.append(abrirLinhaTitulo())
				.append(TITULOS.stream()
						.map(titulo -> abrirColuna("") + titulo + fecharColuna())
						.collect(Collectors.joining()))
				.append(fecharLinhaTitulo())
				.append("\n")
				.append(adicionarLinhasProdutos(listaProdutos))
				.append("\n").append(fecharTabela());

         return sb.toString();
    }

	public String adicionarLinhasProdutos(List<Produto> listaProdutos) {
		 return listaProdutos.stream()
	                .map(this::adicionarColunaProduto)
	                .collect(Collectors.joining("\n"));
	}
	
	public String adicionarColunaProduto(Produto produto) {
		List<String> dadosProduto = List.of(String.valueOf(produto.getId()), produto.getDescricao(),
                produto.getMarca(), produto.getModelo(), String.valueOf(produto.getEstoque()));
        return abrirLinha() + dadosProduto.stream()
                .map(dado -> abrirColuna("") + dado + fecharColuna())
                .collect(Collectors.joining()) + fecharLinha();
	}

}
