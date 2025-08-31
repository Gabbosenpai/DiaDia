package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	private Borsa borsa;
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa();
	}
	
	@Test
	void testIsEmptyConBorsaVuota() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	void testIsEmptyConBorsaNonVuota() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	void testHasAttrezzoConBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo("pigna"));
	}
	
	@Test
	void testHasAttrezzoConAttrezzoPresente() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertTrue(this.borsa.hasAttrezzo("pigna"));
	}
	
	@Test
	void testHasAttrezzoConAttrezzoDiverso() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertFalse(this.borsa.hasAttrezzo("ghianda"));
	}
	
	@Test
	void testGetAttrezzoSuNull() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertNull(this.borsa.getAttrezzo(null));
	}
	
	@Test
	void testGetAttrezzoSuccesso() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.borsa.addAttrezzo(pigna);
		assertEquals(pigna, this.borsa.getAttrezzo("pigna"));
	}
	
	@Test
	void testGetAttrezzoAssente() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.borsa.addAttrezzo(pigna);
		assertNull(this.borsa.getAttrezzo("ghianda"));
	}
	

}
