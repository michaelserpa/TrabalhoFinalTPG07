package com.myTrip.casos_de_uso.servicos;

import com.myTrip.casos_de_uso.repositorios.RepositorioAgencia;
import com.myTrip.casos_de_uso.repositorios.RepositorioViagem;
import com.myTrip.entidades.Agencia;
import com.myTrip.entidades.Retorno;
import com.myTrip.entidades.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicosAgencia
{
	private RepositorioAgencia agencias;
	private RepositorioViagem viagens;

	@Autowired
	public ServicosAgencia(RepositorioAgencia agencias, RepositorioViagem viagens)
	{
		this.agencias = agencias;
		this.viagens = viagens;
	}

	public Retorno<Agencia> obterDadosAgencia(String cnpj)
	{
		return agencias.obterPorCnpj(cnpj);
	}

	public List<Viagem> obterViagensAgencias(String cnpj)
	{
		Retorno<Agencia> retAgencia = agencias.obterPorCnpj(cnpj);
		if (!retAgencia.ok())
		{
			throw new IllegalArgumentException(retAgencia.mensagem());
		}
		Retorno<List<Viagem>> retViagens = viagens.obterViagens(retAgencia.dados());
		if (!retViagens.ok())
		{
			throw new IllegalArgumentException(retViagens.mensagem());
		}
		return retViagens.dados();
	}
}