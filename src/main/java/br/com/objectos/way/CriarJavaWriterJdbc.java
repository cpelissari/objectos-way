/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way;

import java.io.IOException;
import java.io.StringWriter;
import java.util.EnumSet;

import javax.lang.model.element.Modifier;

import com.squareup.javawriter.JavaWriter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CriarJavaWriterJdbc {

  private final StringWriter writer = new StringWriter();
  private final JavaWriter javaWriter = new JavaWriter(writer);

  public String criaClasseJdbc() {
    String coment = "Copyright 2013 Objectos, Fábrica de Software LTDA.\n\n" +
        "Licensed under the Apache License, Version 2.0 (the \"License\"); you may not\n" +
        "use this file except in compliance with the License. You may obtain a copy of\n" +
        "the License at\n\n" +
        "http://www.apache.org/licenses/LICENSE-2.0\n\n" +
        "Unless required by applicable law or agreed to in writing, software\n" +
        "distributed under the License is distributed on an \"AS IS\"BASIS, WITHOUT\n" +
        "WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the\n" +
        "License for the specific language governing permissions and limitations under\n" +
        "the License.";
    try {
      javaWriter.emitEmptyLine();
      javaWriter.emitJavadoc(coment);

      javaWriter.emitPackage("br.com.objectos.way.codegen");

      javaWriter.emitImports("com.whatever.Import0");
      javaWriter.emitEmptyLine();
      javaWriter.emitImports("br.com.objectos.way.codegen.Import1");
      javaWriter.emitImports("br.com.objectos.way.codegen.Import2");
      javaWriter.emitImports("br.com.objectos.way.codegen.Import3");
      javaWriter.emitImports("br.com.objectos.way.codegen.Import4");
      javaWriter.emitImports("br.com.objectos.comuns.cli.Command");
      javaWriter.emitImports("br.com.objectos.comuns.base.br.Cep");
      javaWriter.emitEmptyLine();

      String type = javaWriter.compressType("br.com.objectos.comuns.cli.Command");
      javaWriter.beginType("br.com.objectos.way.codegen.ClassJavaWriterJdbc", "class",
          criaModificadorDefault(), null, type);

      javaWriter.emitEmptyLine();
      javaWriter.emitField("java.lang.Integer", "id", criaModificadorPrivate());
      javaWriter.emitEmptyLine();
      javaWriter.emitField("int", "quantidade", criaModificadorPrivateFinal());
      javaWriter.emitEmptyLine();
      javaWriter
          .emitField("java.lang.String", "nome", criaModificadorPrivateFinal());
      javaWriter.emitEmptyLine();
      String typeCep = javaWriter.compressType("br.com.objectos.comuns.base.br.Cep");
      javaWriter.emitField(typeCep, "prefixo",
          criaModificadorPrivateFinal());
      javaWriter.emitEmptyLine();

      javaWriter.emitEmptyLine();
      String typeConstrutor = javaWriter.compressType("br.com.fake.Construtor");
      javaWriter.beginMethod(null, "br.com.objectos.way.codegen.ClassJavaWriterJdbc",
          EnumSet.of(Modifier.PUBLIC), typeConstrutor, "construtor");
      javaWriter.emitStatement("this.id = construtor.getId()");
      javaWriter.emitStatement("this.quantidade = construtor.getQuantidade()");
      javaWriter.emitStatement("this.nome = construtor.getNome()");
      javaWriter.emitStatement("this.prefixo = construtor.getPrefixo()");
      javaWriter.endMethod();
      javaWriter.emitEmptyLine();

      javaWriter.beginMethod("Insert", "getInsert", EnumSet.of(Modifier.PUBLIC));
      javaWriter
          .emitStatement("return Insert.into(\"WAY.ENTIDADES\")\n  .value(\"ID\", id)\n  .value(\"QUANTIDADE\", quantidade)\n  .value(\"NOME\", nome)\n  .value(\"PREFIXO\", prefixo)");
      javaWriter.endMethod();
      javaWriter.emitEmptyLine();

      javaWriter.emitEmptyLine();
      javaWriter.beginMethod("java.lang.Integer", "getId", criaModificadorPublic());
      javaWriter.emitStatement("return id");
      javaWriter.endMethod();
      javaWriter.emitEmptyLine();
      javaWriter.beginMethod("int", "getQuantidade", EnumSet.of(Modifier.PUBLIC));
      javaWriter.emitStatement("return quantidade");
      javaWriter.endMethod();
      javaWriter.emitEmptyLine();
      javaWriter.beginMethod("java.lang.String", "getNome", EnumSet.of(Modifier.PUBLIC));
      javaWriter.emitStatement("return name");
      javaWriter.endMethod();
      javaWriter.emitEmptyLine();
      javaWriter.beginMethod("int", "getPrefixo", EnumSet.of(Modifier.PUBLIC));
      javaWriter.emitStatement("return prefixo");
      javaWriter.endMethod();

      javaWriter.emitEmptyLine();

      javaWriter.endType();

      return writer.toString();
    } catch (IOException e) {
      return "";
    } finally {
      try {
        javaWriter.close();
      } catch (IOException e) {
        return "";
      }
    }
  }

  private EnumSet<Modifier> criaModificadorPublic() {
    EnumSet<Modifier> modificador = EnumSet.of(Modifier.PUBLIC);
    return modificador;
  }

  private EnumSet<Modifier> criaModificadorPrivate() {
    EnumSet<Modifier> modificador = EnumSet.of(Modifier.PRIVATE);
    return modificador;
  }

  private EnumSet<Modifier> criaModificadorPrivateFinal() {
    EnumSet<Modifier> modificador = EnumSet.of(Modifier.PRIVATE, Modifier.FINAL);
    return modificador;
  }

  private EnumSet<Modifier> criaModificadorDefault() {
    EnumSet<Modifier> modificador = EnumSet.noneOf(Modifier.class);
    return modificador;
  }

}