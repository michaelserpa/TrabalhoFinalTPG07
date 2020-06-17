package com.myTrip.entidades;

import java.util.List;

public class Viagem {
    private int id;
	private Local origem;
	private List<Local> destino;
	private Cliente cliente;
    private Agencia agencia;
    private TipoPlano tipo;
    private double custo;

    public Viagem(int id, Local origem, List<Local> destino, Cliente cliente, Agencia agencia, TipoPlano tipo, double custo)
	{
		this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.cliente = cliente;
        this.agencia = agencia;
        this.tipo = tipo;
        this.custo = custo;
    }

    public static Viagem novaViagem(int id, Local origem, List<Local> destino, Cliente cliente, Agencia agencia, TipoPlano tipo, double custo)
	{
		return new Viagem(id,origem,destino,cliente,agencia,tipo,custo);
    }
    
    public static Viagem viagemExistente(int id, Local origem, List<Local> destino, Cliente cliente, Agencia agencia, TipoPlano tipo, double custo)
	{
		return new Viagem(id,origem,destino,cliente,agencia,tipo,custo);
    }
    
    public int id(){
        return id;
    }

    public Local origem(){
        return origem;
    }

    public List<Local> destino(){
        return destino;
    }

    public Cliente cliente(){
        return cliente;
    }

    public Agencia agencia(){
        return agencia;
    }

    public TipoPlano tipo(){
        return tipo;
    }

    public double custo(){
        return custo;
    }

    @Override
	public String toString()
	{
		return id + " - " + custo;
	}
}