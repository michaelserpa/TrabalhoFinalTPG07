package com.myTrip.interfaces.persistencia;

import com.myTrip.casos_de_uso.repositorios.RepositorioCliente;
import com.myTrip.entidades.Cliente;
import com.myTrip.entidades.FormaDePagamento;
import com.myTrip.entidades.Retorno;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class RepositorioClienteMem implements RepositorioCliente
{
	private Map<String, Cliente> clientes;

	public RepositorioClienteMem()
	{
		clientes = new HashMap<>();

        clientes.put("123456789-01", Cliente.novoCliente("123456789-01", "Michael Rosa", FormaDePagamento.CREDITO));
        clientes.put("223456789-01", Cliente.novoCliente("223456789-01", "Matheus Rosa", FormaDePagamento.CREDITO));
        clientes.put("323456789-01", Cliente.novoCliente("323456789-01", "Murilo Rosa", FormaDePagamento.DEBITO));
	}

	@Override
	public Retorno<Cliente> obterPorCpf(String cpf)
	{
		Cliente cliente = clientes.get(cpf);
		if (cliente == null)
		{
			return Retorno.retornarFalha("Cliente Inexistente: " + cpf);
		}
		clientes.replace(cpf, cliente);
		return Retorno.retornarSucesso(cliente);
	}
	@Override
	public Retorno<Cliente> obterlistaPorCpf(String cpf)
	{
		Cliente cliente = clientes.get(cpf);
		if (cliente == null)
		{
			return Retorno.retornarFalha("Cliente Inexistente: " + cpf);
		}
		cliente.setqtdViagens();
		clientes.replace(cpf, cliente);
		return Retorno.retornarSucesso(cliente);
    }
}