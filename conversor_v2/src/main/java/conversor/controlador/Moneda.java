package conversor.controlador;

import conversor.conexion.ConexionCurrencyApi;
import conversor.modelo.Conversor;
import conversor.modelo.Convertible;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Moneda extends Conversor implements Convertible {

    public Moneda() {
        super( "Moneda");
        for (MedidasMoneda m : MedidasMoneda.values()){
            agregarElemento(getTipoEntrada(),m);
            agregarElemento(getTipoSalida(),m);
        }
        getConvertirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValorSalida();
            }
        });
        getVolverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio i = new Inicio();
                getFrame().dispose();
            }
        });
        getSalirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getFrame().dispose();
            }
        });
    }
    private static void agregarElemento(JComboBox<MedidasMoneda> comboBox, MedidasMoneda elemento) {
        DefaultComboBoxModel<MedidasMoneda> model = (DefaultComboBoxModel<MedidasMoneda>) comboBox.getModel();
        model.addElement(elemento);
    }


    @Override
    public double convertir()  {
        double val = 0;

        String entrada = String.valueOf(getTipoEntrada().getSelectedItem());
        String salida = String.valueOf(getTipoSalida().getSelectedItem());
        ConexionCurrencyApi conexionCurrencyApi = new ConexionCurrencyApi();
        try {
            conexionCurrencyApi.conectar(entrada,salida);
            val = conexionCurrencyApi.getFactorMultiplicador();
        }catch (IOException e){
            e.printStackTrace();
        }

        return val;

    }

    @Override
    public void setValorSalida() {
        if(Convertible.verificarEntradas(getValorEntrada().getText())){
            double p = Double.parseDouble(getValorEntrada().getText());
            setValorSalida(String.valueOf(p*convertir()));
        }else{
            JOptionPane.showMessageDialog(getFrame(),"Debe ingresar un valor numérico");
        }

    }




}
