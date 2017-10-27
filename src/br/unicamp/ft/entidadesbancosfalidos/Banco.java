package br.unicamp.ft.entidadesbancosfalidos;

import java.util.Map;
import java.util.TreeMap;

public class Banco {
    private String cert;
    private String nome;
    private Map<String, Double> datas;
  
    
    public Banco(){
        datas = new TreeMap();
    }
    
    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void adicionarData(String discidados, Double encerra){
        this.datas.put(discidados, encerra);
    }
    
    public double retornarData(String discidados){
        return this.datas.get(discidados);
    }
    
    public Map<String, Double> getDatas() {
        return datas;
    }
      
    @Override
    public String toString(){        
        StringBuilder sb = new StringBuilder();
        sb.append("CERT:" );
        sb.append(this.cert);
        sb.append(";");
        sb.append("NOME:" );
        sb.append(this.nome);
        sb.append(";");

              
	for (Map.Entry<String, Double> entry : this.datas.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append(";");
	}
        
        return sb.toString();

    }
    
}
    