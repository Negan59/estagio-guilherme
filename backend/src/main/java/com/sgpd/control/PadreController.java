package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Padre;

public class PadreController {
    public Erro salvar(Padre padre){
        if(!padre.getEmail().isEmpty()){
            if(!padre.getNome().isEmpty()){
                if(!padre.getParoquia().isEmpty()){
                    if(!padre.salvar()){
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

    public Erro alterar(Padre padre){
        if(!padre.getEmail().isEmpty()){
            if(!padre.getNome().isEmpty()){
                if(!padre.getParoquia().isEmpty()){
                    if(!padre.alterar()){
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

    public ArrayList<Padre> buscarTodos(){
        return new Padre().buscarTodos();
    }

    public ArrayList<Padre> buscarTodosInativos(){
        return new Padre().buscarTodosInativos();
    }

    public Padre buscarUm(int id){
        return new Padre().buscarUm(id);
    }

    public Erro ativar(int id){
        Padre p = new Padre();
        if(p.ativar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Ero ao ativar padre", true, 400);
        }
    }

     public Erro desativar(int id){
        Padre p = new Padre();
        if(p.desativar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Ero ao desativar funcionário", true, 400);
        }
    }
}
