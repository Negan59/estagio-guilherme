package com.sgpd.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgpd.control.AgendaController;
import com.sgpd.control.AluguelController;
import com.sgpd.control.AtividadeController;
import com.sgpd.control.FuncionarioController;
import com.sgpd.control.ItensSalaoParoquialController;
import com.sgpd.control.PadreController;
import com.sgpd.control.ParoquianoController;
import com.sgpd.control.PastoralController;
import com.sgpd.control.TipoAtividadeController;
import com.sgpd.model.Aluguel;
import com.sgpd.model.Erro;
import com.sgpd.model.Funcionario;
import com.sgpd.model.ItensSalaoParoquial;
import com.sgpd.model.Local;
import com.sgpd.model.Padre;
import com.sgpd.model.Paroquiano;
import com.sgpd.model.Pastoral;
import com.sgpd.model.Sala;
import com.sgpd.model.TipoAtividade;

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

    //padre
    @PostMapping("/padre")
    public ResponseEntity<Erro> inserirPadre(@RequestBody Padre padre) {
        return new ResponseEntity<>(new PadreController().salvar(padre), HttpStatus.OK);
    }

    @PutMapping("/padre")
    public ResponseEntity<Erro> alterarPadre(@RequestBody Padre padre) {
        return new ResponseEntity<>(new PadreController().alterar(padre), HttpStatus.OK);
    }

    @GetMapping("/padre/{id}")
    public ResponseEntity<Padre> buscarUmPadre(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new PadreController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/padre/ativos")
    public ResponseEntity<Object> buscarTodosPadreAtivo() {
        return new ResponseEntity<>(new PadreController().buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/padre/inativos")
    public ResponseEntity<Object> buscarTodosPadreInativo() {
        return new ResponseEntity<>(new PadreController().buscarTodosInativos(), HttpStatus.OK);
    }

    @PutMapping("/padre/ativos/{id}")
    public ResponseEntity<Erro> ativarPadre(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new PadreController().desativar(id), HttpStatus.OK);
    }

    @PutMapping("/padre/inativos/{id}")
    public ResponseEntity<Erro> desativarPadre(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new PadreController().ativar(id), HttpStatus.OK);
    }

    //tipoatividade
    @PostMapping("/tipoatividade")
    public ResponseEntity<Erro> inserirTipoAtividade(@RequestBody TipoAtividade tipoatividade) {
        return new ResponseEntity<>(new TipoAtividadeController().salvar(tipoatividade), HttpStatus.OK);
    }

    @PutMapping("/tipoatividade")
    public ResponseEntity<Erro> alterarTipoAtividade(@RequestBody TipoAtividade tipoatividade) {
        return new ResponseEntity<>(new TipoAtividadeController().alterar(tipoatividade), HttpStatus.OK);
    }

    @GetMapping("/tipoatividade/{id}")
    public ResponseEntity<TipoAtividade> buscarUmTipoAtividade(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new TipoAtividadeController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/tipoatividade/ativos")
    public ResponseEntity<Object> buscarTodosTipoAtividadeAtivo() {
        return new ResponseEntity<>(new TipoAtividadeController().buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/tipoatividade/inativos")
    public ResponseEntity<Object> buscarTodosTipoAtividadeInativo() {
        return new ResponseEntity<>(new TipoAtividadeController().buscarTodosInativos(), HttpStatus.OK);
    }

    @PutMapping("/tipoatividade/ativos/{id}")
    public ResponseEntity<Erro> ativarTipoAtividade(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new TipoAtividadeController().desativar(id), HttpStatus.OK);
    }

    @PutMapping("/tipoatividade/inativos/{id}")
    public ResponseEntity<Erro> desativarTipoAtividade(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new TipoAtividadeController().ativar(id), HttpStatus.OK);
    }

    //itemsalao
    @PostMapping("/itemsalao")
    public ResponseEntity<Erro> inserirItensSalaoParoquial(@RequestBody ItensSalaoParoquial itemsalao) {
        return new ResponseEntity<>(new ItensSalaoParoquialController().salvar(itemsalao), HttpStatus.OK);
    }

    @PutMapping("/itemsalao")
    public ResponseEntity<Erro> alterarItensSalaoParoquial(@RequestBody ItensSalaoParoquial itemsalao) {
        return new ResponseEntity<>(new ItensSalaoParoquialController().alterar(itemsalao), HttpStatus.OK);
    }

    @GetMapping("/itemsalao/{id}")
    public ResponseEntity<ItensSalaoParoquial> buscarUmItensSalaoParoquial(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ItensSalaoParoquialController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/itemsalao/ativos")
    public ResponseEntity<Object> buscarTodosItensSalaoParoquialAtivo() {
        return new ResponseEntity<>(new ItensSalaoParoquialController().buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/itemsalao/inativos")
    public ResponseEntity<Object> buscarTodosItensSalaoParoquialInativo() {
        return new ResponseEntity<>(new ItensSalaoParoquialController().buscarTodosInativos(), HttpStatus.OK);
    }

    @PutMapping("/itemsalao/ativos/{id}")
    public ResponseEntity<Erro> ativarItensSalaoParoquial(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ItensSalaoParoquialController().desativar(id), HttpStatus.OK);
    }

    @PutMapping("/itemsalao/inativos/{id}")
    public ResponseEntity<Erro> desativarItensSalaoParoquial(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new ItensSalaoParoquialController().ativar(id), HttpStatus.OK);
    }

    // Aluguel
    @PostMapping("/aluguel")
    public ResponseEntity<Erro> inserirAluguel(@RequestBody Aluguel u) {
        return new ResponseEntity<>(new AluguelController().salvar(u), HttpStatus.OK);
    }

    @PutMapping("/aluguel")
    public ResponseEntity<Erro> alterarAluguel(@RequestBody Aluguel u) {
        return new ResponseEntity<>(new AluguelController().alterar(u), HttpStatus.OK);
    }

    @DeleteMapping("/aluguel/{id}")
    public ResponseEntity<Erro> apagarAluguel(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new AluguelController().apagar(id), HttpStatus.OK);
    }

    @GetMapping("/aluguel/{id}")
    public ResponseEntity<Aluguel> buscarUmAluguel(@PathVariable(value = "id") int id) {
        return new ResponseEntity<Aluguel>(new AluguelController().buscarUm(id), HttpStatus.OK);
    }

    @GetMapping("/aluguel")
    public ResponseEntity<Object> buscarTodosAluguel() {
        return new ResponseEntity<>(new AluguelController().buscarTodos(), HttpStatus.OK);
    }


}
