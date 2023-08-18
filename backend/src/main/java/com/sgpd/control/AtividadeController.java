package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Local;

public class AtividadeController {
    public Erro salvarLocal(Local local) {
        if (!local.getNome().isEmpty()) {
            if (!local.getEndereco().isEmpty()) {
                if (!local.getTelefone().isEmpty()) {
                    if (!local.getBairro().isEmpty()) {
                        if (!local.getCep().isEmpty()) {
                            if (!local.salvar()) {
                                return new Erro("Erro no banco de dados", true, 500);
                            }
                        } else {
                            return new Erro("CEP do local não é válido", true, 400);
                        }
                    } else {
                        return new Erro("Bairro do local não é válido", true, 400);
                    }
                } else {
                    return new Erro("Telefone do local não é válido", true, 400);
                }
            } else {
                return new Erro("Endereço do local não é válido", true, 400);
            }
        } else {
            return new Erro("Por favor, insira um nome para o local", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterarLocal(Local local) {
        if (!local.getNome().isEmpty()) {
            if (!local.getEndereco().isEmpty()) {
                if (!local.getTelefone().isEmpty()) {
                    if (!local.getBairro().isEmpty()) {
                        if (!local.getCep().isEmpty()) {
                            if (!local.alterar()) {
                                return new Erro("Erro no banco de dados", true, 500);
                            }
                        } else {
                            return new Erro("CEP do local não é válido", true, 400);
                        }
                    } else {
                        return new Erro("Bairro do local não é válido", true, 400);
                    }
                } else {
                    return new Erro("Telefone do local não é válido", true, 400);
                }
            } else {
                return new Erro("Endereço do local não é válido", true, 400);
            }
        } else {
            return new Erro("Por favor, insira um nome para o local", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public ArrayList<Local> buscarTodosLocal() {
        return new Local().buscarTodos();
    }

    public Local buscarUmLocal(int id) {
        return new Local().buscarUm(id);
    }

    public Erro apagarLocal(int id) {
        Local p = new Local();
        if (p.apagar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Local não pode ser excluido", true, 400);
        }
    }

}
