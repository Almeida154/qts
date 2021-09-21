package model;
import org.junit.Test;
public class Game {
		
	// Attributes
	
	private String name;
	private double value;
	private int inventory;
	
	// Constructor
	
	public Game(String name, double value, int inventory) {
		super();
		this.name = name;
		this.value = value;
		this.inventory = inventory;
	}
	
	// Getters and Setters
	
	@Test
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public int getInventory() {
		return inventory;
	}
	
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
}

// CÓDIGO ORIGINAL:

//package qts.Locadora.model;
//
//public class Jogo {
//	private String nome;
//	private double valor;
//	private int estoque;
//	
//	public Jogo(String nome, double valor, int estoque) {
//		super();
//		this.nome = nome;
//		this.valor = valor;
//		this.estoque = estoque;
//	}
//	
//	public String getNome() {
//		return nome;
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	public double getValor() {
//		return valor;
//	}
//	public void setValor(double valor) {
//		this.valor = valor;
//	}
//	public int getEstoque() {
//		return estoque;
//	}
//	public void setEstoque(int estoque) {
//		this.estoque = estoque;
//	}
//}