package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class pantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel nada1, nada2, escribir1, escribir2, panel, matriz[][]=new JLabel[3][3];
	String textoEscribir;
	Boolean turnoX=true, ganador=false, nom1=false, nom2=false, empezarJuego=false, contFa=true, contAv=true, win=false;
	private boolean multi=true, IA_Fa=false, IA_Av=false;
	int cont=0,contJ1=0,contJ2=0;
	private JLabel nomJug1;
	private JLabel contJug1;
	private JLabel nomJug2;
	private JLabel contJug2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaPrincipal frame = new pantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pantallaPrincipal() {
		
		KeyListener keyboard= new MyKeyListener(); 
		MyMouseListener mouse= new MyMouseListener();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane.setLayout(null);
		
		Border LineBorder= BorderFactory.createLineBorder(Color.CYAN);
		
		nada1 = new JLabel("");
		nada1.addMouseListener(mouse);
		
		JButton empezar = new JButton("");
		empezar.setIcon(new ImageIcon("./src/imagenes/btnstart.png"));
		empezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomJug1.setText(escribir1.getText());
				nomJug2.setText(escribir2.getText());
				empezarJuego=true;
			}
		});
		
		JButton Informacion = new JButton("");
		Informacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Para jugar introduzca los jugadores clickando en jugador1 y jugador 2, luego presione start", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Informacion.setIcon(new ImageIcon("./src/imagenes/info.gif"));
		Informacion.setBounds(20, 597, 40, 40);
		contentPane.add(Informacion);
		empezar.setBounds(376, 597, 90, 40);
		contentPane.add(empezar);
		nada1.setBorder(new EmptyBorder(5, 5, 5, 5));
		nada1.setBounds(20, 44, 123, 39);
		contentPane.add(nada1);
		
		nada2 = new JLabel("");
		nada2.addMouseListener(mouse);
		nada2.setBounds(490, 54, 123, 29);
		contentPane.add(nada2);
		
		escribir1 = new JLabel("");
		escribir1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 25));
		escribir1.setForeground(Color.CYAN);
		escribir1.setBackground(Color.WHITE);
		escribir1.addKeyListener(keyboard);
		escribir1.setBounds(155, 52, 146, 29);
		contentPane.add(escribir1);
		
		escribir2 = new JLabel("");
		escribir2.setForeground(Color.CYAN);
		escribir2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 25));
		escribir2.setBackground(Color.WHITE);
		escribir2.addKeyListener(keyboard);
		escribir2.setBounds(621, 52, 159, 29);
		contentPane.add(escribir2);
		
		int x=200,y=125;
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				panel = new JLabel();
				panel.setBounds(x, y, 150, 150);
				panel.setBackground(Color.GREEN);
				panel.setBorder(LineBorder);
				panel.addMouseListener(mouse); 
				matriz[i][k]=panel;
				contentPane.add(panel);
				x+=150;
			}
			x=200;
			y+=150;
		}
		
		JLabel lblNewLabel = new JLabel("3 EN");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(392, 33, 75, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblRaya = new JLabel("RAYA");
		lblRaya.setForeground(Color.CYAN);
		lblRaya.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		lblRaya.setBounds(392, 63, 75, 39);
		contentPane.add(lblRaya);
		
		JLabel cabecera = new JLabel("");
		cabecera.setIcon(new ImageIcon("./src/imagenes/banner.png"));
		cabecera.setBounds(0, 23, 834, 90);
		contentPane.add(cabecera);
		
		JLabel imgJug1 = new JLabel("");
		imgJug1.setIcon(new ImageIcon("./src/imagenes/jug1.png"));
		imgJug1.setBounds(20, 195, 125, 200);
		contentPane.add(imgJug1);
		
		nomJug1 = new JLabel("");
		nomJug1.setHorizontalAlignment(SwingConstants.CENTER);
		nomJug1.setForeground(Color.CYAN);
		nomJug1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		nomJug1.setBounds(20, 405, 125, 27);
		contentPane.add(nomJug1);
		
		contJug1 = new JLabel("");
		contJug1.setHorizontalAlignment(SwingConstants.CENTER);
		contJug1.setForeground(Color.CYAN);
		contJug1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		contJug1.setBounds(20, 439, 125, 29);
		contentPane.add(contJug1);
		
		JLabel imgJug2 = new JLabel("");
		imgJug2.setIcon(new ImageIcon("./src/imagenes/jug2.png"));
		imgJug2.setBounds(687, 195, 125, 200);
		contentPane.add(imgJug2);
		
		nomJug2 = new JLabel("");
		nomJug2.setHorizontalAlignment(SwingConstants.CENTER);
		nomJug2.setForeground(Color.CYAN);
		nomJug2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		nomJug2.setBounds(686, 405, 125, 27);
		contentPane.add(nomJug2);
		
		contJug2 = new JLabel("");
		contJug2.setHorizontalAlignment(SwingConstants.CENTER);
		contJug2.setForeground(Color.CYAN);
		contJug2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 30));
		contJug2.setBounds(686, 439, 125, 29);
		contentPane.add(contJug2);
		
		JLabel marco1 = new JLabel("");
		marco1.setIcon(new ImageIcon("./src/imagenes/marco.png"));
		marco1.setBounds(10, 186, 153, 300);
		contentPane.add(marco1);
		
		JLabel marco2 = new JLabel("");
		marco2.setIcon(new ImageIcon("./src/imagenes/marco.png"));
		marco2.setBounds(671, 186, 153, 300);
		contentPane.add(marco2);
		
		JLabel fondoPantalla = new JLabel("");
		fondoPantalla.setBackground(new Color(240, 240, 240));
		fondoPantalla.setIcon(new ImageIcon("./src/imagenes/fondo1.png"));
		fondoPantalla.setBounds(0, 113, 834, 548);
		contentPane.add(fondoPantalla);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 834, 22);
		contentPane.add(menuBar);
		
		JMenu Menu = new JMenu("Opciones");
		menuBar.add(Menu);
		
		JMenu modos = new JMenu("Modo de juego");
		Menu.add(modos);
		
		JMenuItem mMultijugador = new JMenuItem("Multijugador");
		mMultijugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multi=true;
				IA_Fa=false;
				IA_Av=false;
				JOptionPane.showMessageDialog(null,"Cambio de modo: Multijugador", "Cambio de Modo", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/empate.gif"));
			}
		});
		modos.add(mMultijugador);
		
		JMenu unJugador = new JMenu("Un jugador");
		modos.add(unJugador);
		
		JMenuItem mFacil = new JMenuItem("Facil");
		mFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multi=false;
				IA_Fa=true;
				IA_Av=false;
				escribir2.setText("IA");
				nomJug2.setText("IA");
				nom2=true;
				JOptionPane.showMessageDialog(null,"Cambio de modo: Facil", "Cambio de Modo", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/empate.gif"));
			}
		});
		unJugador.add(mFacil);
		
		JMenuItem mAvanzado = new JMenuItem("Avanzado");
		mAvanzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Estas en modo Multijugador, el modo avanzado se incluira en futuras versiones", "Cambio de Modo", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/empate.gif"));
			}
		});
		unJugador.add(mAvanzado);
		
		JMenu menuFondos = new JMenu("Fondos de pantalla");
		Menu.add(menuFondos);
		
		JMenuItem fondo1 = new JMenuItem("Galaxia");
		fondo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoPantalla.setIcon(new ImageIcon("./src/imagenes/fondo1.png"));
			}
		});
		menuFondos.add(fondo1);
		
		JMenuItem fondo2 = new JMenuItem("Galaxia retro");
		fondo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoPantalla.setIcon(new ImageIcon("./src/imagenes/fondo2.png"));
			}
		});
		menuFondos.add(fondo2);
		
		JMenuItem fondo3 = new JMenuItem("Atardecer rojo");
		fondo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoPantalla.setIcon(new ImageIcon("./src/imagenes/fondo3.png"));
			}
		});
		menuFondos.add(fondo3);
		
		JMenuItem fondo4 = new JMenuItem("Sobre la tierra");
		fondo4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoPantalla.setIcon(new ImageIcon("./src/imagenes/fondo4.png"));
			}
		});
		menuFondos.add(fondo4);
		
		JMenuItem Resetear = new JMenuItem("Resetear");
		Resetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaPrincipal pP=new pantallaPrincipal();
				pP.setVisible(true);
				dispose();
			}
		});
		Menu.add(Resetear);
		setFocusable(true);
		requestFocus();
		addMouseListener(mouse);
		addKeyListener(keyboard);
	}
	
	public class MyKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// Sin uso
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(textoEscribir=="escribir1") {
				escritura(escribir1, e);
				nom1=true;
			}else if(textoEscribir=="escribir2") {
				escritura(escribir2, e);
				nom2=true;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// Sin uso
		}
		
		public void escritura(JLabel texto, KeyEvent e) {
			if(texto.getText().length()<10) {
				if(e.getKeyCode()>48 && e.getKeyCode()<90) {
					texto.setText(texto.getText()+KeyEvent.getKeyText(e.getKeyCode()));
				}else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace")){
					texto.setText(texto.getText().substring(0, texto.getText().length()-1));
				}else if(KeyEvent.getKeyText(e.getKeyCode()).equals("Space")){
					texto.setText(texto.getText()+" ");
				}
			}else {
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Backspace")){
					texto.setText(texto.getText().substring(0, texto.getText().length()-1));
				}
			}
		}
	}
	
	 public class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==nada1) {
				textoEscribir="escribir1";
			}else if(e.getSource()==nada2) {
				textoEscribir="escribir2";
			}else {
				textoEscribir="";
			}
			
			
			for(int i=0;i<3;i++) {
				for(int k=0;k<3;k++) {
					if(multi) {
						if(e.getSource()==matriz[i][k]) {
							elegir(matriz[i][k]);
						}
					}else if(IA_Fa) {
						if(e.getSource()==matriz[i][k]) {
							IA_facil(matriz[i][k]);
						}
					}else if(IA_Av) {
						
					}
				}
			}
		}

		private void elegir( JLabel matriz) {
			if(nom1 && nom2 && empezarJuego) {
					if(matriz.getIcon()==null) {
						if(turnoX) {
							matriz.setIcon(new ImageIcon("./src/imagenes/x.png"));
							matriz.setText("x");
							turnoX=false;
							comprobar("x");
							cont++;
						}else {
							matriz.setIcon(new ImageIcon("./src/imagenes/o.png"));
							matriz.setText("o");
							turnoX=true;
							comprobar("o");
							cont++;
					}
				}
			}	
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// Sin uso
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// Sin uso
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Sin uso
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Sin uso
		}
	 }
	 
	 private void resetear() {
		 cont=0;
		 for(int i=0;i<3;i++) {
				for(int k=0;k<3;k++) { 
					matriz[i][k].setIcon(null);
					matriz[i][k].setText("");
				}
			}
		 turnoX=true;
		 win=false;
	 }

	private void IA_facil(JLabel matrizE) {
		contFa=true;
		if(nom1 && nom2 && empezarJuego) {
			if(turnoX) {
				matrizE.setIcon(new ImageIcon("./src/imagenes/x.png"));
				matrizE.setText("x");
				comprobar("x");
				if(!win) {
					cont++;
					do {
						int i=(int)(Math.random()*3);
						int k=(int)(Math.random()*3);
						if(matriz[i][k].getText().equals("")) {
							matriz[i][k].setIcon(new ImageIcon("./src/imagenes/o.png"));
							matriz[i][k].setText("o");
							comprobar("o");
							cont++;
							contFa=false;
						}
					}while(contFa);	
				}
			}
		}
	}
	
	private void IA_avanzada() {
		//Se vera en futuras versiones
	}
	 
	 private void comprobar(String letra) {
			if(cont!=9 && cont>5) {
				verticales(letra);
				horizontales(letra);
				diagonales(letra);
			}else if(cont==9){
				JOptionPane.showMessageDialog(null,"Empate entre los jugadores", "Tie", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/empate.gif"));
				resetear();
				}
			}
		
		private void verticales(String letra) {
			for(int i=0;i<matriz.length;i++) {
				if(matriz[0][i].getText().equals(letra) && matriz[1][i].getText().equals(letra) && matriz[2][i].getText().equals(letra)) {
					ganador=true;
					if(letra.equals("x")) {
						JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug1.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
						contJ1++;
						contJug1.setText(""+contJ1);
						win=true;
					}else {
						JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug2.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
						contJ2++;
						contJug2.setText(""+contJ2);
						win=true;
					}	
					resetear();
				}
			}
		}
		
		private void horizontales(String letra) {
			for(int i=0;i<matriz.length;i++) {
				if(matriz[i][0].getText().equals(letra) && matriz[i][1].getText().equals(letra) && matriz[i][2].getText().equals(letra)){
					ganador=true;
					if(letra.equals("x")) {
						JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug1.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
						contJ1++;
						contJug1.setText(""+contJ1);
						win=true;
					}else {
						JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug2.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
						contJ2++;
						contJug2.setText(""+contJ2);
						win=true;
					}
					resetear();
				}
			}
		}
		
		private void diagonales(String letra) {
			if(matriz[0][0].getText().equals(letra) && matriz[1][1].getText().equals(letra) && matriz[2][2].getText().equals(letra)) {
				ganador=true;
				if(letra.equals("x")) {
					JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug1.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
					contJ1++;
					contJug1.setText(""+contJ1);
					win=true;
				}else {
					JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug2.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
					contJ2++;
					contJug2.setText(""+contJ2);
					win=true;
				}
				resetear();
			}else if(matriz[0][2].getText().equals(letra) && matriz[1][1].getText().equals(letra) && matriz[2][0].getText().equals(letra)) {
				ganador=true;
				if(letra.equals("x")) {
					JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug1.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
					contJ1++;
					contJug1.setText(""+contJ1);
					win=true;
				}else {
					JOptionPane.showMessageDialog(null,"Ganador: "+ nomJug2.getText(), "Win", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./src/imagenes/copa.png"));
					contJ2++;
					contJug2.setText(""+contJ2);
					win=true;
				}
				resetear();
			}
		}
		
		public String getNameJug1(String a) {
			return a;
		}
}

