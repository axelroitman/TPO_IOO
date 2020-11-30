package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import controlador.Juego;
import negocio.ProyectilDePlasma;
public class Ventana extends JFrame {
	private static final long serialVersionUID = -4601737718372115147L;
	private JLabel bateria, vida, puntaje;
	private Collection <JLabel> enemigos;
	private Collection <JLabel> muros;
	private Map <Integer,JLabel> disparos;
	private Container c = this.getContentPane();

	public Ventana(){
		configurar();
		eventos();
		this.setResizable(false);
		this.setTitle("Juego");	
		this.setSize(500, 700);
		this.setVisible(true);
	}
	private void configurar() {
		
		c.setLayout(null);
		c.setBackground(Color.BLACK);
		Juego.getInstancia().crearMuros();
		muros = new ArrayList<JLabel>();
		enemigos = new ArrayList<JLabel>();
		disparos = new HashMap<Integer,JLabel>();
		int idMuro = 0;
		while(idMuro < 4) 
		{
			JLabel muro = new JLabel();
			muro.setIcon(new ImageIcon("muro2.png"));
			muro.setBounds(Juego.getInstancia().getMuroPorId(idMuro).getCoordenadaX(), Juego.getInstancia().getMuroPorId(idMuro).getCoordenadaY(), 70, 50);
			muros.add(muro);
			c.add(muro);
			idMuro++;
		}
		
		int idNave = 0;
		while(idNave < 15) 
		{
			JLabel nave = new JLabel();
			nave.setIcon(new ImageIcon("enemigo.png"));
			nave.setBounds(Juego.getInstancia().getNavePorId(idNave).getCoordenadaX(), Juego.getInstancia().getNavePorId(idNave).getCoordenadaY(), 50, 50);
			enemigos.add(nave);
			c.add(nave);
			idNave++;
		}
		bateria = new JLabel();//label sin texto
		puntaje= new JLabel();
		vida= new JLabel();
		puntaje.setText("Puntaje: " + Juego.getInstancia().getJugador().getPuntos());
		vida.setText("Vidas: " + Juego.getInstancia().getJugador().getVidas());
		puntaje.setBounds(0, 0, 100, 50);
		vida.setBounds(400, 0, 100, 50);
		bateria.setIcon(new ImageIcon("jugador.png"));
		bateria.setBounds(Juego.getInstancia().getJugador().getCoordenadaX(), Juego.getInstancia().getJugador().getCoordenadaY(), 50, 50);
		puntaje.setForeground(Color.CYAN);
		vida.setForeground(Color.CYAN);
		Font f = new Font(Font.SANS_SERIF,Font.PLAIN,22);
		puntaje.setFont(f);
		vida.setFont(f);
		c.add(puntaje);
		c.add(vida);
		c.add(bateria);
		
		
	
	}
	private void eventos()
	{
		this.addKeyListener(new ManejoTeclas());
		Timer t = new Timer(400, new ManejoEvento());
		t.start();
		
		//Arreglar problema de timer en disparos: Si dispara mas de 1 a la vez, se bugea.
		Timer disparoEnemigo = new Timer(4000, new ManejoDisparo());
		disparoEnemigo.start();
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class ManejoTeclas implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) { } //tocar y soltar la tecla

		@Override
		public void keyReleased(KeyEvent e) { } //soltar la tecla

		@Override
		public void keyPressed(KeyEvent e) { //mantener apretada
			if(e.getKeyCode() == 37){ 
				int pos = Juego.getInstancia().presionaFlechaIzq();
				bateria.setBounds(pos, Juego.getInstancia().getJugador().getCoordenadaY(), 50, 50);
			}
			else
				if(e.getKeyCode() == 39){ 
					int pos = Juego.getInstancia().presionaFlechaDer();
					bateria.setBounds(pos, Juego.getInstancia().getJugador().getCoordenadaY(), 50, 50);
				}
				else
				{
					if(e.getKeyCode()==32)
					{
						ProyectilDePlasma proy = Juego.getInstancia().presionaEnter();
						JLabel disparo = new JLabel();
						disparo.setIcon(new ImageIcon("proyectil.png"));
						disparo.setBounds(Juego.getInstancia().getJugador().getCoordenadaX()+20, Juego.getInstancia().getJugador().getCoordenadaY(), 10, 10);
						disparos.put(proy.getCodigoProyectil(),disparo);
						
						
						System.out.println(disparos.size());
						c.add(disparo);
					}
				}
		}
	}
	class ManejoDisparo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Arreglar esto.
			JLabel disparo = new JLabel();
			ProyectilDePlasma proyectil = Juego.getInstancia().naveDispara();
			disparo.setIcon(new ImageIcon("proyectil.png"));
			disparo.setBounds(proyectil.getCoordenadaX(), proyectil.getCoordenadaY(), 10, 10);
			disparos.put(proyectil.getCodigoProyectil(),disparo);
			c.add(disparo);

			
		}
	}
	class ManejoEvento implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			puntaje.setText("Puntaje: " + Juego.getInstancia().getJugador().getPuntos());
			vida.setText("Vidas: " + Juego.getInstancia().getJugador().getVidas());
			Juego.getInstancia().moverNaves();
			Juego.getInstancia().moverProyectiles();
			
			
			
			//MOVERNAVES
			
			Iterator<JLabel> j;
			//Revisar el tema del id
			int idNave = 0;
			for (j = enemigos.iterator(); j.hasNext();) {
				JLabel act = j.next();
				
				int x = Juego.getInstancia().getNavePorId(idNave).getCoordenadaX();
				int y = Juego.getInstancia().getNavePorId(idNave).getCoordenadaY();
				act.setBounds(x,y,50,50);
				idNave++;
			}
			
			//ARREGLAR DESPUES TEMA DE OBJECT VIEW
			//Arreglar este desastre.
			Collection<ProyectilDePlasma> proyectiles = Juego.getInstancia().getProyectiles();
			JLabel act = new JLabel();

			for (Entry<Integer, JLabel> entry : disparos.entrySet()) {
			
				int codigo = entry.getKey();
				//entry.setValue(act.setBounds(, y, width, height);)
				
				entry.setValue(arg0)
				System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
			}
			
			
			
			
			ProyectilDePlasma proyectilact;
			//Iterator<HashMap> i;
			
			
			//disparos.forEach();
			act.setIcon(new ImageIcon("proyectil.png"));
			
			
			/*for (i = disparos.; i.hasNext();) {
				act = i.next();
				int x = proyectilact.getCoordenadaX();
				int y = proyectilact.getCoordenadaY();
				//System.out.println(x + "," + y);
				act.setBounds(x,y,10,10);
				//disparos.add(act);
				c.add(act);
				
				
			}*/
			

		}
	}
}
