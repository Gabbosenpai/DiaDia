package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private static final String DESCRIZIONE_STANZA_BUIA = "Qui c'è un buio pesto...";
	
	private String nomeAttrezzoLuce;
	
	public StanzaBuia(String nome, String nomeAttrezzoLuce) {
		super(nome);
		this.nomeAttrezzoLuce = nomeAttrezzoLuce;
	}

	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeAttrezzoLuce))
			return DESCRIZIONE_STANZA_BUIA;
		return super.getDescrizione();
	}
	
	public String getNomeAttrezzoLuce() {
		return this.nomeAttrezzoLuce;
	}
	
	public void setNomeAttrezoLuce(String nomeAttrezoLuce) {
		this.nomeAttrezzoLuce = nomeAttrezoLuce;
	}
	
}
