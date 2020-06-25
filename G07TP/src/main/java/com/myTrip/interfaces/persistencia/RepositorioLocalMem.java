package com.myTrip.interfaces.persistencia;

import com.myTrip.casos_de_uso.repositorios.RepositorioLocal;
import com.myTrip.entidades.Local;
import com.myTrip.entidades.Retorno;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RepositorioLocalMem implements RepositorioLocal
{
	private Map<String, Local> locais;

	public RepositorioLocalMem()
	{
		locais = new HashMap<>();

        locais.put("Buenos Aires", new Local("Argentina", "Buenos Aires"));
        locais.put("Lima", new Local("Peru","Lima"));
        locais.put("Sidney", new Local("Australia","Sidney"));
        locais.put("Dublin", new Local("Irlanda","Dublin"));
        locais.put("Londres", new Local("Inglaterra","Londres"));
        locais.put("Paris", new Local("França","Paris"));
        locais.put("Porto Alegre", new Local("Brasil","Porto Alegre"));
	}

	@Override
	public Retorno<Local> obterPorCidade(String nomeCidade)
	{
		Local local = locais.get(nomeCidade);
		if (local == null)
		{
			return Retorno.retornarFalha("Local inexistente: " + nomeCidade);
		}
		return Retorno.retornarSucesso(local);
	}
}