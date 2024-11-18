package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana1 extends JFrame{
    private JLabel usuarioLabel, maquinaLabel, resultadoLabel;
    private JButton piedraBtn, papelBtn, tijeraBtn, jugarBtn, reiniciarBtn, salirBtn;
    private String eleccionUsuario = "";
    private String eleccionMaquina = "";
    
    public Ventana1() throws HeadlessException {
        setSize(480,350);
        setTitle("Piedra Papel o Tijera");
        setLocation(200,100);
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel(new GridLayout(2, 2));
        usuarioLabel = new JLabel("Tu elección: ", SwingConstants.CENTER);
        maquinaLabel = new JLabel("Elección de la máquina: ", SwingConstants.CENTER);
        resultadoLabel = new JLabel("Resultado: ", SwingConstants.CENTER);

        panel1.add(usuarioLabel);
        panel1.add(maquinaLabel);
        panel1.add(resultadoLabel);
        JPanel panel2 = new JPanel();
        JLabel elegir = new JLabel("Haz clic en un botón para elegir:", SwingConstants.CENTER);
        piedraBtn = new JButton("Piedra");
        papelBtn = new JButton("Papel");
        tijeraBtn = new JButton("Tijera");
        panel2.add(elegir);
        panel2.add(piedraBtn);
        panel2.add(papelBtn);
        panel2.add(tijeraBtn);
        
        JPanel panel3 = new JPanel(new GridLayout(1, 3));
        jugarBtn = new JButton("Jugar");
        reiniciarBtn = new JButton("Reiniciar");
        salirBtn = new JButton("Salir");
        panel3.add(jugarBtn);
        panel3.add(reiniciarBtn);
        panel3.add(salirBtn);
        
        JPanel panel4= new JPanel(new GridLayout(2, 1));
        panel4.add(panel2);
        panel4.add(panel1);
        add(panel4, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        
        piedraBtn.addActionListener(e -> eleccionUsuario = "Piedra");
        papelBtn.addActionListener(e -> eleccionUsuario = "Papel");
        tijeraBtn.addActionListener(e -> eleccionUsuario = "Tijera");

        jugarBtn.addActionListener(e -> jugar());
        reiniciarBtn.addActionListener(e -> reiniciar());
        salirBtn.addActionListener(e -> System.exit(0));
    }

    private void jugar() {
        String[] op = {"Piedra", "Papel", "Tijera"};
        eleccionMaquina = op[new Random().nextInt(op.length)];

        usuarioLabel.setText("Tu elección fue: "+ eleccionUsuario);
        maquinaLabel.setText("Elección de la máquina fue: "+ eleccionMaquina);

        String resultado;
        if (eleccionUsuario.equals(eleccionMaquina)) {
            resultado = "Empate";
        }else if((eleccionUsuario.equals("Piedra") && eleccionMaquina.equals("Tijera")) ||
                   (eleccionUsuario.equals("Papel") && eleccionMaquina.equals("Piedra")) ||
                   (eleccionUsuario.equals("Tijera") && eleccionMaquina.equals("Papel"))) {
            resultado = "¡Felicidades ganaste!";
        }else{
            resultado = "La máquina ganó";
        }

        resultadoLabel.setText("Resultado: " + resultado);
    }

    private void reiniciar() {
        eleccionUsuario = "";
        eleccionMaquina = "";
        usuarioLabel.setText("Tu elección: ");
        maquinaLabel.setText("Elección de la máquina: ");
        resultadoLabel.setText("Resultado: ");
    }
}
