package com.myTrip.casos_de_uso.politicas;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class SelecaoAgencia {
    public String SelecionaAgencia(String destino){
        Map<String, List<String>> agencias = new HashMap<>();
        List<String> cvc = new LinkedList<String>(Arrays.asList("Lima","Buenos Aires"));
        List<String> hotelUrbano = new LinkedList<String>(Arrays.asList("Sidney","Paris"));
        List<String> decolar = new LinkedList<String>(Arrays.asList("Londres","Dublin"));
        agencias.put("12345678901234", cvc);
        agencias.put("12345678901235", hotelUrbano);
        agencias.put("12345678901236", decolar);
        String auxRetorno = "";
        for (Map.Entry<String, List<String>> entrada : agencias.entrySet()) {
            if(entrada.getValue().contains(destino)){
                auxRetorno = entrada.getKey();
            }
            else{
            auxRetorno = "12345678901234";
            }
        }
        return auxRetorno;
    }
}