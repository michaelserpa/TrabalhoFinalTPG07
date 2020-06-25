package com.myTrip.interfaces.webservice;


import com.myTrip.casos_de_uso.servicos.ServicosAgencia;
import com.myTrip.casos_de_uso.servicos.ServicosCliente;
import com.myTrip.entidades.Viagem;
import com.myTrip.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/myTrip")
public class ClienteFachadaRemota
{
	private ServicosCliente servicosCliente;
	private ServicosAgencia servicosAgencia;

	@Autowired
	public ClienteFachadaRemota(ServicosCliente servicosCliente, ServicosAgencia servicosAgencia)
	{
		this.servicosCliente = servicosCliente;
		this.servicosAgencia = servicosAgencia;
	}

	@CrossOrigin(origins = "*")//"http://localhost")
	@GetMapping("/solicitarviagem")
	public Viagem dadosViagem(@RequestParam String cpf,
	                            @RequestParam String lOrig,
	                            @RequestParam String lDest,
	                            @RequestParam String formaPgto,
	                            @RequestParam String tViagem)
	{

		Viagem viagem = servicosCliente.criarViagem(cpf, lOrig, lDest, formaPgto, tViagem);
		return viagem;
	}

	@CrossOrigin(origins = "*")//"http://localhost")
	@GetMapping("/listarviagens")
	public List<Viagem> listarViagens(@RequestParam String cnpj)
	{
		List<Viagem> lstViagens = servicosAgencia.obterViagensAgencias(cnpj);
		return lstViagens;
	}

	@CrossOrigin(origins = "*")//"http://localhost")
	@GetMapping("/buscarcliente")
	public Cliente dadosCliente(@RequestParam String cpf)
	{
		Cliente cliente = servicosCliente.obterDadosCliente(cpf).dados();
		return cliente;
	}
}