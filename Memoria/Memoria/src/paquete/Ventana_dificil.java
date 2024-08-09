package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana_dificil {

	private JFrame frmModoFacil;
	private JTextField textFieldTiempo;
	private int cont = 0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b10;
	private Bd bd = new Bd();
	private Connection c;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private Instant tiempoInicial;
	Clip clip;

	/**
	 * Launch the application.
	 */
	public Ventana_dificil() {
		c = bd.getConexion();
		initialize();
		frmModoFacil.setVisible(true);
	}
	private void initialize() {
		tiempoInicial = Instant.now();
		
		frmModoFacil = new JFrame();
		frmModoFacil.getContentPane().setBackground(Color.GRAY);
		frmModoFacil.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Medio.class.getResource("/imagenes/naranja.png")));
		frmModoFacil.setTitle("Modo Facil");
		frmModoFacil.setResizable(false);
		frmModoFacil.setBounds(300, 300, 600, 513);
		frmModoFacil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModoFacil.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(422, 50, 125, 87);
    	frmModoFacil.getContentPane().add(scrollPane);
    	
    	table = new JTable() {
    		@Override
    		public boolean isCellEditable(int row, int col) {
    		
    			return false;
    		}
    	};
    	
    	scrollPane.setViewportView(table);
    	
    	bd.usarDB();
		modelo = new DefaultTableModel();
		bd.mostrarDificil(modelo);
        table.setModel(modelo);
		
		JLabel dificultad = new JLabel("DIFICULTAD DIFICIL");
		dificultad.setForeground(new Color(0, 255, 64));
		dificultad.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 16));
		dificultad.setBounds(10, 10, 411, 46);
		frmModoFacil.getContentPane().add(dificultad);
		
		JLabel seleccionaDificultad = new JLabel("Selecciona las parejas de cartas");
		seleccionaDificultad.setForeground(Color.MAGENTA);
		seleccionaDificultad.setFont(new Font("MV Boli", Font.BOLD, 16));
		seleccionaDificultad.setBounds(10, 66, 307, 46);
		frmModoFacil.getContentPane().add(seleccionaDificultad);
		
		
		textFieldTiempo = new JTextField();
		textFieldTiempo.setForeground(Color.RED);
		textFieldTiempo.setFont(new Font("Stencil", Font.PLAIN, 13));
		textFieldTiempo.setEditable(false);
		textFieldTiempo.setBounds(142, 142, 200, 20);
		frmModoFacil.getContentPane().add(textFieldTiempo);
		
		JLabel puntuacionLabel = new JLabel("Puntuación:");
		puntuacionLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 10));
		puntuacionLabel.setBounds(10, 145, 122, 13);
		frmModoFacil.getContentPane().add(puntuacionLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 172, 566, 294);
		frmModoFacil.getContentPane().add(panel);
		panel.setLayout(null);
		
		b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b1.setActionCommand("smalling");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling1.png"));
				b1.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion1();
					comprobacion2();
					comprobacion3();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b1.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b1.setBounds(340, 154, 100, 134);
		panel.add(b1);
		
		b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b2.setActionCommand("smalling2");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling2.png"));
				b2.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion2();
					comprobacion1();
					comprobacion3();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
				}
			
		});
		b2.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b2.setBounds(120, 10, 100, 134);
		panel.add(b2);
		
		b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b3.setActionCommand("smalling");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling1.png"));
				b3.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion1();
					comprobacion2();
					comprobacion3();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b3.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b3.setBounds(230, 10, 100, 134);
		panel.add(b3);
		
		b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b4.setActionCommand("smalling2");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling2.png"));
				b4.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion2();
					comprobacion1();
					comprobacion3();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b4.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b4.setBounds(10, 154, 100, 134);
		panel.add(b4);
		
		b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b5.setActionCommand("smalling3");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling3.png"));
				b5.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion3();
					comprobacion1();
					comprobacion2();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b5.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b5.setBounds(120, 154, 100, 134);
		panel.add(b5);
		
		b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b6.setActionCommand("smalling3");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling3.png"));
				b6.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion3();
					comprobacion1();
					comprobacion2();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b6.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b6.setBounds(230, 154, 100, 134);
		panel.add(b6);
		
		b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b7.setActionCommand("smalling4");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling4.png"));
				b7.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion4();
					comprobacion1();
					comprobacion2();
					comprobacion3();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b7.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b7.setBounds(10, 10, 100, 134);
		panel.add(b7);
		
		b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b8.setActionCommand("smalling4");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling4.png"));
				b8.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion4();
					comprobacion1();
					comprobacion2();
					comprobacion3();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b8.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b8.setBounds(456, 10, 100, 134);
		panel.add(b8);
		
		b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b9.setActionCommand("smalling5");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling5.png"));
				b9.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion5();
					comprobacion1();
					comprobacion2();
					comprobacion3();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b9.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b9.setBounds(456, 154, 100, 134);
		panel.add(b9);
		
		b10 = new JButton("");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirSonido(Vista.class.getResource("/sonidos/sonido.wav"));
				b10.setActionCommand("smalling5");
				cont++;
				ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling5.png"));
				b10.setIcon(nuevaImagen);
				if(cont == 2) {
					comprobacion5();
					comprobacion1();
					comprobacion2();
					comprobacion3();
					comprobacion4();
					comprobacion5();
				}
				puntuacion();
			}
		});
		b10.setIcon(new ImageIcon(Ventana_facil.class.getResource("/imagenes/carta.jpg")));
		b10.setBounds(340, 10, 100, 134);
		panel.add(b10);
		
		List<JButton> botones = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
		
		JLabel lblUltimasPuntuaciones = new JLabel("Ultimas partidas");
        lblUltimasPuntuaciones.setForeground(Color.BLUE);
        lblUltimasPuntuaciones.setFont(new Font("MV Boli", Font.BOLD, 16));
        lblUltimasPuntuaciones.setBounds(422, 0, 150, 46);
        frmModoFacil.getContentPane().add(lblUltimasPuntuaciones);
        
        JButton btnNewButton = new JButton("Record puntos");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		modelo = new DefaultTableModel();
        		bd.mostrarDificilRecord(modelo);
                table.setModel(modelo);
        	}
        });
        btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 10));
        btnNewButton.setBounds(422, 156, 127, 21);
        frmModoFacil.getContentPane().add(btnNewButton);
        
        Collections.shuffle(botones);
        botones.get(0).setBounds(340, 154, 100, 134);
        botones.get(1).setBounds(120, 10, 100, 134);
        botones.get(2).setBounds(230, 10, 100, 134);
        botones.get(3).setBounds(10, 154, 100, 134);
        botones.get(4).setBounds(120, 154, 100, 134);
        botones.get(5).setBounds(230, 154, 100, 134);
        botones.get(6).setBounds(10, 10, 100, 134);
        botones.get(7).setBounds(456, 10, 100, 134);
        botones.get(8).setBounds(456, 154, 100, 134);
        botones.get(9).setBounds(340, 10, 100, 134);
        
		
	}
	
	private void comprobacion1() {
	    if (b1.getActionCommand() == "smalling" && b3.getActionCommand() == "smalling") {
	        ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling1.png"));
	        b1.setIcon(nuevaImagen);
	        b3.setIcon(nuevaImagen);

	    } else {
	        Thread t = new Thread(() -> {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            SwingUtilities.invokeLater(() -> {
	                ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/carta.jpg"));
	                b1.setIcon(nuevaImagen);
					b1.setActionCommand("");
	                b3.setIcon(nuevaImagen);
					b3.setActionCommand("");
	                frmModoFacil.repaint();
	                
	            });
	        });

	        t.start();
	    }
	    cont = 0;

	}
	
	private void comprobacion2() {
	    if (b2.getActionCommand() == "smalling2" && b4.getActionCommand() == "smalling2") {
	        ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling2.png"));
	        b2.setIcon(nuevaImagen);
	        b4.setIcon(nuevaImagen);
	        
	    } else {
	        Thread t = new Thread(() -> {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            SwingUtilities.invokeLater(() -> {
	                ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/carta.jpg"));
	                b2.setIcon(nuevaImagen);
					b2.setActionCommand("");
	                b4.setIcon(nuevaImagen);
					b4.setActionCommand("");
	                frmModoFacil.repaint();
	                
	            });
	        });

	        t.start();
	    }
	    cont = 0;
	}
	
	private void comprobacion3() {
	    if (b5.getActionCommand() == "smalling3" && b6.getActionCommand() == "smalling3") {
	        ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling3.png"));
	        b5.setIcon(nuevaImagen);
	        b6.setIcon(nuevaImagen);
	        
	    } else {
	        Thread t = new Thread(() -> {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            SwingUtilities.invokeLater(() -> {
	                ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/carta.jpg"));
					b5.setIcon(nuevaImagen);
					b5.setActionCommand("");
					b6.setIcon(nuevaImagen);
					b6.setActionCommand("");
	                frmModoFacil.repaint();
	                
	            });
	        });

	        t.start();
	    }
	    cont = 0;
	}
	
	private void comprobacion4() {
	    if (b7.getActionCommand() == "smalling4" && b8.getActionCommand() == "smalling4") {
	        ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling4.png"));
	        b7.setIcon(nuevaImagen);
	        b8.setIcon(nuevaImagen);
	        
	    } else {
	        Thread t = new Thread(() -> {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            SwingUtilities.invokeLater(() -> {
	                ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/carta.jpg"));
					b7.setIcon(nuevaImagen);
					b7.setActionCommand("");
					b8.setIcon(nuevaImagen);
					b8.setActionCommand("");
	                frmModoFacil.repaint();
	                
	            });
	        });

	        t.start();
	    }
	    cont = 0;
	}
	
	private void comprobacion5() {
	    if (b9.getActionCommand() == "smalling5" && b10.getActionCommand() == "smalling5") {
	        ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/smalling5.png"));
	        b9.setIcon(nuevaImagen);
	        b10.setIcon(nuevaImagen);
	        
	    } else {
	        Thread t = new Thread(() -> {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            SwingUtilities.invokeLater(() -> {
	                ImageIcon nuevaImagen = new ImageIcon(Vista.class.getResource("/imagenes/carta.jpg"));
					b9.setIcon(nuevaImagen);
					b9.setActionCommand("");
					b10.setIcon(nuevaImagen);
					b10.setActionCommand("");
	                frmModoFacil.repaint();
	                
	            });
	        });

	        t.start();
	    }
	    cont = 0;
	}
	
	public void reproducirSonido(URL resourceURL) {
	    try {
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(resourceURL);

	        clip = AudioSystem.getClip();
	        clip.open(audioStream);

	        clip.start();
	    } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}
	
	private void puntuacion() {
		if(b1.getActionCommand() == "smalling" && b2.getActionCommand() == "smalling2"
		   && b3.getActionCommand() == "smalling" && b4.getActionCommand() == "smalling2"
		   && b5.getActionCommand() == "smalling3" && b6.getActionCommand() == "smalling3"
		   && b7.getActionCommand() == "smalling4" && b8.getActionCommand() == "smalling4"
		   && b9.getActionCommand() == "smalling5" && b10.getActionCommand() == "smalling5") {
		Instant tiempoActual = Instant.now();
		Duration duracion = Duration.between(tiempoInicial, tiempoActual);
		long segundosTranscurridos = duracion.getSeconds();
		reproducirSonido(Vista.class.getResource("/sonidos/completado.wav"));

		textFieldTiempo.setText(String.valueOf(segundosTranscurridos));		
		int numero = (int) segundosTranscurridos;
		bd.insertarDificil(numero);
		modelo = new DefaultTableModel();
		bd.mostrarDificil(modelo);
        table.setModel(modelo);
		}
	}
}
