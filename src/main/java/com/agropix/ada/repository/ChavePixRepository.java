package com.agropix.ada.repository;

import com.agropix.ada.model.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, UUID> {
    Optional<ChavePix> getChavePixByChavePix(String chavePix);
}
