package model;

import jakarta.persistence.Entity;

@Entity
public class FuncionarioJunior extends Funcionario {

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 0.8;
    }

    @Override
    public String mostrarInformacoes() {
        return "Junior -> " + super.mostrarInformacoes();
    }
}