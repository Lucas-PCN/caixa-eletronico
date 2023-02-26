package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  private PessoaCliente pessoaCliente;
  private Conta conta;
  private Banco banco;

  public PessoaClienteTest() {
    this.pessoaCliente = new PessoaCliente("Adriana Lima", "06992176609", "12345678");
    this.banco = new Banco();
    this.conta = new Conta("Corrente", this.pessoaCliente, this.banco);
    this.conta.adicionarTransacao(5000.0, "Depósito");
    this.pessoaCliente.adicionarConta(conta);
    this.pessoaCliente.adicionarConta(new Conta("Poupança", this.pessoaCliente, this.banco));
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    ByteArrayOutputStream saidaConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(saidaConsole));

    new PessoaCliente("Adriana Lima", "06992176609", "12345678");
      assertEquals(
        "Nova pessoa cliente Adriana Lima com CPF: 06992176609 criada!",
        saidaConsole.toString().trim()
      );
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    assertEquals(2, this.pessoaCliente.retornarNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    assertEquals(5000.0, this.pessoaCliente.retornarSaldoContaEspecifica(0));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    assertEquals(this.conta.getIdConta(), this.pessoaCliente.retornarIdContaEspecifica(0));
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    ByteArrayOutputStream saidaConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(saidaConsole));

    this.pessoaCliente.retornarExtratoContaEspecifica(0);
    String saida = saidaConsole.toString();

    assertTrue(saida.contains("Depósito"));
    assertTrue(saida.contains("5000.0"));
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    this.pessoaCliente.adicionarTransacaoContaEspecifica(0, 1000.0, "Depósito");
    assertEquals(6000.0, this.pessoaCliente.retornarSaldoContaEspecifica(0));
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    assertTrue(this.pessoaCliente.validarSenha("12345678"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    ByteArrayOutputStream saidaConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(saidaConsole));

    this.pessoaCliente.retornarResumoContas();
    String saida = saidaConsole.toString();

    assertTrue(saida.contains("Corrente"));
    assertTrue(saida.contains("1000.0"));
    assertTrue(saida.contains("Poupança"));
    assertTrue(saida.contains("0.0"));
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    assertEquals("842.074.410-77", this.pessoaCliente.getCpf());
  }

}
