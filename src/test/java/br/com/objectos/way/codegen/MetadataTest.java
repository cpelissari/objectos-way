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

import br.com.objectos.comuns.base.br.Cep;
import br.com.objectos.way.Metadata;
import br.com.objectos.way.model.ClassJavaWriter;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class MetadataTest {

  private Metadata meta;

  @BeforeMethod
  public void setup() {
    meta = Metadata.of(ClassJavaWriter.class);
  }

  public void package_name() {
    String res = meta.getPackageName();

    assertThat(res, equalTo("br.com.objectos.way.model"));
  }

  public void interface_name() {
    String res = meta.getClassName();

    assertThat(res, equalTo("br.com.objectos.way.model.ClassJavaWriter"));
  }

  public void extract_inner_classes() {
    List<Class<?>> res = meta.getInnerClasses();

    assertThat(res.size(), equalTo(1));
    assertThat(res.get(0), equalTo((Object) ClassJavaWriter.Construtor.class));
  }

  public void extract_methods() {
    List<MethodMetadata> res = meta.getMethods();

    assertThat(res.size(), equalTo(5));

    assertThat(res.get(0).getType(), equalTo((Object) Integer.class));
    assertThat(res.get(0).getName(), equalTo("getId"));

    assertThat(res.get(1).getType(), equalTo((Object) int.class));
    assertThat(res.get(1).getName(), equalTo("getQuantidade"));

    assertThat(res.get(2).getType(), equalTo((Object) String.class));
    assertThat(res.get(2).getName(), equalTo("getNome"));

    assertThat(res.get(3).getType(), equalTo((Object) Cep.class));
    assertThat(res.get(3).getName(), equalTo("getPrefixo"));

    assertThat(res.get(4).getType(), equalTo((Object) void.class));
    assertThat(res.get(4).getName(), equalTo("serializer"));
  }

  public void extract_getters() {
    List<MethodMetadata> res = meta.getGetters();

    assertThat(res.size(), equalTo(4));

    assertThat(res.get(0).getType(), equalTo((Object) Integer.class));
    assertThat(res.get(0).getName(), equalTo("getId"));

    assertThat(res.get(1).getType(), equalTo((Object) int.class));
    assertThat(res.get(1).getName(), equalTo("getQuantidade"));

    assertThat(res.get(2).getType(), equalTo((Object) String.class));
    assertThat(res.get(2).getName(), equalTo("getNome"));

    assertThat(res.get(3).getType(), equalTo((Object) Cep.class));
    assertThat(res.get(3).getName(), equalTo("getPrefixo"));
  }

}