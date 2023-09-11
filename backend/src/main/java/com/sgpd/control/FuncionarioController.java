package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Funcionario;

public class FuncionarioController {
    public Erro salvar(Funcionario funcionario){
        if(!funcionario.getEmail().isEmpty()){
            if(!funcionario.getNome().isEmpty()){
                if(funcionario.getSenha().length() >= 5){
                    if(!funcionario.salvar()){
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

    public Erro alterar(Funcionario funcionario){
        if(!funcionario.getEmail().isEmpty()){
            if(!funcionario.getNome().isEmpty()){
                if(funcionario.getSenha().length() >= 5){
                    if(!funcionario.alterar()){
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

    public ArrayList<Funcionario> buscarTodos(){
        return new Funcionario().buscarTodos();
    }

    public ArrayList<Funcionario> buscarTodosInativos(){
        return new Funcionario().buscarTodosInativos();
    }

    public Funcionario buscarUm(int id){
        return new Funcionario().buscarUm(id);
    }

    public Erro ativar(int id){
        Funcionario p = new Funcionario();
        if(p.ativar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Ero ao ativar funcionário", true, 400);
        }
    }

     public Erro desativar(int id){
        Funcionario p = new Funcionario();
        if(p.desativar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Ero ao desativar funcionário", true, 400);
        }
    }
}
