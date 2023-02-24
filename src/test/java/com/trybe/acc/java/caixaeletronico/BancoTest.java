package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;


@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String novaConta = banco.gerarNumeroNovaConta();
    assertEquals(10, novaConta.length());
  }

  @Test
  @DisplayName("2 - Testa se o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    assertEquals({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, banco.adicionarPessoaCliente("Adriana", "06992176609", "12345678"));
    /**
     * banco.adicionarPessoaCliente("Adriana", "06992176609", "12345678");
     * ArrayList pessoasClientes = banco.getPessoasClientes();
     * assertTrue(pessoasClientes.contains({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }));
     */
  }

  @Test
  @DisplayName("3 - Testa se o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    banco.adicionarPessoaCliente("Adriana", "06992176609", "12345678");
    assertEquals({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, banco.pessoaClienteLogin("06992176609", "12345678"));
    assertNull(banco.pessoaClienteLogin("06992176609", "12345679"));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    banco.gerarNumeroNovaConta();
    banco.adicionarPessoaCliente("Adriana", "06992176609", "12345678");
    banco.depositar({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, 0, 10000.00);
    banco.gerarNumeroNovaConta();
    banco.transferirFundos({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, 0, 1, 5000.00);
    assertEquals(5000.00, banco.mostrarExtrato({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, 0));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    banco.gerarNumeroNovaConta();
    banco.adicionarPessoaCliente("Adriana", "06992176609", "12345678");
    banco.depositar({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, 0, 10000.00);
    banco.sacar({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, 0, 5000.00);
    assertEquals(5000.00, banco.mostrarExtrato({ nome: "Adriana", cpf: "06992176609", senha: "12345678" }, 0));
  }

}
