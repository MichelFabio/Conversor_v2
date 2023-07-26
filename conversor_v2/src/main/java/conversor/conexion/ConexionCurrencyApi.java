package conversor.conexion;

import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConexionCurrencyApi {

    private static final String API_KEY = "621ab52a4448d95aa0b8a6fe";
    private double factorMultiplicador;

    public void conectar(String monedaEntrada,String monedaSalida) throws IOException {
        String direccion = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s?symbols=%s",API_KEY,monedaEntrada,monedaSalida);
        URL url = new URL(direccion);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int response = conn.getResponseCode();
        if (response != 200){
            JOptionPane.showMessageDialog(null,"No se puede conectar");
        }else{
            try{
                setMultiplicador(url,monedaEntrada,monedaSalida);
            }catch (IOException e){
                JOptionPane.showMessageDialog(null,"No puede leer los datos");
            }finally {

            }

        }

    }
    private void setMultiplicador(URL url, String monedaEntrada,String monedaSalida) throws IOException {
        String val = "";
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()){
            val += scanner.nextLine();
        }
        JSONObject jasonArray = new JSONObject(val);
        JSONObject jasonObject = jasonArray.getJSONObject("conversion_rates");
        BigDecimal d =  jasonObject.getBigDecimal(monedaSalida);
        factorMultiplicador = Double.parseDouble(String.valueOf(d));
        scanner.close();

    }
    public double getFactorMultiplicador(){
        return this.factorMultiplicador;
    }


}
