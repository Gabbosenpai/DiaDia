package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	
private static final String AttrezzoDaPosare = "attrezzoDaPosare";
	
	private Partita partita;
	private Comando comandoPosa;
	private Attrezzo attrezzoDaPosare;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.comandoPosa = new ComandoPosa();
		this.attrezzoDaPosare = new Attrezzo(AttrezzoDaPosare,1);
		this.comandoPosa.setIO(new IOConsole());
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPosare);
	}
	
	@Test
	public void testComandoPosaSuccesso() {
		this.comandoPosa.setParametro(AttrezzoDaPosare);
		this.comandoPosa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPosare));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPosare));
	}
	
	@Test
	public void testComandoPosaNomeSbagliato() {
		this.comandoPosa.setParametro("pigna");
		this.comandoPosa.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPosare));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPosare));
	}
	
	@Test
	public void testComandoPosaStanzaPiena() {
		this.partita.getStanzaCorrente().setNumeroAttrezzi(10);
		this.comandoPosa.setParametro(AttrezzoDaPosare);
		this.comandoPosa.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPosare));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPosare));
	}
	
	@Test
	public void testComandoPosaBorsaVuota() {
		this.partita.getGiocatore().getBorsa().removeAttrezzo(AttrezzoDaPosare);
		this.comandoPosa.setParametro(AttrezzoDaPosare);
		this.comandoPosa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(AttrezzoDaPosare));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(AttrezzoDaPosare));
	}

}
