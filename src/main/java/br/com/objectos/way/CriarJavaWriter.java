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
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
class CriarJavaWriter {

  public String criarPacote() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);
    try {
      javaWriter.emitPackage("br.com.objectos.way.codegen");
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarImport() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);
    try {
      javaWriter.emitImports("com.whatever.Import0");
      javaWriter.emitEmptyLine();
      javaWriter.emitImports("br.com.objectos.way.codegen.Import1");
      javaWriter.emitImports("br.com.objectos.way.codegen.Import2");
      javaWriter.emitImports("br.com.objectos.way.codegen.Import3");
      javaWriter.emitImports("br.com.objectos.way.codegen.Import4");
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarComentarioAutor() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);

    try {
      javaWriter.emitEmptyLine();
      javaWriter
          .emitJavadoc("@author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)");
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }
  public String criarClasse() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);
    try {
      javaWriter.emitPackage("br.com.objectos.way.codegen");
      javaWriter.beginType("br.com.objectos.way.codegen.ClassJavaWriterJdbc", "class",
          EnumSet.of(Modifier.PUBLIC));
      javaWriter.endType();
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarImplements() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);

    try {
      javaWriter.emitPackage("br.com.objectos.way.codegen");
      javaWriter.beginType("br.com.objectos.way.codegen.ClassJavaWriterJdbc", "class",
          EnumSet.noneOf(Modifier.class), "br.com.objectos.comuns.cli.Command");
      javaWriter.endType();
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarVariaveis() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);

    try {
      javaWriter
          .emitField("java.lang.String", "nome", EnumSet.of(Modifier.PRIVATE, Modifier.FINAL));

      javaWriter.emitField("java.lang.Integer", "id", EnumSet.of(Modifier.PRIVATE));
      javaWriter.emitEmptyLine();
      javaWriter.emitField("int", "quantidade", EnumSet.of(Modifier.PRIVATE, Modifier.FINAL));

      javaWriter.emitField("br.com.objectos.comuns.base.br.Cep", "prefixo",
          EnumSet.of(Modifier.PRIVATE, Modifier.FINAL));
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarConstrutor() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);

    try {
      javaWriter.emitPackage("br.com.objectos.way.codegen");
      javaWriter.beginMethod(null, "br.com.objectos.way.codegen.ClassJavaWriterJdbc",
          EnumSet.of(Modifier.PUBLIC), "br.com.riskoffice.ro.org.previdencia.Construtor",
          "construtor");
      javaWriter.endMethod();
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarAnotacao() {
    StringWriter writer = new StringWriter();
    JavaWriter javaWriter = new JavaWriter(writer);

    try {
      javaWriter.emitPackage("br.com.objectos.way.codegen");
      // javaWriter.emitAnnotation("javax.inject.Singleton");
      javaWriter.emitAnnotation(SuppressWarnings.class,
          JavaWriter.stringLiteral("unchecked"));
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  public String criarMetodoInsert() {
    return "";
  }

  public String criarGetters() {
    return "";
  }

  public String criaComentarioInicio() {
    return "";
  }

}