package com.mycompany.projetofactorysimple.v1.abstrata.subclasse;

import com.mycompany.projetofactorysimple.v1.abstrata.AbstractExportadorListaProduto;

public class ExportadorListaProdutoCsv extends AbstractExportadorListaProduto {
    @Override
    public String abrirTabela() {
        return  "";
    }

    @Override
    public String fecharTabela() {
        return "";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "";
    }

    @Override
    public String abrirLinhaTitulo() {
        return "";
    }

    @Override
    public String fecharLinhaTitulo() {
        return "\n";
    }

    @Override
    public String abrirColuna(String valor) {
        return valor;
    }

    @Override
    public String fecharColuna() {
        return ";";
    }
}
