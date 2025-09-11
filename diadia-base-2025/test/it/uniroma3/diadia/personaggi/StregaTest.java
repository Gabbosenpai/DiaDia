package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StregaTest {

	private Strega strega;
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		this.strega = new Strega("Gertrude", "Magica Bula Chittese ncula");
		this.partita = new Partita();
		this.creaPiccoloLabirinto();
	}
	
	@Test
	void testStregaAgisciSenzaSaluto() {
		this.strega.agisci(partita);
		assertEquals("pochiAttrezzi", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	void testStregaAgisciConSaluto() {
		this.strega.saluta();
		this.strega.agisci(partita);
		assertEquals("moltiAttrezzi", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	void testStregaAgisciSenzaSalutoAdiacenteVuota() {
		this.creaPiccoloLabirinto2();
		this.strega.agisci(partita);
		assertEquals("iniziale", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	void testStregaAgisciConSalutoAdiacenteVuota() {
		this.creaPiccoloLabirinto2();
		this.strega.saluta();
		this.strega.agisci(partita);
		assertEquals("pochiAttrezzi", this.partita.getStanzaCorrente().getNome());
	}

	public void creaPiccoloLabirinto() {
		Stanza iniziale = new Stanza("iniziale");
		Stanza moltiAttrezzi = new Stanza("moltiAttrezzi");
		Stanza pochiAttrezzi = new Stanza("pochiAttrezzi");
		moltiAttrezzi.addAttrezzo(new Attrezzo("pigna",1));
		moltiAttrezzi.addAttrezzo(new Attrezzo("ghianda",2));
		pochiAttrezzi.addAttrezzo(new Attrezzo("noce",0));
		iniziale.impostaStanzaAdiacente(Direzione.NORD, pochiAttrezzi);
		iniziale.impostaStanzaAdiacente(Direzione.SUD, moltiAttrezzi);
		pochiAttrezzi.impostaStanzaAdiacente(Direzione.EST, moltiAttrezzi);
		pochiAttrezzi.impostaStanzaAdiacente(Direzione.SUD, iniziale);
		moltiAttrezzi.impostaStanzaAdiacente(Direzione.NORD, iniziale);
		moltiAttrezzi.impostaStanzaAdiacente(Direzione.OVEST, pochiAttrezzi);
		iniziale.setPersonaggio(strega);
		this.partita.setStanzaCorrente(iniziale);
	}
	
	public void creaPiccoloLabirinto2() {
		Stanza iniziale = new Stanza("iniziale");
		Stanza moltiAttrezzi = new Stanza("moltiAttrezzi");
		Stanza pochiAttrezzi = new Stanza("pochiAttrezzi");
		moltiAttrezzi.addAttrezzo(new Attrezzo("pigna",1));
		moltiAttrezzi.addAttrezzo(new Attrezzo("ghianda",2));
		pochiAttrezzi.addAttrezzo(new Attrezzo("noce",0));
		iniziale.impostaStanzaAdiacente(Direzione.NORD, pochiAttrezzi);
		iniziale.impostaStanzaAdiacente(Direzione.SUD, moltiAttrezzi);
		pochiAttrezzi.impostaStanzaAdiacente(Direzione.EST, moltiAttrezzi);
		pochiAttrezzi.impostaStanzaAdiacente(Direzione.SUD, iniziale);
		moltiAttrezzi.impostaStanzaAdiacente(Direzione.NORD, iniziale);
		moltiAttrezzi.impostaStanzaAdiacente(Direzione.OVEST, pochiAttrezzi);
		moltiAttrezzi.setPersonaggio(strega);
		this.partita.setStanzaCorrente(moltiAttrezzi);
	}
	
}
