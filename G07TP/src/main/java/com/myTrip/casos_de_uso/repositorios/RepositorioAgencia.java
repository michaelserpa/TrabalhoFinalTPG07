package com.myTrip.casos_de_uso.repositorios;

import com.myTrip.entidades.Agencia;
import com.myTrip.entidades.Retorno;

public interface RepositorioAgencia
{
	Retorno<Agencia> obterPorCnpj(String cnpj);
}