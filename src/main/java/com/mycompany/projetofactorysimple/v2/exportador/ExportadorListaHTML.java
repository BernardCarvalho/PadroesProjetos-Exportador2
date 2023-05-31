package com.mycompany.projetofactorysimple.v2.exportador;

import com.mycompany.projetofactorysimple.v2.coluna.Coluna;
import com.mycompany.projetofactorysimple.v2.coluna.ColunaHtml;
import com.mycompany.projetofactorysimple.v2.model.Produto;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ExportadorListaHTML<T> extends AbstractExportadorLista<T> {


    public ExportadorListaHTML(List<T> lista) {
        super(lista);
    }

    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>";
    }

    @Override
    public String abrirLinha() {
        return "<tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String abrirLinhaTitulo() {
        return "<th>";
    }

    @Override
    public String fecharLinhaTitulo() {
        return "</th>\n";
    }

    @Override
    public String exportar() {
        StringBuilder exportado = new StringBuilder();
        exportado.append(this.abrirTabela());
            exportado.append(this.abrirLinhaTitulo());
            getColunas().forEach(coluna->{
                exportado.append("<td>")
                        .append(coluna.getTitulo())
                        .append("</td>");
            });
            exportado.append(this.fecharLinhaTitulo());

            for(int j=0;j<getLista().size();j++) {
                exportado.append("<tr>");
                T objeto = getLista().get(j);
                getColunas().forEach(coluna->{
                    exportado.append(coluna.abrir());
                    exportado.append(coluna.exportarDado(objeto));
                    exportado.append(coluna.fechar());
                });
                exportado.append("</tr>\n");
            }
        exportado.append(this.fecharTabela());
        return exportado.toString();
    }

    @Override
    public Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo) {
        return null;
    }

    @Override
    public Coluna<T> newColuna(Field field) {
        return new ColunaHtml<>(field);
    }
}
