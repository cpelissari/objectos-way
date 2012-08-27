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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class DirsTest {

  private Dirs dirs;

  @BeforeClass
  public void setUp() {
    dirs = Dirs.valueOf(".", "br.com.objectos.waytest");
  }

  public void base_dir_should_be_duh_base_dir() {
    assertThat(dirs.getBaseDir(), equalTo("."));
  }

  public void source_dir_should_be_maven_package_name() {
    String res = dirs.getSourceDir();
    assertThat(res, equalTo("./src/main/java/br/com/objectos/waytest"));
  }

}