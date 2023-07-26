package conversor.controlador;

import conversor.modelo.Convertible;
import conversor.modelo.Conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Masa extends Conversor implements Convertible {
    public Masa() {
        super( "Masa");
        for(MedidasMasa m : MedidasMasa.values()){
            agregarElemento(getTipoEntrada(),m);
        }
        for(MedidasMasa m : MedidasMasa.values()){
            agregarElemento(getTipoSalida(),m);
        }


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
    private static void agregarElemento(JComboBox<MedidasMasa> comboBox, MedidasMasa elemento) {
        DefaultComboBoxModel<MedidasMasa> model = (DefaultComboBoxModel<MedidasMasa>) comboBox.getModel();
        model.addElement(elemento);
    }

    @Override
    public double convertir() {
        MedidasMasa entrada = (MedidasMasa) getTipoEntrada().getSelectedItem();
        MedidasMasa salida = (MedidasMasa)getTipoSalida().getSelectedItem();
        double factorMultiplicador = 0;

        Map<Enum,Map<Enum,Double>> masas = new HashMap<>();
        masas.put(MedidasMasa.KILOGRAMO,new HashMap<>());
        masas.get(MedidasMasa.KILOGRAMO).put(MedidasMasa.KILOGRAMO,1d);
        masas.get(MedidasMasa.KILOGRAMO).put(MedidasMasa.GRAMO,1000d);
        masas.get(MedidasMasa.KILOGRAMO).put(MedidasMasa.MILIGRAMO,1000000d);
        masas.get(MedidasMasa.KILOGRAMO).put(MedidasMasa.ONZAS,35.274d);
        masas.get(MedidasMasa.KILOGRAMO).put(MedidasMasa.LIBRAS,2.20);

        masas.put(MedidasMasa.GRAMO,new HashMap<>());
        masas.get(MedidasMasa.GRAMO).put(MedidasMasa.KILOGRAMO,0.001d);
        masas.get(MedidasMasa.GRAMO).put(MedidasMasa.GRAMO,1d);
        masas.get(MedidasMasa.GRAMO).put(MedidasMasa.MILIGRAMO,1000d);
        masas.get(MedidasMasa.GRAMO).put(MedidasMasa.ONZAS,0.035274d);
        masas.get(MedidasMasa.GRAMO).put(MedidasMasa.LIBRAS,0.00220);

        masas.put(MedidasMasa.MILIGRAMO,new HashMap<>());
        masas.get(MedidasMasa.MILIGRAMO).put(MedidasMasa.KILOGRAMO,0.000001d);
        masas.get(MedidasMasa.MILIGRAMO).put(MedidasMasa.GRAMO,0.001d);
        masas.get(MedidasMasa.MILIGRAMO).put(MedidasMasa.MILIGRAMO,1d);
        masas.get(MedidasMasa.MILIGRAMO).put(MedidasMasa.ONZAS,0.000035274d);
        masas.get(MedidasMasa.MILIGRAMO).put(MedidasMasa.LIBRAS,0.00000220);

        masas.put(MedidasMasa.ONZAS,new HashMap<>());
        masas.get(MedidasMasa.ONZAS).put(MedidasMasa.KILOGRAMO ,0.0283495d);
        masas.get(MedidasMasa.ONZAS).put(MedidasMasa.GRAMO,28.3495d);
        masas.get(MedidasMasa.ONZAS).put(MedidasMasa.MILIGRAMO,28349.5d);
        masas.get(MedidasMasa.ONZAS).put(MedidasMasa.ONZAS,1d);
        masas.get(MedidasMasa.ONZAS).put(MedidasMasa.LIBRAS,0.0625d);

        masas.put(MedidasMasa.LIBRAS,new HashMap<>());
        masas.get(MedidasMasa.LIBRAS).put(MedidasMasa.KILOGRAMO,453592.0d);
        masas.get(MedidasMasa.LIBRAS).put(MedidasMasa.GRAMO,453.592d);
        masas.get(MedidasMasa.LIBRAS).put(MedidasMasa.MILIGRAMO,0.45392d);
        masas.get(MedidasMasa.LIBRAS).put(MedidasMasa.ONZAS,16d);
        masas.get(MedidasMasa.LIBRAS).put(MedidasMasa.LIBRAS,1d);

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
