package com.jogorpg.atividadeDesafioJogoRPG.service;

import com.jogorpg.atividadeDesafioJogoRPG.entity.ItemMagico;
import com.jogorpg.atividadeDesafioJogoRPG.entity.Personagem;
import com.jogorpg.atividadeDesafioJogoRPG.entity.TipoDoItem;
import com.jogorpg.atividadeDesafioJogoRPG.repository.ItemMagicoRepository;
import com.jogorpg.atividadeDesafioJogoRPG.repository.PersonagemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    public ItemMagico adicionarItemAoPersonagem(Long personagemId, ItemMagico item) {
        if (item.getForca() == 0 && item.getDefesa() == 0) {
            throw new RuntimeException("Item deve ter pelo menos um atributo diferente de zero.");
        }
        if (item.getTipo() == TipoDoItem.ARMA && item.getDefesa() != 0) {
            throw new RuntimeException("Item do tipo ARMA deve ter defesa igual a zero.");
        }
        if (item.getTipo() == TipoDoItem.ARMADURA && item.getForca() != 0) {
            throw new RuntimeException("Item do tipo ARMADURA deve ter força igual a zero.");
        }
        if (item.getTipo() == TipoDoItem.AMULETO) {
            if (item.getForca() > 10 || item.getDefesa() > 10) {
                throw new RuntimeException("Atributos do Amuleto não podem ser maiores que 10.");
            }
        }

        Optional<Personagem> op = personagemRepository.findById(personagemId);
        if (!op.isPresent()) {
            throw new RuntimeException("Personagem não encontrado com ID: " + personagemId);
        }
        Personagem personagem = op.get();

        if (item.getTipo() == TipoDoItem.AMULETO) {
            Optional<ItemMagico> amuletoExistente = itemMagicoRepository.findByPersonagemIdAndTipo(personagemId, TipoDoItem.AMULETO);
            if (amuletoExistente.isPresent()) {
                throw new RuntimeException("Personagem já possui um Amuleto.");
            }
        }

        item.setPersonagem(personagem);
        personagem.getItensMagicos().add(item);
        personagemRepository.save(personagem);
        return itemMagicoRepository.save(item);
    }

    public List<ItemMagico> listarTodos() {
        return itemMagicoRepository.findAll();
    }

    public ItemMagico buscarPorId(Long id) {
        Optional<ItemMagico> item = itemMagicoRepository.findById(id);
        if (!item.isPresent()){
            throw new RuntimeException("Item Mágico não encontrado com ID: " + id);
        }
        return item.get();
    }

    public List<ItemMagico> listarPorPersonagem(Long personagemId) {
        return itemMagicoRepository.findByPersonagemId(personagemId);
    }

    public void remover(Long id) {
        ItemMagico item = buscarPorId(id);
        if (item.getPersonagem() != null) {
            Personagem p = item.getPersonagem();
            p.getItensMagicos().remove(item);
            personagemRepository.save(p);
        }
        itemMagicoRepository.delete(item);
    }

    public ItemMagico buscarAmuleto(Long personagemId) {
        Optional<ItemMagico> amuleto = itemMagicoRepository.findByPersonagemIdAndTipo(personagemId, TipoDoItem.AMULETO);
        if (!amuleto.isPresent()){
            throw new RuntimeException("Amuleto não encontrado para o Personagem com ID: " + personagemId);
        }
        return amuleto.get();
    }
}
