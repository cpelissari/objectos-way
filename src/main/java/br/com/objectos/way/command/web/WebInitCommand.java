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

import br.com.objectos.comuns.cli.AbstractCommand;
import br.com.objectos.way.model.Project;

import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class WebInitCommand extends AbstractCommand<WebInitOptions> {

  private final WebInitCommandYaml yaml;

  @Inject
  public WebInitCommand(WebInitCommandYaml yaml) {
    this.yaml = yaml;
  }

  @Override
  public String getName() {
    return Web.INIT.getName();
  }

  @Override
  protected WebInitOptions getNewOptions() {
    return new WebInitOptions();
  }

  @Override
  protected void executeWithOptions(WebInitOptions options) {
    Project project = options.toProject();

    yaml.execute(project);
  }

}