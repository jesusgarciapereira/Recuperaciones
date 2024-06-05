package unidad3parchis;

import java.util.Random;

public class Parchis {

	public static final int TAM_TABLERO = 20;
	private int fichaJ1;
	private int fichaJ2;
	private static int dado1;
	private static int dado2;
	private String nomJ1 = "";
	private String nomJ2 = "";

	public Parchis() {

	}

	public Parchis(String nomJ1, String nomJ2) {
		if (nomJ1 != null && !nomJ1.equals(""))
			this.nomJ1 = nomJ1;
		if (nomJ2 != null && !nomJ2.equals(""))
			this.nomJ2 = nomJ2;
	}
	

	public static int getDado1() {
		return dado1;
	}

	public static int getDado2() {
		return dado2;
	}

	public static void tiraDados() {
		Random r = new Random();
		dado1 = r.nextInt(1, 7);
		dado2 = r.nextInt(1, 7);
	}

	public void pintaTablero() {
		for (int i = 0; i <= TAM_TABLERO; i++) {
			System.out.print("\t" + (i == 0 ? "I" : (i == TAM_TABLERO ? "F" : i)));

		}
		System.out.println();
		
		pintaJugador(nomJ1, fichaJ1);
		
		pintaJugador(nomJ2, fichaJ2);
	}

	private void pintaJugador(String nombre, int ficha) {
		System.out.print(nombre);
		for (int i = 0; i <= TAM_TABLERO; i++) {
			System.out.print("\t" + (i == 0 ? "I" : (i == TAM_TABLERO ? "F" : (i == ficha ? "O" : ""))));

		}
		System.out.println();
	}

	public void avanzaPosiciones(int numJugador) {
		int tirada = dado1 + dado2;
		
		if (numJugador == 1) {
			fichaJ1 += tirada;
			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = 2 * TAM_TABLERO - fichaJ1;
			}
		} else {
			fichaJ2 += tirada;
			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = 2 * TAM_TABLERO - fichaJ2;
			}
		}

	}

	public void estadoCarrera() {
		if (fichaJ1 > fichaJ2) {
			System.out.println("Va ganando " + nomJ1);
		} else if (fichaJ1 < fichaJ2) {
			System.out.println("Va ganando " + nomJ2);
		} else {
			System.out.println(nomJ1 + " y " + nomJ2 + " van empatados");
		}

	}

	public String esGanador() {
		String nombreGanador = "";

		if (fichaJ1 == TAM_TABLERO) {
			nombreGanador = nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			nombreGanador = nomJ2;
		} 

		return nombreGanador;
	}

}
