package view;

import entities.*;
import exceptions.ExceptionIdade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Cliente cliente = null;
    public static Banco banco = new Banco();

    public static void main(String[] args) {

        System.out.println("Bem-vindo(a) ao seu banco digital");
        System.out.println("=================================");

        try {
            while (true) {
                System.out.println();
                System.out.println("Digite qual conta você quer utilizar? ");
                System.out.println();
                System.out.println("Criar conta Poupança - [1]");
                System.out.println("Criar conta Corrente - [2]");
                System.out.println("Acessar conta já criada - [3]");
                System.out.println("Finalizar operação - [4]");

                System.out.print("RESPOSTA: ");
                int r1 = sc.nextInt();

                switch (r1) {
                    case 1:
                        criandoContaPoupanca();
                        break;
                    case 2:
                        criandoContaCorrente();
                        break;
                    case 3:
                        acessandoContaJaCriada();
                        break;
                    case 4:
                        System.out.println("Deseja exibir as suas informações de clientes e contas cadastradas antes de encerrar o serviço? sim[1] - nao[2]");
                        System.out.print("RESPOSTA: ");
                        int respFinalizando = sc.nextInt();
                        if (respFinalizando == 1) {
                            System.out.println("Clientes cadastrados: ");
                            banco.exbirListaClientes();
                            System.out.println("Informações de todas contas cadastradas: ");
                            banco.exibirContas();
                            System.out.println();
                            System.out.println("Finalizando operação obrigado por utilizar nosso serviço :)");
                            break;
                        } else if (respFinalizando == 2) {
                            System.out.println("Finalizando operação obrigado por utilizar nosso serviço :)");
                            break;
                        }
                    default:
                        System.out.println("Operação inválida.");
                        break;
                }
                if (r1 == 4) {
                    break;
                }
            }
        } catch (RuntimeException e) {
            throw new InputMismatchException("====!!!==Entrada de dados inválida. Por favor tente novamente==!!!=====");
        }
    }

    public static void criandoContaCorrente() {
        ContaCorrente contaCorrente = new ContaCorrente();
        cliente = clientesContas(contaCorrente);
        System.out.print("Digite um valor de depósito inicial: ");
        double depositoInicial = sc.nextDouble();
        contaCorrente.depositar(depositoInicial);
        contaCorrente.adcionandoCliente(cliente);
        banco.adcionarConta(contaCorrente);
        System.out.println("Sua conta poupança foi criada com sucesso, o numero da sua conta é = " + contaCorrente.getNumero() + ", guarde-o para futuras transferências.");
    }

    public static void criandoContaPoupanca() {

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        cliente = clientesContas(contaPoupanca);
        System.out.print("Digite um valor de depósito inicial: ");
        double depositoInicial = sc.nextDouble();
        contaPoupanca.depositar(depositoInicial);
        contaPoupanca.adcionandoCliente(cliente);
        banco.adcionarConta(contaPoupanca);
        System.out.println("Sua conta poupança foi criada com sucesso, o numero da sua conta é = " + contaPoupanca.getNumero() + ", guarde-o para futuras transferências.");
    }

    public static void acessandoContaJaCriada() {
        System.out.print("Digite o n° da conta que deseja acessar: ");
        int numeroConta = sc.nextInt();
        Conta conta = banco.buscarContasPorNumero(numeroConta);
        if (conta != null) {
            if (conta instanceof ContaPoupanca) {
                operaçoesContaPoupança((ContaPoupanca) conta);
            } else if (conta instanceof ContaCorrente) {
                operaçoesContaCorrente((ContaCorrente) conta);
            } else {
                System.out.println("Conta inexistente");
            }
        } else {
            System.out.println("Essa conta ainda não foi criada, volte ao menu principal.");
        }
    }

    public static Cliente clientesContas(Conta conta) {
        Cliente cliente1 = null;
        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {

                System.out.println("====Digite os dados do usuario===== ");
                sc.nextLine();
                System.out.print("Primeiro nome: ");

                String nome = sc.next();
                sc.nextLine();
                System.out.print("Id: ");
                Integer id = sc.nextInt();
                System.out.print("Idade: ");
                Integer idade = sc.nextInt();

                cliente1 = new Cliente(nome, idade, id);

                cliente1.verificandoMaiorDe18();

                dadosValidos = true;
                banco.adcionarClientes(cliente1);
            } catch (ExceptionIdade e) {
                System.out.println(e.getMessage());
                System.out.println("Tente novamente, por favor.");
                System.out.println();
            }
        }
        return cliente1;
    }

    public static void operaçoesContaPoupança(ContaPoupanca contaPoupanca) {

        while (true) {
            System.out.println();
            System.out.println("====Digite quais opções você deseja fazer======");
            System.out.println();
            System.out.println("Fazer um deposito - [1]");
            System.out.println("Fazer um saque - [2]");
            System.out.println("Fazer uma transferência para conta corrente - [3]");
            System.out.println("Exibir extrato - [4]");
            System.out.println("Sair da conta poupança - [5]");

            System.out.print("RESPOSTA: ");
            int resp = sc.nextInt();

            if (resp == 1) {
                System.out.print("Digite o valor de depósito: ");
                double valor = sc.nextDouble();
                contaPoupanca.depositar(valor);

            } else if (resp == 2) {
                System.out.println();
                System.out.print("Digite o valor de saque: ");
                double valor = sc.nextDouble();
                contaPoupanca.sacar(valor);
                System.out.println();

            } else if (resp == 3) {
                System.out.print("Digite o numero da conta que você deseja transfeirir: ");
                Integer numeroConta = sc.nextInt();
                Conta contaCorrente = banco.buscarContasPorNumero(numeroConta);

                if (numeroConta == contaCorrente.getNumero()) {
                    System.out.print("Digite o valor de transferência para conta corrente: ");
                    double valor = sc.nextDouble();
                    contaPoupanca.transferencia(valor, contaCorrente);
                } else {
                    System.out.println();
                    System.out.println("Numero da conta não corresponde com a conta cadastrada no sistema");
                }
            } else if (resp == 4) {
                contaPoupanca.imprimirExtrato();
                System.out.println();
            } else if (resp == 5) {
                break;
            } else {
                System.out.println("Opção invalida");
            }
        }
    }

    public static void operaçoesContaCorrente(ContaCorrente contaCorrente) {
        while (true) {
            System.out.println();
            System.out.println("====Digite quais opções você deseja fazer======");
            System.out.println();
            System.out.println("Fazer um deposito - [1]");
            System.out.println("Fazer um saque - [2]");
            System.out.println("Fazer uma transferência para conta poupança - [3]");
            System.out.println("Exibir o extrato - [4]");
            System.out.println("Sair da conta corrente - [5]");
            System.out.print("RESPOSTA: ");
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
                System.out.println("Digite o numero da conta poupança que você deseja transferir");
                Integer numeroConta = sc.nextInt();
                Conta contaPoupança = banco.buscarContasPorNumero(numeroConta);
                if (numeroConta == contaPoupança.getNumero()) {
                    System.out.print("Digite o valor de transferência para conta poupança: ");
                    double valor = sc.nextDouble();
                    contaCorrente.transferencia(valor, contaPoupança);
                } else {
                    System.out.println();
                    System.out.println("Numero da conta não corresponde com a conta cadastrada no sistema");
                    break;
                }
            } else if (resp == 4) {
                contaCorrente.imprimirExtrato();
            } else if (resp == 5) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
