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
		System.out.print(nomJ1);
		for (int i = 0; i <= TAM_TABLERO; i++) {
			System.out.print("\t" + (i == 0 ? "I" : (i == TAM_TABLERO ? "F" : (i == fichaJ1 ? "O" : ""))));

		}
		System.out.println();
		System.out.print(nomJ2);
		for (int i = 0; i <= TAM_TABLERO; i++) {
			System.out.print("\t" + (i == 0 ? "I" : (i == TAM_TABLERO ? "F" : (i == fichaJ2 ? "O" : ""))));

		}
		System.out.println();
	}

	public void avanzaPosiciones(int numJugador) {
		if (numJugador == 1) {
			fichaJ1 += dado1 + dado2;
			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = 2 * TAM_TABLERO - fichaJ1;
			}
		} else {
			fichaJ2 += dado1 + dado2;
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
			nombreGanador += nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			nombreGanador += nomJ2;
		} 

		return nombreGanador;
	}

}
