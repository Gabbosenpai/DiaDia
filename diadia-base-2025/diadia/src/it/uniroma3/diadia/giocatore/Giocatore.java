package it.uniroma3.diadia.giocatore;

public class Giocatore {

	static final private int CFU_INIZIALI = 10;
	
	private int cfu;
	
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
	}
	
	public boolean isVivo() {
		return this.cfu == 0;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
}
