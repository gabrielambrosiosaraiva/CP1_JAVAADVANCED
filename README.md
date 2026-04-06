Documentação Técnica: Check Point 1 - Java Advanced

Visão Geral do Projeto Este projeto representa a implementação do primeiro Check Point da disciplina de Java Advanced. Ele consiste em uma API RESTful desenvolvida com o ecossistema Spring Boot, focada em fornecer um backend robusto para a gestão de entidades de negócio. O projeto prioriza a separação de responsabilidades, a manutenibilidade do código e a conformidade com os padrões de desenvolvimento empresarial.

Análise da Arquitetura do Sistema A aplicação foi construída utilizando o padrão de arquitetura em camadas, garantindo que a lógica de negócio, a persistência de dados e a exposição de serviços incluídos isolados.

Camada de Exposição (Controller): Implemente os recursos REST utilizando anotações como @RestController e @RequestMapping. É responsável por interceptar as requisições HTTP, validar os dados de entrada e retornar os códigos de status HTTP adequados (200 OK, 201 Criado, 404 Não Encontrado, etc.).

Camada de Negócio (Serviço): Centraliza toda a lógica de domínio. Esta camada é anotada com @Service, permitindo que o Spring gerencie seu ciclo de vida. Aqui são aplicadas as regras de negócio antes que os dados sejam enviados para persistência ou retornados para o usuário.

Camada de Persistência (Repositório): Utiliza o Spring Data JPA. Ao estender o JpaRepository, o projeto ganha funcionalidades automáticas de CRUD (Criar, Ler, Atualizar, Excluir) e paginação, reduzindo significativamente a necessidade de escrita de código SQL manual.

Camada de Modelo (Entity): Define o esquema do banco de dados através de mapeamento objeto-relacional (ORM) com Hibernate. Inclui o uso de anotações como @Entity, @Table, @Id e @Column.

Camada de Transferência (DTO): Implementa o padrão Data Transfer Object para desacoplar a entidade do banco de dados da resposta da API. Isso garante que dados sensíveis não sejam expostos e que a API possa evoluir independentemente do modelo de dados.

Stack Tecnológico e Ferramentas O projeto utiliza as versões mais benéficas e recomendadas para o desenvolvimento Java moderno:
Java 17 (LTS): Utilização de recursos modernos da linguagem para melhor desempenho e sintaxe limpa.

Spring Boot 3.x: Base do projeto, facilitando a configuração via "Convention over Configuration".

Spring Data JPA: Para gerenciamento de camada de dados e integração com ORM.

Bean Validation (Hibernate Validator): Implementação de regras de validação diretamente nos DTOs através de anotações como @NotBlank, @Size e @Min.

Lombok: Utilizado para eliminar código repetitivo, gerando automaticamente construtores, getters, setters e métodos auxiliares no tempo de compilação.

Maven: Gerenciador de dependências e automação do ciclo de vida do projeto (construir, testar, implantar).

Gerenciamento de Banco de Dados O projeto está configurado para operar em dois cenários distintos, facilitando tanto o desenvolvimento rápido quanto a simulação de um ambiente produtivo:
Ambiente de Desenvolvimento (Banco de Dados H2): Banco de dados em memória que permite testes rápidos sem a necessidade de instalação de infraestrutura externa.

Ambiente de Homologação/Produção (Oracle Database): Configuração pronta para persistência persistente, utilizando drivers específicos para integração com servidores Oracle.

Configurações: Localizadas em src/main/resources/application.properties, onde são definidos os dialetos, URLs de conexão, credenciais e estratégias de geração de tabelas (ddl-auto).

Fluxo de Execução da API A análise do fluxo de dados segue o seguinte percurso:
A requisição chega ao Controller através de um método HTTP (GET, POST, PUT ou DELETE).

Os dados de entrada (JSON) são convertidos em um DTO e validados.

O Controlador invoca o Serviço correspondente.

O Serviço processa as regras de negócio e interação com o Repositório.

O Repositório executa a operação no banco de dados e retorna a Entidade.

O Serviço converte uma Entidade de volta para um DTO de resposta.

O Controller entrega a resposta final ao cliente com o status HTTP correto.

Tratamento de Erros e Exceções O projeto inclui um mecanismo de tratamento global de abordagens. Isso é feito através de uma classe anotada com @ControllerAdvice. Este componente captura falhas em qualquer ponto da aplicação e se transforma em respostas padronizadas, evitando que logs técnicos sejam expostos ao usuário final e garantindo uma experiência de integração mais fluida.

Como executar o Projeto Localmente Certifique-se de ter o JDK 17 e o Maven instalados.

Clone o repositório: git clone https://github.com/gabrielambrosiosaraiva/CP1_JAVAADVANCED.git .

Navegue até a pasta raiz do projeto.

Execute o comando mvn clean install para baixar as dependências.

Inicie a aplicação com mvn spring-boot:run.

Testes de API Para testar os endpoints, recomendamos o uso de ferramentas como Postman ou Insomnia. A porta padrão de execução é 8080.

Considerações Finais Este projeto demonstra a aplicação prática de conceitos avançados de Java, focando em uma estrutura profissional que pode ser facilmente expandida para sistemas de maior escala. A separação clara entre DTOs e Entidades, o uso de Serviços para lógica e a configuração modular de bancos de dados são os pontos fortes desta entrega.
