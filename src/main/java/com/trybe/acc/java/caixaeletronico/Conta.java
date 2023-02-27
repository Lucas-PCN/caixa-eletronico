package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

/**
 * Classe Conta.
 */
public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes;

  /**
   * Método construtor.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.idConta = banco.gerarNumeroNovaConta();
    this.pessoaCliente = pessoaCliente;
    this.transacoes = new ArrayList<Transacao>();
  }

  public String getTipoConta() {
    return this.tipoConta;
  }

  public String getIdConta() {
    return this.idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);
    this.transacoes.add(novaTransacao);
  }

  /**
   * Método retornarSaldo.
   */
  public double retornarSaldo() {
    double saldo = 0;
    for (Transacao transacao : this.transacoes) {
      if (transacao.getDescricao() == "Depósito") {
        saldo += transacao.getQuantia();
      }

      if (transacao.getDescricao() == "Saque") {
        saldo -= transacao.getQuantia();
      }
    }
    return saldo;
  }

  /**
   * Método retornarResumoConta.
   */
  public String retornarResumoConta() {
    return "Conta: " + this.tipoConta + " " + this.idConta + " com saldo de: "
          + this.retornarSaldo();
  }

  /**
   * Método retornarExtrato.
   */
  public void retornarExtrato() {
    for (Transacao transacao : this.transacoes) {
      System.out.println(transacao.retornarResumoTransacao());
    }
  }

}
