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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.objectos.way.model.ClassJavaWriter;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class GenJdbcClassTest {

  private GenJdbcClass gen;

  @BeforeMethod
  public void setup() {
    gen = GenJdbcClass.of(ClassJavaWriter.class);
  }

  public void create_jdbc_package_and_class_() {
    String path = "/codegenjdbc/InterfaceName.java";

    String res = gen.createClassInit();

    assertGen(res, path);
  }

  public void create_jdbc_attributes() {
    String path = "/codegenjdbc/Attributes.java";

    String res = gen.createAttributes();

    assertGen(res, path);
  }

  public void create_jdbc_constructor() {
    String path = "/codegenjdbc/Constructor.java";

    String res = gen.createConstructors();

    assertGen(res, path);
  }

  public void create_jdbc_getters() {
    String path = "/codegenjdbc/Getters.java";

    String res = gen.createGetters();

    assertGen(res, path);
  }

  private void assertGen(String res, String path) {
    String prova = extraiConteudo(path);
    if (!res.equals(prova)) {
      System.out.println(res);
      System.out.println("======================");
      System.out.println(prova);
      System.out.println("_____________________________________________________________");
    }
    assertThat(res, equalTo(prova));
  }
  private String extraiConteudo(String path) {
    try {
      URL url = Resources.getResource(getClass(), path);
      return Resources.toString(url, Charsets.UTF_8);
    } catch (IOException e) {
      return "";
    }
  }
}