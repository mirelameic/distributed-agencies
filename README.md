# Distributed Agencys

    Projeto da disciplina de Sistemas Distribuidos (EACH-USP)
Sistema de informações sobre Agências e Agentes (parts) usando Remote Method Invocation (RMI) e Java.
A classe `Agency` possui um identificador único e um nome de máquina. Ela é responsável por registrar-se no serviço de registro, bem como registrar agentes associados a ela e migrar agentes para outras agências.
A classe `Agent` também possui um identificador único. Ela registra-se no serviço de registro, indicando a agência à qual pertence, e pode ser migrada para outra agência.

## Estrutura

- `src`: pasta com arquivos .java
- `bin`: pasta com arquivos .class

## Classes


## Comandos do cliente



#
## Compilar
- Dentro da pasta `distributed-agencys`, execute o comando:
  ~~~ 
  $ javac -d bin src/*.java
  ~~~
## Executar
- Dentro da pasta `distributed-agencys`, execute os seguintes comandos:
  ~~~ 
  $ cd bin; rmiregistry
  ~~~