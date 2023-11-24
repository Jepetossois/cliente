package br.com.jepeto.Cliente.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jepeto.Cliente.models.entites.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{
	
	Cliente findByCpf(String cpf);

}
