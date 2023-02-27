package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testes para a classe Banco")
class BancoTest {
  private Banco banco;
  private PessoaCliente cliente;

  public BancoTest() {
    banco = new Banco();
    cliente = banco.adicionarPessoaCliente("Adriana Lima", "06992176609", "12345678");
  }

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    String novaConta = banco.gerarNumeroNovaConta();
    assertEquals(10, novaConta.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
	  assertNotNull(cliente);
  }

  @Test
  @DisplayName("3 - Testa se o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    assertEquals(cliente, banco.pessoaClienteLogin("06992176609", "12345678"));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    PessoaCliente cliente = this.banco.pessoaClienteLogin("06992176609", "12345678");
    cliente.adicionarConta(new Conta("Corrente", cliente, this.banco));
    cliente.adicionarConta(new Conta("Poupança", cliente, this.banco));
    this.banco.depositar(cliente, 0, 5000.0);
    this.banco.transferirFundos(cliente, 0, 1, 1000.0);

    ByteArrayOutputStream saidaConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(saidaConsole));

    this.banco.mostrarExtrato(cliente, 0);
    assertTrue(saidaConsole.toString().contains("Depósito"));
    assertTrue(saidaConsole.toString().contains("5000.0"));
    assertTrue(saidaConsole.toString().contains("Saque"));
    assertTrue(saidaConsole.toString().contains("1000.0"));

    saidaConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(saidaConsole));

    this.banco.mostrarExtrato(cliente, 1);
    assertTrue(saidaConsole.toString().contains("Depósito"));
    assertTrue(saidaConsole.toString().contains("1000.0"));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    PessoaCliente cliente = this.banco.pessoaClienteLogin("06992176609", "12345678");
    cliente.adicionarConta(new Conta("Corrente", cliente, this.banco));
    this.banco.depositar(cliente, 0, 5000.0);
    this.banco.sacar(cliente, 0, 1000.0);

    ByteArrayOutputStream saidaConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(saidaConsole));

    this.banco.mostrarExtrato(cliente, 0);
    assertTrue(saidaConsole.toString().contains("Saque"));
    assertTrue(saidaConsole.toString().contains("1000.0"));
  }

}
