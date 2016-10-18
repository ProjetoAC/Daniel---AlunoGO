package controller;

import dao.RelatorioDao;
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

    public ArrayList<Relatorio> getRelatorio() {
        return relatorioDao.getRelatorios();
    }

    public boolean deleteRelatorio(int id) {
        return relatorioDao.deleteRelatorio(id);
    }
}
