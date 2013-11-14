
/**
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way.codegen;

import com.whatever.Import0;

import br.com.objectos.way.codegen.Import1;
import br.com.objectos.way.codegen.Import2;
import br.com.objectos.way.codegen.Import3;
import br.com.objectos.way.codegen.Import4;
import br.com.objectos.comuns.cli.Command;
import br.com.objectos.comuns.base.br.Cep;

class ClassJavaWriterJdbc
implements Command {

  private Integer id;

  private final int quantidade;

  private final String nome;

  private final Cep prefixo;

  public ClassJavaWriterJdbc(Construtor construtor) {
    this.id = construtor.getId();
    this.quantidade = construtor.getQuantidade();
    this.nome = construtor.getNome();
    this.prefixo = construtor.getPrefixo();
  }

  public Insert getInsert() {
    return Insert.into("WAY.ENTIDADES")
        .value("ID", id)
        .value("QUANTIDADE", quantidade)
        .value("NOME", nome)
        .value("PREFIXO", prefixo);
  }

  public Integer getId() {
    return id;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public String getNome() {
    return name;
  }

  public int getPrefixo() {
    return prefixo;
  }
  
}
