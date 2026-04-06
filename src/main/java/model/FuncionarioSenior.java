package model;

import jakarta.persistence.Entity;

@Entity
public class FuncionarioSenior extends Funcionario {

    @Override
    public double calcularSalario() {
        double bonus = (getHorasTrabalhadas() / 15) * 200;
        return super.calcularSalario() + bonus;
    }

    @Override
    public String mostrarInformacoes() {
        return "Senior -> " + super.mostrarInformacoes();
    }
}