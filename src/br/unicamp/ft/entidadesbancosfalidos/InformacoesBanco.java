/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ft.entidadesbancosfalidos;

import br.unicamp.ft.dadosbancosfalidos.DadosBancosFalidos;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InformacoesBanco{

    private final Map<String, Banco> listaBancos;
    private final DadosBancosFalidos bancoDadosPersist;
    public final List<String> nomesBancos;


    public InformacoesBanco() {
        bancoDadosPersist = new DadosBancosFalidos();
        listaBancos = bancoDadosPersist.lerBancosFalidosCSV();
        nomesBancos = bancoDadosPersist.obterHeader();
        
    }
    
    
    public int obterNumeroDatas(){
        return this.listaBancos.size();
    }
    
 
    public Map<String, Banco> buscarBancos(String nomeBuscado){
        Map<String, Banco> bancosBuscados = new TreeMap();
        for (Map.Entry<String, Banco> entry : this.listaBancos.entrySet()) {
            String nomeBanco =entry.getValue().getNome().toLowerCase();
            if (nomeBanco.contains(nomeBuscado)){
                 bancosBuscados.put(entry.getKey(), entry.getValue());
            }

           
        }

        return bancosBuscados;
    }
    
    public Banco buscarUmBanco(String cert){
        return listaBancos.get(cert);
    }

}
