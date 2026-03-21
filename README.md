# Comunicação Síncrona entre Microsserviços Spring Boot

Atividade da matéria PTBDAMS (Desenvolvimento de APIs e Microsserviços).

## 1. Funcionamento Integrado:

Para rodar o projeto é necessário executar:

```bash
    git clone http://github.com/Veketi/comunicacao-microsservicos.git
    cd ./comunicacao-microsservicos 
    docker compose up --build
```

![Vídeo rodando o projeto.](./images/rodando_projeto.webp)

Após rodar será possível acessar dois endpoints:

- [http://localhost:8081/api/v1/movie/{id}](http://localhost:8081/api/v1/movie/1)

![Endpoit /api/v1/movie/{id}](./images/endpoint_movie.png)

- [http://localhost:8082/api/v1/ratings](http://localhost:8081/api/v1/ratings)

![Endpoit /api/v1/details](./images/endpoint_details.png)

## 2. Simulação de falha de comunicação entre serviços:

Para simular uma falha de comunicação execute o seguinte:

```bash
    cd ./ratings
    docker build -t ratings .
    docker run -p 8082:8082 ratings
```

![Vídeo da simulação de falha de comunicação](./images/simulacao_falha_comunicacao.webp)

Quando tentar acessar o endpoint [http://localhost:8082/api/v1/ratings](http://localhost:8081/api/v1/ratings) você terá essa resposta:

![Resposta da falha de comunicação](./images/falha_comunicacao.png)

## 3. Simulação de timout na comunicação entre serviços:

Para simular um timeout na comunicação entre serviços execute o seguinte:

### 3.1. Alterar o serviço movies:

-  Acesse a pasta do serviço movies e abra no seu editor de texto ou IDE favorita:

```bash
    # Se estiver na pasta raiz:
    ./movies
    
    #Se estiver na pasta do serviço ratings:
    ../movies

    # VS Code
    code .

    # Vim 
    vim .

    # NeoVim
    nvim .
    
    # Emacs
    emacs
```

- Na pasta `/src/main/java/edu/ifsp/movies/controller/` altere o arquivo `MovieController.java`:

```java
    // Adicione "throws InterruptedException" na assinatura do método:
    public Movie index(@PathVariable Integer id) throws InterruptedException 


    // Adione a linha abaixo antes do retorno do método:
        Thread.sleep(5000);
```

![Vídeo demotrando alterações](./imagens/alterando_movies.webp)

Quando executar uma requisição no endpoint [http://localhost:8082/api/v1/ratings](http://localhost:8081/api/v1/ratings) isso irá ocorrer:

![Imagem do timeout](./images/timeout.png)
