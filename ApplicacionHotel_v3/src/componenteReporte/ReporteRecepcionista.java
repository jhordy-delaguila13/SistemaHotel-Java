package componenteReporte;

import ComponenteDatos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ReporteRecepcionista {

    private Connection conexion;
    public ReporteRecepcionista() throws SQLException{
        conexion = Conexion.getInstancia().miConexion();
    }

    public void runReporteRecepcionista(){
 
        try {
            String direccionJasPer = "src\\componenteReporte\\JaspReporteRecepcionista.jasper";
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObjectFromFile(direccionJasPer);
            } catch (JRException e) {
                System.err.println("e: "+e.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conexion);
            JasperViewer jviewer = new JasperViewer(jasperPrint);
            jviewer.setTitle("Reporte Recepcionista");
            jviewer.setVisible(true);

        } catch (JRException j) {
            System.err.println("j: "+j.getMessage());
        }
    }
}
