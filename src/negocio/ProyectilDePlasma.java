package negocio;


public class ProyectilDePlasma {
	private int codigoProyectil;
	private double velocidadCaida;
	private int coordenadaX;
	private int coordenadaY;
	private int poderDanio;
	private boolean direccion;
	private int contador = 0;
	
	public ProyectilDePlasma(double velocidadCaida, int coordenadaX, int coordenadaY, int poderDanio, boolean direccion) {
		super();
		this.velocidadCaida = velocidadCaida;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.poderDanio = poderDanio;
		this.direccion = direccion;
		codigoProyectil = contador;
		contador++;
	}

	public void moverProyectil() {
		if(direccion == false) 
		{
			coordenadaY = (int) (coordenadaY + (velocidadCaida));
		}
		else 
		{
			coordenadaY = (int) (coordenadaY - (velocidadCaida));

		}
	}

	public void actualizarVelocidad() {
		velocidadCaida = velocidadCaida * 1.15;
	}

	public double getVelocidadCaida() {
		return velocidadCaida;
	}

	public void setVelocidadCaida(double velocidadCaida) {
		this.velocidadCaida = velocidadCaida;
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

	public int getPoderDanio() {
		return poderDanio;
	}

	public void setPoderDanio(int poderDanio) {
		this.poderDanio = poderDanio;
	}

	public boolean isDireccion() {
		return direccion;
	}

	public void setDireccion(boolean direccion) {
		this.direccion = direccion;
	}

	public int getCodigoProyectil() {
		return codigoProyectil;
	}
}
