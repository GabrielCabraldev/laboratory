## NEGÓCIO

O desafio consiste em criar uma aplicação onde o usuário possa inserir transações de retirada de dinheiro de um cartão pré pago e também consultar o saldo atual do mesmo, bem como a lista com as últimas 10 transações do respectivo cartão.

A aplicação é iniciada contento 2 cartões com saldo de R$ 1.000,00.

Os possíveis códigos de retorno serão:

**00** -> Requisição aprovada. <br/>
**14** -> Conta informada inválida. <br/>
**51** -> Saldo insuficiente. <br/>
**96** -> Erro de processamento.<br/>


## API


A aplicação disponibiliza a porta (socket TCP) **8181** para requisições no formato **JSON** conforme o exemplo abaixo:
```
{"action":"withdraw","cardNumber":"1111222233334444","amount":"5,50"}
```

**action (String)** -> Representa a operação que será realizada e seu valor deve ser sempre igual a *withdraw*, caso contrário o usuário recebe um código de erro no processamento (96). <br/>
**cardNumber (String)** -> Representa o número do cartão que será debitado o valor requisitado. Um campo que não possua 16 caracteres numéricos ou se o cartão informado não existir na base de dados, será retornado um código de conta inválida (14). <br/>
**amount (String)** -> Representa o valor que será debitado do saldo do cartão. Caso o valor não siga os padrões *0000,00* ou *0000.00* será retornado um erro de processamento (96). Caso não haja saldo para o valor requisitado, será retornado um código de saldo insuficiente (51).<br/>

A resposta a essa requisição será exibida no seguinte formato:
```
{"action":"withdraw","code":"00","authorization_code":"406540"}
```

**action** -> Operação realizada conforme requisitado. <br/>
**code** -> Código que informa ao usuário o status da operação conforme os campos informados na requisição. <br/>
**authorization_code** -> Informa o código de autorização de 6 dígitos para a requisição. <br/>

Qualquer requisição que não siga este formato, retornará um erro de processamento (96).

A aplicação também disponibiliza na porta **8080** uma API *REST* para a consulta do saldo de um cartão. Abaixo os dados para a consulta:

**verbo** -> GET<br/>
**URL** -> http://localhost/card/{cardNumber}<br/>

Caso o atributo *cardNumber* seja válido e exista no banco de dados, a aplicação deverá retornar uma resposta no seguinte formato:<br/>
```
{ 
    "cardNumber": "1111222233334444",
    "availableAmount": "994,50", 
    "transactions": [ 
        { 
            "date": "2019-09-13 14:07:24", 
            "amount": "5,50" 
        } 
    ] 
}
```

**cardNumber** -> Número do cartão.<br/>
**availableAmount** -> Saldo disponível no cartão.<br/>
**transactions** -> Objeto que representa a lista de transações.<br/>
**date** -> Data e hora do momento em que a transação foi feita.<br/>
**amount** -> Valor da transação.<br/>

## TECNOLOGIAS

Java 8<br/>
Spring boot 2.1.8.RELEASE<br/>
Banco de dados H2 (in memory)<br/>

## INSTRUÇÕES DE RUN

Ao realizar um *pull* os comandos abaixo devem ser executados via terminal na pasta raiz do projeto:<br/>

Maven buid:
```
mvn clean install
```

Build da imagem do docker:
```
sudo docker build -t hubfintech-app .
```

Rodar a aplicação no docker:
```
sudo docker run -p 8080:8080 -p 8181:8181  hubfintech-app
```

Nesse momento temos a aplicação rodando em um container. Para realizar uma requisição, os comandos devem ser executados conforme abaixo:

Conexão com a porta TCP:
```
telnet localhost 8181
```
Requisição:
```
{"action":"withdraw","cardNumber":"1111222233334444","amount":"5,50"}
```

