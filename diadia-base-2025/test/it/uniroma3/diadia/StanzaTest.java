package it.uniroma3.diadia;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest {

	private Stanza stanza;
	private Stanza adiacenteSud;
	private Stanza adiacenteEst;
	
	@BeforeEach
	public void setUp() {
		this.stanza = new Stanza("stanzaTest");
		this.adiacenteSud = new Stanza("stanzaAdiacenteSud");
		this.adiacenteEst = new Stanza("stanzaAdiacenteEst");
		this.stanza.impostaStanzaAdiacente("sud", adiacenteSud);
		this.stanza.impostaStanzaAdiacente("est", adiacenteEst);
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneNull() {
		assertNull(this.stanza.getStanzaAdiacente(null));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneInesistente() {
		assertNull(this.stanza.getStanzaAdiacente("Pippo"));
	}
	
	@Test
	public void testGetStanzaAdiacenteAssente() {
		assertNull(this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacentePresente() {
		assertEquals(this.adiacenteSud, this.stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteCorrettaSud() {
		assertEquals(this.adiacenteSud, this.stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteCorrettaEst() {
		assertEquals(this.adiacenteEst, this.stanza.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteDirezioneNull() {
		Stanza adiacenteOvest = new Stanza("stanzaAdiacenteOvest");
		this.stanza.impostaStanzaAdiacente(null, adiacenteOvest);
		assertEquals(2, this.stanza.getNumeroStanzeAdiacenti());
	}
	
	@Test
	public void testImpostaStanzaAdiacenteStanzaNull() {
		this.stanza.impostaStanzaAdiacente("ovest", null);
		assertEquals(2, this.stanza.getNumeroStanzeAdiacenti());
	}
	
	@Test
	public void testImpostaStanzaAdiacenteParametriNull() {
		this.stanza.impostaStanzaAdiacente(null, null);
		assertEquals(2, this.stanza.getNumeroStanzeAdiacenti());
	}
	
	
	@Test
	public void testImpostaStanzaAdiacenteSovrascrittura() {
		Stanza sovrascritta = new Stanza("stanza");
		this.stanza.impostaStanzaAdiacente("est", sovrascritta);
		assertEquals(sovrascritta, this.stanza.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertFalse(this.stanza.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoStanzaPiena() {
		this.stanza.setNumeroAttrezzi(10);
		Attrezzo pigna = new Attrezzo("pigna", 1);
		assertFalse(this.stanza.addAttrezzo(pigna));
	}
	
	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		assertTrue(this.stanza.addAttrezzo(pigna));
		assertEquals(pigna, this.stanza.getAttrezzo("pigna"));
	}
	
	@Test
	public void testHasAttrezzoSuNull() {
		
		assertFalse(this.stanza.hasAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzoAttrezzoPresente() {
		this.stanza.addAttrezzo(new Attrezzo("pigna", 1));
		assertTrue(this.stanza.hasAttrezzo("pigna"));
	}
	
	@Test
	public void testHasAttrezzoAttrezzoAssente() {
		assertFalse(this.stanza.hasAttrezzo("pigna"));
	}
	
	@Test
	public void testGetAttrezzoSuNull() {
		this.stanza.addAttrezzo(new Attrezzo("pigna", 1));
		assertNull(this.stanza.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoSuccesso() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.stanza.addAttrezzo(pigna);
		assertEquals(pigna, this.stanza.getAttrezzo("pigna"));
	}
	
	@Test
	public void testGetAttrezzoAssente() {
		assertNull(this.stanza.getAttrezzo("pigna"));
	}
}
