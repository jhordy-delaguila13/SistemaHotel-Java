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

public class ReporteComprobantePago {

    private Connection cnn;

    public ReporteComprobantePago() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
    }

    public void runReporteComprobantePago(String idReserva) {
 
        try {
            String direccionJasPer = "src\\componenteReporte\\JaspReporteComprobante.jasper";
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObjectFromFile(direccionJasPer);
            } catch (JRException e) {
                System.out.println("e: " + e.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            parametro.put("id", idReserva);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, cnn);
            JasperViewer jviewer = new JasperViewer(jasperPrint);
            jviewer.setTitle("Reporte comprobante");
            jviewer.setVisible(true);

        } catch (JRException j) {
            System.out.println("J: " + j.getMessage());
        }

    }
}
