package br.com.objectos.way.codegen;

import br.com.fake.Construtor;

public class ClassJavaWriterJdbc {

  public ClassJavaWriterJdbc(Construtor construtor) {
    this.id = construtor.getId();
    this.quantidade = construtor.getQuantidade();
    this.nome = construtor.getNome();
    this.prefixo = construtor.getPrefixo();
  }

}
