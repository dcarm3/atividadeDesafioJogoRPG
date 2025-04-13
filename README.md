## Atividade Desafio profissional
Sistema de jogo de rpg feito em spring

obs: a classe e o tipo do item precisam estar em maiusculo pra funcionar
## Endpoints criados

### 1. Cadastrar Personagem
- **Método:** `POST`
- **URL:** `/personagens`
- **Descrição:** cria um personagem novo
- **Body Exemplo (JSON):**
```json
{
  "nome": "daniel",
  "nomeAventureiro": "daniel herói",
  "classe": "GUERREIRO",
  "level": 1,
  "forcaBase": 5,
  "defesaBase": 5
}
```

---

### 2. Cadastrar Item Mágico
- **Método:** `POST`
- **URL:** `/itens`
- **Descrição:** cria um novo item magico
- **Body Exemplo (JSON):**
```json
{
  "nome": "Exxxcalibuurrr",
  "tipo": "ARMA",
  "forca": 5,
  "defesa": 0
}
```

---

### 3. Listar Todos os Personagens
- **Método:** `GET`
- **URL:** `/personagens`
- **Descrição:** retorna lista de personagens cadastrados

---

### 4. Buscar Personagem por Identificador
- **Método:** `GET`
- **URL:** `/personagens/{id}`
- **Descrição:** retorna dados do personagem do ID informado

---

### 5. Atualizar Nome Aventureiro por Identificador
- **Método:** `PATCH`
- **URL:** `/personagens/{id}/nome-aventureiro`
- **Descrição:** atualiza apenas o NOME AVENTUREIRO de algum personagem
- **Body Exemplo (JSON):**
```json
{
  "nomeAventureiro": "Daniel grandão"
}
```

---

### 6. Remover Personagem
- **Método:** `DELETE`
- **URL:** `/personagens/{id}`
- **Descrição:** remove um personagem e também seus itens

---

### 7. Listar Todos os Itens Mágicos
- **Método:** `GET`
- **URL:** `/itens`
- **Descrição:** retorna lista de itens cadastrados

---

### 8. Buscar Item Mágico por Identificador
- **Método:** `GET`
- **URL:** `/itens/{id}`
- **Descrição:** retorna dados do item pelo ID

---

### 9. Adicionar Item Mágico a um Personagem
- **Método:** `POST`
- **URL:** `/personagens/{personagemId}/itens/{itemId}`
- **Descrição:** associa um item a um personagem

---

### 10. Listar Itens Mágicos de um Personagem
- **Método:** `GET`
- **URL:** `/personagens/{personagemId}/itens`
- **Descrição:** lista todos os itens de um char ja criado pelo seu ID
---

### 11. Remover Item Mágico do Personagem
- **Método:** `DELETE`
- **URL:** `/personagens/{personagemId}/itens/{itemId}`
- **Descrição:** remove um item de algum personagem, mas o item ainda existe no sistema

---

### 12. Buscar Amuleto do Personagem
- **Método:** `GET`
- **URL:** `/personagens/{personagemId}/amuleto`
- **Descrição:** retorna o amuleto do personagem, caso ele tenha
