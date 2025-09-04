package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	static final private String NOME = "posa";
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			System.out.println("Cosa vuoi posare?");
			return;
		}
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			System.out.println("L'attrezzo " + nomeAttrezzo + " non c'è nella borsa!");
			return;
		}
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getStanzaCorrente().addAttrezzo(a)) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			System.out.println("Attrezzo " + nomeAttrezzo + " posato!");
		}
		else {
			System.out.println("Non c'è spazio nella stanza!");
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
