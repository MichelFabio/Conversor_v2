package conversor.tipo;

import conversor.enums.UnidadesLongitud;
import conversor.impl.Inicio;
import conversor.modelo.Convertible;
import conversor.modelo.Conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Longitud extends Conversor implements Convertible {
    public Longitud() {
        super(UnidadesLongitud.values(),"Longitud");

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
        UnidadesLongitud entrada = (UnidadesLongitud) getTipoEntrada().getSelectedItem();
        UnidadesLongitud salida = (UnidadesLongitud) getTipoSalida().getSelectedItem();
        double factorMultiplicador = 0;
        Map<UnidadesLongitud,Map<UnidadesLongitud,Double>> rates = new HashMap<>();

        rates.put(UnidadesLongitud.km,new HashMap<>());
        rates.get(UnidadesLongitud.km).put(UnidadesLongitud.km,1d);
        rates.get(UnidadesLongitud.km).put(UnidadesLongitud.m,1000d);
        rates.get(UnidadesLongitud.km).put(UnidadesLongitud.mm,1000000d);
        rates.get(UnidadesLongitud.km).put(UnidadesLongitud.mi,0.621371d);
        rates.get(UnidadesLongitud.km).put(UnidadesLongitud.yd,1093.61d);
        rates.get(UnidadesLongitud.km).put(UnidadesLongitud.ft,3280.84d);

        rates.put(UnidadesLongitud.m,new HashMap<>());
        rates.get(UnidadesLongitud.m).put(UnidadesLongitud.km,0.001d);
        rates.get(UnidadesLongitud.m).put(UnidadesLongitud.m,1d);
        rates.get(UnidadesLongitud.m).put(UnidadesLongitud.mm,1000d);
        rates.get(UnidadesLongitud.m).put(UnidadesLongitud.mi,0.000621371d);
        rates.get(UnidadesLongitud.m).put(UnidadesLongitud.yd,1.09361d);
        rates.get(UnidadesLongitud.m).put(UnidadesLongitud.ft,3.28084d);

        rates.put(UnidadesLongitud.mm,new HashMap<>());
        rates.get(UnidadesLongitud.mm).put(UnidadesLongitud.km,0.000001d);
        rates.get(UnidadesLongitud.mm).put(UnidadesLongitud.m,0.001d);
        rates.get(UnidadesLongitud.mm).put(UnidadesLongitud.mm,1d);
        rates.get(UnidadesLongitud.mm).put(UnidadesLongitud.mi,0.000000621371d);
        rates.get(UnidadesLongitud.mm).put(UnidadesLongitud.yd,0.00109361d);
        rates.get(UnidadesLongitud.mm).put(UnidadesLongitud.ft,0.00328084d);

        rates.put(UnidadesLongitud.mi,new HashMap<>());
        rates.get(UnidadesLongitud.mi).put(UnidadesLongitud.km,1.60934d);
        rates.get(UnidadesLongitud.mi).put(UnidadesLongitud.m,1609.34d);
        rates.get(UnidadesLongitud.mi).put(UnidadesLongitud.mm,1609340.0d);
        rates.get(UnidadesLongitud.mi).put(UnidadesLongitud.mi,1d);
        rates.get(UnidadesLongitud.mi).put(UnidadesLongitud.yd,1760d);
        rates.get(UnidadesLongitud.mi).put(UnidadesLongitud.ft,5280d);

        rates.put(UnidadesLongitud.yd,new HashMap<>());
        rates.get(UnidadesLongitud.yd).put(UnidadesLongitud.km,0.0009144d);
        rates.get(UnidadesLongitud.yd).put(UnidadesLongitud.m,0.9144d);
        rates.get(UnidadesLongitud.yd).put(UnidadesLongitud.mm,914.4d);
        rates.get(UnidadesLongitud.yd).put(UnidadesLongitud.mi,0.000568182d);
        rates.get(UnidadesLongitud.yd).put(UnidadesLongitud.ft,1d);
        rates.get(UnidadesLongitud.yd).put(UnidadesLongitud.ft,3.00000096);

        rates.put(UnidadesLongitud.ft,new HashMap<>());
        rates.get(UnidadesLongitud.ft).put(UnidadesLongitud.km,0.000304800097536d);
        rates.get(UnidadesLongitud.ft).put(UnidadesLongitud.m,0.304800097536d);
        rates.get(UnidadesLongitud.ft).put(UnidadesLongitud.mm,304.800097536);
        rates.get(UnidadesLongitud.ft).put(UnidadesLongitud.mi,0.00018939400000000000983d);
        rates.get(UnidadesLongitud.ft).put(UnidadesLongitud.yd,0.33333344000000003637d);
        rates.get(UnidadesLongitud.ft).put(UnidadesLongitud.ft,1d);
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
