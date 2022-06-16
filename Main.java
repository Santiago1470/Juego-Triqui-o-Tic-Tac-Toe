import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


public class Main extends JFrame implements ActionListener {
	private JPanel panelMain;
	private JButton iniciar;
	private JLabel triqui, titulo;
	
	public Font tituloTriqui = new Font("Calibri",0,30);
    public Font welcome = new Font("Calibri",0,20);
    
	public Main() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Triqui");
		panelPrincipal();
	}
	
	private void panelPrincipal() {
		panelMain = new JPanel();
		panelMain.setBounds(1,1,400,500);
		panelMain.setVisible(true);
		panelMain.setLayout(null);
		this.add(panelMain);
		
		triqui = new JLabel("TRIQUI");
		triqui.setBounds(150,40,150,30);
        triqui.setFont(tituloTriqui);
		panelMain.add(triqui);
		
		titulo = new JLabel("BIENVENIDO");
		titulo.setBounds(140,160,110,20);
        titulo.setFont(welcome);
		panelMain.add(titulo);
		
		iniciar = new JButton("INICIAR");
		iniciar.setBounds(140,350,100,20);
		iniciar.setFocusable(false);
		panelMain.add(iniciar);
		iniciar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == iniciar) {
			// Se desactiva la ventana principal y se activa la ventana
			// donde se almacena el juego triqui
			Juego pro = new Juego();
			this.setVisible(false);
			pro.setBounds(0,0,400,500);
			pro.setVisible(true);
			pro.setResizable(false);
			pro.setLocationRelativeTo(null);
		}
	}
	
	public static void main(String[] args) {
		Main principal = new Main();
		principal.setBounds(0,0,400,500);
		principal.setVisible(true);
		principal.setResizable(false);
		principal.setLocationRelativeTo(null);
	}
}



/* 
	Desarrollado por:

	Santiago Jair Torres Rivera
*/