# legendary-video-library
Disponibiliza endpoints para ser consumido onde retornará um (get) lista de filmes ou um Consumer para retornar a lista de filmes através do Kafka.

# Esse projeto está dividido em 3 branches.
* **mongo &rarr;** Utiliza o banco de dados MongoDB para recuperar a lista de filmes. Não há restrições de acesso pois o GetMapping está aberto para todos. Na prática é a mais simples entre as 3.
* **mongo-token &rarr;** Utiliza o banco de dados MongoDB para recuperar a lista de filmes. Nesse caso, Há restrições de acesso pois o GetMapping está protegido por um token. O token é validado através da anotação **@EscopoNecessario()** com uma lista de escopos que o usuário precisa ter para acessar o endpoint, por exemplo, **{"listar-filmes"}**.
* **mongo-token-kafka &rarr;** Herda as mesmas necessidades da branch **mongo-token** e utiliza o banco de dados MongoDB para recuperar a lista de filmes. Foi criado o consumer **ConsumerMessage** que faz a leitura do topico ***solicita-videos-library***. Até o presente momento não necessiade de chaves para ler e escrever nos topicos do Kafka.

# Pre-requisitos para rodar o projeto
1. **Docker Desktop** deve estar instalado no seu computador.

# Softwares de apoio
1. **Postman &rarr;** Para realizar HTTP Requests
2. **MongoDB Compass &rarr;** Para consultar e alterar dados no MongoDB se necessário.

# Dependência externa (Opcional, branch mongo)
### Esse passo não é obrigatório se estiver utilizando a branch ***mongo***.

Como forma de geração e validação de Tokens, foi utilizado o projeto **security-tokens**. Encontra-se disponível no github e pode ser clonado `git clone https://github.com/evertongodoy/security-tokens.git`.
Executar o comando `mvn clean install` para gerar o jar e adicionar no repositório local.
Esse jar será utilizado para validar o token gerado pelo projeto **security-tokens**.

# Como rodar o projeto
1. Abra um **Terminal** válido para rodar comandos do Docker, por exemplo, **PowerShell** ou **Git Bash**.
2. Clone o projeto para sua máquina. Exemplo: `git clone https://github.com/evertongodoy/legendary-video-library.git`
3. Acesse a branch desejada. Exemplo: `git checkout mongo`
4. Abra o projeto no IntelliJ e faça a configuração do JAVA:
    1. Procure no menu por **Project Structure**
    2. Em Project Settings, selecione **Project**
    3. Em Project SDK, selecione a versão do Java que você deseja utilizar, no caso, Corretto 17.
    4. Se ainda não estiver instalada, clique em **Download** e selecione a versão e o vendor. Diretório não precisa ser alterado.
    5. No terminal do IntelliJ, abra uma guia para deixar com acesso no arquivo docker-compose.yml. Exemplo: `cd compose`
    6. Execute o comando `docker-compose up -d` para subir o Mongo, Kafka, Zookeeper e Kafka-UI.
    7. Nesse momento, serão criados os tópicos **solicita-videos-library** e **retorna-videos-library**.
5. No IntelliJ, abra a janela **Run Anything** tecla Control(2x) e execute o comando `mvn clean install`.
6. Execute a aplicação, botão direito no arquivo **LegendaryVideoLibraryApplication** e selecione **Run**.

# Orientações para uso
1. Esse projeto vai ser consumido pelo projeto **filmes-legendary-video-library**.
2. Possui um Controller **LegendaryVideoController** que disponibiliza um endpoint [GET] `/recuperar/todos` para retornar a lista de filmes.
3. Na branch **mongo**, não há restrições de acesso. Qualquer usuário pode acessar o endpoint.
4. Nas demais branches, há restrições de acesso. O endpoint está protegido por um token. O token é validado através da anotação **@EscopoNecessario()** com uma lista de escopos que o usuário precisa ter para acessar o endpoint, por exemplo, **{"listar-filmes"}**.
5. Outro modo de acesso é através do Kafka. O consumer **ConsumerMessage** faz a leitura do topico ***solicita-videos-library***. Caso o consumo seja por Kafka, esse projeto publicará uma mensagem de resposta no tópico **devolve-videos-library**.

# Orientações para uso do Kafka
* Se você está rodando a aplicação Java FORA do Docker (host)
* **application.yml**
```yml
spring:
  kafka:
    bootstrap-servers: localhost:29092
```

* Se a aplicação Java estiver rodando DENTRO do Docker
* **application.yml**
```yml
spring:
  kafka:
    bootstrap-servers: kafka:9092
```

Isso acontece porque dentro do Docker, o Kafka escuta na porta 9092, mas para acesso externo (como sua aplicação rodando no host/computador local), ele precisa ser acessado via localhost:29092.

# Acesso ao Kafka-UI
1. Abra o navegador e acesse `http://localhost:7085/ui/`.