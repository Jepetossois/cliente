package br.com.jepeto.Cliente.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jepeto.Cliente.models.entites.Cliente;
import br.com.jepeto.Cliente.models.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping("/")
	public ResponseEntity<Object> criarCliente(@RequestBody Cliente cliente){
		//verifica se o CPF já existe no banco de dados
		var cpf = this.service.listaCpf(cliente);
		if(cpf != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já existente");
		}
		
		//salva o cliente caso não exista o cpf no banco de dados
		var usuarioCriado = this.service.novoCliente(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioCriado);
	}
	
	@GetMapping("/")
	public List<Cliente> listarClientes(){
		return service.listarClientes();
	
	}
	
	@GetMapping("/{id}")
	public Cliente buscarClientePorId(@PathVariable UUID id) {
		return service.buscarClientePorId(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizarCliente(@PathVariable UUID id, @RequestBody Cliente cliente) {
		//mante o atributo "criadoEm" sem alteração
		Optional<Cliente> original = service.buscarClientePorId(id);
		cliente.setCriadoEm(original.get().getCriadoEm());
		
		return service.atualizarCliente(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente (@PathVariable UUID id) {
		service.deletarCliente(id);
	}
	
	 

}
