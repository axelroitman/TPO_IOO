package negocio;

import controlador.Juego;

public class Bateria{
	 int puntos;
	 int vidas;
	 int coordenadaX;
	 int coordenadaY;
	
		
	public ProyectilDePlasma lanzarProyectil() {
		ProyectilDePlasma proyectil = new ProyectilDePlasma(10, coordenadaX+20, coordenadaY, 10, true);
		return proyectil;
	
	}
	
	public void colision() {
		//Revisar cuando estemos en la fase D
		disminuirVida();
		Juego.getInstancia().cambioNivel();
		//this.setCoordenadaX(0); //ancho de la imagen/2

	}
	
	public int moverBateriaIzquierda() {
		if(coordenadaX - 1 > 1)
			coordenadaX -= 3;
		return coordenadaX;
	}
	
	public int moverBateriaDerecha(int anchoArea) {
	
		if(coordenadaX + 1 < anchoArea)
			coordenadaX += 3 ;
		return coordenadaX;
	}
	
	public void actualizarPuntos() {
		puntos = puntos + 25;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void aumentarVida() {
		vidas++;	
	}
	
	public void disminuirVida() {
		vidas--;
		Juego.getInstancia().cambioNivel();
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getVidas() {
		return vidas;
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
