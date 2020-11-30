package controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import negocio.Bateria;
import negocio.MuroDeEnergia;
import negocio.NaveInvasora;
import negocio.Nivel;
import negocio.ProyectilDePlasma;

public class Juego {
	private Collection<NaveInvasora> enemigos;
	private Bateria jugador;
	private Collection<MuroDeEnergia> muros;
	private Nivel dificultad;
	private int anchoArea;
	private int altoArea;
	private boolean direccionEnemigos;
	private Collection<ProyectilDePlasma> proyectiles;
	
	private static Juego instancia; //Singleton: Creo una variable de clase

	
	private Juego() {
		anchoArea = 500;
		altoArea = 700;
		crearBateria();
		crearMuros();
		crearNaves();

		dificultad = Nivel.Cadete;
		direccionEnemigos = true;
		proyectiles = new ArrayList<ProyectilDePlasma>();
	}
	
	public static Juego getInstancia()
	{ //Singleton: Creo un metodo de clase que devuelve al objeto
		if(instancia == null)
		{
			instancia = new Juego();
		}
		return instancia;
	}

	public void crearNaves() {
		enemigos=new ArrayList<NaveInvasora>();
		
		int idNave = 0;
		int posX = 0;
		int posY = 50;
		while(idNave < 15) 
		{
			if(idNave == 5 || idNave == 10)
			{
				posY = posY + 40;
				posX = 0;
			}
			NaveInvasora nave = new NaveInvasora();
			nave.setCodigoNave(idNave);
			nave.setCoordenadaX(0+posX); 
			nave.setCoordenadaY(0+posY);
			nave.setVelocidadMovimiento(1); //Definir velocidad después
			enemigos.add(nave);
			posX = posX + 60;
			idNave++;
		}
	}
	
	public void crearBateria() {
		jugador = new Bateria();		
		jugador.setVidas(3);
		jugador.setPuntos(0);
		jugador.setCoordenadaX((anchoArea-70)/2);
		jugador.setCoordenadaY(altoArea-100); //en donde va el 0 debe estar el alto de la imagen del jugador/2
	}
	
	public void crearMuros() {
		muros= new ArrayList<MuroDeEnergia>();
		
		int distancia = (anchoArea-70)/4;
		int posX = 45;
		int idMuro = 0;
		while(idMuro < 4) 
		{
			MuroDeEnergia muro = new MuroDeEnergia();
			muro.setCodigoMuro(idMuro);
			muro.setDanio(0);
			muro.setCoordenadaX(posX);
			muro.setCoordenadaY(altoArea-180);			
			muros.add(muro);
			posX = posX + distancia;		
			idMuro++;
		}
	}
	
	public ProyectilDePlasma getProyectilPorId(int idProyectil) 
	{
		//Cambiar despues por un Object View
		Iterator<ProyectilDePlasma> i;
		ProyectilDePlasma proyectilADevolver = null;

		for(i = proyectiles.iterator(); i.hasNext();) {
			ProyectilDePlasma evaluado = i.next(); 
			if(idProyectil == evaluado.getCodigoProyectil())
			{	
				proyectilADevolver= evaluado; 
			}
		}
		return proyectilADevolver;
	}

	
	public MuroDeEnergia getMuroPorId(int idMuro) 
	{
		//Cambiar despues por un Object View
		Iterator<MuroDeEnergia> i;
		MuroDeEnergia muroADevolver = null;

		for(i = muros.iterator(); i.hasNext();) {
			MuroDeEnergia evaluado = i.next(); 
			if(idMuro == evaluado.getCodigoMuro())
			{	
				muroADevolver= evaluado; 
			}
		}
		return muroADevolver;
	}

	public NaveInvasora getNavePorId(int idNave) 
	{
		//Cambiar despues por un Object View
		Iterator<NaveInvasora> i;
		NaveInvasora naveADevolver = null;

		for(i = enemigos.iterator(); i.hasNext();) {
			NaveInvasora evaluado = i.next(); 
			if(idNave == evaluado.getCodigoNave())
			{	
				naveADevolver= evaluado; 
			}
		}
		return naveADevolver;
	}

	
	public void destruirMuro(int idMuro) {
		
		Iterator<MuroDeEnergia> i;
		MuroDeEnergia muroAEliminar = null;
		for(i = muros.iterator(); i.hasNext();) {
			MuroDeEnergia evaluado = i.next(); 
			if(idMuro == evaluado.getCodigoMuro())
			{	
				muroAEliminar= evaluado; 
			}
		}
		if(muroAEliminar != null) 
		{
			muros.remove(muroAEliminar);

		}
	}
		
	public void destruirNave(int idNave) {
		Iterator<NaveInvasora> i;
		NaveInvasora naveAEliminar= null;
		for(i = enemigos.iterator(); i.hasNext();) {
			NaveInvasora evaluada = i.next();
			if(idNave == evaluada.getCodigoNave()) {
				naveAEliminar = evaluada;
			}
		}

		
		if(naveAEliminar != null) 
		{
			enemigos.remove(naveAEliminar);
			jugador.actualizarPuntos();

		}
		if(enemigos.isEmpty()){
			cambioNivel();
		}
	}


