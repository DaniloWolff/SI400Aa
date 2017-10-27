
package br.unicamp.ft.dadosbancosfalidos;

import br.unicamp.ft.entidadesbancosfalidos.Banco;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DadosBancosFalidos {

    List<String> nomesBancos  = new ArrayList();
    
    
    public Map<String, Banco> lerBancosFalidosCSV() {
            Map<String, Banco> listaBancos = new TreeMap();
            try {
                CSVReader reader = new CSVReader(new FileReader("arquivo_csv/banklist.csv"), ',' , '"' , 0);

                String[] nextLine;
                boolean headerFoiLido = false;
                
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine != null) {
          
                        if (!headerFoiLido){
                            preencherNomesBancos(nextLine);
                            headerFoiLido = true;
                            continue;
                        }
                        
                        Banco banco = new Banco();
                        banco.setCert(nextLine[0]);
                        banco.setNome(nextLine[1]);
                        int i=2;
                        for (String nome : nomesBancos) {
                            banco.adicionarDados(nome, new Double(nextLine[i]));
                            i++;
                        }
                       
                        listaBancos.put(banco.getCert(), banco);
                        
                    }
                }
               
               
            } 
            catch (IOException ex) {
            Logger.getLogger(DadosBancosFalidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listaBancos;
    }
    
    public List<String> obterHeader(){
        return nomesBancos;
    }
    
    public void preencherNomesBancos(String[] nextLine) {
            for(String column: nextLine){
                if (!column.equals("CERT")&& !column.equals("NOME")){
                    nomesBancos.add(column);
                }
            }
    }
}
    
  