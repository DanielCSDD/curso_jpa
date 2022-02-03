package com.curso.jpa.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.*;

public class Propriedades {

    private InputStream inStream;
    private Map<String, String> propriedades;

    private static final Logger log = Logger.getLogger(Propriedades.class.getName());
    private static final String RESOURCE_FILE = "EJBMessages";
    private static ResourceBundle resourceBundle;

    public Propriedades(InputStream inputStream) throws Exception{
        this.inStream = inputStream;
        iniciar();
    }

    public Propriedades(String arquivo)	throws Exception
    {
        FileInputStream inStream = new FileInputStream(arquivo);
        this.inStream = inStream;
        iniciar();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void iniciar() throws Exception
    {
        Properties props = new Properties();
        try
        {
            props.load(inStream);
            this.propriedades = new HashMap<String, String>((Map) props);
        }
        catch(Exception e)
        {
            throw new Exception("Problemas ao Carregar o arquivo de Propriedades", e);
        }
    }

    public String getPropriedade(String chave)
    {
        return propriedades.get(chave);
    }


    public Map<String, String> getPropriedades(){
        return propriedades;
    }

    private static ResourceBundle getRecurso() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE,
                    new Locale("pt", "BR"));
            if (resourceBundle == null) {
                log.error("Arquivo de propriedades não encontrado.");
            }
        }
        return resourceBundle;
    }

    public static String getMensagem(String mensagem) {
        return getMensagem(mensagem, new Object[] {});
    }

    public static String getMensagem(String mensagem, String... argumentos) {
        Object[] args = Arrays.copyOf(argumentos, argumentos.length, Object[].class);
        return getMensagem(mensagem, args);
    }


    public static String getMensagem(String mensagem, Object[] args)
    {
        try
        {
            String conteudo = getRecurso().getString(mensagem);
            if (args != null)
            {
                return MessageFormat.format(conteudo, args);
            }
            else
            {
                return conteudo;
            }
        }
        catch (Exception e)
        {
            String mensagemNaoCadastrada = "[Mensagem não cadastrada: "
                    + mensagem + "]";
            log.error(mensagemNaoCadastrada);
            return mensagemNaoCadastrada;
        }
    }
}
