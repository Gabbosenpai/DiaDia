package it.uniroma3.esercizi;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaTest1 {
	
	public static void main(String[] argc) {
		
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		bar.impostaStanzaAdiacente(Direzione.NORD, mensa);
		mensa.impostaStanzaAdiacente(Direzione.SUD, bar);
		System.out.println(bar.getStanzaAdiacente(Direzione.NORD).getDescrizione());
		System.out.println(mensa.getStanzaAdiacente(Direzione.SUD).getDescrizione());
	}
}
