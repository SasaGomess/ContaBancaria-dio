package entities;

public class ContaCorrente extends Conta {

    @Override
    public void imprimirExtrato() {
        System.out.println("======= Infomações da conta corrente ====== ");
        super.imprimirInfoComuns();
    }
}
