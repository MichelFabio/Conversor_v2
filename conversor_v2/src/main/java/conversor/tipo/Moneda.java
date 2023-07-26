package conversor.tipo;

import conversor.conexion.ConexionCurrencyApi;
import conversor.enums.UnidadesMoneda;
import conversor.impl.Inicio;
import conversor.modelo.Conversor;
import conversor.modelo.Convertible;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Moneda extends Conversor implements Convertible {
    private ConexionCurrencyApi conexionCurrencyApi;
    public Moneda() {
        super( UnidadesMoneda.values(),"Moneda");

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
    @Override
    public double convertir()  {
        double val = 0;
        conexionCurrencyApi = new ConexionCurrencyApi();
        String entrada = String.valueOf(getTipoEntrada().getSelectedItem());
        String salida = String.valueOf(getTipoSalida().getSelectedItem());
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
