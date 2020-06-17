package com.myTrip.entidades;

public class Local {
    private String nomePais;
    private String nomeCidade;

    public Local(String nomePais, String nomeCidade)
	{
		this.nomePais = nomePais;
		this.nomeCidade = nomeCidade;
    }
    
    public String nomeCidade(){
        return nomeCidade;
    }

    public String nomePais(){
        return nomePais;
    }

    @Override
	public String toString()
	{
		return nomeCidade + " - " + nomePais;
	}
}