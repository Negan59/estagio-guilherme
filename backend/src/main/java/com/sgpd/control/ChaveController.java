package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Chave;

public class ChaveController {
    public Erro salvarChave(Chave chave) {
        if (!chave.salvar()) {
            return new Erro("Erro no banco de dados", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterarChave(Chave chave) {

        if (!chave.alterar()) {
            return new Erro("Erro no banco de dados", true, 500);
        }

        return new Erro("Sucesso", false, 200);
    }

    public Erro apagarChave(int id) {
        Chave p = new Chave();
        if (p.apagar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Chave possui funções atribuídas, não pode ser excluido", true, 400);
        }
    }

    public ArrayList<Chave> buscarTodosChave() {
        return new Chave().buscarTodos();
    }

    public Chave buscarUmChave(int id) {
        return new Chave().buscarUm(id);
    }
}
