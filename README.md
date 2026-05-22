# Safe-Health API

## Fase 1: Fundação Hexagonal e Domínio Rico
Nesta primeira fase do SafeHealth, o objetivo foi construir a fundação da aplicação utilizando a Arquitetura Hexagonal (Ports and Adapters), garantindo que as regras de negócio fossem totalmente independentes de frameworks, bancos de dados ou protocolos de internet.

Conceitos Praticados e Aplicados:
1. *Domínio Rico (Rich Domain Model) vs Modelo Anêmico*

   Em vez de criar classes que são apenas "sacos de dados" (apenas getters e setters), o projeto iniciou com a entidade Consultation em Java puro.

O que foi feito: A regra de que "uma consulta não pode ser agendada no passado" foi encapsulada dentro do construtor da própria entidade. Os setters foram privados para proteger o estado do objeto.

Por que importa: Garante que é impossível criar um objeto em um estado inválido em qualquer lugar do sistema.

2. *Portas e Adaptadores (Inversão de Dependência)*

   Para salvar a consulta sem que o Domínio conhecesse o Spring Data JPA, utilizamos o padrão de Portas e Adaptadores.

A Porta (Port): Criamos a interface ConsultationRepositoryPort na camada de Aplicação. Ela dita a regra ("precisamos de um método save"), mas não diz como fazer.

O Adaptador (Adapter): Criamos a classe ConsultationRepositoryAdapter na camada de Infraestrutura. Ele implementa a interface, traduz a Entidade de Domínio (Consultation) para a Entidade de Banco de Dados (ConsultationEntity) e aciona o PostgreSQL.

3. *Isolamento da Camada de Aplicação (Use Cases)*

   O orquestrador do sistema, ScheduleConsultationUseCase, foi criado sem a anotação *@Service*.

Como o Spring o reconhece? 
Através de uma classe explícita @Configuration, que instancia o Caso de Uso manualmente. Isso blinda o código de negócio e permite que o sistema seja migrado para outro framework amanhã sem reescrever a lógica.

4. *Boas Práticas de API e Infraestrutura*

   DTOs com Java Records: 
Utilizamos o recurso record do Java 17+ para criar o ScheduledConsultationRequest, garantindo imutabilidade no tráfego de dados da web para o controller.

Fail-Fast Configuration: 
Configuramos o banco local via Docker (docker-compose.yml) isolando a porta 5433 para evitar conflitos com serviços locais do sistema operacional (Linux), assegurando que o ambiente de dev suba de forma previsível.
