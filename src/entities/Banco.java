package entities;

import java.util.*;

public class Banco {
    private String name;
    private List<Conta> contas;
    List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adcionarClientes(Cliente cliente){
        clientes.add(cliente);
    }
    public void adcionarConta(Conta conta){
        contas.add(conta);
    }
    public void listaDeContas(Conta conta){
        contas.add(conta);
    }

    public void exbirListaClientes(){
        for (Cliente cl : clientes){
            System.out.println("Titular: " + cl.getName() + ", " + cl.getIdade() + " anos, ID = " + cl.getId());
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
    public void exibirContas(){
        if (!contas.isEmpty()){
            for (Conta conta : contas){
                System.out.println("TIPO: " + conta.nomeTipoConta()+ ", AGENCIA: " + conta.getAgencia() + ", NUMERO: " + conta.getNumero() + ", SALDO DISPONÍVEL: " + String.format("%.2f", conta.getSaldo()));
            }
        }
    }
    public Conta buscarContasPorNumero(Integer numeroConta){
        for (Conta c : contas){
            if (c.getNumero() == numeroConta){
                return c;
            }
        }
        return null;
    }

}
