package entities;

import exceptions.ExceptionIdade;

public class Cliente {
    private Integer id;
    private String name;
    private Integer idade;

    public Cliente(){
    }

    public Cliente(String name, Integer idade, Integer id) {
        this.name = name;
        this.idade = idade;
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void verificandoMaiorDe18() throws ExceptionIdade {
        if (idade < 18){
            throw new ExceptionIdade("Você não pode criar uma conta pois é menor de 18 anos");
        }
    }
    @Override
    public String toString() {
        return "Id: " + id +", nome: " + name +", idade: "+ idade;
    }
}
