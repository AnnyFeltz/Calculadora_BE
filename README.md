Calculadora Distribuída em Java com RMI e Docker. O objetivo desta atividade é desenvolver uma aplicação distribuída em Java capaz de realizar operações matemáticas básicas por meio de “invocação remota de métodos” entre processos executando em máquinas distintas ou na mesma máquina para fins de teste;

Seguir o modelo cliente-servidor, no qual o servidor disponibiliza um objeto remoto com os serviços de cálculo e o cliente consome esse serviço por meio do RMI Registry

Seguir conceitos de Orientação à Objeto

____________________________________________________________

usar 

Terminal 1 - servidor
docker-compose up servidor

Terminal 2 - cliente
docker run -it --network calculadora_be_rmi-net calculadora_be-cliente
