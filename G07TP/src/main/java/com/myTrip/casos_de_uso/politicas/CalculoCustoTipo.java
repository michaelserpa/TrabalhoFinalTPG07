package com.myTrip.casos_de_uso.politicas;
import java.util.HashMap;
import java.util.Map;

public class CalculoCustoTipo{


    public Double CalculoCusto(String tipo, String destino) {
        Map<String, Integer> locais;
        locais = new HashMap<>();

        locais.put("Buenos Aires",1000);
        locais.put("Lima", 1500);
        locais.put("Sidney", 3000);
        locais.put("Dublin", 3000);
        locais.put("Londres", 2800);
        locais.put("Paris", 2500);
        locais.put("Porto Alegre", 0);
        switch (tipo)
		{
			case "SIMPLES":
				return locais.get(destino)*1.0;
			case "PADRAO":
                return locais.get(destino)*1.5;
			case "LUXO":
                return locais.get(destino)*2.0;
			default:
				return 0.0;
		}
    }
}