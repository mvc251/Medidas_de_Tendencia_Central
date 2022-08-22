package Negocio;
import Modelo.ModeloOPA;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Mariano Ventura
 */
public class NegocioA {
 public NegocioA(List datos, ModeloOPA model) {

        double Media;
        double Mediana;
        double Moda1;
        double DesviacionP;
        double DesviacionM;
        double varianzaP;
        double varianzaM;
        double Datos;
        int intervalo;
        int rango;

        double[] datos1;

        datos1 = cambiar(datos);
        //Medida central
        Media = mediaNG(datos1);
        Mediana = MedianaNG(datos1);
        Moda1 = moda(datos1);

        //Rango, Desviacion y Varianza
        rango = rangoNAG(datos1);
        varianzaP = varianzaPoblacion(datos1, Media);
        varianzaM = varianzaMuestra(datos1, Media);
        DesviacionP = desviacionPoblacion(datos1, Media);
        DesviacionM = desviacionMuestra(datos1, Media);

        model.setMedia(Media);
        model.setMediana(Mediana);
        model.setModa1(Moda1);
        model.setRango(rango);
        model.setDesviacionP(DesviacionP);
        model.setDesviacionM(DesviacionM);
        model.setVarianzaP(varianzaP);
        model.setVarianzaM(varianzaM);
    }

    public static double[] cambiar(List datos) {
        int sum = 0;
        for (int i = 0; i < datos.size(); i++) {
            String get = (String) datos.get(i);
            if (Numero(get)) {
                sum++;
            }
        }
        double[] prueba = new double[sum];
        int lugar = 0;
        for (int i = 0; i < datos.size(); i++) {
            if (Numero((String) datos.get(i))) {
                if (i != lugar) {
                    prueba[lugar] = Double.parseDouble((String) datos.get(i));
                } else {
                    prueba[lugar] = Double.parseDouble((String) datos.get(i));
                }
                lugar = lugar + 1;
            }
        }
        Arrays.sort(prueba);
        return prueba;
    }

    public static boolean Numero(String a) {

        boolean resultado = false;
        try {
            Double.parseDouble(a);
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }

    public double mediaNG(double[] a) {
        double media = 0.0;
        for (int i = 0; i < a.length; i++) {
            media = media + a[i];
        }
        media = media / a.length;
        return media;
    }

    public double MedianaNG(double[] a) {
        double mediana = 0;
        if (a.length == 1) {
            mediana = a[0];
        } else {
            if (a.length % 2 == 0) {
                mediana = (a[(a.length / 2) - 1] + a[(a.length / 2)]) / 2;
            } else {
                mediana = a[a.length / 2];
            }

        }
        return mediana;
    }

    public double moda(double[] v) {
        int i, j, moda = 0, n = v.length, frec;
        int frecTemp, frecModa = 0;
        double moda1 = -1;

        for (i = 0; i < n; i++) {
            frecTemp = 1;
            for (j = i + 1; j < n; j++) {
                if (v[i] == v[j]) {
                    frecTemp++;
                }
            }
            if (frecTemp > frecModa) {
                frecModa = frecTemp;
                moda1 = v[i];
            }
        }
        return moda1;
    }

    public int rangoNAG(double[] a) {

        int v = (int) (a[a.length - 1] - a[0]);
        return (int) (a[a.length - 1] - a[0]);
    }

    //Varianza Poblacion
    public double varianzaPoblacion(double[] a, double media) {

        double div = 0.0, sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = 0.0;
            d = Math.pow((a[i] - media), 2);
            sum = sum + d;
        }
        div = sum / a.length;

        return div;
    }

    //Desviacion Poblacion
    public double desviacionPoblacion(double[] a, double media) {

        double desEs = 0.0, div = 0.0, sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = 0.0;
            d = Math.pow((a[i] - media), 2);
            sum = sum + d;
        }
        div = sum / a.length;
        desEs = Math.sqrt(div);
        return desEs;
    }

    //Varianza Muestra
    public double varianzaMuestra(double[] a, double media) {

        double div = 0.0, sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = 0.0;
            d = Math.pow((a[i] - media), 2);
            sum = sum + d;
        }
        div = sum / (a.length - 1);

        return div;
    }

    //Desviacion Muestra
    public double desviacionMuestra(double[] a, double media) {

        double desEs = 0.0, div = 0.0, sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = 0.0;
            d = Math.pow((a[i] - media), 2);
            sum = sum + d;
        }
        div = sum / (a.length - 1);
        desEs = Math.sqrt(div);
        return desEs;
    }
}

