package conversor.tipo;

import conversor.enums.UnidadesTemperatura;
import conversor.impl.Inicio;
import conversor.modelo.Conversor;
import conversor.modelo.Convertible;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Temperatura extends Conversor implements Convertible {
    public Temperatura() {
        super(UnidadesTemperatura.values(), "Longitud");
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
    public double convertir() {
        UnidadesTemperatura entrada = (UnidadesTemperatura) getTipoEntrada().getSelectedItem();
        UnidadesTemperatura salida = (UnidadesTemperatura) getTipoSalida().getSelectedItem();
        double in = Double.parseDouble(getValorEntrada().getText());
        Map<UnidadesTemperatura,Map<UnidadesTemperatura,Double>> rates = new HashMap<>();
        rates.put(UnidadesTemperatura.KELVIN,new HashMap<>());
        rates.get(UnidadesTemperatura.KELVIN).put(UnidadesTemperatura.KELVIN,in);
        rates.get(UnidadesTemperatura.KELVIN).put(UnidadesTemperatura.CELSIUS,in-273.15d);
        rates.get(UnidadesTemperatura.KELVIN).put(UnidadesTemperatura.FAHRENHEIT,(in-273.15)*9/5+32);

        rates.put(UnidadesTemperatura.CELSIUS,new HashMap<>());
        rates.get(UnidadesTemperatura.CELSIUS).put(UnidadesTemperatura.KELVIN,in +273.15d);
        rates.get(UnidadesTemperatura.CELSIUS).put(UnidadesTemperatura.CELSIUS,in);
        rates.get(UnidadesTemperatura.CELSIUS).put(UnidadesTemperatura.FAHRENHEIT,(in* 9/5) + 32);

        rates.put(UnidadesTemperatura.FAHRENHEIT,new HashMap<>());
        rates.get(UnidadesTemperatura.FAHRENHEIT).put(UnidadesTemperatura.KELVIN,((in-32) * 5/9 + 273.15));
        rates.get(UnidadesTemperatura.FAHRENHEIT).put(UnidadesTemperatura.CELSIUS,(in-32)* 5/9);
        rates.get(UnidadesTemperatura.FAHRENHEIT).put(UnidadesTemperatura.FAHRENHEIT,in);
        return rates.get(entrada).get(salida) ;
    }

    @Override
    public void setValorSalida() {
        if (Convertible.verificarEntradas(getValorEntrada().getText())){
            setValorSalida(String.valueOf(convertir()));
        }else JOptionPane.showMessageDialog(getFrame(),"Debe ingresar un valor numérico");
    }
}
