

##Executando o projeto

#1 - Iniciar dependencias
1.1 - Banco de dados mysql
docker-compose up --build -d

#2 - Execute o microservico
2.1 - Eu usei a IDE STS https://spring.io/tools (versao pro MAC), mas funciona com inteliJ tamb[e. Basta importar o projeto na IDE
2.2 - Quando importar o projeto (no STS) use o atalho Boot Dashboard par executar o projeto

#3 - Documentacao
3.1 - http://localhost:8080/swagger-ui/index.html#/ (swagger com todas as operacoes disponiveis)

3.2 - Com as operações da API você pode inserir, atualizar e remover itens e categroias do banco mysql. Use o botão 'tryout', modifique o payload e depois execute para testar.
3.3 - Caso queira iniciar a aplicação com o banco já populado, edite os arquivos abaixo:
src/main/resources/db/migration/V1.0.1__criar-categorias.sql
src/main/resources/db/migration/V1.0.2__criar-itens.sql
OBS. VOcê vai precisar dropar as tabelas do banco e rodar novamente o projeto, caso edite os arquivos SQL sem apagar as tabelas a aplicação vai deixar de funcionar.

##Criar um projeto igual?

Acesse o site https://start.spring.io/ e prenencha o form da seguinte forma: 
- Project: Maven
- Language: java
- Springboot: 3.3.0

Group: com.pizzaria
Artifact: fracaroli
Name: pizza-fracaroli
Description: Pizzaria Fracaroli
Package name: com.pizzaria.fracaroli
Packaging: Jar
Java: 17

Adcione as dependencias
- Spring Web WEB
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
- H2 Database SQL
Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.
- MySQL Driver SQL
MySQL JDBC driver.
- Spring Data JPA SQL
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
- Flyway Migration SQL
Version control for your database so you can migrate from any version (incl. an empty database) to the latest version of the schema.
- Lombok DEVELOPER TOOLS
Java annotation library which helps to reduce boilerplate code.


Adicione no pom:

			<dependency>
				<groupId>com.github.dozermapper</groupId>
				<artifactId>dozer-core</artifactId>
				<version>6.5.0</version>
			</dependency>
            <dependency>
                <groupId>javax.xml.bind</groupId>
                <artifactId>jaxb-api</artifactId>
                <version>2.3.0</version>
            </dependency>
            <dependency>
                <groupId>org.springdoc</groupId>
                <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
                <version>2.5.0</version>
            </dependency>