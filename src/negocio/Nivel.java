package negocio;

public enum Nivel {
	Cadete(1), Guerrero(2), Master(3);
	private int numeroNivel;
	Nivel (int numeroNivel) {
		this.numeroNivel = numeroNivel;
	}

	public int getNumeroNivel() {
		return numeroNivel;
	}
}
