package model;
import java.util.Date;
import org.junit.Test;

public class Location {
	
	// Attributes
	
	private Client client;
	private Game game;
	private Date pullout; // retirada
	private Date devolution;
	private double value;
	private int quantity;
	
	// Constructors
	
	public Location() {}
	
	public Location(Client client,  Game game, Date pullout, Date devolution, double value, int quantity) {
		super();
		this.client = client;
		this.game = game;
		this.pullout = pullout;
		this.devolution = devolution;
		this.value = value;
		this.quantity = quantity;
	}
	
	// Getters and Setters
	
	@Test
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Date getPullout() {
		return pullout;
	}

	public void setPullout(Date pullout) {
		this.pullout = pullout;
	}

	public Date getDevolution() {
		return devolution;
	}

	public void setDevolution(Date devolution) {
		this.devolution = devolution;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}

//CÓDIGO ORIGINAL:

//package qts.Locadora.model;
//
//import java.util.Date;
//import java.util.List;
//
//public class Locacao {
//	private Cliente cliente;
//	private Jogo jogo;
//	private Date retirada;
//	private Date devolucao;
//	private double valor;
//	
//	public Locacao() {}
//	
//	public Locacao(Cliente cliente,  Jogo jogo, Date retirada, Date devolucao, double valor) {
//		super();
//		this.cliente = cliente;
//		this.jogo = jogo;
//		this.retirada = retirada;
//		this.devolucao = devolucao;
//		this.valor = valor;
//	}
//
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//	public Jogo getJogo() {
//		return jogo;
//	}
//
//	public void setJogo(Jogo jogo) {
//		this.jogo = jogo;
//	}
//
//	public Date getRetirada() {
//		return retirada;
//	}
//
//	public void setRetirada(Date retirada) {
//		this.retirada = retirada;
//	}
//
//	public Date getDevolucao() {
//		return devolucao;
//	}
//
//	public void setDevolucao(Date devolucao) {
//		this.devolucao = devolucao;
//	}
//
//	public double getValor() {
//		return valor;
//	}
//
//	public void setValor(double valor) {
//		this.valor = valor;
//	}	
//
//}