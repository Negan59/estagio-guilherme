package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.TipoAtividade;

public class TipoAtividadeController {
    public Erro salvar(TipoAtividade tipoatividade) {

        if (!tipoatividade.getNome().isEmpty()) {
            if (!tipoatividade.salvar()) {
                return new Erro("Erro no banco de dados", true, 500);
            }
        } else {
            return new Erro("Senha muito curta", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(TipoAtividade tipoatividade) {
        if (!tipoatividade.getNome().isEmpty()) {
            if (!tipoatividade.alterar()) {
                return new Erro("Erro no banco de dados", true, 500);
            }
        } else {
            return new Erro("Senha muito curta", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public ArrayList<TipoAtividade> buscarTodos() {
        return new TipoAtividade().buscarTodos();
    }

    public ArrayList<TipoAtividade> buscarTodosInativos() {
        return new TipoAtividade().buscarTodosInativos();
    }

    public TipoAtividade buscarUm(int id) {
        return new TipoAtividade().buscarUm(id);
    }

    public Erro ativar(int id) {
        TipoAtividade p = new TipoAtividade();
        if (p.ativar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Ero ao ativar tipo de atividade", true, 400);
        }
    }

    public Erro desativar(int id) {
        TipoAtividade p = new TipoAtividade();
        if (p.desativar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Ero ao desativar tipo de atividade", true, 400);
        }
    }
}
