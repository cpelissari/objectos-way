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

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.objectos.way.Metadata;
import br.com.objectos.way.model.ClassJavaWriter;

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
    List<Class<?>> res = meta.extractInnerClasses(ClassJavaWriter.class);

    String className = res.get(0).getName();
    assertThat(className, equalTo("Construtor"));
  }

  public void extract_methods() {
    List<MethodMetadata> res = meta.extractMethods(ClassJavaWriter.class);

    assertThat(res.size(), equalTo(4));

    assertThat(res.get(0).getReturnType(), equalTo("class java.lang.Integer"));
    assertThat(res.get(0).getName(), equalTo("getId"));

    assertThat(res.get(1).getReturnType(), equalTo("int"));
    assertThat(res.get(1).getName(), equalTo("getQuantidade"));

    assertThat(res.get(2).getReturnType(), equalTo("java.lang.String"));
    assertThat(res.get(2).getName(), equalTo("getNome"));

    assertThat(res.get(3).getReturnType(), equalTo("int"));
    assertThat(res.get(3).getName(), equalTo("getPrefixo"));
  }

  public void extract_getters() {
    List<String> res = meta.extractGetters(ClassJavaWriter.class);

    assertThat(res.get(0), equalTo("Construtor"));
  }

}