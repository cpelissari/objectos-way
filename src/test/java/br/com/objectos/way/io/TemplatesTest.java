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
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.comuns.etc.EtcFiles;
import br.com.objectos.way.model.Dirs;
import br.com.objectos.way.model.FakeProjects;
import br.com.objectos.way.model.Project;

import com.google.common.base.Throwables;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TemplatesTest {

  private Templates templates;

  private Project project;

  @BeforeClass
  public void setUp() {
    project = FakeProjects.WAY_TEST_PROJECT;

    templates = Templates
        .foundAtBaseDir(fakeTemplateBaseDir())
        .forProject(project);
  }

  public void simple() throws IOException {
    File template = fakeTemplate("simple.txt");

    File simple = newExpectedFile("simple.txt");
    assertThat(simple.exists(), is(false));

    File res = templates.parse(template);
    assertThat(res, equalTo(simple));
    assertThat(simple.exists(), is(true));

    String lines = EtcFiles.readLines(res);
    assertThat(lines, equalTo("br.com.objectos\nWay Test\nway-test"));
  }

  private File newExpectedFile(String filename) {
    Dirs dirs = project.getDirs();
    File baseDir = dirs.getBaseDirFile();
    return EtcFiles.cleanFile(baseDir, filename);
  }

  private File fakeTemplateBaseDir() {
    try {
      URL url = Resources.getResource(getClass(), "/fake-templates");
      return new File(url.toURI());

    } catch (URISyntaxException e) {
      throw Throwables.propagate(e);

    }
  }

  private File fakeTemplate(String filename) {
    File baseDir = fakeTemplateBaseDir();
    return new File(baseDir, filename);
  }

}