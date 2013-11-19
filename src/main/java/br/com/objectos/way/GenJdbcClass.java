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

import java.util.List;

import br.com.objectos.way.codegen.MethodMetadata;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
public class GenJdbcClass {

  private final Class<?> clazz;

  private Metadata meta;
  private final Metadata instance;

  private CriarJavaWriter write;

  public static GenJdbcClass of(Class<?> clazz) {
    return new GenJdbcClass(clazz);
  }

  private GenJdbcClass(Class<?> clazz) {
    this.clazz = clazz;
    instance = meta.of(clazz);
    write.criarClasse();
  }

  public String createClassInit() {
    String className = instance.getClassName();

    return null;
  }

  public String createAttributes() {
    return null;
  }

  public String createConstructors() {
    List<Class<?>> innerClasses = instance.getInnerClasses();
    return null;
  }

  public String createGetters() {
    List<MethodMetadata> getters = instance.getGetters();
    return null;
  }

}