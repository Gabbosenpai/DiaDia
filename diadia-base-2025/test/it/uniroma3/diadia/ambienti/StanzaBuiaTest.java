package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private static final String DESCRIZIONE_STANZA = "Stanza\n" + 
			"Uscite:\n" + 
			"Attrezzi nella stanza: [luce (1kg)]";
	
	private StanzaBuia stanzaBuia;
	private Attrezzo luce;
	
	@BeforeEach
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("Stanza", "luce");
		this.luce = new Attrezzo("luce", 1);
	}
	
	@Test
	void testStanzaBuiaSenzaLuce() {
		assertEquals(this.stanzaBuia.getDescrizioneStanzaBuia(), this.stanzaBuia.getDescrizione());
	}

	@Test
	void testStanzaBuiaConLuce() {
		this.stanzaBuia.addAttrezzo(luce);
		assertEquals(DESCRIZIONE_STANZA, this.stanzaBuia.getDescrizione());
	}
	
}
