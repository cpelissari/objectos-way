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
public class CriarJavaWriter {

  private final StringWriter stringWriter = new StringWriter();
  private final JavaWriter javaWriter = new JavaWriter(stringWriter);

  public StringWriter criarTipoDeclaracao() throws IOException {
    javaWriter.emitPackage("br.com.objectos.way");

    javaWriter.beginType("br.com.objectos.way.Foo", "class",
        EnumSet.of(Modifier.PUBLIC, Modifier.FINAL));
    javaWriter.endType();

    return stringWriter;
  }

  public StringWriter criarEnum() throws IOException {
    javaWriter.emitPackage("br.com.objectos.way");
    javaWriter
        .beginType("br.com.objectos.way.Foo", "enum", EnumSet.of(Modifier.PUBLIC));
    javaWriter.emitEnumValue("FUNCIONARIO");
    javaWriter.emitEnumValue("ORGANIZACAO");
    javaWriter.emitEnumValue("USUARIO");
    javaWriter.endType();

    return stringWriter;
  }

}