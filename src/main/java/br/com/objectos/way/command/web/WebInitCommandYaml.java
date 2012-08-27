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

import java.io.File;
import java.io.IOException;

import org.yaml.snakeyaml.Yaml;

import br.com.objectos.way.model.Project;
import br.com.objectos.way.model.Yamls;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class WebInitCommandYaml {

  public void execute(WebInitOptions options) {
    try {
      tryToExecute(options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void tryToExecute(WebInitOptions options) throws IOException {
    Project project = options.toProject();

    Yaml yaml = Yamls.newYaml();
    String dump = yaml.dump(project);

    File workingDir = getWorkingDir();
    File dir = new File(workingDir, options.getDirectory());
    File file = new File(dir, "way.yaml");
    Files.write(dump, file, Charsets.UTF_8);
  }

  private File getWorkingDir() {
    String userDir = System.getProperty("user.dir");
    return new File(userDir);
  }

}