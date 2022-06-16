import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Juego extends JFrame implements ActionListener {
	private JPanel panelJuego;
	private JLabel movimientos, j1, j2, puntaje, turno;
	private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
	private JButton reiniciar, reiniciarPtaje, inicio;
	
	public Font fichas = new Font("Calibri",0,25);
	public JFrame mensaje = new JFrame();
	
	public Juego() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Triqui");
		
		addPanelJuego();
	}
	
	private void addPanelJuego() {
		panelJuego = new JPanel();
		panelJuego.setBounds(1,1,400,500);
		panelJuego.setLayout(null);
		panelJuego.setVisible(true);
		this.add(panelJuego);
		
		etiquetasPuntajes();
		botonesJuegoTriqui();
		botonesReinicio();
	}
	
	private void etiquetasPuntajes() {
		puntaje = new JLabel("Partidas Ganadas");
		puntaje.setBounds(140,10,105,30);
		panelJuego.add(puntaje);
		
		j1 = new JLabel("Jugador 1: 0");
		j1.setBounds(25,30,80,30);
		panelJuego.add(j1);
		
		j2 = new JLabel("Jugador 2: 0");
		j2.setBounds(285,30,105,30);
		panelJuego.add(j2);
                
        turno = new JLabel("Turno: Jugador 1");
        turno.setBounds(142,80,100,30);
        panelJuego.add(turno);
		
		movimientos = new JLabel("Movimientos: 0");
		movimientos.setBounds(148,325,100,30);
		panelJuego.add(movimientos);
	}
	
	private void botonesJuegoTriqui() {
		boton1 = new JButton();
		boton1.setBounds(85,110,70,70);
		boton1.setFocusable(false);
		boton1.setFont(fichas);
		panelJuego.add(boton1);
		boton1.addActionListener(this);
		
		boton2 = new JButton();
		boton2.setBounds(155,110,70,70);
		boton2.setFocusable(false);
		boton2.setFont(fichas);
		panelJuego.add(boton2);
		boton2.addActionListener(this);
		
		boton3 = new JButton();
		boton3.setBounds(225,110,70,70);
		boton3.setFocusable(false);
		boton3.setFont(fichas);
		panelJuego.add(boton3);
		boton3.addActionListener(this);
		
		boton4 = new JButton();
		boton4.setBounds(85,180,70,70);
		boton4.setFocusable(false);
		boton4.setFont(fichas);
		panelJuego.add(boton4);
		boton4.addActionListener(this);
		
		boton5 = new JButton();
		boton5.setBounds(155,180,70,70);
		boton5.setFocusable(false);
		boton5.setFont(fichas);
		panelJuego.add(boton5);
		boton5.addActionListener(this);
		
		boton6 = new JButton();
		boton6.setBounds(225,180,70,70);
		boton6.setFocusable(false);
		boton6.setFont(fichas);
		panelJuego.add(boton6);
		boton6.addActionListener(this);
		
		boton7 = new JButton();
		boton7.setBounds(85,250,70,70);
		boton7.setFocusable(false);
		boton7.setFont(fichas);
		panelJuego.add(boton7);
		boton7.addActionListener(this);
		
		boton8 = new JButton();
		boton8.setBounds(155,250,70,70);
		boton8.setFocusable(false);
		boton8.setFont(fichas);
		panelJuego.add(boton8);
		boton8.addActionListener(this);
		
		boton9 = new JButton();
		boton9.setBounds(225,250,70,70);
		boton9.setFocusable(false);
		boton9.setFont(fichas);
		panelJuego.add(boton9);
		boton9.addActionListener(this);
	}
	
	private void botonesReinicio() {
		reiniciar = new JButton("Reiniciar Casillas");
		reiniciar.setBounds(10,380,135,25);
		reiniciar.setFocusable(false);
		panelJuego.add(reiniciar);
		reiniciar.addActionListener(this);
		
		reiniciarPtaje = new JButton("Reiniciar Puntaje");
		reiniciarPtaje.setBounds(245,380,130,25);
		reiniciarPtaje.setFocusable(false);
		panelJuego.add(reiniciarPtaje);
		reiniciarPtaje.addActionListener(this);
		
		inicio = new JButton("Volver al inicio");
		inicio.setBounds(120,430,150,25);
		inicio.setFocusable(false);
		panelJuego.add(inicio);
		inicio.addActionListener(this);
	}
	
	// Cada variable con nombre b con x número representa cada botón respectivamente
	
	private int b1 = 0;
	private int b2 = 0;
	private int b3 = 0;
	private int b4 = 0;
	private int b5 = 0;
	private int b6 = 0;
	private int b7 = 0;
	private int b8 = 0;
	private int b9 = 0;
	
	// la variable vez calcula los movimientos en el juego
	private int vez = 0;
	
	// La variable otra define si se activa o no el reinicio de cada variable
	// para volver a jugar desde 0
	private boolean otra = false;
	
	// Cada variable gana con x número determina que jugador ha ganado y cuantas veces lo ha hecho 
	private int gana1 = 0;
	private int gana2 = 0;
	
	// Se define una matriz de nombre triqui, en aquella matriz se dan valores iniciales que facilitarán
	// el procedimiento para determinar cuando hay triqui o empate
	private int[][] triqui = {
			{3, 2, 3},
			{2, 2, 3},
			{3, 3, 2},
	};
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
      
		/* 
		Conforme cada jugador seleccione un boton para rellenar la casilla correspondiente
		cada varible asignada a cada botón irá en aumento, esto para válidar que el botón
		sea activado solamente una vez y, cada vez que se de clic en un boton se contabilizará
		como un movimiento
		*/
		
		if(e.getSource() == boton1) {
			b1++;
			if(b1 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton1.setLabel("O");
					triqui[0][0] = 0;
				} else {
					boton1.setLabel("X");
					triqui[0][0] = 1;
				}
			}
			
			//Se imprime por consola la variable "b1" y "vez" para válidar su funcionamiento
			System.out.println(b1);
			System.out.println(vez);
		} else if(e.getSource() == boton2) {
			b2 += 1;
			if(b2 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton2.setLabel("O");
					triqui[0][1] = 0;
				} else {
					boton2.setLabel("X");
					triqui[0][1] = 1;
				}
			}
		} else if(e.getSource() == boton3) {
			b3 += 1;
			if(b3 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton3.setLabel("O");
					triqui[0][2] = 0;
				} else {
					boton3.setLabel("X");
					triqui[0][2] = 1;
				}
			}
		} else if(e.getSource() == boton4) {
			b4++;
			if(b4 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton4.setLabel("O");
					triqui[1][0] = 0;
				} else {
					boton4.setLabel("X");
					triqui[1][0] = 1;
				}
			}
		} else if(e.getSource() == boton5) {
			b5++;
			if(b5 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton5.setLabel("O");
					triqui[1][1] = 0;
				} else {
					boton5.setLabel("X");
					triqui[1][1] = 1;
				}
			}
		} else if(e.getSource() == boton6) {
			b6++;
			if(b6 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton6.setLabel("O");
					triqui[1][2] = 0;
				} else {
					boton6.setLabel("X");
					triqui[1][2] = 1;
				}
			}
		} else if(e.getSource() == boton7) {
			b7++;
			if(b7 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton7.setLabel("O");
					triqui[2][0] = 0;
				} else {
					boton7.setLabel("X");
					triqui[2][0] = 1;
				}
			}
		} else if(e.getSource() == boton8) {
			b8++;
			if(b8 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton8.setLabel("O");
					triqui[2][1] = 0;
				} else {
					boton8.setLabel("X");
					triqui[2][1] = 1;
				}
			}
		} else if(e.getSource() == boton9) {
			b9++;
			if(b9 > 1) {
		        JOptionPane.showMessageDialog(mensaje, "No se puede marcar la misma casilla");
			} else {
				vez++;
				if(vez % 2 == 0) {
					boton9.setLabel("O");
					triqui[2][2] = 0;
				} else {
					boton9.setLabel("X");
					triqui[2][2] = 1;
				}
			}
		}
		// Se imprime por consola si la variable vez cumple su función
		System.out.println(vez);
		
		// Se comprueba primero que el jugador 1 le haya dado clic
		// a uno de los botones que rellena alguna casilla
        if(vez > 0){
        	// Se comprueba que jugador sigue cuando la variable vez
        	// aumenta según los movimientos
        	if(vez % 2 != 0){
        		turno.setText("Turno: Jugador 2");
        	} else {
        		turno.setText("Turno: Jugador 1");
            	}
           	}
        
        // Cuando se de clic en el boton reiniciar, se "activa"
        // la estructura if que reinicia todas las variables
		if(e.getSource() == reiniciar) {
			otra = true;
		} else if(e.getSource() == reiniciarPtaje) {
			gana1 = 0;
			gana2 = 0;
			j1.setText("Jugador 1: " + gana1);
			j2.setText("Jugador 2: " + gana2);
		} else if(e.getSource() == inicio) {
			Main principal = new Main();
			this.setVisible(false);
			principal.setBounds(0,0,400,500);
			principal.setVisible(true);
			principal.setResizable(false);
			principal.setLocationRelativeTo(null);
		}
		
		// Cada estructura de if compara 3 casillas de la matriz triqui
		// para dar veredicto cuando se completen las mismas con un mismo caracter
		comprobarTriqui();
            
        // Estructura if para reiniciar los valores de cada variable
		if(otra) {
            reiniciarValores();
		}
		
		// Establecer los movimientos en su respectivo lugar
		movimientos.setText(String.valueOf("Movimientos: " + vez));
		
		// Estructura for para recorrer matriz triqui
		// y para visualizar cambios al momento de jugar
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(triqui[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	private void comprobarTriqui() {
				if(triqui[0][0] == triqui[0][1] && triqui[0][0] == triqui[0][2]) {
					if(triqui[0][0] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					
					otra = true;
				} else if(triqui[1][0] == triqui[1][1] && triqui[1][0] == triqui[1][2]) {
					if(triqui[1][0] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					
					otra = true;
				} else if(triqui[2][0] == triqui[2][1] && triqui[2][0] == triqui[2][2]) {
					if(triqui[2][0] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					
					otra = true;
				} else if(triqui[0][0] == triqui[1][0] && triqui[0][0] == triqui[2][0]) {
					if(triqui[0][0] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					
					otra = true;
				} else if(triqui[0][1] == triqui[1][1] && triqui[0][1] == triqui[2][1]) {
					if(triqui[0][1] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					
					otra = true;
				} else if(triqui[0][2] == triqui[1][2] && triqui[0][2] == triqui[2][2]) {
					if(triqui[0][2] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					
					otra = true;
				} else if(triqui[0][0] == triqui[1][1] && triqui[0][0] == triqui[2][2]) {
					if(triqui[0][0] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					otra = true;			
				} else if(triqui[2][0] == triqui[1][1] && triqui[2][0] == triqui[0][2]) {
					if(triqui[2][0] == 0) {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 2");
						gana2++;
						j2.setText("Jugador 2: " + gana2);
					} else {
						JOptionPane.showMessageDialog(mensaje, "Ganó el jugador 1");
						gana1++;
						j1.setText("Jugador 1: " + gana1);
					}
					otra = true;
				}
				
		        if(vez == 9){
		        	if(otra == false){
		        		JOptionPane.showMessageDialog(mensaje, "Empate");
		                	otra = true;
		                }
		        }
	}
	
	private void reiniciarValores() {
		turno.setText("Turno: Jugador 1");
        
		triqui[0][0] = 3;
		triqui[0][1] = 2;
		triqui[0][2] = 3;
		triqui[1][0] = 2;
		triqui[1][1] = 2;
		triqui[1][2] = 3;
		triqui[2][0] = 3;
		triqui[2][1] = 3;
		triqui[2][2] = 2;
		
		boton1.setLabel(" ");
		boton2.setLabel(" ");
		boton3.setLabel(" ");
		boton4.setLabel(" ");
		boton5.setLabel(" ");
		boton6.setLabel(" ");
		boton7.setLabel(" ");
		boton8.setLabel(" ");
		boton9.setLabel(" ");
		
		vez = 0;
		b1 = 0;
		b2 = 0;
		b3 = 0;
		b4 = 0;
		b5 = 0;
		b6 = 0;
		b7 = 0;
		b8 = 0;
		b9 = 0;
		
		otra = false;
	}
}