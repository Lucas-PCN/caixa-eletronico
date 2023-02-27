package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

/**
 * class Banco.
 */
public class Banco {
  ArrayList<PessoaCliente> clientes = new ArrayList<PessoaCliente>();
  ArrayList<Conta> contas = new ArrayList<Conta>();
  
  /**
   * Método gerarNumeroNovaConta.
   */
  public String gerarNumeroNovaConta() {
    String conta = "";
    Random random = new Random();

    for (int i = 0; i < 10; i++) {
      int numero = random.nextInt(10);
      conta += Integer.toString(numero);
    }

    return conta;
  }
  
  /**
   * Método adicionarPessoaCliente.
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    clientes.add(cliente);
    return cliente;
  }

  /**
   * Método adicionarConta.
   */
  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  /**
   * Método getContas.
   */
  public ArrayList<Conta> getContas() {
    return contas;
  }

  /**
   * Método pessoaClienteLogin.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente cliente : clientes) {
      if (cliente.getCpf() == cpf && cliente.validarSenha(senha)) {
        return cliente;
      }
    }

    return null;
  }

  /**
   * Método transferirFundos.
   */
  public void transferirFundos(
      PessoaCliente pessoaCliente, int daConta, int paraConta, double quantia) {
    this.sacar(pessoaCliente, daConta, quantia);
    this.depositar(pessoaCliente, paraConta, quantia);
  }

  /**
   * Método sacar.
   */
  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, -quantia, "Saque ok");
  }

  /**
   * Método depositar.
   */
  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Depósito ok");
  }

  /**
   * Método mostrarExtrato.
   */
  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    pessoaCliente.retornarExtratoContaEspecifica(conta);
  }
}
