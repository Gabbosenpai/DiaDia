package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	private Giocatore giocatore;
	
	@BeforeEach
	public void setUp() {
		this.giocatore = new Giocatore();
	}
	
	@Test
	void testIsVivoInizioPartita() {
		assertTrue(this.giocatore.isVivo());
	}
	
	@Test
	void testIsVivoCfuEsauriti() {
		this.giocatore.setCfu(0);
		assertFalse(this.giocatore.isVivo());
	}
	
	@Test
	void testInizializzazioneNumeroCfuCorretto() {
		assertEquals(this.giocatore.getCfuIniziali(), this.giocatore.getCfu());
	}

}
