package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	public static final String MESSAGGIO_MORSO = 
			"*Il cane ti morde la mano...(-1 CFU)*";

	private String ciboPreferito;
	private Attrezzo regaloDelCane;
	private boolean regaloPosato = false;

	public Cane(String nome, String presentazione, String ciboPreferito, Attrezzo regalo) {
		super(nome, presentazione);
		this.ciboPreferito = ciboPreferito;
		this.regaloDelCane = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu();
		cfu--;
		partita.getGiocatore().setCfu(cfu);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		if(regalo.getNome().equals(this.ciboPreferito)) {
			if(!this.isRegaloPosato()) {
				partita.getStanzaCorrente().addAttrezzo(this.regaloDelCane);
				this.regaloPosato = true;
			}
			return "Il cane accetta il cibo e lascia cadere un attrezzo";
		} else {
			partita.getStanzaCorrente().addAttrezzo(regalo);
			int cfu = partita.getGiocatore().getCfu();
			cfu--;
			partita.getGiocatore().setCfu(cfu);
			return "Il cane non accetta il tuo regalo e ti morde";
		}
	}

	public String getCiboPreferito() {
		return ciboPreferito;
	}

	public void setCiboPreferito(String ciboPreferito) {
		this.ciboPreferito = ciboPreferito;
	}

	public Attrezzo getRegaloDelCane() {
		return regaloDelCane;
	}

	public void setRegaloDelCane(Attrezzo regaloDelCane) {
		this.regaloDelCane = regaloDelCane;
	}

	public boolean isRegaloPosato() {
		return regaloPosato;
	}

	public void setRegaloPosato(boolean regaloPosato) {
		this.regaloPosato = regaloPosato;
	}
}
