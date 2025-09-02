package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	private Attrezzo pigna;
	
	@BeforeEach
	public void setUp() {
		this.stanzaMagica = new StanzaMagica("Stanza", 2);
		this.pigna = new Attrezzo("pigna",1);
	}
	
	@Test
	public void testAddAttrezzoPreSoglia() {
		this.stanzaMagica.addAttrezzo(pigna);
		assertEquals("pigna", this.stanzaMagica.getAttrezzo(pigna.getNome()).getNome());
	}
	
	@Test
	public void testAddAttrezzoPostSoglia() {
		this.stanzaMagica.setSogliaMagica(0);
		this.stanzaMagica.addAttrezzo(pigna);
		assertEquals("angip", this.stanzaMagica.getAttrezzo("angip").getNome());
	}

}
