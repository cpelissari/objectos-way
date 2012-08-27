/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.model;

import static br.com.objectos.way.model.FakeProjects.ACAO_POSITIVA_PROJECT;
import static br.com.objectos.way.model.FakeProjects.WAY_TEST_PROJECT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TypesTest {

  private Types acaoPositiva;
  private Types wayTest;

  @BeforeClass
  public void setUp() {
    acaoPositiva = Types.valueOf(ACAO_POSITIVA_PROJECT);
    wayTest = Types.valueOf(WAY_TEST_PROJECT);
  }

  public void prefix_should_be_name_camel_cased() {
    String prefix = wayTest.getPrefix();
    assertThat(prefix, equalTo("WayTest"));
  }

  public void prefix_should_not_strip_accents() {
    String prefix = acaoPositiva.getPrefix();
    assertThat(prefix, equalTo("AcaoPositiva"));
  }

  public void package_should_be_group_plus_name_lowercased() {
    String packageName = wayTest.getPackageName();
    assertThat(packageName, equalTo("br.com.objectos.waytest"));
  }

}