package unidad3parchis;

import java.util.Scanner;

public class Principal {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String nombreJ1 = "";
		String nombreJ2 = "";
		String ganador = "";

		int turnoJugador = 1;

		Parchis partida;

		System.out.println("BIENVENIDO AL PARCHÍS DEL IES NERVIÓN =D");

		System.out.println("Introduzca el nombre del jugador 1");
		nombreJ1 = sc.nextLine();

		do {
			System.out.println("Introduzca el nombre del jugador 2");
			nombreJ2 = sc.nextLine();
		} while (nombreJ1.equalsIgnoreCase(nombreJ2));

		partida = new Parchis(nombreJ1, nombreJ2);

		ganador = partida.esGanador();

		while (ganador.equals("")) {
			System.out.println("Pulse una tecla para avanzar");
			sc.nextLine();

			System.out.println("Turno de " + (turnoJugador == 1 ? nombreJ1 : nombreJ2));
			Parchis.tiraDados();

			System.out.println("La tirada ha sido " + Parchis.getDado1() + " y " + Parchis.getDado2());

			partida.avanzaPosiciones(turnoJugador);

			partida.pintaTablero();

			System.out.println();
			partida.estadoCarrera();
			System.out.println();

			if (Parchis.getDado1() != Parchis.getDado2()) {

				turnoJugador = turnoJugador == 1 ? 2 : 1;
			}

			ganador = partida.esGanador();

		}

		System.out.println("¡ENHORABUENA " + ganador + ", HAS GANADO!");

		sc.close();
	}
}
