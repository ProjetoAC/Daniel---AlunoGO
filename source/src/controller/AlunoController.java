package controller;

import dao.AlunoDao;
import model.Aluno;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class AlunoController {
        AlunoDao alunoDao;

    public AlunoController() {
        if (alunoDao == null) {
            alunoDao = new AlunoDao();
        }
    }

    public boolean insereAluno(Aluno aluno) {
        if (aluno.getAlunoid() != 0) {
            return alunoDao.updateAluno(aluno);
        } else {
            return alunoDao.insereAluno(aluno);
        }
    }

    public ArrayList<Aluno> getAlunos(String texto) {
        return alunoDao.getAlunos(texto);
    }

    public boolean deleteAluno(int id) {
        return alunoDao.deleteAluno(id);
    }
}
