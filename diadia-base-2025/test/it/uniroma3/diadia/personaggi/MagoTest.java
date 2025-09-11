package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class MagoTest {

	private AbstractPersonaggio mago;
	private Partita partita;
	private Attrezzo tomo;
	
	@BeforeEach
	public void setUp() {
		this.tomo = new Attrezzo("Tomo", 1);
		this.partita = new Partita();
		this.mago = new Mago("Merlino", "Aò", tomo);
	}
	
	@Test
	public void testMagoAgisciString() {
		assertEquals(Mago.MESSAGGIO_DONO, this.mago.agisci(partita));
	}
	
	@Test
	public void testMagoAgisciSingolo() {
		this.mago.agisci(partita);
		assertEquals(tomo, partita.getStanzaCorrente().getAttrezzo("Tomo"));
	}
	
	@Test
	public void testMagoAgisciDoppio() {
		this.mago.agisci(partita);
		assertEquals(tomo, partita.getStanzaCorrente().getAttrezzo("Tomo"));
		assertEquals(Mago.MESSAGGIO_SCUSE, this.mago.agisci(partita));
	}

}
