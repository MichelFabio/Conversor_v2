package conversor.modelo;

import javax.swing.*;
public interface Convertible<T extends Enum<T>> {

    double convertir();
    void setValorSalida();
    static boolean verificarEntradas(String entrada){
        if (!(entrada.matches("[0-9.]+")) || entrada == null) {
            return false;
        }
        return true;
    }


}
