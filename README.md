Este repositório contém uma aplicação Java, JPA, Spring e com suporte ao JSF (Jakarta Server Faces) para renderização de páginas .xhtml. A aplicação utiliza o banco de dados H2 em memória e está configurada para rodar como uma aplicação web tradicional (com servlet).

Funcionalidades:

Integração JSF com Spring Boot: Configuração completa do FacesServlet para processar páginas .xhtml e utilizar beans do Spring no ciclo de vida do JSF.

Banco de Dados H2: Banco de dados em memória (H2) configurado para persistência de dados.

Exibição de Páginas JSF: Utiliza arquivos .xhtml para renderizar conteúdo dinâmico com suporte a JSF e Spring.

Acesso a URL: As páginas JSF são acessíveis pela URL http://localhost:8080/clientes/cadastrar.xhtml e listar.hxtml

Requisitos
Java 11 ou superior (necessário para rodar a aplicação).
Maven ou Gradle (para gerenciamento de dependências e execução).
IDE (recomendado IntelliJ IDEA, Eclipse, ou VS Code).
Tecnologias Usadas
Spring Boot 2.x
Jakarta Faces (JSF 4.0) para renderização de páginas .xhtml.
H2 Database como banco de dados em memória.
Spring Data JPA para interação com o banco de dados.
Maven como gerenciador de dependências.
Estrutura do Projeto

Model: Cliente (Mapeamento da Entidade para o banco de dados com validaçoes dos atributos)
DTO: EnderecoDTO (Classe de mapeamento da resposta do servico VaiCep)
Repository: ClienteRepository (Interface de mapeamento das funcionalidade do JPA para transaçães com o banco)
Service: ViaCepService (Classe de serviço para integração de busca do dados de entreço conforme o CEP informado)
Service: ClienteService (Classe de serviço intermediária entre a persistência do banco de dados/Repository e o controlador)
Controller: ClienteBean (Classe controlador responsável de integrar as funções da interface, JSF no caso, para as validações e cominucações com o repositório/banco)

src/main/webapp/clientes/cadastrar.xhtml e src/main/webapp/clientes/listar.xhtml (Paginas JSF)
A estrutura do projeto segue a convenção do Spring Boot, com os seguintes diretórios principais:
