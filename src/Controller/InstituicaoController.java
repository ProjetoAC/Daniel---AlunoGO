package Controller;

import Dao.InstituicaoDao;
import Model.Instituicao;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class InstituicaoController {
    InstituicaoDao instituicaoDao;

    public InstituicaoController() {
        if (instituicaoDao == null) {
            instituicaoDao = new InstituicaoDao();
        }
    }

    public boolean insereInstituicao(Instituicao instituicao) {

        if (instituicao.getInstituicaoid() != 0) {
            return instituicaoDao.updateInstituicao(instituicao);
        } else {
            return instituicaoDao.insereInstituicao(instituicao);
        }
    }

    public ArrayList<Instituicao> getInstituicoes() {
        return instituicaoDao.getInstituicoes();
    }

    public boolean deleteInstituicao(int id) {
        return instituicaoDao.deleteInstituicao(id);
    }
}
