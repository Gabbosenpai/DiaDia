package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

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
		Attrezzo tomo = new Attrezzo("tomo", 2);
		Attrezzo doblone = new Attrezzo("doblone", 5);
		Attrezzo diamante = new Attrezzo("diamanate", 2);
		Attrezzo collare = new Attrezzo("collare", 2);
		
		/* crea i personaggi */
		AbstractPersonaggio mago = new Mago("Merlino", "Aò so io!", tomo);
		AbstractPersonaggio strega = new Strega("Svetlana", "Hihihihi sono molto stronza!");
		AbstractPersonaggio cane = new Cane("Panzone", "Woof Woof!", "osso", collare);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza cinema = new StanzaBuia("Cinema", "lanterna");
		Stanza caveau = new StanzaBloccata("Caveau",Direzione.SUD, "chiave");
		Stanza tesoreria = new Stanza("Tesoreria");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente(Direzione.NORD, biblioteca);
		atrio.impostaStanzaAdiacente(Direzione.EST, aulaN11);
		atrio.impostaStanzaAdiacente(Direzione.SUD, aulaN10);
		atrio.impostaStanzaAdiacente(Direzione.OVEST, laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzione.EST, laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzione.OVEST, atrio);
		aulaN10.impostaStanzaAdiacente(Direzione.NORD, atrio);
		aulaN10.impostaStanzaAdiacente(Direzione.EST, aulaN11);
		aulaN10.impostaStanzaAdiacente(Direzione.OVEST, laboratorio);
		laboratorio.impostaStanzaAdiacente(Direzione.EST, atrio);
		laboratorio.impostaStanzaAdiacente(Direzione.OVEST, aulaN11);
		laboratorio.impostaStanzaAdiacente(Direzione.SUD, cinema);
		cinema.impostaStanzaAdiacente(Direzione.NORD, laboratorio);
		cinema.impostaStanzaAdiacente(Direzione.OVEST, caveau);
		caveau.impostaStanzaAdiacente(Direzione.EST, cinema);
		caveau.impostaStanzaAdiacente(Direzione.SUD, tesoreria);
		tesoreria.impostaStanzaAdiacente(Direzione.NORD, caveau);
		biblioteca.impostaStanzaAdiacente(Direzione.SUD, atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		laboratorio.addAttrezzo(statua);
		cinema.addAttrezzo(chiave);
		tesoreria.addAttrezzo(doblone);
		tesoreria.addAttrezzo(diamante);
		
		/* pone i personaggi nelle stanze */
		
		caveau.setPersonaggio(strega);
		aulaN10.setPersonaggio(cane);
		atrio.setPersonaggio(mago);
		
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
