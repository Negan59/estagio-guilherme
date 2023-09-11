package com.sgpd.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgpd.control.AgendaController;
import com.sgpd.control.AtividadeController;
import com.sgpd.control.FuncionarioController;
import com.sgpd.control.ParoquianoController;
import com.sgpd.control.PastoralController;
import com.sgpd.model.Erro;
import com.sgpd.model.Funcionario;
import com.sgpd.model.Local;
import com.sgpd.model.Paroquiano;
import com.sgpd.model.Pastoral;
import com.sgpd.model.Sala;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Rotas {

    // Paroquiano
    @PostMapping("/paroquiano")
    public ResponseEntity<Erro> inserirParoquiano(@RequestBody Paroquiano u) {
        return new ResponseEntity<>(new ParoquianoController().salvar(u), HttpStatus.OK);
    }

    @PutMapping("/paroquiano")
    public ResponseEntity<Erro> alterarParoquiano(@RequestBody Paroquiano u) {
        return new ResponseEntity<>(new ParoquianoController().alterar(u), HttpStatus.OK);
    }

    @DeleteMapping("/paroquiano/{id}")
    public ResponseEntity<Erro> apagarParoquiano(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ParoquianoController().apagar(id), HttpStatus.OK);
    }

    @GetMapping("/paroquiano/{id}")
    public ResponseEntity<Paroquiano> buscarUmParoquiano(@PathVariable(value = "id") int id) {
        return new ResponseEntity<Paroquiano>(new ParoquianoController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/paroquiano")
    public ResponseEntity<Object> buscarTodosParoquiano() {
        return new ResponseEntity<>(new ParoquianoController().buscarTodos(), HttpStatus.OK);
    }

    // sala
    @PostMapping("/sala")
    public ResponseEntity<Erro> inserirSala(@RequestBody Sala u) {
        return new ResponseEntity<>(new AgendaController().salvarSala(u), HttpStatus.OK);
    }

    @PutMapping("/sala")
    public ResponseEntity<Erro> alterarSala(@RequestBody Sala u) {
        return new ResponseEntity<>(new AgendaController().alterarSala(u), HttpStatus.OK);
    }

    @DeleteMapping("/sala/{id}")
    public ResponseEntity<Erro> apagarSala(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AgendaController().apagarSala(id), HttpStatus.OK);
    }

    @GetMapping("/sala/{id}")
    public ResponseEntity<Sala> buscarUmSala(@PathVariable(value = "id") int id) {
        return new ResponseEntity<Sala>(new AgendaController().buscarUmSala(id), HttpStatus.OK);
    }

    @GetMapping("/sala")
    public ResponseEntity<Object> buscarTodosSala() {
        return new ResponseEntity<>(new AgendaController().buscarTodosSala(), HttpStatus.OK);
    }

    // pastoral
    @PostMapping("/pastoral")
    public ResponseEntity<Erro> inserirPastoral(@RequestBody Pastoral u) {
        return new ResponseEntity<>(new PastoralController().salvar(u), HttpStatus.OK);
    }

    @PutMapping("/pastoral")
    public ResponseEntity<Erro> alterarPastoral(@RequestBody Pastoral u) {
        return new ResponseEntity<>(new PastoralController().alterar(u), HttpStatus.OK);
    }

    @DeleteMapping("/pastoral/ativos/{id}")
    public ResponseEntity<Erro> desativarPastoral(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new PastoralController().desativar(id), HttpStatus.OK);
    }

    @DeleteMapping("/pastoral/inativos/{id}")
    public ResponseEntity<Erro> ativarPastoral(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new PastoralController().ativar(id), HttpStatus.OK);
    }

    @GetMapping("/pastoral/{id}")
    public ResponseEntity<Pastoral> buscarUmPastoral(@PathVariable(value = "id") int id) {
        return new ResponseEntity<Pastoral>(new PastoralController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/pastoral/ativos")
    public ResponseEntity<Object> buscarTodosPastoralAtivos() {
        return new ResponseEntity<>(new PastoralController().buscarAtivas(), HttpStatus.OK);
    }

    @GetMapping("/pastoral/inativos")
    public ResponseEntity<Object> buscarTodosPastoralInativos() {
        return new ResponseEntity<>(new PastoralController().buscarInativas(), HttpStatus.OK);
    }

    // local
    @PostMapping("/local")
    public ResponseEntity<Erro> inserirLocal(@RequestBody Local local) {
        return new ResponseEntity<>(new AtividadeController().salvarLocal(local), HttpStatus.OK);
    }

    @PutMapping("/local")
    public ResponseEntity<Erro> alterarLocal(@RequestBody Local local) {
        return new ResponseEntity<>(new AtividadeController().alterarLocal(local), HttpStatus.OK);
    }

    @GetMapping("/local/{id}")
    public ResponseEntity<Local> buscarUmLocal(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AtividadeController().buscarUmLocal(id), HttpStatus.OK);
    }

    @GetMapping("/local")
    public ResponseEntity<Object> buscarTodosLocal() {
        return new ResponseEntity<>(new AtividadeController().buscarTodosLocal(), HttpStatus.OK);
    }

    @DeleteMapping("/local/{id}")
    public ResponseEntity<Erro> apagarLocal(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AtividadeController().apagarLocal(id), HttpStatus.OK);
    }

    //funcionarios
    @PostMapping("/funcionario")
    public ResponseEntity<Erro> inserirFuncionario(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(new FuncionarioController().salvar(funcionario), HttpStatus.OK);
    }

    @PutMapping("/funcionario")
    public ResponseEntity<Erro> alterarFuncionario(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(new FuncionarioController().alterar(funcionario), HttpStatus.OK);
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> buscarUmFuncionario(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new FuncionarioController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/funcionario/ativos")
    public ResponseEntity<Object> buscarTodosFuncionarioAtivo() {
        return new ResponseEntity<>(new FuncionarioController().buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/funcionario/inativos")
    public ResponseEntity<Object> buscarTodosFuncionarioInativo() {
        return new ResponseEntity<>(new FuncionarioController().buscarTodosInativos(), HttpStatus.OK);
    }

    @PutMapping("/funcionario/ativos/{id}")
    public ResponseEntity<Erro> ativarFuncionario(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new FuncionarioController().desativar(id), HttpStatus.OK);
    }

    @PutMapping("/funcionario/inativos/{id}")
    public ResponseEntity<Erro> desativarFuncionario(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new FuncionarioController().ativar(id), HttpStatus.OK);
    }
}
