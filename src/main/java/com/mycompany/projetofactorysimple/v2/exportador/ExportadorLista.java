package com.mycompany.projetofactorysimple.v2.exportador;

import com.mycompany.projetofactorysimple.v2.coluna.Coluna;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface ExportadorLista<T> {
    static <T> ExportadorLista newInstance(List<T> list) {
        return new ExportadorListaHTML(list);
    }

    public static  <T> ExportadorLista newInstance(List<T> list, String extensaoArquivoExportacao) {
        final Map<String, ExportadorLista> formatosSuportados = new HashMap<>();

        formatosSuportados.put("HTML", new ExportadorListaHTML(list));
        //formatosSuportados.put("CSV", new ExportadorListaCSV());
        //formatosSuportados.put("MARKDOWN", new ExportadorListaMARKDOWN());

        if(!formatosSuportados.containsKey(extensaoArquivoExportacao.toUpperCase().trim()))
            throw new UnsupportedOperationException("\nErro - O formato '"+extensaoArquivoExportacao+
                    """
                    ' escolhido não é suportado.
                    Escolha um dos formatos suportados:
                    """+
                    formatosSuportados.keySet().toString()
                    );

        return formatosSuportados.get(extensaoArquivoExportacao.toUpperCase().trim());
    }

    public String abrirTabela();
    public String fecharTabela();
    public String abrirLinha();
    public String fecharLinha();
    public String abrirLinhaTitulo();
    public String fecharLinhaTitulo();
    public String exportar();
    public Coluna<T> newColuna(Function<T,String> funcaoValorColuna, String titulo);

    Coluna<T> newColuna(Field field);
    public void addColuna(Coluna<T> coluna);
}
