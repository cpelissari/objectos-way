package br.com.objectos.way.codegen;

import br.com.objectos.comuns.relational.jdbc.Insert;

public class ClassJavaWriterJdbc {

  public Insert getInsert() {
    return Insert.into("WAY.ENTIDADES")
          .value("ID", id)
          .value("QUANTIDADE", quantidade)
          .value("NOME", nome)
          .value("PREFIXO", prefixo);
  }

}
