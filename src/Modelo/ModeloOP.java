package Modelo;

import Negocio.NegocioD;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Mariano Ventura
 */
public class ModeloOP {
    //Aqui es donde se declaran las variables de instancia se hacen privadas y se utiliza el metodo mutador para poder utilizarlas en el programa

    private double Moda1;
    private double Media;
    private double Mediana;
    private double DesviacionP;
    private double DesviacionM;
    private int intervalo;
    private int rango;
    private double varianzaP;
    private double varianzaM;

    public double getMedia() {
        return Media;
    }

    public void setMedia(double Media1) {
        this.Media = Media1;
    }

    public double getMediana() {
        return Mediana;
    }

    public void setMediana(double Mediana1) {
        this.Mediana = Mediana1;
    }

    public double getModa1() {
        return Moda1;
    }

    public void setModa1(double Moda11) {
        this.Moda1 = Moda11;
    }

    public double getDesviacionP() {
        return DesviacionP;
    }

    public void setDesviacionP(double DesviacionP) {
        this.DesviacionP = DesviacionP;
    }

    public double getDesviacionM() {
        return DesviacionP;
    }

    public void setDesviacionM(double DesviacionM) {
        this.DesviacionP = DesviacionM;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo1) {
        this.intervalo = intervalo1;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango1) {
        this.rango = rango1;
    }

    public double getVarianzaP() {
        return varianzaP;
    }

    public void setVarianzaP(double varianza1) {
        this.varianzaP = varianza1;
    }

    public double getVarianzaM() {
        return varianzaM;
    }

    public void setVarianzaM(double varianzaM) {
        this.varianzaM = varianzaM;
    }

    public String importar1(ModeloOP modelE, File file) {
        String msgE = "Error importación";

        try {
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();

            DataFormatter formatter = new DataFormatter();
            List<String> dato = new ArrayList();
            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    dato.add(contenidoCelda);
                }
                msgE = "LISTO";
            }
            new NegocioD(dato, modelE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msgE;
    }
}
