package controller;


import dao.relatorioAtaDao;
import java.sql.ResultSet;

/**
 *
 * @author Danel
 */
public class relatorioAtaController {
    relatorioAtaDao rad;
    
        public relatorioAtaController() {
        if (rad == null) {
            rad = new relatorioAtaDao();
        }
    }
        public ResultSet relatorioAta() {
        return rad.RelatorioAta();
    }
}
