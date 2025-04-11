package com.jogorpg.atividadeDesafioJogoRPG.repository;

import com.jogorpg.atividadeDesafioJogoRPG.entity.ItemMagico;
import com.jogorpg.atividadeDesafioJogoRPG.entity.TipoDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
    List<ItemMagico> findByPersonagemId(Long personagemId);
    Optional<ItemMagico> findByPersonagemIdAndTipo(Long personagemId, TipoDoItem tipo);

}

