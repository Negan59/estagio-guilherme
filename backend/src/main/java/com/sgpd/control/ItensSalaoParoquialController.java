package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.ItensSalaoParoquial;

public class ItensSalaoParoquialController {
    public Erro salvar(ItensSalaoParoquial itemsalao) {

        if (!itemsalao.getNome().isEmpty()) {
            if (!itemsalao.salvar()) {
                return new Erro("Erro no banco de dados", true, 500);
            }
        } else {
            return new Erro("Senha muito curta", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(ItensSalaoParoquial itemsalao) {
        if (!itemsalao.getNome().isEmpty()) {
            if (!itemsalao.alterar()) {
                return new Erro("Erro no banco de dados", true, 500);
            }
        } else {
            return new Erro("Senha muito curta", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public ArrayList<ItensSalaoParoquial> buscarTodos() {
        return new ItensSalaoParoquial().buscarTodos();
    }

    public ArrayList<ItensSalaoParoquial> buscarTodosInativos() {
        return new ItensSalaoParoquial().buscarTodosInativos();
    }

    public ItensSalaoParoquial buscarUm(int id) {
        return new ItensSalaoParoquial().buscarUm(id);
    }

    public Erro ativar(int id) {
        ItensSalaoParoquial p = new ItensSalaoParoquial();
        if (p.ativar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Ero ao ativar item do salão", true, 400);
        }
    }

    public Erro desativar(int id) {
        ItensSalaoParoquial p = new ItensSalaoParoquial();
        if (p.desativar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Ero ao desativar item do salão", true, 400);
        }
    }
}
