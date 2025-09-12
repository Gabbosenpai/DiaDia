package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	static final private String NOME = "regala";
	private static final String MESSAGGIO_A = "A chi dovrei regalarlo?";
	private static final String MESSAGGIO_NO_ATTREZZO = "Non fare il tirchio...";

	public ComandoRegala() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio pg = partita.getStanzaCorrente().getPersonaggio();
		Attrezzo regalo = partita.getGiocatore().getBorsa().getAttrezzo(super.getParametro());
		if(pg == null) {
			super.getIO().mostraMessaggio(MESSAGGIO_A);
			return;
		}
		if(regalo == null) {
			super.getIO().mostraMessaggio(MESSAGGIO_NO_ATTREZZO);
			return;
		}
		partita.getGiocatore().getBorsa().removeAttrezzo(regalo.getNome());
		super.getIO().mostraMessaggio(pg.riceviRegalo(regalo, partita));
	}
}
