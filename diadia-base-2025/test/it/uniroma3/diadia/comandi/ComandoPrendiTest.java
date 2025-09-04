package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	private static final String AttrezzoDaPrendere = "attrezzoDaPrendere";
	
	private Partita partita;
	private Comando comandoPrendi;
	private Attrezzo attrezzoDaPrendere;
	
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.comandoPrendi = new ComandoPrendi();
		this.attrezzoDaPrendere = new Attrezzo(AttrezzoDaPrendere,1);
		this.comandoPrendi.setIO(new IOConsole());
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPrendere);
	}

	@Test
	public void testComandoPrendiSuccesso() {
		this.comandoPrendi.setParametro(AttrezzoDaPrendere);
		this.comandoPrendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPrendere));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPrendere));
	}
	
	@Test
	public void testComandoPrendiAttrezzoNomeSbagliato() {
		this.comandoPrendi.setParametro("pigna");
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPrendere));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPrendere));
	}
	
	@Test
	public void testComandoPrendiAttrezzoStanzaVuota() {
		this.partita.getStanzaCorrente().removeAttrezzo(this.attrezzoDaPrendere);
		this.comandoPrendi.setParametro(AttrezzoDaPrendere);
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPrendere));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPrendere));
	}
	
	@Test
	public void testComandoPrendiAttrezzoTroppoPesante() {
		this.partita.getGiocatore().getBorsa().setPesoMax(0);
		this.comandoPrendi.setParametro(AttrezzoDaPrendere);
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPrendere));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPrendere));
	}
	
	@Test
	public void testComandoPrendiAttrezzoBorsaPiena() {
		this.partita.getGiocatore().getBorsa().setNumeroAttrezzi(10);
		this.comandoPrendi.setParametro(AttrezzoDaPrendere);
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPrendere));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPrendere));
	}

}
