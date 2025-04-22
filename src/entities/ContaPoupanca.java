package entities;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
    }

    @Override
    public String nomeTipoConta() {
        return "Conta Poupança";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=======Infomações da conta poupança====== ");
        super.imprimirInfoComuns();
    }

}
