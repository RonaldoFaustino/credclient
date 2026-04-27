package com.devsuperior.crudcliente.repositories;

import com.devsuperior.crudcliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
