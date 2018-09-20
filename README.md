# Validator
Projeto 1 de Teoria da Computação

## Introdução
Durante o primeiro estágio da cadeira de Teoria da Computação aprendemos sobre autômatos finitos e expressões regulares. O projeto deste estágio consiste em usar expressões regulares em uma linguagem de programação para verificar se algumas cadeias satisfazem certos padrões. Para implementar isso, desenvolveremos uma aplicação <b>Java</b> que receberá cadeias e fará a verificação delas com uso da biblioteca <b>java.util.regex.*</b>. A aplicação se divide entre uma classe com uma interface visual para testar as cadeias e outra para validar as cadeias recebidas.

## Cadeias a serem reconhecidas
### Número de CPF
O CPF é composto por cadeias de 3 dígitos, seguidos de ponto, mais 3 dígitos, ponto, 3 dígitos, hífen, 2 dígitos. Sua expressão regular logo é dada por:
```Java
  String cpf_regex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
```

O ^ no começo e $ no fim da expressão servem pra indicar que a expressão deve bater com o padrão do começo ao fim da linha de entrada.
Para representar os digitos usamos \\d seguido de {3} onde 3 é o número de digitos(0-9) que devem ocorrer, logo depois \\. para indicar que a cadeia deve seguir com um ponto e novamente \\d{3} para mais três digitos, \\. para outro ponto, \\d{3} para outros três dígitos, \\- para indicar que deve se seguir um hifen e por fim \\d{2} para indicar que a cadeia se encerra com dois dígitos.

Depois disso é necessário compilar o padrão cpf_regex e testar com a cadeia recebida, eis o código do método, o seu retorno é um valor booleano para se a cadeia de entrada corresponde a expressão regular pedida:
```Java
public static boolean validateCPF(String cpf) {
        String cpf_regex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
        Pattern pattern = Pattern.compile(cpf_regex);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
}
```

Teste com algumas cadeias:
<p align="center">
 <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/cpf1.png"><br>
  Cadeia Aceita<br>
  <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/cpf2.png"><br>
  Cadeia Recusada<br>
 </p>

### Número de Telefone
Um número de telefone é composto por 4 dígitos, hífen, 4 dígitos. Como sugestão opicional implementamos para aceitar quatro ou cinco dígitos no início da cadeia. Sua expressão regular é dada por:
```Java
  String phone_regex = "^\\d{4,5}\\-\\d{4}$";
```

Nesta expressão \\d{4,5} indica que a cadeia deve possuir inicialmente no mínimo 4 digitos e no máximo 5 seguidos por \\- que representa um hifen e se encerra com \\d{4} que significa 4 dígitos. 

Implementação do método:
```Java
public static boolean validatePhone(String number){
        String phone_regex = "^\\d{4,5}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(phone_regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
}
```

Teste com algumas cadeias:
<p align="center">
 <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/phone2.png"><br>
  Cadeia Aceita<br>
  <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/phone1.png"><br>
  Cadeia Recusada<br>
 </p>

### Placa de Carro
Uma placa de carro possui 3 letras maiúsculas seguidas por um hífen e 4 dígitos no fim. Eis sua expressão regular:
```Java
  String phone_regex = "^[A-Z]{3}\\-\\d{4}$";
```

O [A-Z]{3} indica que no início devem existir três letra maiúsculas, seguido por \\- representando um hifen e por fim \\d{4}
representando quatro dígitos. 

Implementação do método:
```Java
public static boolean validatePlate(String plate){
        String plate_regex = "^[A-Z]{3}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(plate_regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
}
```

Teste com algumas cadeias:
<p align="center">
 <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/plate1.png"><br>
  Cadeia Aceita<br>
  <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/plate2.png"><br>
  Cadeia Recusada<br>
 </p>

### Web URL simples
Para a url a ser testada ser válida ela precisa ser no formato www (3 letras w) seguidas de ponto, depois um nome de domínio com letras ou números, seguido de .com ou .org. A expressão regular que trata disso:
```Java
  String url_regex = "^[w]{3}\\.\\w+\\.(com|org)";
```

Nesta expressão regular, [w]{3} indica que a cadeia deve começar com 3 letras w, seguidas por \\. (ponto) e então o nome de um domínio que pode ter letras ou números representados por \\w+ onde w quer dizer um caractere que pode ser uma letra ou número e tem pelo menos tamanho 1 representado pelo +, seguido de \\. para representar um ponto e (com|org) para sinalizar que finaliza com "com" ou "org".

Implementação do método:
```Java
public static boolean validateUrl(String url){
        String url_regex = "^[w]{3}\\.\\w+\\.(com|org)";
        Pattern pattern = Pattern.compile(url_regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
}
```

Teste com algumas cadeias:
<p align="center">
 <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/url1.png"><br>
  Cadeia Aceita<br>
  <img src="https://github.com/DefinitelyNotACactus/Validator/raw/master/pictures/url2.png"><br>
  Cadeia Recusada<br>
 </p>
 
 ## Conclusão
 O projeto desenvolvido ajudou a aplicar o conteúdo visto em sala de aula em um programa para testar padrões, além de ajudar em aprender mais sobre biblioteca de expressões regulares de Java. O código completo da aplicação está disponível na pasta /src/ deste repositório
 
 ### Referências
 [Regular expressions in Java](http://www.vogella.com/tutorials/JavaRegularExpressions/article.html)<br>
