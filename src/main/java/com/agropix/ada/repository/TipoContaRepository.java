package com.agropix.ada.repository;

import com.agropix.ada.model.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, UUID> {
}
