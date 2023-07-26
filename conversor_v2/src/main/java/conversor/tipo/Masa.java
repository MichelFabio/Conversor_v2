package conversor.tipo;

import conversor.enums.UnidadesMasa;
import conversor.impl.Inicio;
import conversor.modelo.Convertible;
import conversor.modelo.Conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Masa extends Conversor implements Convertible {
    public Masa() {
        super( UnidadesMasa.values(),"Masa");

        getConvertirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValorSalida();
            }
        });
        getSalirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose();
            }
        });
        getVolverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio i = new Inicio();
                getFrame().dispose();
            }
        });

    }

    @Override
    public double convertir() {
        UnidadesMasa entrada = (UnidadesMasa) getTipoEntrada().getSelectedItem();
        UnidadesMasa salida = (UnidadesMasa)getTipoSalida().getSelectedItem();
        double factorMultiplicador = 0;

        Map<Enum,Map<Enum,Double>> masas = new HashMap<>();
        masas.put(UnidadesMasa.KILOGRAMO,new HashMap<>());
        masas.get(UnidadesMasa.KILOGRAMO).put(UnidadesMasa.KILOGRAMO,1d);
        masas.get(UnidadesMasa.KILOGRAMO).put(UnidadesMasa.GRAMO,1000d);
        masas.get(UnidadesMasa.KILOGRAMO).put(UnidadesMasa.MILIGRAMO,1000000d);
        masas.get(UnidadesMasa.KILOGRAMO).put(UnidadesMasa.ONZAS,35.274d);
        masas.get(UnidadesMasa.KILOGRAMO).put(UnidadesMasa.LIBRAS,2.20);

        masas.put(UnidadesMasa.GRAMO,new HashMap<>());
        masas.get(UnidadesMasa.GRAMO).put(UnidadesMasa.KILOGRAMO,0.001d);
        masas.get(UnidadesMasa.GRAMO).put(UnidadesMasa.GRAMO,1d);
        masas.get(UnidadesMasa.GRAMO).put(UnidadesMasa.MILIGRAMO,1000d);
        masas.get(UnidadesMasa.GRAMO).put(UnidadesMasa.ONZAS,0.035274d);
        masas.get(UnidadesMasa.GRAMO).put(UnidadesMasa.LIBRAS,0.00220);

        masas.put(UnidadesMasa.MILIGRAMO,new HashMap<>());
        masas.get(UnidadesMasa.MILIGRAMO).put(UnidadesMasa.KILOGRAMO,0.000001d);
        masas.get(UnidadesMasa.MILIGRAMO).put(UnidadesMasa.GRAMO,0.001d);
        masas.get(UnidadesMasa.MILIGRAMO).put(UnidadesMasa.MILIGRAMO,1d);
        masas.get(UnidadesMasa.MILIGRAMO).put(UnidadesMasa.ONZAS,0.000035274d);
        masas.get(UnidadesMasa.MILIGRAMO).put(UnidadesMasa.LIBRAS,0.00000220);

        masas.put(UnidadesMasa.ONZAS,new HashMap<>());
        masas.get(UnidadesMasa.ONZAS).put(UnidadesMasa.KILOGRAMO ,0.0283495d);
        masas.get(UnidadesMasa.ONZAS).put(UnidadesMasa.GRAMO,28.3495d);
        masas.get(UnidadesMasa.ONZAS).put(UnidadesMasa.MILIGRAMO,28349.5d);
        masas.get(UnidadesMasa.ONZAS).put(UnidadesMasa.ONZAS,1d);
        masas.get(UnidadesMasa.ONZAS).put(UnidadesMasa.LIBRAS,0.0625d);

        masas.put(UnidadesMasa.LIBRAS,new HashMap<>());
        masas.get(UnidadesMasa.LIBRAS).put(UnidadesMasa.KILOGRAMO,453592.0d);
        masas.get(UnidadesMasa.LIBRAS).put(UnidadesMasa.GRAMO,453.592d);
        masas.get(UnidadesMasa.LIBRAS).put(UnidadesMasa.MILIGRAMO,0.45392d);
        masas.get(UnidadesMasa.LIBRAS).put(UnidadesMasa.ONZAS,16d);
        masas.get(UnidadesMasa.LIBRAS).put(UnidadesMasa.LIBRAS,1d);

        factorMultiplicador = masas.get(entrada).get(salida);
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
