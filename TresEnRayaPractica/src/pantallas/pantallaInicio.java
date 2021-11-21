package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pantallas.pantallaPrincipal.MyKeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaInicio extends JFrame {

	private JPanel contentPane;
	private boolean vk_ctrl=false, vk_alt=false, vk_s=false; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaInicio frame = new pantallaInicio();
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
	public pantallaInicio() {
		KeyListener keyboard= new MyKeyListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ayuda = new JButton("Ayuda");
		ayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Ctrl+Alt+S para desbloquear", "Win", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ayuda.setForeground(Color.CYAN);
		ayuda.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		ayuda.setBackground(Color.BLACK);
		ayuda.setBorder(null);
		ayuda.setBounds(23, 599, 129, 34);
		contentPane.add(ayuda);
		
		JLabel fondoPantalla = new JLabel("");
		fondoPantalla.setIcon(new ImageIcon("./src/imagenes/pantBloq.png"));
		fondoPantalla.setBounds(0, 0, 834, 661);
		contentPane.add(fondoPantalla);
		setLocationRelativeTo(null);
		this.setResizable(false);
		addKeyListener(keyboard);
		setFocusable(true);
		requestFocus();
	}
	
	public class MyKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// Sin uso
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_CONTROL) {
				vk_ctrl=true;
			}
			
			if(e.getKeyCode()== KeyEvent.VK_ALT) {
				vk_alt=true;
			}
			
			if(e.getKeyCode()== KeyEvent.VK_S) {
				vk_s=true;
			}
			
			if(vk_ctrl && vk_alt && vk_s) {
				pantallaPrincipal pP=new pantallaPrincipal();
				pP.setVisible(true);
				dispose();
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_CONTROL) {
				vk_ctrl=false;
			}
			
			if(e.getKeyCode()== KeyEvent.VK_ALT) {
				vk_alt=false;
			}
			
			if(e.getKeyCode()== KeyEvent.VK_S) {
				vk_s=false;
			}
		}
	}
}
