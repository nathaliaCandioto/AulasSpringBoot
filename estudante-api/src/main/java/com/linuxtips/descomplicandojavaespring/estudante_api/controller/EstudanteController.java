package com.linuxtips.descomplicandojavaespring.estudante_api.controller;

import com.linuxtips.descomplicandojavaespring.estudante_api.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudante_api.services.EstudanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/v1")
public class EstudanteController {

    @Autowired
    private EstudanteServices estudanteServices;

    //criando os endpoints:
    @PostMapping("/estudantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante criarEstudante(@RequestBody Estudante estudante) {
        return estudanteServices.criarEstudante(estudante);
    }

    @GetMapping("/estudantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudante() {
        return estudanteServices.ListarEstudante();

    }

    @GetMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> BuscaEstudantePeloID(@PathVariable(value = "id") Long id) {
        return estudanteServices.buscaEstudantePeloId(id);
    }

    @PutMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> atualizarEstudantePeloID(@PathVariable(value = "id") Long id,
                                                              @RequestBody Estudante estudante) {
        return estudanteServices.atualizarEstudantePeloID(estudante, id);
    }

    @DeleteMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluirEstudantePeloId(@PathVariable(value = "id") Long id) {
        return estudanteServices.excluirEstudantePeloId(id);

    }

    @GetMapping("/estudantes/buscanome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> BuscaEstudantePeloNome(@PathVariable(value = "nome") String nome) {
        return estudanteServices.buscaEstudantePeloNome(nome);

    }

    @GetMapping("/estudantes/curso")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> ListaEstudantePeloCurso(@RequestParam String nome_curso) {
        return estudanteServices.ListarEstudantePeloCurso(nome_curso);
    }

    @GetMapping("/estudantes/endereco")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> ListaEstudantePeloEndereco(@RequestParam String endereco) {
        return estudanteServices.ListaEstudantePeloEndereco(endereco);
    }

//    @GetMapping("/estudantes/meiopagamento")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Estudante> ListaEstudantePeloMeioPagamento(@RequestParam Long meioPagamento) {
//        return estudanteServices.ListaEstudantePeloMeioPagamento(meioPagamento);
//    }

    @GetMapping("/estudantes/nome")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantePeloComecoNome(@RequestParam String comeco_nome) {
        return estudanteServices.listarEstudantePeloComecoDoNome(comeco_nome);
    }

    @GetMapping("/estudantes/nomeecurso")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantePeloComecoNomeECurso(@RequestParam String comeco_nome, String curso) {
        return estudanteServices.listarEstudantePeloComecoDoNomeECurso(comeco_nome, curso);
    }

    @GetMapping("/estudantes/listarendereco")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantePeloEndereco(@RequestParam String endereco) {
        return estudanteServices.listarEstudantePeloEndereco(endereco);
    }

    @GetMapping("/estudantes/promo")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarPrimeirosEstudante(@RequestParam Long id) {
        return estudanteServices.listarPrimeirosEstudantes(id);
    }
}