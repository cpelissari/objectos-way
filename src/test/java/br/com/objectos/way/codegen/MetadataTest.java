/*
 * Copyright 2013 Objectons, Fábrica de Software LTDA.
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
package br.com.objectos.way.codegen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.objectos.way.Metadata;
import br.com.objectos.way.model.ClassJavaWriter;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class MetadataTest {

  private Metadata meta;

  @BeforeMethod
  public void setup() {
    meta = new Metadata();
  }

  public void package_name() {
    String res = meta.extractPackageName(ClassJavaWriter.class);

    assertThat(res, equalTo("br.com.objectos.way.model"));
  }

  public void interface_name() {
    String res = meta.extractInterfaceName(ClassJavaWriter.class);

    assertThat(res, equalTo("br.com.objectos.way.model.ClassJavaWriter"));
  }

  public void extract_inner_classes() {
    String path = "/codegen/InnerClass.java";

    List<String> res = meta.extractInnerClasses(ClassJavaWriter.class);

    assertGen(res, path);
  }

  public void extract_methods() {
    String path = "/codegen/Methods.java";

    List<String> res = meta.extractMethods(ClassJavaWriter.class);

    assertGen(res, path);
  }

  public void extract_getters() {
    String path = "/codegen/Getters.java";

    List<String> res = meta.extractGetters(ClassJavaWriter.class);

    assertGen(res, path);
  }

  private void assertGen(List<String> res, String path) {
    String prova = extraiConteudo(path);
    if (!res.equals(prova)) {
      System.out.println(res);
      System.out.println("======================");
      System.out.println(prova);
      System.out.println("_____________________________________________________________");
    }
    assertThat(res.get(0), equalTo(prova));
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