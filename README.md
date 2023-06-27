# Distributed Agencys

    Projeto da disciplina de Sistemas Distribuidos (EACH-USP)

Sistema de informações sobre Agências e Agentes (parts) usando Remote Method Invocation (RMI) e Java.
A classe `Agency` possui um identificador único e um nome de máquina. Ela é responsável por registrar-se no serviço de registro, bem como registrar agentes associados a ela e migrar agentes para outras agências.
A classe `Agent` também possui um identificador único. Ela registra-se no serviço de registro, indicando a agência à qual pertence, e pode ser migrada para outra agência.

## Estrutura

- `src`: pasta com arquivos .java
- `bin`: pasta com arquivos .class

## Classes
- `Agency`:
  blablabla

- `AgencyImpl`:
  blablabla

- `Agent`:
  blablabla

- `AgentImpl`:
  blablabla

- `NamingService`:
  blablabla

- `NamingServiceImpl`:
  blablabla

- `UserInterface`:
  Responsável por interagir com o usuário, exibir mensagens no console e obter comandos de entrada do usuário. Ela fornece métodos simples para exibir mensagens, ler comandos e lidar com erros de exceção.

- `Server`:
  blablabla

- `Client`:
  blablabla

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
  - Abra outro terminal. Troque `<agency_name>` pelo nome da agência que será criada e `<port>` pelo número da porta que deseja conectar:
  ~~~
  $ java -cp bin Server <agency_name> <port>
  ~~~
  - Abra outro terminal:
  ~~~
  $ java -cp bin Client
  ~~~