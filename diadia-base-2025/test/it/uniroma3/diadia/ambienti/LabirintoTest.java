package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testInizializzazioneStanzaIngresso() {
		assertNotNull(this.labirinto.getStanzaIngresso());
	}
	
	@Test
	public void testInizializzazioneStanzaVincente() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}
	
	@Test
	public void testSetNullIngresso() {
		this.labirinto.setStanzaIngresso(null);
		assertNull(this.labirinto.getStanzaIngresso());
	}
	
	@Test
	public void testSetNullStanzaVincente() {
		this.labirinto.setStanzaVincente(null);
		assertNull(this.labirinto.getStanzaVincente());
	}

}
