package conversor.modelo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class Conversor<T extends Enum<T>> {
    private JComboBox<T> tipoEntrada;
    private JComboBox<T> tipoSalida;
    private JLabel aLabel;
    private JLabel igualLabel;
    private JTextField valorEntrada;
    private JTextField valorSalida;

    private JButton convertirButton;
    private JButton volverButton;

    private JButton salirButton;
    private JPanel panelButton;
    private JPanel panelData;
    private JPanel mainPanel;
    private JFrame frame;



    public Conversor(T[] elemento,String tipo) {
        this.tipoEntrada = new JComboBox<>(elemento);
        this.tipoSalida = new JComboBox<>(elemento);
        this.aLabel = new JLabel("a");
        aLabel.setHorizontalAlignment(JLabel.CENTER);
        this.igualLabel = new JLabel("=");
        igualLabel.setHorizontalAlignment(JLabel.CENTER);
        this.valorEntrada = new JTextField(15);
        this.valorSalida = new JTextField(15);
        this.convertirButton = new JButton("Convertir");
        this.volverButton = new JButton("Volver");
        this.salirButton = new JButton("Salir");
        this.panelData = new JPanel(new GridLayout(2, 3));
        this.panelButton = new JPanel(new GridLayout(1, 3));
        this.mainPanel = new JPanel(new GridLayout(2, 1));
        this.frame = new JFrame(tipo);
        //Añadir componentes de entrada y salida al panel superior

        panelData.add(tipoEntrada);
        panelData.add((aLabel));
        panelData.add(tipoSalida);
        panelData.add(valorEntrada);
        panelData.add(igualLabel);
        panelData.add(valorSalida);
        panelData.setBorder(new EmptyBorder(10, 50, 10, 50));
        panelButton.add(volverButton);
        panelButton.add(convertirButton);
        panelButton.add(salirButton);
        panelButton.setBorder(new EmptyBorder(10, 50, 10, 50));
        mainPanel.add(panelData);
        mainPanel.add(panelButton);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 600);
        frame.pack();
        frame.setVisible(true);
    }

    public JComboBox<T> getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(JComboBox<T> tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public JComboBox<T> getTipoSalida() {
        return tipoSalida;
    }

    public void setTipoSalida(JComboBox<T> tipoSalida) {
        this.tipoSalida = tipoSalida;
    }

    public JTextField getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(JTextField valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public JTextField getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(String valorSalida) {
        this.valorSalida.setText(valorSalida);
    }

    public JPanel getPanelInput() {
        return panelButton;
    }

    public void setPanelInput(JPanel panelInput) {
        this.panelButton = panelInput;
    }

    public JPanel getPanelOutput() {
        return panelData;
    }

    public void setPanelOutput(JPanel panelOutput) {
        this.panelData = panelOutput;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getConvertirButton() {
        return convertirButton;
    }

    public JButton getVolverButton() {
        return volverButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }
}