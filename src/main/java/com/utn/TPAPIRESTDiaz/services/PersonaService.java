package com.utn.TPAPIRESTDiaz.services;

import com.utn.TPAPIRESTDiaz.entities.Persona;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PersonaService extends BaseService<Persona,Long>{
 List<Persona> search(String filtro) throws Exception;
}

