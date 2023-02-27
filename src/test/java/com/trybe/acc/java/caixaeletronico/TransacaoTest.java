package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {
  private double quantia;
  private String descricao;
  private Transacao transacao;
  private String instante;

  public TransacaoTest() {
    this.quantia = 1000.0;
    this.descricao = "Depósito";
    this.transacao = new Transacao(quantia, descricao);
    this.instante = getInstante();
  }

  private String getInstante() {
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return agora.format(formato);
  }


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    assertEquals(this.quantia, transacao.getQuantia());
    assertEquals(this.descricao, transacao.getDescricao());

  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    assertEquals(this.quantia, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    String resumo = String.format("%s - %s - %s", this.instante, this.quantia, this.descricao);
    assertEquals(resumo, transacao.retornarResumoTransacao());
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    assertEquals(getInstante(), transacao.retornarInstante());
  }

}
