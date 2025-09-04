package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	static final private String NOME = "prendi";
	
	private String nomeAttrezzo;

	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			this.io.mostraMessaggio("Cosa vuoi prendere?");
			return;
		}
		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non c'è nella stanza!");
			return;
		}
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
			this.io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " preso!");
		}
		else {
			this.io.mostraMessaggio("Non c'è spazio nella borsa!");
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
