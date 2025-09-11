package it.uniroma3.esercizi;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest2 {

	public static void main(String[] args) {
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		bar.impostaStanzaAdiacente(Direzione.NORD, mensa);
		mensa.impostaStanzaAdiacente(Direzione.SUD, bar);
		Attrezzo tazzina = new Attrezzo("tazzina", 1);
		Attrezzo piatto = new Attrezzo("piatto", 2);
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
		System.out.println(mensa.getStanzaAdiacente(Direzione.SUD).getAttrezzo("tazzina").toString());
		System.out.println(bar.getStanzaAdiacente(Direzione.NORD).getAttrezzo("piatto").toString());
	}
	
}
