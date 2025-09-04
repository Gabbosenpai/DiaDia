package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza stanzaVincente;
	private Stanza stanzaIngresso;

	public Labirinto() {
		creaStanze();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	private void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo statua = new Attrezzo("statua",30);
		Attrezzo chiave = new Attrezzo("chiave", 1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza cinema = new StanzaBuia("Cinema", "lanterna");
		Stanza caveau = new StanzaBloccata("Caveau","sud", "chiave");
		Stanza tesoreria = new Stanza("Tesoreria");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("sud", cinema);
		cinema.impostaStanzaAdiacente("nord", laboratorio);
		cinema.impostaStanzaAdiacente("ovest", caveau);
		caveau.impostaStanzaAdiacente("est", cinema);
		caveau.impostaStanzaAdiacente("sud", tesoreria);
		tesoreria.impostaStanzaAdiacente("nord", caveau);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		laboratorio.addAttrezzo(statua);
		cinema.addAttrezzo(chiave);
		
		// il gioco comincia nell'atrio
		stanzaIngresso = atrio;  
		stanzaVincente = biblioteca;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public Stanza getStanzaIngresso() {
		return this.stanzaIngresso;
	}

	public void setStanzaIngresso(Stanza stanzaIngresso) {
		this.stanzaIngresso = stanzaIngresso;
	}
}
