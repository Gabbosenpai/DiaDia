package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {

	static final private String NOME = "saluta";
	
	public ComandoSaluta() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio pg = partita.getStanzaCorrente().getPersonaggio();
		if(pg == null) {
			super.getIO().mostraMessaggio("Chi diavolo stai salutando?");
		}
		else {
			super.getIO().mostraMessaggio(pg.saluta());
		}
		
	}

}
