package controller;

import dao.RelatorioDao;
import java.sql.ResultSet;
import model.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class RelatorioController {
    RelatorioDao relatorioDao;

    public RelatorioController() {
        if (relatorioDao == null) {
            relatorioDao = new RelatorioDao();
        }
    }

    public boolean insereRelatorio(Relatorio relatorio) {

        if (relatorio.getRelatorioid() != 0) {
            return relatorioDao.updateRelatorio(relatorio);
        } else {
            return relatorioDao.insereRelatorio(relatorio);
        }
    }

    public ArrayList<Relatorio> getRelatorio(String text) {
        return relatorioDao.getRelatorio(text);
    }

    public boolean deleteRelatorio(int id) {
        return relatorioDao.deleteRelatorio(id);
    }
        public ResultSet relatorioAta(int id) {
        return relatorioDao.RelatorioAta(id);
    }
}
