package Control;

import Modelo.ModeloOP;
import Vista.DatosNoAgrupados;
import Vista.ImportarExcel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Control implements ActionListener {

    ModeloOP mod = new ModeloOP();
    ImportarExcel VistaEX = new ImportarExcel();

    JFileChooser SelectArchivo = new JFileChooser();
    File archivo;
    int contAccion = 0;

    public Control(ImportarExcel VistaEX) {
        this.VistaEX = VistaEX;
        this.VistaEX.btnImportar.addActionListener(this);
        VistaEX.setVisible(true);
        VistaEX.setLocationRelativeTo(null);
    }

    //Control que hara la importacion de los archivos de excel en cualquiera de sus dos formatos
    public void AgregarFiltro() {
        SelectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        SelectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contAccion++;
        if (contAccion == 1) {
            AgregarFiltro();
        }
        if (e.getSource() == VistaEX.btnImportar) {
            if (SelectArchivo.showDialog(null, "Seleccionar Archivo") == JFileChooser.APPROVE_OPTION) {
                archivo = SelectArchivo.getSelectedFile();
                //ALT + 124 ||
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, mod.importar1(mod, archivo));

                    //si el archivo  que seleccionamos no es compatible con java arrojara el siguiente mensaje 
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un formato valido");
                }
            }

        }
        //Los datos de este archivo sera enviados para calcular las medidas de los Datos no agrupados
        DatosNoAgrupados inf = new DatosNoAgrupados(mod);
        inf.setVisible(true);
    }
}
