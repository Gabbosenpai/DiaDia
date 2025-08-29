package it.uniroma3.diadia;

public class StanzaTest2 {

	public static void main(String[] args) {
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		Attrezzo tazzina = new Attrezzo("tazzina", 1);
		Attrezzo piatto = new Attrezzo("piatto", 2);
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
		System.out.println(mensa.getStanzaAdiacente("sud").getAttrezzo("tazzina").toString());
		System.out.println(bar.getStanzaAdiacente("nord").getAttrezzo("piatto").toString());
	}
	
}
