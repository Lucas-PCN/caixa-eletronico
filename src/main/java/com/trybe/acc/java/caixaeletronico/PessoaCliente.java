package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

/**
 * Classe PessoaCliente.
 */
public class PessoaCliente {
  private String nome;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas;

  /**
   * Método construtor.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
    this.contas = new ArrayList<Conta>();
    System.out.println("Nova pessoa cliente " + this.nome + " com CPF: " + this.cpf + " criada!");
  }

  public String getCpf() {
    return this.cpf;
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  public int retornarNumeroDeContas() {
    return this.contas.size();
  }

  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    this.contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }

  /**
   * Método retornarResumoContas.
   */
  public void retornarResumoContas() {
    for (Conta conta : this.contas) {
      System.out.println(conta.retornarResumoConta());
    }
  }
}
