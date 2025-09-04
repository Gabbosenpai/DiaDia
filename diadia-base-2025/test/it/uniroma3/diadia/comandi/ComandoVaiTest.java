package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {

	private Partita partita;
	private Stanza stanzaIniziale;
	private Comando comandoVai;
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.stanzaIniziale = new Stanza("stanzaIniziale");
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita.setStanzaCorrente(stanzaIniziale);
	}
	
	@Test
	public void testComandoVaiStanzaAssente() {
		this.comandoVai.setParametro("sud");
		this.comandoVai.esegui(partita);
		assertEquals(stanzaIniziale, partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiStanzaPresente() {
		Stanza stanzaSud = new Stanza("stanzaSud");
		this.stanzaIniziale.impostaStanzaAdiacente("sud", stanzaSud);
		this.comandoVai.setParametro("sud");
		this.comandoVai.esegui(partita);
		assertEquals(stanzaSud, partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiStanzaPresenteDirezioneSbagliata() {
		Stanza stanzaSud = new Stanza("stanzaSud");
		this.stanzaIniziale.impostaStanzaAdiacente("sud", stanzaSud);
		this.comandoVai.setParametro("nord");
		this.comandoVai.esegui(partita);
		assertEquals(stanzaIniziale, partita.getStanzaCorrente());
	}

}
