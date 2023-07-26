package conversor.impl;

import conversor.modelo.Conversor;
import conversor.tipo.Longitud;
import conversor.tipo.Masa;
import conversor.tipo.Moneda;
import conversor.tipo.Temperatura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JLabel texto;
    private JButton monedasButton;
    private JButton masaButton;
    private JButton temperaturaButton;
    private JButton longitudButton;
    private Conversor conversor;


    public Inicio(){
        frame = new JFrame("Conversor General");
        texto = new JLabel("Que tipo de conversor desea?");

        monedasButton = new JButton("Moneda");
        monedasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conversor = new Moneda();
                frame.dispose();
            }
        });
        masaButton = new JButton("Masa");
        masaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conversor = new Masa();
                frame.dispose();
            }
        });



        temperaturaButton = new JButton("Temperatura");
        temperaturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conversor = new Temperatura();
                frame.dispose();
            }
        });

        longitudButton = new JButton("Longitud");
        longitudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conversor = new Longitud();
                frame.dispose();
            }
        });

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(monedasButton);
        buttonPanel.add(temperaturaButton);
        buttonPanel.add(masaButton);
        buttonPanel.add(longitudButton);
        buttonPanel.setBorder(new EmptyBorder(10,25,10,25));
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(texto);
        mainPanel.add(buttonPanel);
        mainPanel.setBorder(new EmptyBorder(10,25,10,25));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}