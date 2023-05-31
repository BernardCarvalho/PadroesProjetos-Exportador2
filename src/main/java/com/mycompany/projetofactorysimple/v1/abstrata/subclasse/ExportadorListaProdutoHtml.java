
package com.mycompany.projetofactorysimple.v1.abstrata.subclasse;

import com.mycompany.projetofactorysimple.v1.abstrata.AbstractExportadorListaProduto;

public class ExportadorListaProdutoHtml extends AbstractExportadorListaProduto{

    @Override
    public String abrirTabela() {
          return "<table>";
    }

    @Override
    public String fecharTabela() {
        return "</table>";
    }

    @Override
    public String abrirLinha() {
          return " <tr>";
    }

    @Override
    public String fecharLinha() {
          return "</tr>";
    }
    
    @Override
    public String abrirLinhaTitulo() {
        return " <th>";
    }
    
    @Override
    public String fecharLinhaTitulo() {
          return "</th>";
    }

    @Override
    public String abrirColuna(String valor) {
          return "<td>";
    }

    @Override
    public String fecharColuna() {
          return "</td>";
    }   
}
