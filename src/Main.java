
import entities.Banco;
import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPoupança;
import exceptions.ExceptionIdade;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Cliente cliente = null;
    public static Banco banco = new Banco();

    public static void main(String[] args) {

        System.out.println("Bem-vindo(a) ao seu banco digital");
        System.out.println("=================================");
        while (true) {

            System.out.println();
            System.out.println("Digite qual conta você quer utilizar? ");
            System.out.println();
            System.out.println("Conta Poupança - [1]");
            System.out.println("Conta Corrente - [2]");
            System.out.println("Conta já criada");
            System.out.println("Finalizar operação - [3]");

            int r1 = sc.nextInt();

            if (r1 == 1) {
                ContaPoupança contaPoupança = criandoContaCorrente();
                operaçoesContaPoupança(contaPoupança, contaCorrente);
            } else if (r1 == 2) {
                ContaCorrente contaCorrente = criandoContaCorrente();
                operaçoesContaCorrente(contaCorrente, contaPoupança);
            } else if (r1 == 3) {
                System.out.println("Finalizando operação obrigado por utilizar nosso serviço :)");
                System.out.println("Clientes cadastrados: ");
                banco.exbirListaClientes();
                System.out.println("Informações de todas contas cadastradas: ");
                banco.exibirContas();
                break;
            }
        }
    }
    public static ContaCorrente criandoContaCorrente(){

    }
    public static void operaçoesContaPoupança(ContaPoupança contaPoupança, ContaCorrente contaCorrente) {
        contaPoupança = new ContaPoupança();
        clientesContaPoupança(contaPoupança);
        System.out.println("Digite um valor de depósito inicial: ");
        double depositoInicial = sc.nextDouble();
        contaPoupança.depositar(depositoInicial);
        while (true) {

            System.out.println("====Digite quais opções você deseja fazer======");
            System.out.println("Fazer um deposito - [1]");
            System.out.println("Fazer um saque - [2]");
            System.out.println("Fazer uma transferência para conta corrente - [3]");
            System.out.println("Exibir extrato - [4]");
            System.out.println("Sair da conta poupança - [5]");


            int resp = sc.nextInt();

            if (resp == 1) {
                System.out.print("Digite o valor de depósito: ");
                double valor = sc.nextDouble();
                contaPoupança.depositar(valor);

            } else if (resp == 2) {
                System.out.println();
                System.out.print("Digite o valor de saque: ");
                double valor = sc.nextDouble();
                contaPoupança.sacar(valor);

            } else if (resp == 3) {
                    System.out.print("Digite o valor de transferência para conta corrente: ");
                    double valor = sc.nextDouble();
                    contaPoupança.transferencia(valor, contaCorrente);

            } else if (resp == 4) {
                contaPoupança.imprimirExtrato();
            } else if (resp == 5) {
                break;
            } else {
                System.out.println("Opção invalida");
            }
        }
    }

    public static void clientesContaPoupança(ContaPoupança contaPoupança) {
        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                System.out.println("====Digite os dados do usuario===== ");
                System.out.print("Primeiro nome: ");
                String nome = sc.next();
                System.out.print("Id: ");
                Integer id = sc.nextInt();
                System.out.print("Idade: ");
                Integer idade = sc.nextInt();

                cliente = new Cliente(nome, idade, id);

                cliente.verificandoMaiorDe18();

                dadosValidos = true;
                contaPoupança.adcionandoCliente(cliente);
                banco.listaDeClientes(cliente);
            } catch (ExceptionIdade e) {
                System.out.println(e.getMessage());
                System.out.println("Tente novamente, por favor");
            }
        }
    }

    public static void operaçoesContaCorrente(ContaCorrente contaCorrente, ContaPoupança contaPoupança) {

        clientesContaCorrente(contaCorrente);
        System.out.println("Digite um valor de depósito inicial: ");

        double depositoInicial = sc.nextDouble();
        contaCorrente.depositar(depositoInicial);

        while (true) {

            System.out.println("====Digite quais opções você deseja fazer======");
            System.out.println("Fazer um deposito - [1]");
            System.out.println("Fazer um saque - [2]");
            System.out.println("Fazer uma transferência para conta poupança - [3]");
            System.out.println("Exibir o extrato - [4]");
            System.out.println("Sair da conta corrente - [5]");

            int resp = sc.nextInt();
            if (resp == 1) {
                System.out.print("Digite o valor de depósito");
                double valor = sc.nextDouble();
                contaCorrente.depositar(valor);

            } else if (resp == 2) {
                System.out.println();
                System.out.print("Digite o valor de saque: ");
                double valor = sc.nextDouble();
                contaCorrente.sacar(valor);

            } else if (resp == 3) {
                    System.out.print("Digite o valor de transferência para conta poupança: ");
                    double valor = sc.nextDouble();
                    contaCorrente.transferencia(valor, contaPoupança);
            } else if (resp == 4) {
                contaCorrente.imprimirExtrato();
            } else if (resp == 5) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
    public static void clientesContaCorrente(ContaCorrente contaCorrente) {
        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                System.out.println("====Digite os dados do usuario=====");
                System.out.print("Primeiro nome: ");
                String nome = sc.next();
                System.out.print("Id: ");
                Integer id = sc.nextInt();
                System.out.print("Idade: ");
                Integer idade = sc.nextInt();

                Cliente cliente = new Cliente(nome, idade, id);

                cliente.verificandoMaiorDe18();

                dadosValidos = true;
                contaCorrente.adcionandoCliente(cliente);
                banco.listaDeClientes(cliente);
            } catch (ExceptionIdade e) {
                System.out.println(e.getMessage());
                System.out.println("Tente novamente, por favor");
            }
        }
    }
}
