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

import br.com.objectos.comuns.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Types {

  public static interface Builder extends br.com.objectos.way.Builder<Types> {

    String getPrefix();

    String getPackageName();

  }

  private String prefix;
  private String packageName;

  public Types() {
  }

  Types(Builder builder) {
    prefix = builder.getPrefix();
    packageName = builder.getPackageName();
  }

  public static Types valueOf(Project project) {
    return new FromProject(project).build();
  }

  public String getPrefix() {
    return prefix;
  }

  public String getPackageName() {
    return packageName;
  }

  public String getClassName(String suffix) {
    return prefix + suffix;
  }
  public String getSubPackage(String sub) {
    return packageName + "." + sub;
  }

  private static class FromProject implements Builder {

    private final Project project;

    public FromProject(Project project) {
      this.project = project;
    }

    @Override
    public Types build() {
      return new Types(this);
    }

    @Override
    public String getPrefix() {
      String name = project.getName();
      return Strings.accentsToAscii(name)
          .camelCase()
          .toString();
    }

    @Override
    public String getPackageName() {
      String group = project.getGroup();
      String name = project.getName();

      String packageName = group + '.' + name;

      return Strings.accentsToAscii(packageName)
          .stripWhitespace()
          .toString()
          .toLowerCase();
    }

  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

}