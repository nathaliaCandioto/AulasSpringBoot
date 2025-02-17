package com.linuxtips.descomplicandojavaespring.estudante_api.repository;

import com.linuxtips.descomplicandojavaespring.estudante_api.model.EstudanteApiApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import com.linuxtips.descomplicandojavaespring.estudante_api.model.Estudante;
import org.springframework.stereotype.Repository;

@Repository  //marca uma classe como componente de acesso dados,
            // habilitando a tradução de exceções de persistência


//Interface que estende JpaRepository para fornecer operações CRUD para a
// entidade Estudante com chave primária do tipo Long.HERDADNDO OS METODOS DO JPAREPOSITORY
public interface EstudanteRepository extends JpaRepository<Estudante,Long> {

}
