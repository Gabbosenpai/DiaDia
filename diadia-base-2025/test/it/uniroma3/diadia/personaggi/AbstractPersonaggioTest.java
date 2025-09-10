package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractPersonaggioTest {

	private static final String PRESENTAZIONE = 
			"Ciao, io sono Mario.Aò so io!";
	private static final String SALUTATO = 
			"Ciao, io sono Mario.Ci siamo gia' presentati!";
	
	private AbstractPersonaggio personaggio;

	@BeforeEach
	public void setUp(){
		this.personaggio = new FakePersonaggio("Mario", "Aò so io!");
	}

	@Test
	public void testGetPresentazione() {
		assertEquals("Aò so io!", this.personaggio.getPresentazione());
	}
	
	@Test
	public void testNonHaSalutato() {
		assertFalse(this.personaggio.haSalutato());
	}
	
	@Test
	public void testHaSalutato() {
		this.personaggio.saluta();
		assertTrue(this.personaggio.haSalutato());
	}
	
	@Test
	public void testToString() {
		assertEquals("Mario",this.personaggio.toString());
	}
	
	@Test
	public void testSaluta() {
		assertEquals(PRESENTAZIONE,this.personaggio.saluta());
	}
	
	@Test
	public void testSalutaDueVolte() {
		assertEquals(PRESENTAZIONE,this.personaggio.saluta());
		assertEquals(SALUTATO,this.personaggio.saluta());
	}

}
