package controller;
import java.util.Calendar;
import java.util.Date;

import model.Client;
import model.Game;
import model.Location;

import util.Util;

import org.junit.Test;

public class LocationController {
	
	private final int patternDays = 5;
	
	@Test
	public Location rentGame(Client client, Game game, int quantity) {		
		Date devolution = new Util().addDays(new Date(), patternDays);
		Location location = new Location(
				client, game, new Date(), devolution, game.getValue(), quantity
			);
		return location;
	}
	
	/**
	 * @return boolean
	 * @param Client cliente
	 * @param Game jogo
	 * @param Location locação
	 * Faz todas as verificações
	 * */
	public boolean verify(Client client, Game game, Location location) {
		if (!this.verifyClient(client.getName(), location.getClient().getName())) return this.error("| Clientes divergem");
		if (!this.verifyName(game.getName(), location.getGame().getName())) return this.error("| Jogos divergem");
		if (!this.verifyValue(game.getValue(), location.getGame().getValue())) return this.error("| Valores divergem");
		if (!this.verifyDevolution(location.getDevolution(), location.getPullout())) return this.error("| Devolução precisa ser posterior à retirada");
		if (!this.verifyInventory(game.getInventory(), (int) location.getQuantity())) return this.error("| Quantidade insuficiente");
		if (!new Util().areEqualDates(location.getPullout())) return this.error("| Datas iguais");
		return this.success(client, game, location);
	}
	
	boolean success(Client client, Game game, Location location) {
		System.out.println(
			"| Locação realizada:" +
			"\nCliente: " + client.getName() +
			"\nJogo: " + game.getName() +
			"\nPreço: R$" + game.getValue() +
			"\nQuantity: " + location.getQuantity() +
			"\nTotal: R$" + location.getQuantity() * game.getValue() +
			"\n| Datas:" +
			"\nRetirada (Hoje): " + location.getPullout() +
			"\nDevolução: " + location.getDevolution()
		);
		return true;
	}
	
	boolean error(String msg) {
		System.out.println(msg);
		return false;
	}
	
	/**
	 * @return boolean
	 * @param String jogo
	 * @param String jogo alugado
	 * Verifica se o jogo alugado é o mesmo selecionado
	 * */
	boolean verifyName(String game, String rentedGame) {
		return game.equals(rentedGame);
	}
	
	/**
	 * @return boolean
	 * @param int estoque
	 * @param int quantidade alugada
	 * Verifica se a quantidade alugada é menor ou igual à quantidade disponível no estoque
	 * */
	boolean verifyInventory(int inventory, int rentedQuantity) {
		return inventory >= rentedQuantity;
	}
	
	/**
	 * @return boolean
	 * @param String nome do cliente
	 * @param String cliente que alugou
	 * Verifica se a quantidade alugada é menor ou igual à quantidade disponível no estoque
	 * */
	boolean verifyClient(String client, String rentedByClient) {
		return client.equals(rentedByClient);
	}
	
	/**
	 * @return boolean
	 * @param double preço
	 * @param double preço alugado
	 * Verifica o preço do jogo da locação é igual ao selecionado
	 * */
	boolean verifyValue(double value, double rentedValue) {
		return value == rentedValue;
	}
	
	/**
	 * @return boolean
	 * @param Date devolução
	 * @param Date retirada
	 * Verifica se a data de devolução é posterior à data de retirada
	 * */
	boolean verifyDevolution(Date devolution, Date pullout) {
		return devolution.after(pullout);
	}
	
}

//CÓDIGO ORIGINAL:

//package services;
//
//import java.util.Date;
//
//import Util.DataUtil;
//import qts.Locadora.model.Cliente;
//import qts.Locadora.model.Jogo;
//import qts.Locadora.model.Locacao;
//
//public class LocacaoService {
//	private final int diasPadrao = 5;
//	public Locacao alugarJogo(Cliente cliente, Jogo jogo) {
//		Locacao locacao =new Locacao();
//		locacao.setCliente(cliente);
//		locacao.setJogo(jogo);
//		locacao.setValor(jogo.getValor());
//		locacao.setRetirada(new Date());
//		
//		Date devolucao = new DataUtil().addDias(new Date(),diasPadrao);
//		locacao.setDevolucao(null);
//		return locacao;
//	}
//
//	public static void main(String[] args) {
//		// cenario
//		Cliente cliente = new Cliente("Wellington");
//		Jogo jogo = new Jogo("Homem Aranha",15.00, 5);
//		
//		//ação
//		LocacaoService locacaoService = new LocacaoService();
//		Locacao locacao = locacaoService.alugarJogo(cliente, jogo);
//		
//		//verificação
//		System.out.println(locacao.getJogo().getNome().equals(jogo.getNome()));
//		System.out.println(locacao.getCliente().getNome().equals(cliente.getNome()));
//		System.out.println(locacao.getValor()==jogo.getValor());
//		//System.out.println(locacao.getRetirada().compareTo(new Date())==0);
//		System.out.println(new DataUtil().verificaDatasIguais(locacao.getRetirada(), new Date()));
//	}
//}