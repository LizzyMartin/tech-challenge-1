# alura-fiap tech-challenge 2

Esse é o repositório contendo o código e documentação do tech-challenge 2 da pós tech de Arquitetura e Desenvolvimento Java. As principais dificuldades encontradas foram referentes ao uso do banco de dados, foram encontrados problemas para fazer as relações ManyToMany, OneToMany etc. A busca também foi um desafio, sendo que foi implementada de forma simples.

## Tecnologias utilizadas
- Spring Boot 3
- Gradle
- Java 17
- MapStruct
- Spring Validation
- Lombok
- h2
- Spring Data JPA

## Rotas

> Todas as rotas retornam um BadRequest caso algum parametro esteja invalido. É possivel acessar a documentação da API via swagger em http://localhost:8080/swagger-ui/index.html

### Endereço

GET `/api/address/{id}` : recebe um id como parâmetro no path e retorna o endereço do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/address/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```json
{
  "id": "cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320",
  "rua": "Rua das Pitangueiras",
  "numero": "123",
  "bairro": "Bairro do Limão",
  "cidade": "Cidade Bonita",
  "estado": "Estado Lindo"
}
```

---

GET `/api/address` : retorna uma lista de todos os ids cadastrados. Exemplo:

request:
> http://localhost:8080/api/address

response:
```json
[
  {
    "id": "cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320",
    "rua": "Rua das Pitangueiras",
    "numero": "123",
    "bairro": "Bairro do Limão",
    "cidade": "Cidade Bonita",
    "estado": "Estado Lindo"
  }
]
```

---

POST `/api/address` : cadastra um novo endereço. Exemplo:

request:
> http://localhost:8080/api/address

request body:
```json
{
    "rua": "Rua das Pitangueiras",
    "numero": "123",
    "bairro": "Bairro do Limão",
    "cidade": "Cidade Bonita",
    "estado": "Estado Lindo"
}
```

response:
```txt
Endereco cadastrado!
```

---

PUT `/api/address/{id}` : recebe um id como parâmetro no path e atualiza o endereço do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/address/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```txt
Endereço atualizado com sucesso!
```

---

DELETE `/api/address/{id}` : recebe um id como parâmetro no path e deleta o endereço do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/address/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```txt
Endereço excluido com sucesso!
```

---

POST `/api/address/search` : recebe um parametro do endereco e busca por ele. Exemplo:

request body:
```json
{
    "estado": "Estado Lindo"
}
```

response:
```json
[
  {
    "id": 1,
    "rua": "Rua das Pitangueiras",
    "numero": "123",
    "bairro": "Bairro do Limão",
    "cidade": "Cidade Bonita",
    "estado": "Estado Lindo"
  }
]
```

### Pessoas

GET `/api/people/{id}` : recebe um id como parâmetro no path e retorna a pessoa do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/people/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```json
{
  "id": "cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320",
  "nome": "Mariazinha",
  "dataNascimento": "2023-07-05",
  "sexo": "FEMININO",
  "parentesco": "filha"
}
```

---

GET `/api/people` : retorna uma lista de todos os ids de pessoas cadastrados. Exemplo:

request:
> http://localhost:8080/api/people

response:
```json
[
  {
    "id": "cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320",
    "nome": "Mariazinha",
    "dataNascimento": "2023-07-05",
    "sexo": "FEMININO",
    "parentesco": "filha"
  }
]
```

---

POST `/api/address` : cadastra uma nova pessoa. Exemplo:

request:
> http://localhost:8080/api/people

request body:
```json
{
  "nome": "Mariazinha",
  "dataNascimento": "2023-07-05",
  "sexo": "FEMININO",
  "parentesco": "filha"
}
```

response:
```txt
Pessoa cadastrada!
```

---

PUT `/api/people/{id}` : recebe um id como parâmetro no path e atualiza a pessoa do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/people/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```txt
Pessoa atualizada com sucesso!
```

---

DELETE `/api/people/{id}` : recebe um id como parâmetro no path e deleta a pessoa do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/people/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```txt
Pessoa excluida com sucesso!
```

---

POST `/api/people/search` : recebe um parametro da pessoa e busca por ele. Exemplo:

request body:
```json
{
  "nome": "paulo"
}
```

response:
```json
[
  {
    "nome": "paulo",
    "dataNascimento": "2023-09-02",
    "sexo": "MASCULINO",
    "parentesco": [],
    "enderecos": [],
    "eletrodomesticos": []
  }
]
```

---

POST `/api/people/{pessoaId}/endereco/{enderecoId}` : associa uma pessoa a um endereco. Se não existir algum id a associação não é feita. Exemplo:

request:
> http://localhost:8080/api/people/1/endereco/1

---

POST `/api/people/{pessoaId}/eletrodomestico/{eletrodomesticoId}` : associa uma pessoa a um eletrodomestico. Se não existir algum id a associação não é feita. Exemplo:

request:
> http://localhost:8080/api/people/1/eletrodomestico/1

---

POST `/api/people/{pessoaId}/relative/{parenteId}` : associa uma pessoa a um parente. Se não existir algum id a associação não é feita. Exemplo:

request:
> http://localhost:8080/api/people/1/relative/2?tipoParentesco=PAI


### Eletrodomesticos

GET `/api/homeappliance/{id}` : recebe um id como parâmetro no path e retorna o eletrodomestico do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/homeappliance/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```json
{
  "id": "cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320",
  "nome": "celular",
  "modelo": "xiaomi",
  "potencia": "+8000"
}
```

---

GET `/api/homeappliance` : retorna uma lista de todos os ids de eletrodomesticos cadastrados. Exemplo:

request:
> http://localhost:8080/api/homeappliance

response:
```json
[
  {
    "id": "cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320",
    "nome": "celular",
    "modelo": "xiaomi",
    "potencia": "+8000"
  }
]
```

---

POST `/api/homeappliance` : cadastra um novo eletrodomestico. Exemplo:

request:
> http://localhost:8080/api/homeappliance

request body:
```json
{
  "nome": "celular",
  "modelo": "xiaomi",
  "potencia": "+8000"
}
```

response:
```txt
Eletrodomestico cadastrado!
```

---

PUT `/api/homeappliance/{id}` : recebe um id como parâmetro no path e atualiza a pessoa do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/homeappliance/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```txt
Eletrodomestico atualizado com sucesso!
```

---

DELETE `/api/homeappliance/{id}` : recebe um id como parâmetro no path e deleta a pessoa do id solicitado caso encontre. Exemplo:

request:
> http://localhost:8080/api/homeappliance/cb76c411-e29e-4d2c-a8c1-9ec6b8a8a320

response:
```txt
Eletrodomestico excluido com sucesso!
```

---

POST `/api/homeappliance/search` : recebe um parametro do eletrodomestico e busca por ele. Exemplo:

request body:
```json
{
  "nome": "aspirador"
}
```

response:
```json
[
  {
    "id": 1,
    "nome": "aspirador",
    "modelo": "mondial",
    "potencia": "100W",
    "consumo": 41191
  }
]
```
