package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Aluguel;

public class AluguelController {
    public Erro salvar(Aluguel aluguel) {
        if (!aluguel.getNomealuguel().isEmpty()) {
            if (!aluguel.salvar()) {
                return new Erro("Erro no banco de dados", true, 500);
            }
        } else {
            return new Erro("Por favor, preencha o nome do usuário", true, 400);
        }

        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(Aluguel aluguel) {
        if (!aluguel.getNomealuguel().isEmpty()) {
            if (!aluguel.alterar()) {
                return new Erro("Erro no banco de dados", true, 500);
            }
        } else {
            return new Erro("Por favor, preencha o nome do usuário", true, 400);
        }

        return new Erro("Sucesso", false, 200);

    }

    public Erro apagar(int id) {
        Aluguel p = new Aluguel();
        if (p.apagar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Aluguel possui funções atribuídas, não pode ser excluido", true, 400);
        }
    }

    public ArrayList<Aluguel> buscarTodos() {
        return new Aluguel().buscarTodos();
    }

    public Aluguel buscarUm(int id) {
        return new Aluguel().buscarUm(id);
    }
}
