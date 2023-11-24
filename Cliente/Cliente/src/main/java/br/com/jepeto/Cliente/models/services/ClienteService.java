package br.com.jepeto.Cliente.models.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jepeto.Cliente.models.entites.Cliente;
import br.com.jepeto.Cliente.models.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente listaCpf(Cliente cliente){
		return repository.findByCpf(cliente.getCpf());
	}
	
	public List<Cliente> listarClientes(){
		return repository.findAll();
	}
	
	public Cliente novoCliente( Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Optional<Cliente> buscarClientePorId(UUID id){
		return repository.findById(id);
	}
	
	public Cliente atualizarCliente(UUID id, Cliente cliente) {
		cliente.setId(id);
		return repository.save(cliente);
	}
	
	
	public void deletarCliente(UUID id) {
		repository.deleteById(id);
	}
	
	
	

}
