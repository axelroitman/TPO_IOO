package negocio;

import controlador.Juego;

public class MuroDeEnergia {
	private int danio;
	private int codigoMuro;
	private int coordenadaX;
	private int coordenadaY;
	public void colision(int poderDanio) {
		actualizarDanio(poderDanio);
		if(danio <= 0)
		{
			Juego.getInstancia().destruirMuro(codigoMuro);
		}
	}
	
	public void actualizarDanio(int poderDanio) {
		danio = danio - poderDanio;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
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

	public int getCodigoMuro() {
		return codigoMuro;
	}

	public void setCodigoMuro(int codigoMuro) {
		this.codigoMuro = codigoMuro;
	}
}
