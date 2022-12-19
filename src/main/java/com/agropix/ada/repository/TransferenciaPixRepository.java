package com.agropix.ada.repository;

import com.agropix.ada.model.TransferenciaPix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferenciaPixRepository extends JpaRepository<TransferenciaPix, UUID> {

}
