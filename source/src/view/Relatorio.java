package view;

import controller.RelatorioController;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Senai
 */
public class Relatorio {

    public static void main(String args[]) {

        try {
            new Relatorio().ExecutaRelatorio();
        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ExecutaRelatorio() throws JRException {

        JRResultSetDataSource jr = new JRResultSetDataSource(new RelatorioController().getRelatorioByIDRs(1));
        File reportFile = new File("relatorio/Ata.jrxml");
        JasperRunManager.runReportToPdfFile(reportFile.getPath(), new HashMap(), jr);

    }
}
