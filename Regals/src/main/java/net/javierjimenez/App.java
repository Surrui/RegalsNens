package net.javierjimenez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	private static String NOM_FITXER = "/llista_regals.txt";

	/**
	 * Metode principal que llegeix el fitxer de text i inicialitza l'objecte
	 * LlistaNens.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader llista = null;

		try {

			String llistaNens;
			String regalsNoel = null;

			llista = new BufferedReader(new InputStreamReader(App.class.getResource(NOM_FITXER).openStream()));

			while ((llistaNens = llista.readLine()) != null) {

				if (!llistaNens.contains(":")) {
					regalsNoel = llistaNens;
				}
			}

			llista.close();

			llista = new BufferedReader(new InputStreamReader(App.class.getResource(NOM_FITXER).openStream()));

			LlistaNens LN = new LlistaNens(regalsNoel);

			System.out.println("Nens amb regal:");
			System.out.println();

			while ((llistaNens = llista.readLine()) != null) {

				if (llistaNens.contains(":")) {
					LN.comprobarLlista(llistaNens);
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (llista != null)
					llista.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
}
