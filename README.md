# Automação E2E com Selenium

Este é um README para guiar você na automação de testes end-to-end (E2E) usando o Selenium com Maven e Java 19. Aqui você encontrará informações essenciais sobre a configuração, instalação e execução dos testes automatizados.

## Descrição do Projeto

O objetivo deste projeto é criar testes automatizados que simulem o comportamento do usuário em um navegador web, verificando se é possível realizar uma transação.

## Pré-requisitos

Antes de começar, certifique-se de que você tenha as seguintes dependências instaladas em seu ambiente de desenvolvimento:

- Java Development Kit (JDK) 19: [JDK19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
- Maven: [Instalar Maven](https://maven.apache.org/install.html)

Certifique-se também de ter um navegador web instalado em seu sistema para que o Selenium possa interagir com ele durante a execução dos testes.

## Configuração do Projeto

1. Clone o repositório para o seu ambiente de desenvolvimento:

   ```bash
   git clone https://github.com/Franias/selenium-bugbank
   ```

2. Navegue até o diretório raiz do projeto:

   ```bash
   cd projetoSelenium3
   ```

3. Compile o projeto e baixe as dependências usando o Gradle:

   ```bash
   mvn install
   ```
## Executando os Testes

Após a configuração do projeto, você pode executar os testes automatizados usando o seguinte comando Gradle:

```bash
mvn test
```

Os testes serão executados e você poderá acompanhar o progresso no terminal. Ao final da execução, serão exibidos os resultados dos testes, indicando se eles passaram ou falharam.

## Estrutura do Projeto

O projeto segue uma estrutura básica, com os seguintes diretórios e arquivos principais:

- **src/main/java**: Este diretório contém as classes Java responsáveis pela interação com o Selenium e a implementação dos testes.
- **src/test/java**: Aqui estão os arquivos de teste, onde você pode adicionar seus próprios testes E2E.
- **src/test/resources**: Este diretório é usado para armazenar arquivos de configuração e recursos auxiliares, como dados de teste ou arquivos de propriedades. Certifique-se de atualizar a versão do Selenium conforme necessário.

## Documentação do Selenium

Você pode encontrar a documentação oficial do Selenium em [Selenium Documentation](https://www.selenium.dev/documentation/). A documentação inclui guias, exemplos e referências para ajudar você a utilizar o Selenium de maneira eficaz em seus testes automatizados.