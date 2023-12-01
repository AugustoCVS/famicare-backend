# famicare-backend

Instruções para inicialização: 

1 - Baixa o MYSQl e o MYSQl Workbench na sua maquina

2 - Anote o user e a senha do MYSQl (muitos por padrão são root e root)

3 - Aplique os seguintes comandos para a criação das tabelas: 

CREATE DATABASE famicare;\
\
use famicare;\
\
CREATE TABLE family (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    name varchar(100) not null,\
    email varchar(100) not null unique,\
    password varchar(250) not null,\
    confirm_password varchar(250) not null,\
    PRIMARY KEY (id)\
);\
\
alter table family add ativo tinyint;\
\
CREATE TABLE relative (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    name varchar(100) not null,\
    email varchar(100) not null unique,\
    cpf varchar(100) not null unique,\
    password varchar(250) not null,\
	confirm_password varchar(250) not null,\
    \
    PRIMARY KEY (id)\
);\
\
ALTER TABLE relative\
ADD COLUMN id_family SMALLINT,\
ADD FOREIGN KEY (id_family) REFERENCES family(id);\
\
\
CREATE TABLE historic (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    diagnostic varchar(250) not null,\
    treatment varchar(250) not null,\
    allergies varchar(250) not null,\
    results varchar(250) not null,\
    \
    PRIMARY KEY (id)\
);\
\
ALTER TABLE historic\
ADD COLUMN id_relative SMALLINT,\
ADD FOREIGN KEY (id_relative) REFERENCES relative(id);\
\
CREATE TABLE appointments (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    doctor varchar(250) not null,\
    diagnostic varchar(250) not null,\
    treatment varchar(250) not null,\
    medicines varchar(250) not null,\
    results varchar(250) not null,\
    observations varchar(250) not null,\
    \
    PRIMARY KEY (id)\
);\
\
ALTER TABLE appointments\
ADD COLUMN id_relative SMALLINT,\
ADD FOREIGN KEY (id_relative) REFERENCES relative(id);\
\
CREATE TABLE exams (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    type varchar(250) not null,\
    date varchar(250) not null,\
    result varchar(250) not null,\
    observations varchar(250) not null,\
    doctor varchar(250) not null,\
    \
    PRIMARY KEY (id)\
);\
\
ALTER TABLE exams\
ADD COLUMN id_relative SMALLINT,\
ADD FOREIGN KEY (id_relative) REFERENCES relative(id);\
\
CREATE TABLE prescriptions (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    date varchar(250) not null,\
    medicine varchar(250) not null,\
    dosage varchar(250) not null,\
    duration varchar(250) not null,\
	instructions varchar(250) not null,\
    doctor varchar(250) not null,\
    \
    PRIMARY KEY (id)\
);\
\
ALTER TABLE prescriptions\
ADD COLUMN id_relative SMALLINT,\
ADD FOREIGN KEY (id_relative) REFERENCES relative(id);\
\
CREATE TABLE agenda (\
    id SMALLINT NOT NULL AUTO_INCREMENT,\
    type varchar(250) not null,\
    date varchar(250) not null,\
    doctor varchar(250) not null,\
    local varchar(250) not null,\
	observations varchar(250) not null,\
    \
    PRIMARY KEY (id)\
);\
\
ALTER TABLE agenda\
ADD COLUMN id_relative SMALLINT,\
ADD FOREIGN KEY (id_relative) REFERENCES relative(id);}.rtf…]()


4 - Baixe o projeto e importe-o para a sua IDE de preferência

5 - Troque o user e a senha do MYSQL para as que vc definiu no momento que baixou o MYSQL, troque o localhost se necessário (na maioria das vezes, por padrão é o localhost:3306)

<img width="927" alt="image" src="https://github.com/AugustoCVS/famicare-backend/assets/122945327/b3448549-fb19-4be7-afa0-bef17b1b7a39">

6 - Rode a aplicação 

7 - Para acessar a documentação do swagger, basta ir nesse link no momento que a aplicação iniciar: 

 - http://localhost:8080/swagger-ui/index.html

7.1 - Caso esse link de erro, verifique se o localhost iniciado no projeto é o 8080, caso não seja, altere para o correto

7.2 - As únicas 2 rotas que não estão com verificação de token são cadastro e login da familia: 
    - Primeiro você cadastra uma familia
    - Depois faz o login que vai gerar um token, este token você irá utilizar para verificação de todas as outras rotas

  <img width="1374" alt="image" src="https://github.com/AugustoCVS/famicare-backend/assets/122945327/6c756e94-7fd2-43a2-ba4d-0894f70d86cc">

    - Aqui é onde você colcar o token para destravar as outras requisições: 

  <img width="1374" alt="image" src="https://github.com/AugustoCVS/famicare-backend/assets/122945327/b950e2c7-39ff-4ab5-a243-9a4dd2d6c8dd">

