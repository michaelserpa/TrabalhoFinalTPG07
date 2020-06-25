package com.myTrip.interfaces.persistencia;

import com.myTrip.casos_de_uso.repositorios.RepositorioViagem;
import com.myTrip.entidades.Agencia;
import com.myTrip.entidades.Retorno;
import com.myTrip.entidades.Viagem;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class RepositorioViagemMem implements RepositorioViagem
{
	private Map<String, List<Viagem>> viagens;

	public RepositorioViagemMem()
	{
		viagens = new HashMap<>();

		viagens.put("", new LinkedList<>());
	}

	@Override
	public Retorno<Boolean> cadastrarViagem(Viagem viagem)
	{
		if (viagens.containsKey(viagem.agencia().cnpj()))
		{
			viagens.get(viagem.agencia().cnpj())
					.add(viagem);
			return Retorno.retornarSucesso(true);
		}
		LinkedList<Viagem> listaInicial = new LinkedList<>();
		listaInicial.add(viagem);
		viagens.put(viagem.agencia().cnpj(), listaInicial);
		return Retorno.retornarSucesso(true);
	}

	@Override
	public Retorno<List<Viagem>> obterViagens(Agencia agencia)
	{
		List<Viagem> viagensAgencia = viagens.get(agencia.cnpj());
		if (viagensAgencia == null)
		{
			return Retorno.retornarFalha("Agencia " + agencia.nome() + " não possui viagens");
		}
		return Retorno.retornarSucesso(viagensAgencia);
	}
}