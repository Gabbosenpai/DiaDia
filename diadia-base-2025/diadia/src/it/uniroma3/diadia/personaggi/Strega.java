package it.uniroma3.diadia.personaggi;

import java.util.Collection;
import java.util.Iterator;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio {

	private static final String MESSAGGIO_TELEPIPPO = 
			"Hocus Pocus, il tuo pipo perde focus!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		Stanza corrente = partita.getStanzaCorrente();
		Collection<Stanza> adiacenti = corrente.getAdiacenti();
		Iterator<Stanza> it = adiacenti.iterator();
		Stanza attrMin = null;
		Stanza attrMax = null;
		while(it.hasNext()) {
			Stanza s = it.next();
			if(attrMin == null || attrMin.getAttrezzi().size() > s.getAttrezzi().size())
				attrMin = s;
			if(attrMax == null || attrMax.getAttrezzi().size() < s.getAttrezzi().size())
				attrMax = s;	
		}
		if(super.haSalutato())
			partita.setStanzaCorrente(attrMax);
		else
			partita.setStanzaCorrente(attrMin);
		return MESSAGGIO_TELEPIPPO;
	}
}
