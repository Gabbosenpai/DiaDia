package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String nomeAttrezzoSbloccante;

	public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;

	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione != null && direzione.equals(direzioneBloccata) && !super.hasAttrezzo(nomeAttrezzoSbloccante))
			return this;	
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite:");
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		if(!super.hasAttrezzo(nomeAttrezzoSbloccante)) {
			risultato.append("\nLa porta a " + this.direzioneBloccata + " è bloccata!");
			risultato.append("\nPer passare serve posare l'attrezzo " + this.nomeAttrezzoSbloccante + " nella stanza!");
		}
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(super.getAttrezzi().values().toString());
		return risultato.toString();
	}

	public String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getNomeAttrezzoSbloccante() {
		return this.nomeAttrezzoSbloccante;
	}

	public void setNomeAttrezzoSbloccante(String nomeAttrezzoSbloccante) {
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
	}

}
