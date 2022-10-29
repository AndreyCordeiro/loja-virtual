package com.webstore.repository;

import com.webstore.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
