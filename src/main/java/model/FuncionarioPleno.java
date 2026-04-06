package model;

import jakarta.persistence.Entity;

@Entity
public class FuncionarioPleno extends Funcionario {

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 1.0;
    }

    @Override
    public String mostrarInformacoes() {
        return "Pleno -> " + super.mostrarInformacoes();
    }
}