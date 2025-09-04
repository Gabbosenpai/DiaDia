package it.uniroma3.diadia.giocatore;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa borsa;
	
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public boolean isVivo() {
		return this.cfu > 0;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public int getCfuIniziali() {
		return Giocatore.CFU_INIZIALI;
	}
}
