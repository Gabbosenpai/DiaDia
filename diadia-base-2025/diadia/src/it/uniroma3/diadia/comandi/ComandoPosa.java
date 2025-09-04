package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	static final private String NOME = "posa";

	private String nomeAttrezzo;

	private IO io;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			this.io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non c'è nella borsa!");
			return;
		}
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getStanzaCorrente().addAttrezzo(a)) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			this.io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato!");
		}
		else {
			this.io.mostraMessaggio("Non c'è spazio nella stanza!");
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

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
