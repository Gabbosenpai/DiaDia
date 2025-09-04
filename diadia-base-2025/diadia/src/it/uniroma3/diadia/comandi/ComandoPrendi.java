package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	static final private String NOME = "prendi";
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			System.out.println("Cosa vuoi prendere?");
			return;
		}
		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			System.out.println("L'attrezzo " + nomeAttrezzo + " non c'è nella stanza!");
			return;
		}
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
			System.out.println("Attrezzo " + nomeAttrezzo + " preso!");
		}
		else {
			System.out.println("Non c'è spazio nella borsa!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
