package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{

	@SuppressWarnings("deprecation")
	@Override
	public Comando costruisciComando(String istruzione, IO io){
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
			// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
			nomeClasse.append(nomeComando.substring(1));
			// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
			comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
			// POSSIBILE ALTERNATIVA basata sul rendere il tipo Class<Comando> esplicito:
			// comando = ((Class<Comando>)Class.forName(nomeClasse.toString())).newInstance();
			comando.setParametro(parametro);
			comando.setIO(io);
		}
		catch (Exception e) {
			comando = new ComandoNonValido();
			comando.setIO(io);
		}
		return comando;
	}
}
