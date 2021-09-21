package model;
import org.junit.Test;

public class Client {
	
	// Attributes
	
	private String name;
	
	// Constructor
	
	public Client(String name) {
		super();
		this.name = name;
	}
	
	// Getters and Setters
	
	@Test
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

//CÓDIGO ORIGINAL:

//package qts.locadora.model;

//public class Cliente {
//	private String nome;

//	public Cliente(String nome) {
//		super();
//		this.nome = nome;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//}
