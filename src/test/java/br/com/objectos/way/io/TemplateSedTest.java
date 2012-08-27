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
package br.com.objectos.way.io;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import br.com.objectos.way.model.FakeProjects;
import br.com.objectos.way.model.Project;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TemplateSedTest {

  private final String templateBaseDir = "/whatever/templates";

  private final Project project = FakeProjects.WAY_TEST_PROJECT;

  public void normal_case() {
    TemplateSed sed = sedOf("/simple.txt");
    assertThat(sed.get(), equalTo("/simple.txt"));
  }

  public void normal_case_subdirs() {
    TemplateSed sed = sedOf("/sub1/sub2/sub3/simple.txt");
    assertThat(sed.get(), equalTo("/sub1/sub2/sub3/simple.txt"));
  }

  public void prefix_java_file() {
    TemplateSed sed = sedOf("/src/main/java/Foo.java");
    assertThat(sed.get(), equalTo("/src/main/java/WayTestFoo.java"));
  }

  public void prefix_package() {
    TemplateSed sed = sedOf("/src/main/java/prefix-package/whatever.txt");
    assertThat(sed.get(), equalTo("/src/main/java/br/com/objectos/waytest/whatever.txt"));
  }

  public void prefix_shortname() {
    TemplateSed sed = sedOf("/src/main/webapp/prefix-shortname-js/my.js");
    assertThat(sed.get(), equalTo("/src/main/webapp/way-test-js/my.js"));
  }

  private TemplateSed sedOf(String filename) {
    File file = new File(templateBaseDir, filename);
    return new TemplateSed(templateBaseDir, file, project);
  }

}