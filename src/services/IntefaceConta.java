package services;

import entities.Conta;

public interface IntefaceConta {
    void sacar(double valor);

    void depositar(double valor);

    void transferencia(double valor, Conta contaDestino);

    void imprimirExtrato();

}
