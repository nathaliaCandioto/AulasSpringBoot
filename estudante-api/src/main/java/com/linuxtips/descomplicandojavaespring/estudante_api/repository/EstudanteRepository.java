package com.linuxtips.descomplicandojavaespring.estudante_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.linuxtips.descomplicandojavaespring.estudante_api.model.Estudante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,Long> {

    @Query("Select c FROM Estudante c WHERE c.nome = nome")
    Optional<Estudante> findByName(String nome);
    @Query("Select a FROM Estudante a WHERE a.curso = :curso")
    List<Estudante> findByCurso(String curso);
    @Query("Select a FROM Estudante a WHERE a.endereco = :endereco")
    List<Estudante> ListaEstudantePeloEndereco (String endereco);



    @Query
    List<Estudante> findByNomeStartingWith(String nome);
    List<Estudante> findByNomeStartingWithAndCurso(String nome, String curso);
    List<Estudante> findByEnderecoStartingWithOrderByEnderecoDesc(String endereco);
    List<Estudante> findByIdLessThanEqual(Long id);

}

