# Distributed Agencies

    Projeto da disciplina de Sistemas Distribuidos (EACH-USP)

Sistema de informações sobre Agências e Agentes (parts) usando Remote Method Invocation (RMI) e Java.
A classe `Agency` possui um identificador único e um nome de máquina. Ela é responsável por registrar-se no serviço de registro, bem como registrar agentes associados a ela e migrar agentes para outras agências.
A classe `Agent` também possui um identificador único. Ela registra-se no serviço de registro, indicando a agência à qual pertence, e pode ser migrada para outra agência.

## Estrutura

- `src`: pasta com arquivos .java
- `bin`: pasta com arquivos .class

## Classes
- `Agency`:
  Interface remota que define os métodos que as agências devem implementar para se conectarem remotamente. Ela contém os métodos para adicionar agentes, imprimir a lista de agentes, mover um agente e removê-lo, além de obter o nome, ID e gerar um código único.

- `AgencyImpl`:
  Implementação da interface Agency. Essa classe representa uma agência específica. Ela mantém uma lista de agentes que pertencem à agência e implementa os métodos definidos na interface para adicionar, imprimir, mover e remover agentes.

- `Agent`:
  Interface remota que define os métodos que os agentes devem implementar para se conectarem remotamente. Ela possui os métodos para iniciar um agente, obter o nome, o ID e gerar um código único.

- `AgentImpl`:
  Implementação da interface Agent. Essa classe representa um agente específico. Ela possui um ID, um nome e implementa o método start(), que é chamado quando o agente é iniciado.

- `NamingService`:
  Interface remota que define os métodos que o serviço de nome deve implementar para permitir o registro e localização de agências e agentes remotamente. Ela possui métodos para registrar, obter e remover agências, mover um agente e obter a lista de agências com seus agentes.

- `NamingServiceImpl`:
  Implementação da interface NamingService. Essa classe representa o serviço de nome e mantém um mapa com as agências registradas, associando o ID da agência ao seu nome, e outro mapa que associa o ID do agente ao ID da agência em que ele está localizado.

- `UserInterface`:
  Responsável por interagir com o usuário, exibir mensagens no console e obter comandos de entrada do usuário. Ela fornece métodos simples para exibir mensagens, ler comandos e lidar com erros de exceção.

- `Server`:
  Classe principal que representa o servidor de uma agência específica. Quando executado, ele cria uma instância da classe AgencyImpl, que representa uma agência específica, e a registra no RMI para que os clientes possam se conectar remotamente.

- `Client`:
  Classe utilitária que lida com a interação do usuário por meio da linha de comando. Ela possui métodos para exibir mensagens, ler comandos do usuário e imprimir linhas vazias para melhorar a apresentação na linha de comando.

## Comandos do cliente



#
## Compilar
- Dentro da pasta `distributed-agencies`, execute o comando:
  ~~~ 
  $ javac -d bin src/*.java
  ~~~
## Executar
- Dentro da pasta `distributed-agencies`, execute os seguintes comandos:
  ~~~ 
  $ cd bin; rmiregistry
  ~~~
  - Abra outro terminal:
  ~~~
  $ java -cp bin NamingServiceServer
  ~~~
  - Abra outro terminal. Troque `<agency_name>` pelo nome da agência que será criada e `<port>` pelo número da porta que deseja conectar:
  ~~~
  $ java -cp bin Server <agency_name> <port>
  ~~~
  - Abra outro terminal:
  ~~~
  $ java -cp bin Client
  ~~~