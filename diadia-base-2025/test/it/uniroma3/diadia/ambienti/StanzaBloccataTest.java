package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private static final String STANZA_BLOCCATA = "Stanza Bloccata";
	private static final String STANZA_DESTINAZIONE = "Stanza Destinazione";
	private static final String DIREZIONE_BLOCCATA = "Direzione Bloccata";
	private static final String DIREZIONE_LIBERA = "Direzione Libera";
	private static final String NUOVA_DIREZIONE_LIBERA = "Nuova Direzione Libera";
	private static final String NUOVA_STANZA_DESTINAZIONE = "Nuova Stanza Destinazione";
	private static final String ATTREZZO_SBLOCCANTE = "chiave";
	
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaDestinazione;
	private Attrezzo chiave;
	
	@BeforeEach
	public void setUp() {
		this.stanzaBloccata = new StanzaBloccata(STANZA_BLOCCATA, DIREZIONE_BLOCCATA, ATTREZZO_SBLOCCANTE);
		this.stanzaDestinazione = new Stanza(STANZA_DESTINAZIONE);
		this.chiave = new Attrezzo(ATTREZZO_SBLOCCANTE, 1);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaDestinazione);
		this.stanzaDestinazione.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaBloccata);
	}
	
	@Test
	void testStanzaSbloccata() {
		this.stanzaBloccata.addAttrezzo(chiave);
		assertEquals(this.stanzaDestinazione, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	@Test
	void testStanzaBloccata() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	@Test
	void testStanzaBloccataAltraDirezione() {
		Stanza nuovaDestinazione = new Stanza(NUOVA_STANZA_DESTINAZIONE);
		this.stanzaBloccata.impostaStanzaAdiacente(NUOVA_DIREZIONE_LIBERA, nuovaDestinazione );
		assertEquals(nuovaDestinazione, this.stanzaBloccata.getStanzaAdiacente(NUOVA_DIREZIONE_LIBERA));
	}
	
	@Test
	void testStanzaBloccataAttrezzoSbagliato() {
		Attrezzo nonChiave = new Attrezzo("Non chiave", 1);
		this.stanzaBloccata.addAttrezzo(nonChiave);
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}


}
