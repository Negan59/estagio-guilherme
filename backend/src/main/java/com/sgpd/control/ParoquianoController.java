package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Paroquiano;

public class ParoquianoController {
    public Erro salvar(Paroquiano paroquiano){
        if(!paroquiano.getEmail().isEmpty()){
            if(!paroquiano.getNome().isEmpty()){
                if(paroquiano.getSenha().length() >= 5){
                    if(!paroquiano.salvar()){
                        return new Erro("Erro no banco de dados", true, 500);
                    }
                }else{
                    return new Erro("Senha muito curta", true, 400);
                }
            }else{
                return new Erro("Por favor, preencha o nome do usuário", true, 400);
            }
        }else{
            return new Erro("Por favor, preencha o email do usuário", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(Paroquiano paroquiano){
        if(!paroquiano.getEmail().isEmpty()){
            if(!paroquiano.getNome().isEmpty()){
                if(paroquiano.getSenha().length() >= 5){
                    if(!paroquiano.alterar()){
                        return new Erro("Erro no banco de dados", true, 500);
                    }
                }else{
                    return new Erro("Senha muito curta", true, 400);
                }
            }else{
                return new Erro("Por favor, preencha o nome do usuário", true, 400);
            }
        }else{
            return new Erro("Por favor, preencha o email do usuário", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro apagar(int id){
        Paroquiano p = new Paroquiano();
        if(p.apagar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Paroquiano possui funções atribuídas, não pode ser excluido", true, 400);
        }
    }

    public ArrayList<Paroquiano> buscarTodos(String filtro){
        return new Paroquiano().buscarTodos(filtro);
    }

    public Paroquiano buscarUm(int id){
        return new Paroquiano().buscarUm(id);
    }
}
