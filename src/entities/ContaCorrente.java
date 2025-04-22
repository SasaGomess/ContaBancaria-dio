package entities;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("======= Infomações da conta corrente ====== ");
        super.imprimirInfoComuns();
    }

    @Override
    public String nomeTipoConta() {
        return "Conta Corrente";
    }
}
