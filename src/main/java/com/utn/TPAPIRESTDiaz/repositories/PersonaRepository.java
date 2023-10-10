package com.utn.TPAPIRESTDiaz.repositories;

import com.utn.TPAPIRESTDiaz.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
//Anotacion metodo de query

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsByDni(int dni);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    List<Persona> search(@Param("filtro") String filtro);
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

   /* //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    List<Persona> search1(@Param("filtro") String filtro);
*/

    //Anotacion Query nativa
    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
        nativeQuery = true)
    List<Persona> search2(@Param("filtro") String filtro);
    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM persona"
            ,nativeQuery = true)
    Page<Persona> search2(@Param("filtro") String filtro, Pageable pageable);
}
