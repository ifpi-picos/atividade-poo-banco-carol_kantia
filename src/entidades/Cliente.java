package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nome;
    private final String cpf;
    private final LocalDate dataNascimento;
    private Endereco endereco;
    private final List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta: this.contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}
