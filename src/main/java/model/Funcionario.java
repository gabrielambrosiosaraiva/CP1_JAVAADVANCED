package model;

import jakarta.persistence.*;
import anotacoes.Descricao;

@Entity
@Table(name = "funcionarios")
@Descricao(descricao = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }

    public String mostrarInformacoes() {
        return "Nome: " + nome + " | Salário: " + calcularSalario();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}