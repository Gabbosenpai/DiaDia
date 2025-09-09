package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	private Borsa borsa;
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa();
	}
	
	@Test
	public void testIsEmptyConBorsaVuota() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testIsEmptyConBorsaNonVuota() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void testHasAttrezzoConBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo("pigna"));
	}
	
	@Test
	public void testHasAttrezzoConAttrezzoPresente() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertTrue(this.borsa.hasAttrezzo("pigna"));
	}
	
	@Test
	public void testHasAttrezzoConAttrezzoDiverso() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertFalse(this.borsa.hasAttrezzo("ghianda"));
	}
	
	@Test
	public void testGetAttrezzoSuNull() {
		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
		assertNull(this.borsa.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoSuccesso() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.borsa.addAttrezzo(pigna);
		assertEquals(pigna, this.borsa.getAttrezzo("pigna"));
	}
	
	@Test
	public void testGetAttrezzoAssente() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.borsa.addAttrezzo(pigna);
		assertNull(this.borsa.getAttrezzo("ghianda"));
	}
	
//	@Test
//	public void testAddAttrezzoSuNull() {
//		this.borsa.addAttrezzo(null);
//		assertEquals(0, this.borsa.getNumeroAttrezzi());
//	}
	
	@Test
	public void testAddAttrezzoPesoMaggiorePesoMax() {
		this.borsa.addAttrezzo(new Attrezzo("incudine", this.borsa.getPesoMax() + 1));
		assertFalse(this.borsa.hasAttrezzo("incudine"));
		this.borsa.addAttrezzo(new Attrezzo("martello", 7));
		this.borsa.addAttrezzo(new Attrezzo("spada", 4));
		assertFalse(this.borsa.hasAttrezzo("spada"));
		assertTrue(this.borsa.hasAttrezzo("martello"));
	}
	
//	@Test
//	public void testAddAttrezzoBorsaPienaMaxNumeroAttrezzi() {
//		this.borsa.setNumeroAttrezzi(9);
//		this.borsa.addAttrezzo(new Attrezzo("martello", 7));
//		this.borsa.addAttrezzo(new Attrezzo("pigna", 1));
//		assertFalse(this.borsa.hasAttrezzo("pigna"));
//		assertTrue(this.borsa.hasAttrezzo("martello"));
//	}
	
	@Test
	public void testAddAttrezzoSingolo() {
		this.borsa.addAttrezzo(new Attrezzo("pigna",1));
		assertTrue(this.borsa.hasAttrezzo("pigna"));
	}
	
	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaAttrezzoSingolo() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.borsa.addAttrezzo(pigna);
		assertEquals(pigna.getPeso(), this.borsa.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaAttrezzoDoppio() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		Attrezzo ghianda = new Attrezzo("ghianda", 2);
		this.borsa.addAttrezzo(pigna);
		this.borsa.addAttrezzo(ghianda);
		assertEquals(pigna.getPeso() + ghianda.getPeso(), this.borsa.getPeso());
	}
	
	@Test
	public void testRemoveAttrezzoSuNull() {
		assertNull(this.borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzoAssente() {
		assertNull(this.borsa.removeAttrezzo("pigna"));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		this.borsa.addAttrezzo(pigna);
		assertTrue(this.borsa.hasAttrezzo("pigna"));
		assertEquals(pigna, this.borsa.removeAttrezzo("pigna"));
		assertFalse(this.borsa.hasAttrezzo("pigna"));
	}
	
	@Test
	public void testRemoveAttrezzoConPiùAttrezzi() {
		this.fixture();
		assertTrue(this.borsa.hasAttrezzo("pigna"));
		assertTrue(this.borsa.hasAttrezzo("ghianda"));
		assertEquals(this.borsa.getAttrezzo("pigna"), this.borsa.removeAttrezzo("pigna"));
		assertFalse(this.borsa.hasAttrezzo("pigna"));
		assertTrue(this.borsa.hasAttrezzo("ghianda"));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoBorsaVuota() {
		List<Attrezzo> vuota = this.borsa.getContenutoOrdinatoPerPeso();
		assertTrue(vuota.isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiversoPeso() {
		this.fixture();
		List<Attrezzo> lista = this.borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = lista.iterator(); 
		assertEquals(1,it.next().getPeso());
		assertEquals(2,it.next().getPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		this.fixture();
		this.borsa.addAttrezzo(new Attrezzo("superghianda", 2));
		List<Attrezzo> lista = this.borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = lista.iterator(); 
		assertEquals("ghianda",it.next().getNome());
		assertEquals("pigna",it.next().getNome());
		assertEquals("superghianda",it.next().getNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeBorsaVuota() {
		SortedSet<Attrezzo> vuota = this.borsa.getContenutoOrdinatoPerNome();
		assertTrue(vuota.isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeStessoNomeStessoPeso() {
		fixture();
		this.borsa.addAttrezzo(new Attrezzo("ghianda", 1));
		SortedSet<Attrezzo> set = this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = set.iterator();
		assertEquals("ghianda",it.next().getNome());
		assertEquals("pigna",it.next().getNome());
		assertFalse(it.hasNext());
	}
	
	public void testGetContenutoRaggruppatoPerPesoBorsaVuota() {
		Map<Integer, Set<Attrezzo>> vuota = this.borsa.getContenutoRaggruppatoPerPeso();
		assertTrue(vuota.isEmpty());
	}
	
	public void testGetContenutoRaggruppatoPerPesoDueAttrezziDiversoPeso() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		Attrezzo ghianda = new Attrezzo("ghianda", 1);
		Attrezzo superghianda = new Attrezzo("superghianda", 2);
		this.borsa.addAttrezzo(pigna);
		this.borsa.addAttrezzo(ghianda);
		this.borsa.addAttrezzo(superghianda);
		Map<Integer, Set<Attrezzo>> peso2SetAttrezzi = new HashMap<Integer, Set<Attrezzo>>();
		peso2SetAttrezzi.put(1, Collections.singleton(new Attrezzo("pigna", 1)));
		peso2SetAttrezzi.put(1, Collections.singleton(new Attrezzo("ghianda", 1)));
		peso2SetAttrezzi.put(2, Collections.singleton(new Attrezzo("superghianda", 2)));
		assertEquals(peso2SetAttrezzi, this.borsa.getContenutoRaggruppatoPerPeso());
		
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		Attrezzo pigna = new Attrezzo("pigna", 1);
		Attrezzo ghianda = new Attrezzo("ghianda", 1);
		Attrezzo superghianda = new Attrezzo("superghianda", 2);
		this.borsa.addAttrezzo(pigna);
		this.borsa.addAttrezzo(ghianda);
		this.borsa.addAttrezzo(superghianda);
		SortedSet<Attrezzo> peso2SetAttrezzi = new TreeSet<>(Arrays.asList(new Attrezzo("pigna", 1),new Attrezzo("ghianda", 1), new Attrezzo("superghianda", 2)));
		assertEquals(peso2SetAttrezzi, this.borsa.getSortedSetOrdinatoPerPeso());
	}
	
	public void fixture() {
		Attrezzo pigna = new Attrezzo("pigna", 2);
		Attrezzo ghianda = new Attrezzo("ghianda", 1);
		this.borsa.addAttrezzo(pigna);
		this.borsa.addAttrezzo(ghianda);
	}
}
