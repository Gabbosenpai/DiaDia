package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbricaDiComandi;
	
	@BeforeEach
	public void setUp() {
		this.fabbricaDiComandi = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	public void testAiuto() {
		testaComando("aiuto", "aiuto", null);
	}
	
	@Test
	public void testFine() {
		testaComando("fine", "fine", null);
	}
	
	@Test
	public void testGuarda() {
		testaComando("guarda", "guarda", null);
	}
	
	@Test
	public void testNonValidoTastiera() {
		testaComando("asdasdasd", "non valido", null);
	}
	
	@Test
	public void testComandoVuoto() {
		testaComando("", "non valido", null);
	}
	
	@Test
	public void testPosa() {
		testaComando("posa", "posa", "pigna");
	}
	
	@Test
	public void testPrendi() {
		testaComando("prendi", "prendi", "pigna");
	}
	
	@Test
	public void testVai() {
		testaComando("vai", "vai", "nord");
	}
	
	private void testaComando(String comandoDaEseguire, String comandoAtteso, String parametroDaDare) {
		Comando comando = this.fabbricaDiComandi.costruisciComando(comandoDaEseguire, new IOConsole());
		if(parametroDaDare != null)
			comando.setParametro(parametroDaDare);
		assertEquals(comandoAtteso, comando.getNome());
		assertEquals(parametroDaDare, comando.getParametro());
		
	}
	

}
