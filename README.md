# ImportProduct (Console + Maven)

Aplicação **Java (console)** usando **Maven** para praticar **herança e polimorfismo** com diferentes tipos de produto:

- `Product` (comum)
- `UsedProduct` (usado)
- `ImportedProduct` (importado)

O programa lê os dados via terminal, cria uma lista de produtos e ao final imprime **PRICE TAGS** chamando `priceTag()` de cada objeto.

## O que existe no projeto (código atual)

### `org.example.Main`
- Define `Locale.US`
- Lê `n` (quantidade de produtos)
- Para cada produto, pergunta o tipo: **common, used or imported (c/u/i)**
- Lê:
  - `name`
  - `price`
  - Se **importado (`i`)**: `customs fee`
  - Se **usado (`u`)**: `manufacture date (DD/MM/YYYY)` (parse com `SimpleDateFormat("dd/MM/yyyy")`)
- Imprime:
  - `PRICE TAGS:` e depois `p.priceTag()` para cada produto da lista

### `entities.Product`
- Campos: `name`, `price`
- Método `priceTag()` retorna:
  - `name + " $ " + preço formatado`

> Observação: os tipos `UsedProduct` e `ImportedProduct` também existem no projeto e são usados no `Main` para compor a lista e gerar o `priceTag()` específico de cada tipo.

## Requisitos

- **Java/JDK**: o `pom.xml` está configurado com `maven.compiler.source/target = 25` (Java 25)
- **Maven**

## Como baixar o projeto

```bash
git clone https://github.com/PaivaOfc/ImportProduct.git
cd ImportProduct
```

## Como compilar

```bash
mvn clean compile
```

## Como executar

O `pom.xml` atual não configura geração de `.jar` executável, então a forma mais simples é executar a classe `Main` pela sua IDE (IntelliJ/Eclipse).

## Exemplo de uso (entrada/saída)

Exemplo aproximado de execução:

```text
Enter the number of products: 3
Product #1 data:
Common, used or imported (c/u/i)? c
Name: Notebook
Price: 1100.00
Product #2 data:
Common, used or imported (c/u/i)? u
Name: iPhone
Price: 400.00
Manufacture date (DD/MM/YYYY): 15/03/2017
Product #3 data:
Common, used or imported (c/u/i)? i
Name: Tablet
Price: 260.00
Customs fee: 20.00

PRICE TAGS:
Notebook $ 1100.00
iPhone (used) $ 400.00 (Manufacture date: 15/03/2017)
Tablet $ 280.00 (Customs fee: 20.00)
```

*(O formato exato das linhas de `UsedProduct` e `ImportedProduct` depende do `priceTag()` implementado em cada classe.)*

## Estrutura de pastas

```
.
├── pom.xml
└── src
    └── main
        └── java
            ├── entities
            │   ├── Product.java
            │   ├── UsedProduct.java
            │   └── ImportedProduct.java
            └── org
                └── example
                    └── Main.java
```

## Autor

- GitHub: https://github.com/PaivaOfc
