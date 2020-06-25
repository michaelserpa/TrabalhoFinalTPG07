package com.myTrip.casos_de_uso.servicos;

import com.myTrip.casos_de_uso.repositorios.RepositorioLocal;
import com.myTrip.casos_de_uso.repositorios.RepositorioAgencia;
import com.myTrip.casos_de_uso.repositorios.RepositorioCliente;
import com.myTrip.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosCliente
{
	private RepositorioLocal locais;
	private RepositorioCliente clientes;
	private RepositorioAgencia agencias;

	@Autowired
	public ServicosCliente(RepositorioLocal locais, RepositorioCliente clientes, RepositorioAgencia agencias)
	{
		this.locais = locais;
		this.clientes = clientes;
		this.agencias = agencias;
	}

	public Retorno<Cliente> obterDadosCliente(String cpf)
	{
		Retorno<Cliente> cliente = clientes.obterPorCpf(cpf);
		if (!cliente.ok())
		{
			throw new IllegalArgumentException(cliente.mensagem());
		}
		
		return clientes.obterPorCpf(cpf);
	}

	public Viagem criarViagem(String cpf, String origem, String destino, String formaPagamento, String tipoPlano)
	{
		Retorno<Cliente> cliente = clientes.obterPorCpf(cpf);
		if (!cliente.ok())
		{
			throw new IllegalArgumentException(cliente.mensagem());
		}

		Retorno<Agencia> agencia = agencias.obterPorCnpj("12345678901234");
		if (!agencia.ok())
		{
			throw new IllegalArgumentException("Agência não encotrada: " + origem);
		}

		TipoPlano tPlano;
		try
		{
			tPlano = TipoPlano.valueOf(tipoPlano);
		}
		catch (Exception ex)
		{
			throw new IllegalArgumentException("Tipo Plano Inválido: " + tipoPlano);
		}

		Retorno<Local> localOrigem = locais.obterPorCidade(origem);
		if (!localOrigem.ok())
		{
			throw new IllegalArgumentException("Local não encotrado: " + origem);
		}

		Retorno<Local> localDestino = locais.obterPorCidade(destino);
		if (!localDestino.ok())
		{
			throw new IllegalArgumentException("Local não encotrado: " + destino);
		}

		return Viagem.novaViagem(1, localOrigem.dados(), localDestino.dados(), cliente.dados(), agencia.dados(), tPlano, 200);
	}
}