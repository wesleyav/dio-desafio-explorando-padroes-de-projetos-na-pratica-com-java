package com.github.wesleyav.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.wesleyav.gof.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
