package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe Transacao.
 */
public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;

  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.instante = retornarInstante();
    this.descricao = descricao;
  }

  public double getQuantia() {
    return this.quantia;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public String retornarResumoTransacao() {
    return String.format("%s - %s - %s", this.instante, this.quantia, this.descricao);
  }

  public String retornarInstante() {
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return agora.format(formato);
  }
}

