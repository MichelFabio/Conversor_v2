package conversor.controlador;

import conversor.modelo.Convertible;
import conversor.modelo.Conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Longitud extends Conversor implements Convertible {
    private String [] ins = {"km","m","mm","mil","yd","ft"};
    public Longitud() {
        super("Longitud");
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
        String entrada = (String) getTipoEntrada().getSelectedItem();
        System.out.println(entrada);
        String salida = (String) getTipoSalida().getSelectedItem();
        System.out.println(salida);
        double factorMultiplicador = 0;
        Map<String,Map<String,Double>> rates = new HashMap<>();
        rates.put("km",new HashMap<>());
        rates.get("km").put("km",1d);
        rates.get("km").put("m",1000d);
        rates.get("km").put("mm",1000000d);
        rates.get("km").put("mi",0.621371d);
        rates.get("km").put("yd",1093.61d);
        rates.get("km").put("ft",3280.84d);

        rates.put("m",new HashMap<>());
        rates.get("m").put("km",0.001d);
        rates.get("m").put("m",1d);
        rates.get("m").put("mm",1000d);
        rates.get("m").put("mi",0.000621371d);
        rates.get("m").put("yd",1.09361d);
        rates.get("m").put("ft",3.28084d);

        rates.put("mm",new HashMap<>());
        rates.get("mm").put("km",0.000001d);
        rates.get("mm").put("m",0.001d);
        rates.get("mm").put("mm",1d);
        rates.get("mm").put("mi",0.000000621371d);
        rates.get("mm").put("yd",0.00109361d);
        rates.get("mm").put("ft",0.00328084d);

        rates.put("mi",new HashMap<>());
        rates.get("mi").put("km",1.60934d);
        rates.get("mi").put("m",1609.34d);
        rates.get("mi").put("mm",1609340.0d);
        rates.get("mi").put("mi",1d);
        rates.get("mi").put("yd",1760d);
        rates.get("mi").put("ft",5280d);

        rates.put("yd",new HashMap<>());
        rates.get("yd").put("km",0.0009144d);
        rates.get("yd").put("m",0.9144d);
        rates.get("yd").put("mm",914.4d);
        rates.get("yd").put("mi",0.000568182d);
        rates.get("yd").put("yd",1d);
        rates.get("yd").put("ft",3.00000096);

        rates.put("ft",new HashMap<>());
        rates.get("ft").put("km",0.304800097536d);
        rates.get("ft").put("m",304.800097536d);
        rates.get("ft").put("mm",304800.097536);
        rates.get("ft").put("mi",0.00018939400000000000983d);
        rates.get("ft").put("yd",0.33333344000000003637d);
        rates.get("ft").put("ft",1d);
        factorMultiplicador = rates.get(entrada).get(salida);
        return factorMultiplicador;
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
