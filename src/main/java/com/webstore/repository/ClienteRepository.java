package com.webstore.repository;

import com.webstore.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Pessoa, Long> {
}
