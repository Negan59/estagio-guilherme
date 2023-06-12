package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Sala;

public class AgendaController {
    // Sala
    public Erro salvarSala(Sala sala) {
        if (!sala.getDescricaosala().isEmpty()) {
            if (sala.getNumerosala() > 0) {
                if (!sala.salvar()) {
                    return new Erro("Erro no banco de dados", true, 500);
                }
            } else {
                return new Erro("Número da sala não é válido", true, 400);
            }
        } else {
            return new Erro("Por favor, insira uma descrição para a sala", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterarSala(Sala sala) {
        System.out.println(sala.getId());
        System.out.println(sala.getDescricaosala());
        System.out.println(sala.getNumerosala());
        if (!sala.getDescricaosala().isEmpty()) {
            if (sala.getNumerosala() > 0) {
                if (!sala.alterar()) {
                    return new Erro("Erro no banco de dados", true, 500);
                }
            } else {
                return new Erro("Número da sala não é válido", true, 400);
            }
        } else {
            return new Erro("Por favor, insira uma descrição para a sala", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro apagarSala(int id) {
        Sala p = new Sala();
        if (p.apagar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Sala possui funções atribuídas, não pode ser excluido", true, 400);
        }
    }

    public ArrayList<Sala> buscarTodosSala() {
        return new Sala().buscarTodos();
    }

    public Sala buscarUmSala(int id) {
        return new Sala().buscarUm(id);
    }
}
