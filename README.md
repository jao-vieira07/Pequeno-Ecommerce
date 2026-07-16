<h1 align="center">Pequeno E-commerce</h1>

<p align="center">
  <em>Um projeto de E-commerce operado via console desenvolvido para aperfeiçoar estudos em Lógica e Orientação a Objetos em Java. 🚀</em>
</p>

## 💻 Sobre o Projeto
Este é um sistema simples de carrinho de compras em linha de comando, que permite gerenciar produtos (Livros, Eletrônicos e Vestuário), aplicar diferentes tipos de promoções e gerar notas fiscais persistidas em um arquivo local (`NOTA_FISCAL.txt`).

O projeto tem grande foco na aplicação de conceitos de Programação Orientada a Objetos (POO), como herança, polimorfismo, interfaces, tratamento de exceções customizadas e manipulação de arquivos (I/O) em Java.

## ✨ Funcionalidades
- **Gerenciamento de Carrinho**: Adicionar e remover diferentes produtos.
- **Categorias de Produtos**: Livros, Eletrônicos e Vestuário.
- **Sistema de Descontos**: Possibilidade de aplicar promoções que calculam automaticamente o valor final na compra.
- **Persistência de Dados**: Leitura e salvamento automático dos itens da nota fiscal em `NOTA_FISCAL.txt`. Ao reiniciar o programa, o carrinho carrega os itens gravados anteriormente.
- **Tratamento de Exceções**: Criação de exceções personalizadas para lidar com erros, como carrinho vazio, valor negativo e posições inválidas na lista.
- **Emissão de Nota Fiscal**: Impressão detalhada no console contendo data da compra e valores calculados (bruto e economia com descontos).

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java
- **Conceitos:** Programação Orientada a Objetos (Herança, Polimorfismo, Tratamento de Erros)
- **Armazenamento:** Persistência local de dados através de arquivos de texto (`java.io`)

## 📁 Estrutura do Projeto (Packages)
- `Exception/`: Classes de exceções personalizadas para garantir o fluxo seguro do sistema (`CarrinhoVazioException`, `ValorInvalidoException`, `PosicaoInvalidaException`).
- `Model/`: Modelagem das entidades principais e uso de herança (`Produto`, `Livro`, `Eletronicos`, `Vestuario`).
- `Service/`: Classes de regra de negócio, gerenciamento do `Carrinho` de compras e cálculo de `PromocaoS`.
- `InputUtils/`: Classe utilitária focada em facilitar a captação de entradas do usuário, garantindo a sanitização dos dados.
- `Main/`: Classe executável onde a interação de interface (via terminal/menu) acontece.

## 🚀 Como Executar

1. Clone o repositório ou faça o download dos arquivos em sua máquina.
2. Certifique-se de ter o **Java JDK** instalado.
3. Importe a pasta em sua IDE preferida (IntelliJ IDEA, Eclipse, VS Code).
4. Abra o arquivo principal `Main.java` (localizado em `src/PequenoEcommerce/Main/`) e o execute.
5. Siga as instruções do menu iterativo apresentado no console!

---
<p align="center">
  Desenvolvido com dedicação por <strong>João Pedro</strong>.
</p>
