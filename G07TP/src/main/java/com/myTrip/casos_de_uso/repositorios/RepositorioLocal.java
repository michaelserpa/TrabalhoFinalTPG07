package com.myTrip.casos_de_uso.repositorios;

import com.myTrip.entidades.Local;
import com.myTrip.entidades.Retorno;

public interface RepositorioLocal
{
	Retorno<Local> obterPorCidade(String nomeCidade);
}