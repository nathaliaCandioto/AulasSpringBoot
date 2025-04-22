package com.linuxtips.descomplicandojavaespring.estudante_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.linuxtips.descomplicandojavaespring.estudante_api.model.Estudante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  //marca uma classe como componente de acesso dados,
            // habilitando a tradução de exceções de persistência


//Interface que estende JpaRepository para fornecer operações CRUD para a
// entidade Estudante com chave primária do tipo Long.HERDADNDO OS METODOS DO JPAREPOSITORY
public interface EstudanteRepository extends JpaRepository<Estudante,Long> {

    //@Query -> escrever consultas personalizadas:

//    List<Estudante> findByMeioPagamento(Long meioPagamento);

    @Query("Select c FROM Estudante c WHERE c.nome = nome")
    //criar um novo metodo que vai retornar um optional de estudante
    Optional<Estudante> findByName(String nome);

    @Query("Select a FROM Estudante a WHERE a.curso = :curso")
        //criar um novo metodo que vai retornar um optional de estudante
    List<Estudante> findByCurso(String curso);

    @Query("Select a FROM Estudante a WHERE a.endereco = :endereco")
        //criar um novo metodo que vai retornar um optional de estudante
    List<Estudante> ListaEstudantePeloEndereco (String endereco);

    @Query("Select a FROM Estudante a WHERE a.meioPagamento = :meioPagamento")
        //criar um novo metodo que vai retornar um optional de estudante
    List<Estudante> ListaEstudantePeloMeioPagamento (Long meioPagamento);


    @Query
    List<Estudante> findByNomeStartingWith(String nome);

    List<Estudante> findByNomeStartingWithAndCurso(String nome, String curso);

    List<Estudante> findByEnderecoStartingWithOrderByEnderecoDesc(String endereco);

    List<Estudante> findByIdLessThanEqual(Long id);

}

