package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class CaneTest {

	private AbstractPersonaggio cane;
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		this.cane = new Cane("Fido", "Woof Woof!", "osso",new Attrezzo("collare", 2));
		this.partita = new Partita();
	}
	
	@Test
	public void testCaneAgisciString() {
		assertEquals(Cane.MESSAGGIO_MORSO, this.cane.agisci(partita));
	}
	
	@Test
	public void testCaneAgisciCFU() {
		this.cane.agisci(partita);
		assertEquals(partita.getGiocatore().getCfuIniziali() - 1, partita.getGiocatore().getCfu());
	}

}
