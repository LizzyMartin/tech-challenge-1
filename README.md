# alura-fiap tech-challenge 1

Esse é o repositório contendo o código e documentação do tech-challenge 1 da pós tech de Arquitetura e Desenvolvimento Java. As principais dificuldades encontradas foram referentes ao ambiente, visto que pela primeira vez codei algo no Windows ao invés do Linux.

## Tecnologias utilizadas
- Spring Boot 3
- Gradle
- Java 17
- MapStruct
- Spring Validation
- Lombok

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
