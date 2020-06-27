package com.myTrip.casos_de_uso.repositorios;

import com.myTrip.entidades.Cliente;
import com.myTrip.entidades.Retorno;

public interface RepositorioCliente
{
    Retorno<Cliente> obterPorCpf(String cpf);
    Retorno<Cliente> obterlistaPorCpf(String cpf);
}