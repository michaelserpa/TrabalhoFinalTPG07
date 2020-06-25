package com.myTrip.interfaces.persistencia;

import com.myTrip.casos_de_uso.repositorios.RepositorioAgencia;
import com.myTrip.entidades.Agencia;
import com.myTrip.entidades.FormaDePagamento;
import com.myTrip.entidades.Retorno;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
public class RepositorioAgenciaMem implements RepositorioAgencia
{
	private Map<String, Agencia> agencias;

	public RepositorioAgenciaMem()
	{
        agencias = new HashMap<>();
        Set<FormaDePagamento> formasPgto = new HashSet<>();
        formasPgto.add(FormaDePagamento.BOLETO);

        agencias.put("12345678901234", Agencia.novaAgencia("12345678901234", "CVC", formasPgto));
        agencias.put("12345678901235", Agencia.novaAgencia("12345678901235", "Hotel Urbano", formasPgto));
        agencias.put("12345678901236", Agencia.novaAgencia("12345678901236", "Decolar.com", formasPgto));
	}

	@Override
	public Retorno<Agencia> obterPorCnpj(String cnpj)
	{
		Agencia agencia = agencias.get(cnpj);
		if (agencia == null)
		{
			return Retorno.retornarFalha("Agencia Inexistente, CNPJ: " + cnpj);
		}
		return Retorno.retornarSucesso(agencia);
    }
}