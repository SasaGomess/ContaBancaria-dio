package entities;

public class ContaPoupança extends Conta {

    @Override
    public void imprimirExtrato() {
        System.out.println("=======Infomações da conta poupança====== ");
        super.imprimirInfoComuns();
    }

}
