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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.way.WayTestModule;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
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

    File yaml = getYaml();

    command.execute(options);

    assertThat(yaml.exists(), is(true));

    List<String> res = readLines(yaml);
    assertThat(res.size(), equalTo(3));
    assertThat(res.get(0), equalTo("group: " + options.group));
    assertThat(res.get(1), equalTo("name: " + options.name));
    assertThat(res.get(2), equalTo("shortName: " + options.shortName));
  }

  private File getYaml() {
    File yaml = new File("way.yaml");
    yaml.delete();
    return yaml;
  }

  private List<String> readLines(File file) throws IOException {
    return Files.readLines(file, Charsets.UTF_8);
  }

}