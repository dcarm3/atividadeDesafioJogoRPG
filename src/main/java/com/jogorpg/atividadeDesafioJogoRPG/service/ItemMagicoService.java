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
            throw new RuntimeException("o itemm deve ter pelo menos um atributo diferente de zero 👌");
        }
        if (item.getTipo() == TipoDoItem.ARMA && item.getDefesa() != 0) {
            throw new RuntimeException("arma deve ter defesa 0 🫡");
        }
        if (item.getTipo() == TipoDoItem.ARMADURA && item.getForca() != 0) {
            throw new RuntimeException("armadura deve ter força 0 🫡");
        }
        if (item.getTipo() == TipoDoItem.AMULETO) {
            if (item.getForca() > 10 || item.getDefesa() > 10) {
                throw new RuntimeException("Amuleto não pode ter atributo maior q 10");
            }
        }

        Optional<Personagem> op = personagemRepository.findById(personagemId);
        if (!op.isPresent()) {
            throw new RuntimeException("Personagem " + personagemId + "não foi encontrado :(");
        }
        Personagem personagem = op.get();

        if (item.getTipo() == TipoDoItem.AMULETO) {
            Optional<ItemMagico> amuletoExistente = itemMagicoRepository.findByPersonagemIdAndTipo(personagemId, TipoDoItem.AMULETO);
            if (amuletoExistente.isPresent()) {
                throw new RuntimeException("Esse personagem ja tem um amuleto");
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
            throw new RuntimeException("Item Mágico " + id + " não foi encontrado");
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
            throw new RuntimeException("Amuleto não foi encontradfo para o personagem " + personagemId);
        }
        return amuleto.get();
    }
}
