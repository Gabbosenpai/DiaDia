package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private Direzione direzioneBloccata;
	private String nomeAttrezzoSbloccante;

	public StanzaBloccata(String nome, Direzione direzioneBloccata, String nomeAttrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;

	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzione != null && direzione.equals(direzioneBloccata) && !super.hasAttrezzo(nomeAttrezzoSbloccante))
			return this;	
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nPersonaggio: ");
		if (this.getPersonaggio() != null)
			risultato.append(this.getPersonaggio().toString());
		risultato.append("\nUscite:");
		for (Direzione direzione : super.getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		if(!super.hasAttrezzo(nomeAttrezzoSbloccante)) {
			risultato.append("\nLa porta a " + this.direzioneBloccata + " è bloccata!");
			risultato.append("\nPer passare serve posare l'attrezzo " + this.nomeAttrezzoSbloccante + " nella stanza!");
		}
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(super.getAttrezzi().toString());
		return risultato.toString();
	}

	public Direzione getDirezioneBloccata() {
		return this.direzioneBloccata;
	}

	public void setDirezioneBloccata(Direzione direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getNomeAttrezzoSbloccante() {
		return this.nomeAttrezzoSbloccante;
	}

	public void setNomeAttrezzoSbloccante(String nomeAttrezzoSbloccante) {
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
	}

}
