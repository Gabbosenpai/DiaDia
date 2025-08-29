package it.uniroma3.diadia;

public class StanzaTest1 {
	
	public static void main(String[] argc) {
		
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		System.out.println(bar.getStanzaAdiacente("nord").getDescrizione());
		System.out.println(mensa.getStanzaAdiacente("sud").getDescrizione());
	}
}
