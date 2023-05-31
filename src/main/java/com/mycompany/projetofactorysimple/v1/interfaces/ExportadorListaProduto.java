
package com.mycompany.projetofactorysimple.v1.interfaces;

import java.util.Arrays;
import java.util.List;

import com.mycompany.projetofactorysimple.v1.abstrata.subclasse.ExportadorListaProdutoCsv;
import com.mycompany.projetofactorysimple.v1.abstrata.subclasse.ExportadorListaProdutoHtml;
import com.mycompany.projetofactorysimple.v1.abstrata.subclasse.ExportadorListaProdutoMarkdown;
import com.mycompany.projetofactorysimple.v1.model.Produto;

import javax.naming.OperationNotSupportedException;

public interface ExportadorListaProduto {
    
    public String abrirTabela();
    public String fecharTabela();
    public String abrirLinha();
    public String fecharLinha();
    public String abrirLinhaTitulo();
    public String fecharLinhaTitulo();
    public String abrirColuna(String valor);
    public String fecharColuna();
    public String exportar(List<Produto> listaProdutos);
    
    public static ExportadorListaProduto newInstance() {
        return new ExportadorListaProdutoHtml();
    }
    public static ExportadorListaProduto newInstance(String extensaoArquivoExportacao) throws OperationNotSupportedException {
        final String FORMATOS_SUPORTADOS[]={"HTML","CSV","MARKDOWN"};

        if(extensaoArquivoExportacao.toLowerCase().contains(FORMATOS_SUPORTADOS[0].toLowerCase()))
            return new ExportadorListaProdutoHtml();
        if(extensaoArquivoExportacao.toLowerCase().contains(FORMATOS_SUPORTADOS[1].toLowerCase()))
            return new ExportadorListaProdutoCsv();
        if(extensaoArquivoExportacao.toLowerCase().contains(FORMATOS_SUPORTADOS[2].toLowerCase()))
            return new ExportadorListaProdutoMarkdown();

        throw new OperationNotSupportedException("\nFormato "+extensaoArquivoExportacao+" não suportado pela fabrica\n"+
                "Escolha um dos formatos suportados:"+ Arrays.toString(FORMATOS_SUPORTADOS));
    }
    
}
