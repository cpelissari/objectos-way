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
import java.net.URISyntaxException;
import java.net.URL;

import br.com.objectos.way.io.Templates;
import br.com.objectos.way.model.Project;

import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class WebInitCommandTemplatesWeb {

  public void execute(Project project) {
    try {
      tryToExecute(project);

    } catch (URISyntaxException e) {
      throw new WebCommandException(e);

    } catch (IOException e) {
      throw new WebCommandException(e);

    }
  }

  private void tryToExecute(Project project) throws URISyntaxException, IOException {
    Templates
        .foundAtBaseDir(templateBaseDir("/templates/common"))
        .forProject(project)
        .parseAll();

    Templates
        .foundAtBaseDir(templateBaseDir("/templates/web"))
        .forProject(project)
        .parseAll();
  }

  private File templateBaseDir(String resource) throws URISyntaxException {
    URL url = Resources.getResource(getClass(), resource);
    return new File(url.toURI());
  }

}