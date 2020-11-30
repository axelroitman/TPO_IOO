package negocio;

import controlador.Juego;

public class NaveInvasora {
	private double velocidadMovimiento;
	private int codigoNave;
	private int coordenadaX;
	private int coordenadaY;

	public ProyectilDePlasma lanzarProyectil() {
		int velocidadProyectil;
		if(velocidadMovimiento == 5) 
		{
			velocidadProyectil = 10;
		}
		else if(velocidadMovimiento == 5.75) 
		{
			velocidadProyectil = 15;
		}
		else 
		{
			velocidadProyectil = 20;
		}
		
		int coordenadaXProyectil = coordenadaX + 70;
		int coordenadaYProyectil = coordenadaY + 70;
		ProyectilDePlasma proyectil = new ProyectilDePlasma(velocidadProyectil, coordenadaXProyectil, coordenadaYProyectil, 5, false);
		System.out.println("Proyectil seteado en: " + proyectil.getCoordenadaX() + ", " + proyectil.getCoordenadaY());
		return proyectil;
	
	}
	
	public void colision() {
		//Ver cuando estemos en la Fase D
		Juego.getInstancia().destruirNave(codigoNave); 
	}
	
	public void actualizarVelocidad(boolean nivelAumenta) {
		
		if(nivelAumenta == true) 
		{
			velocidadMovimiento = velocidadMovimiento * 1.15;
		}
		else 
		{
			velocidadMovimiento = velocidadMovimiento / 1.15;
		}
	
	}
	
	public void moverNave(boolean direccionNave) {
		if(direccionNave == true) 
		{
			coordenadaX = (int) (coordenadaX + (5 * velocidadMovimiento));
		}
		else 
		{
			coordenadaX = (int) (coordenadaX - (5 * velocidadMovimiento));

		}
	}

	public double getVelocidadMovimiento() {
		return velocidadMovimiento;
	}

	public void setVelocidadMovimiento(int velocidadMovimiento) {
		this.velocidadMovimiento = velocidadMovimiento;
	}

	public int getCodigoNave() {
		return codigoNave;
	}

	public void setCodigoNave(int codigoNave) {
		this.codigoNave = codigoNave;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
}
