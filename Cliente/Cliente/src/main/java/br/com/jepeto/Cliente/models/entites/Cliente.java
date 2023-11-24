package br.com.jepeto.Cliente.models.entites;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity (name = "tb_clientes")
@Data
public class Cliente {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	
	private String nome;
	
	@Column(length = 14)
	private String cpf;
	private String email;
	private String numero;
	private String senha;
	
	@CreationTimestamp
	private LocalDateTime criadoEm;
}
