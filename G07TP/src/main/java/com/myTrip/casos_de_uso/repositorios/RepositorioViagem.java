package com.myTrip.casos_de_uso.repositorios;

import com.myTrip.entidades.Agencia;
import com.myTrip.entidades.Viagem;
import com.myTrip.entidades.Retorno;
import java.util.List;

public interface RepositorioViagem
{
    Retorno<Boolean> cadastrarViagem(Viagem viagem);
    Retorno<List<Viagem>> obterViagens(Agencia agencia);
}