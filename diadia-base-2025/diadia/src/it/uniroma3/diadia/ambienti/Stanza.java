package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;

	private Map<String,Attrezzo> attrezzi;
	private Map<Direzione,Stanza> stanzeAdiacenti;

	private AbstractPersonaggio personaggio;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<Direzione, Stanza>();
		this.attrezzi = new HashMap<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		if(this.stanzeAdiacenti.size() >= NUMERO_MASSIMO_DIREZIONI)
			return;
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}

	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}

	public Collection<Stanza> getAdiacenti() {
		return this.stanzeAdiacenti.values();
	}
	
	public Map<Direzione, Stanza> getStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null)
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return this.attrezzi.containsValue(attrezzo);
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite:");
		for (Direzione direzione : this.getDirezioni()) {
			if (direzione!=null)
				risultato.append(" " + direzione);
		}
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.attrezzi.values().toString());
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param Attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		Attrezzo rimosso = attrezzo;
		if(rimosso == null)
			return false;
		rimosso = this.attrezzi.remove(attrezzo.getNome());
		if(rimosso == null)
			return false;
		else
			return true;
	}

	//	Versione senza compattamento dell'Array	
	//	
	//	public boolean removeAttrezzo(Attrezzo attrezzo) {
	//		boolean rimosso = false;
	//		int i=0;
	//		while(!rimosso && i < this.attrezzi.length) {
	//			if(this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(attrezzo.getNome())) {
	//				this.attrezzi[i] = null;
	//				rimosso = true;
	//				this.numeroAttrezzi--;
	//			}
	//			i++;
	//		}
	//		return rimosso;
	//	}


	public Set<Direzione> getDirezioni() {
		Set<Direzione> direzioni = new HashSet<Direzione>();
		direzioni = this.stanzeAdiacenti.keySet();
		return direzioni;
	}

	public void setStanzeAdiacenti(Map<Direzione,Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}
}