package com.linuxtips.descomplicandojavaespring.estudante_api.services;

import com.linuxtips.descomplicandojavaespring.estudante_api.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudante_api.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EstudanteServices {
    //@Service: Indica que esta classe é um componente de serviço, gerenciado pelo Spring,
    // responsável pela lógica de negócio.
    //A classe EstudanteServices encapsula operações sobre a entidade Estudante.
    //metodos responsaveis pela camada logica da aplicação

    @Autowired //injetar a classe dentro de outra classe
    private EstudanteRepository estudanteRepository;//injetando a classe repository

    //metodos CRUD

    public Estudante criarEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> ListarEstudante() {
        return estudanteRepository.findAll();
    }

    public ResponseEntity<Estudante> buscaEstudantePeloId(Long id) {
        return estudanteRepository.findById(id)
                .map(estudante -> ResponseEntity.ok().body(estudante))
                .orElse(ResponseEntity.notFound().build());

    }

    //    public ResponseEntity<Estudante> atualizarEstudantePeloID(Estudante estudante, long id) {
//        return estudanteRepository.findById(id)
//                .map(estudanteToUpdate -> {
//                    estudanteToUpdate.setCurso(estudante.getCurso());
//                    estudanteToUpdate.setEndereco(estudante.getEndereco());
//                    estudanteToUpdate.setNome(estudante.getNome());
//                    estudanteToUpdate.setMeioPagamento(estudante.getMeioPagamento());
//                    Estudante updated = estudanteRepository.save(estudanteToUpdate);
//                    return ResponseEntity.ok().body(updated);
//                }).orElse(ResponseEntity.notFound().build());
    // }
    public ResponseEntity<Estudante> atualizarEstudantePeloID(Estudante estudante, long id) {
        return estudanteRepository.findById(id) // Busca estudante pelo ID
                .map(estudanteToUpdate -> { // Se encontrado, executa o bloco de código abaixo
                    // Atualiza os dados do estudante
                    estudanteToUpdate.setCurso(estudante.getCurso());
                    estudanteToUpdate.setEndereco(estudante.getEndereco());
                    estudanteToUpdate.setNome(estudante.getNome());
                    estudanteToUpdate.setMeioPagamento(estudante.getMeioPagamento());

                    // Salva a atualização no banco de dados
                    Estudante updated = estudanteRepository.save(estudanteToUpdate);

                    // Retorna resposta HTTP 200 (OK) com o estudante atualizado
                    return ResponseEntity.ok().body(updated);
                })
                // Se estudante não for encontrado, retorna HTTP 404 (Not Found)
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Object> excluirEstudantePeloId(Long id) {
        return estudanteRepository.findById(id)
                .map(estudanteTodelete -> {
                    estudanteRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<Estudante> buscaEstudantePeloNome(String nome) {
        return estudanteRepository.findByName(nome).map(estudante -> ResponseEntity.ok().body(estudante))
                .orElse(ResponseEntity.notFound().build());

    }

    public List<Estudante> ListarEstudantePeloCurso(String curso) {

        return estudanteRepository.findByCurso(curso);
    }

    public List<Estudante> ListaEstudantePeloEndereco(String endereco) {

        return estudanteRepository.ListaEstudantePeloEndereco(endereco);
    }

    public List<Estudante> ListaEstudantePeloMeioPagamento(Long meioPagamento) {

        return estudanteRepository.ListaEstudantePeloMeioPagamento(meioPagamento);
    }

    public List<Estudante> listarEstudantePeloComecoDoNome(String comecoNome) {
        return estudanteRepository.findByNomeStartingWith(comecoNome);
    }

    public List<Estudante> listarEstudantePeloComecoDoNomeECurso(String comecoNome, String curso) {
        return estudanteRepository.findByNomeStartingWithAndCurso(comecoNome, curso);

    }

    public List<Estudante> listarEstudantePeloEndereco(String endereco) {
        return estudanteRepository.findByEnderecoStartingWithOrderByEnderecoDesc(endereco);
    }

    public List<Estudante> listarPrimeirosEstudantes(Long id) {
        return estudanteRepository.findByIdLessThanEqual(id);
    }
}
