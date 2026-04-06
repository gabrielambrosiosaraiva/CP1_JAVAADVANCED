package model;

import jakarta.persistence.Entity;

@Entity
public class FuncionarioTemporario extends Funcionario {

    @Override
    public String mostrarInformacoes() {
        return "Temporario -> " + super.mostrarInformacoes();
    }
}