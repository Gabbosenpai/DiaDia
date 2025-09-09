package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.w3c.dom.Attr;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;

	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int peso;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.peso = 0;
		this.attrezzi = new HashMap<String, Attrezzo>(); // speriamo bastino...
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.peso += attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		return this.peso;
	}
	
	public int getPeso2() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi.values())
			peso += a.getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	//	/*Versione meno efficente, si scorre tutto l'array e se ci sono
	//	due attrezzi con lo stesso nome, rimuove l'ultimo trovato*/
	//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	//		Attrezzo attrezzoDaRimuovere = null;
	//		int indice = 0;
	//		for(Attrezzo attrezzo : this.attrezzi) {
	//			if(attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo)) {
	//				attrezzoDaRimuovere = attrezzo;
	//				this.attrezzi[indice] = null;
	//			}
	//			indice++;
	//		}
	//		return attrezzoDaRimuovere;
	//	}

	//	/*Versione più efficente, si scorre l'array finchè non
	//	  trova l'attrezzo con un certo nome, poi lo rimuove*/
	//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	//		Attrezzo attrezzoDaRimuovere = null;
	//		int i = 0; //indice di scorrimento
	//		while(attrezzoDaRimuovere == null && i < this.attrezzi.length) {
	//			if(this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
	//				attrezzoDaRimuovere = this.attrezzi[i];
	//				this.attrezzi[i] = null;
	//				this.numeroAttrezzi--;
	//			}
	//			i++;
	//		}
	//		return attrezzoDaRimuovere;
	//	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> ordinatoPerPeso = new ArrayList<>();
		ordinatoPerPeso.addAll(this.attrezzi.values());
		Collections.sort(ordinatoPerPeso, new ComparatoreAttrezziPerPeso());
		return ordinatoPerPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> gruppoPerPeso = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> attrezziPerPeso;
		for(Attrezzo a : this.attrezzi.values()) {
			 if(gruppoPerPeso.containsKey(a.getPeso())) {
				 attrezziPerPeso = gruppoPerPeso.get(a.getPeso());
				 attrezziPerPeso.add(a);
			 }
			 else{
				 attrezziPerPeso = new HashSet<Attrezzo>();
				 attrezziPerPeso.add(a);
				 gruppoPerPeso.put(a.getPeso(), attrezziPerPeso);
			 }
		}
		return gruppoPerPeso;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso2(){
		Map<Integer, Set<Attrezzo>> gruppoPerPeso = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> attrezziPerPeso;
		for(Attrezzo a : this.attrezzi.values()) {
			attrezziPerPeso = gruppoPerPeso.get(a.getPeso());
			if(attrezziPerPeso == null) {
				attrezziPerPeso = new HashSet<Attrezzo>();
				gruppoPerPeso.put(a.getPeso(), attrezziPerPeso);
			}
			attrezziPerPeso.add(a);
		}
		return gruppoPerPeso;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> sortedPerPeso = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		sortedPerPeso.addAll(this.attrezzi.values());
		return sortedPerPeso;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.attrezzi.values().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}

