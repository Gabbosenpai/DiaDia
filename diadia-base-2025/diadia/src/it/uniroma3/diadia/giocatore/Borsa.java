package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;

	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}

	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(this.attrezzi[i] != null)
				peso += this.attrezzi[i].getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
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
	    Attrezzo attrezzoDaRimuovere = null;
	    for (int i = 0; i < this.numeroAttrezzi; i++) {
	        if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
	            attrezzoDaRimuovere = this.attrezzi[i];
	            // compatto spostando a sinistra gli elementi successivi
	            for (int j = i; j < this.numeroAttrezzi - 1; j++) {
	                this.attrezzi[j] = this.attrezzi[j + 1];
	            }
	            this.attrezzi[this.numeroAttrezzi - 1] = null; // ultimo slot libero
	            this.numeroAttrezzi--;
	            break; // esce dal ciclo dopo aver rimosso l'attrezzo
	        }
	    }
	    return attrezzoDaRimuovere;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				if(attrezzi[i] != null)
					s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}

