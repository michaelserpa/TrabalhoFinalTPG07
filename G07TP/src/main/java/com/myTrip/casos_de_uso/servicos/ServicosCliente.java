package com.myTrip.casos_de_uso.servicos;

import com.myTrip.casos_de_uso.repositorios.RepositorioLocal;
import com.myTrip.casos_de_uso.repositorios.RepositorioViagem;
import com.myTrip.casos_de_uso.politicas.CalculoCustoTipo;
import com.myTrip.casos_de_uso.politicas.SelecaoAgencia;
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
	private RepositorioViagem viagens;

	@Autowired
	public ServicosCliente(RepositorioLocal locais, RepositorioCliente clientes, RepositorioAgencia agencias, RepositorioViagem viagens)
	{
		this.locais = locais;
		this.clientes = clientes;
		this.agencias = agencias;
		this.viagens = viagens;
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

		Retorno<Cliente> cliente = clientes.obterlistaPorCpf(cpf);
		if (!cliente.ok())
		{
			throw new IllegalArgumentException(cliente.mensagem());
		}

		SelecaoAgencia selecaoAgencia = new SelecaoAgencia();
		String cnpjAgencia = selecaoAgencia.SelecionaAgencia(destino);

		Retorno<Agencia> agencia = agencias.obterPorCnpj(cnpjAgencia);
		if (!agencia.ok())
		{
			throw new IllegalArgumentException("Agência não encotrada: " + origem);
		}

		CalculoCustoTipo custoTipo = new CalculoCustoTipo();
		Double custo = custoTipo.CalculoCusto(tipoPlano, destino);

		Viagem viagem = Viagem.novaViagem(1, localOrigem.dados(), localDestino.dados(), cliente.dados(), agencia.dados(), tPlano, custo);

		Retorno<Boolean> viagemCadastro = viagens.cadastrarViagem(viagem);
		if (!viagemCadastro.ok())
		{
			throw new IllegalArgumentException("Erro ao cadastrar a viagem");
		}

		return viagem;
	}
}