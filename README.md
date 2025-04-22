<h1>ContaBancaria-dio <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Card%20File%20Box.png" alt="Card File Box" width="30" height="30" /></h1>

<h3>Projeto realizado durante bootcamp Dio - Java Cloud Native. <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Light%20Bulb.png" alt="Light Bulb" width="25" height="25" /></h3>



#
<img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> Projeto de conta bancaria da Dio foi realizado com o intuito de exercitar minha lógica de negócios e minha capacidade de aplicar programação orientada a objetos na prática.

# Classes criadas <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Gear.png" alt="Gear" width="25" height="25" /> 

* Banco - para gerenciar oss tipos de conta o Banco possui uma lista das contas.
* Cliente - para representar o titular de cada conta.
  
<details>
  <summary> Conta </summary>  
  
* Conta Corrente - para representar uma conta do tipo corrente.
* Conta Poupança - para representar uma conta do tipo poupança.
  
</details>

# Métodos implementados <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Gear.png" alt="Gear" width="25" height="25" />
* ````buscarContasPorNumero()```` - Permitindo o usúario buscar uma conta já exitente no sistema pelo numero gerado da conta, esse método permite posteriormente a realização de uma transferência bancária a partir de duas contas existentes.
* ```` verificandoMaiorDe18()```` - Método para validação de idade.
* ````acessandoContaJaCriada()```` - Acesso do usúario a uma conta que ele mesmo cadastrou, abordagem de polimorfismo e casting.
* ````operacoesContaCorrente()```` e ````operacoesContaPoupanca()```` - Utilizado para fazer operações como ````saque````, ````deposito````, ````transferências```` e ````exibir extrato bancário````.
  
# Exceções <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Gear.png" alt="Gear" width="25" height="25" /> 

* Para o tratamento de exceções foi criada uma exceção personalizada para validar a idade de um usuário (se for maior de 18 anos é permitido a criação da conta).
* Blocos try catch para pegar exceções do tipo ````InputMissMatchException```` caso o usuário digite um dado em um local incorreto.
* Exibição uma mensagem amigável para o usúario tentar novamente.

# Como executar <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Wrench.png" alt="Wrench" width="25" height="25" />

1. Tenha a JDK instalada em sua máquina: [link para instalação](https://www.oracle.com/java/technologies/downloads/#jdk24-linux).
2. Clone meu repositório git clone ````https://github.com/SasaGomess/ContaBancaria-dio.git````.
3. Escolha uma IDE Eclipse ou IntelliJ
4. Execute no console e insira os dados pedidos pelo o programa.

# Imagens ilustrativas <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Hand%20gestures/Backhand%20Index%20Pointing%20Down.png" alt="Backhand Index Pointing Down" width="25" height="25" />
<table>
  <tr>
    <td>
       <img align="left" alt="" height="270px" src="https://github.com/user-attachments/assets/6d5f7fa7-3af5-4c59-a272-41b35aa6099a">
    </td>
      

  
  <td>
      <img align="right" alt="" height="270px" src="https://github.com/user-attachments/assets/cda696da-46bd-4a30-918e-0e63de5a3d4f">
  </td>
    
  
  </tr>
  <tr>
  <td>
        <img align="left" alt="" height="270px" src="https://github.com/user-attachments/assets/8a65da7c-efcf-4373-bf2c-e5ae0e81f29a"> 
    </td>
    
  <td>  
      <img align="right" alt="" height="270px" src="https://github.com/user-attachments/assets/42a77573-bcd7-4fa0-b134-5dae6095c973"> 
  </td>
  </tr>
 
 </table>
</div>
</div>
