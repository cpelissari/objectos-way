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
package br.com.objectos.way.command.web;

import static br.com.objectos.comuns.etc.EtcFiles.readLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.way.WayTestModule;
import br.com.objectos.way.model.Dirs;
import br.com.objectos.way.model.FakeProjects;
import br.com.objectos.way.model.Project;

import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
@Guice(modules = { WayTestModule.class })
public class WebInitCommandYamlTest {

  @Inject
  private WebInitCommandYaml command;

  public void with_default_options() throws IOException {
    WebInitOptions options = new WebInitOptions();
    Project project = options.toProject();

    File yaml = getYaml();
    assertThat(yaml.exists(), is(false));

    command.execute(project);

    assertThat(yaml.exists(), is(true));

    String res = readLines(yaml);
    assertThat(res, equalTo(readLines("/web/way.default.yaml")));
  }

  public void with_defined_options() throws IOException {
    Project project = FakeProjects.WAY_TEST_PROJECT;
    Dirs dirs = project.getDirs();
    File yaml = new File(dirs.getBaseDirFile(), "way.yaml");
    yaml.delete();

    assertThat(yaml.exists(), is(false));

    command.execute(project);

    assertThat(yaml.exists(), is(true));

    String res = readLines(yaml);
    assertThat(res, equalTo(readLines("/web/way.yaml")));
  }

  private File getYaml() {
    File yaml = new File("way.yaml");
    yaml.delete();
    return yaml;
  }

}