	public void cambioNivel() {
		
		if(jugador.getVidas() != 0) {
			boolean aumenta;
			if(enemigos.isEmpty()) 
			{
	
				aumenta = true;
				if(dificultad.getNumeroNivel() == 3)
				{
					finalizarJuego();
				}
				else {
					
					if(dificultad.getNumeroNivel() == 1) 
					{
						dificultad = Nivel.Guerrero;
					}
					else 
					{
						dificultad = Nivel.Master;
					}
	
				}
			}
			else 
			{
				
				
				aumenta = false;
				if(dificultad.getNumeroNivel() != 1) {
	
					if(dificultad.getNumeroNivel() == 3) 
					{
						dificultad = Nivel.Guerrero;
					}
					else 
					{
						dificultad = Nivel.Cadete;
					}
				}
			}
			
			crearNaves();
			if(aumenta == false && dificultad.getNumeroNivel() == 1) {}
			else {
				
				
				Iterator<NaveInvasora> i;
				for(i = enemigos.iterator(); i.hasNext();) {
					NaveInvasora evaluada = i.next();
					evaluada.actualizarVelocidad(aumenta);
				}
			}
			
			int idMuro = 0;
			while(idMuro <3) {
				destruirMuro(idMuro);
				idMuro++;
				
			}
			crearMuros();
		}
		else 
		{
			finalizarJuego();
		}
	}
	
	public boolean cambioSentidoNaves() {
		if(direccionEnemigos==true) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void finalizarJuego() {
		if(jugador.getVidas() == 0)
			{
			    cerrarJuego(false);
			}
		else 
		{
			cerrarJuego(true);
		}

		
	}
	
	public int presionaFlechaIzq() {
		int pos = jugador.moverBateriaIzquierda();
		return pos;
	}
	
	public int presionaFlechaDer() {
		int pos = jugador.moverBateriaDerecha(anchoArea-60);
		return pos;
	}
	
	public ProyectilDePlasma presionaEnter() {
		//CAMBIAR PARA QUE DEVUELVA OBJECT VIEW
		ProyectilDePlasma proy = jugador.lanzarProyectil();
		proyectiles.add(proy);
		
		return proy;
	}
	
	public void bajarLinea() {
		Iterator<NaveInvasora> j;
		boolean llegaAlExtremo = false;
		for (j = enemigos.iterator(); j.hasNext();) {
			NaveInvasora act = j.next();

			if(act.getCoordenadaX()<=0 || act.getCoordenadaX()>=anchoArea-60)
			{
				llegaAlExtremo = true;
			}			
		}
		if(llegaAlExtremo == true) 
		{
			for (j = enemigos.iterator(); j.hasNext();) {
				NaveInvasora act = j.next();
				act.setCoordenadaY(act.getCoordenadaY()+30);
			}

			direccionEnemigos = cambioSentidoNaves();
			llegaAlExtremo = false;

		}
	}
	public void verificarColisiones() 
	{
	// Ver el tema cuando estemos en la Fase D.
	}
	
	private void cerrarJuego(boolean gana) {
		if(gana == false) {
			JOptionPane.showMessageDialog(null, "Fin del juego");
			System.out.println("Fin del juego.");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "¡Ganaste! Tu puntaje fue de " + jugador.getPuntos() + " puntos.");
			System.out.println("Terminaste el juego con " + jugador.getVidas() + " vidas. Llegaste hasta el nivel " + dificultad + ".");
		}
		System.exit(0);


	}
	public void moverProyectiles() 
	{
		Iterator<ProyectilDePlasma> j;
		for (j = proyectiles.iterator(); j.hasNext();) {
			ProyectilDePlasma act = j.next();
			
			act.moverProyectil();
		}
	}
	
	public void moverNaves() 
	{
		Iterator<NaveInvasora> j;
		for (j = enemigos.iterator(); j.hasNext();) {
			NaveInvasora act = j.next();
			
			act.moverNave(direccionEnemigos);
		}
		bajarLinea();

	}
	

	public ProyectilDePlasma naveDispara() 
	{
		//Cambiar a ObjectView.
		boolean existeEnemigo = false;
		ProyectilDePlasma proyectil = null;
		while(existeEnemigo == false){
			Random r = new Random();
			int numero = r.nextInt(5);
			NaveInvasora disparador = new NaveInvasora();
			
			Iterator<NaveInvasora> j;
			for (j = enemigos.iterator(); j.hasNext();) {
				NaveInvasora act = j.next();
				
				if(act.getCodigoNave()%(numero+1) == 0)
				{
					existeEnemigo = true;
					disparador = act;
				}
			}
			if(existeEnemigo == true)
			{
				proyectil = disparador.lanzarProyectil();
			}
		}
		proyectiles.add(proyectil);
		
		return proyectil;
			
	}


	public Collection<NaveInvasora> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(Collection<NaveInvasora> enemigos) {
		this.enemigos = enemigos;
	}

	public Bateria getJugador() {
		return jugador;
	}

	public void setJugador(Bateria jugador) {
		this.jugador = jugador;
	}

	public Collection<MuroDeEnergia> getMuros() {
		return muros;
	}

	public void setMuros(Collection<MuroDeEnergia> muros) {
		this.muros = muros;
	}
	
	public Nivel getDificultad() {
		return dificultad;
	}
	public Collection<ProyectilDePlasma> getProyectiles() {
		return proyectiles;
	}

}
