package test;

/*import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import controlador.Juego;
import negocio.Bateria;
import negocio.MuroDeEnergia;
import negocio.NaveInvasora;*/
import vista.Ventana;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ventana();
/*
		Collection<MuroDeEnergia> muros = new ArrayList<MuroDeEnergia>();
		Collection<NaveInvasora> naves = new ArrayList<NaveInvasora>();
		Bateria jugador = new Bateria();
		
		Juego.getInstancia();
		muros = Juego.getInstancia().getMuros();
		naves = Juego.getInstancia().getEnemigos();
		jugador = Juego.getInstancia().getJugador();
		
		Iterator<MuroDeEnergia> i;
		for (i = muros.iterator(); i.hasNext();) {
			MuroDeEnergia act = i.next();
			System.out.println("El muro " + act.getCodigoMuro() + " esta ubicado en: (" + act.getCoordenadaX() + ", " + act.getCoordenadaY() + ")");
		}
		
		Iterator<NaveInvasora> j;
		for (j = naves.iterator(); j.hasNext();) {
			NaveInvasora act = j.next();
			System.out.println("El enemigo " + act.getCodigoNave() + " esta ubicado en: (" + act.getCoordenadaX() + ", " + act.getCoordenadaY() + ")");
		}
		
		System.out.println("El jugador esta ubicado en (" + jugador.getCoordenadaX() + ", " + jugador.getCoordenadaY() + ")" );

		System.out.println("Hay " + muros.size() + " muros de energia.");
		Juego.getInstancia().destruirMuro(1);
		System.out.println("El muro 1 fue destruido.");
		muros = Juego.getInstancia().getMuros();
		System.out.println("Hay " + muros.size() + " muros de energia.");
		
		System.out.println("Hay " + naves.size() + " enemigos. El jugador tiene " + jugador.getPuntos() + " puntos.");
		Juego.getInstancia().destruirNave(9);
		System.out.println("La nave 9 fue destruida.");
		naves = Juego.getInstancia().getEnemigos();
		System.out.println("Hay " + naves.size() + " enemigos. El jugador tiene " + jugador.getPuntos() + " puntos.");
		System.out.println("Usted esta en el nivel " + Juego.getInstancia().getDificultad());
		System.out.println("Destruyendo naves...");
		int idNave = 0;
		while(idNave < 15) {

			Juego.getInstancia().destruirNave(idNave);

			idNave++;

		}
		System.out.println("Todas las naves fueron destruidas. Usted esta en el nivel " + Juego.getInstancia().getDificultad() + ".");

		System.out.println("El jugador esta ubicado en (" + jugador.getCoordenadaX() + ", " + jugador.getCoordenadaY() + ")" );
		
		System.out.println("El jugador se mueve a la izquierda");
		Juego.getInstancia().presionaFlechaIzq();
		System.out.println("El jugador esta ubicado en (" + jugador.getCoordenadaX() + ", " + jugador.getCoordenadaY() + ")" );
		
		System.out.println("El jugador se mueve a la izquierda");
		Juego.getInstancia().presionaFlechaIzq();
		System.out.println("El jugador esta ubicado en (" + jugador.getCoordenadaX() + ", " + jugador.getCoordenadaY() + ")" );

		System.out.println("El jugador se mueve a la derecha");
		Juego.getInstancia().presionaFlechaDer();
		System.out.println("El jugador esta ubicado en (" + jugador.getCoordenadaX() + ", " + jugador.getCoordenadaY() + ")" );

		System.out.println("Se termina el juego:");
		Juego.getInstancia().finalizarJuego();
		
*/
	}

}
