package model;

import jakarta.persistence.Entity;

@Entity
public class FuncionarioFreelancer extends Funcionario {

    @Override
    public double calcularSalario() {

        double base = super.calcularSalario();

        return base * 1.1;
    }

    @Override
    public String mostrarInformacoes() {
        return "Freelancer -> " + super.mostrarInformacoes();
    }
}