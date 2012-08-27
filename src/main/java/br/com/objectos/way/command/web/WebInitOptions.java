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

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import br.com.objectos.way.command.Options;
import br.com.objectos.way.model.Project;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Parameters(separators = " ")
public class WebInitOptions implements Options {

  @Parameter(names = "--group")
  public String group = "br.com.objectos";

  @Parameter(names = "--name")
  public String name = "New project";

  @Parameter(names = "--short-name")
  public String shortName = "project";

  @Parameter
  public List<String> directory = newArrayList();

  public String getDirectory() {
    if (directory.isEmpty()) {
      directory.add(".");
    }
    return directory.get(0);
  }

  public Project toProject() {
    return new ProjectBuilder().build();
  }

  private class ProjectBuilder implements Project.Builder {

    @Override
    public Project build() {
      return new Project(this);
    }

    @Override
    public String getGroup() {
      return group;
    }

    @Override
    public String getName() {
      return name;
    }

    @Override
    public String getShortName() {
      return shortName;
    }

    @Override
    public String getBaseDir() {
      return getDirectory();
    }

  }

}