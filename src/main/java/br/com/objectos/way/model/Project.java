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

import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Project {

  public static interface Builder extends br.com.objectos.way.Builder<Project> {

    String getGroup();
    String getName();
    String getShortName();

    String getBaseDir();

  }

  private String group;
  private String name;
  private String shortName;

  private Comments comments;
  private Dirs dirs;
  private Types types;

  public Project() {
  }

  public Project(Builder builder) {
    group = builder.getGroup();
    name = builder.getName();
    shortName = builder.getShortName();

    fixShortNameIfNecessary();

    comments = new Comments();

    types = Types.valueOf(this);

    String baseDir = builder.getBaseDir();
    dirs = Dirs.valueOf(baseDir, types.getPackageName());
  }

  public String getGroup() {
    return group;
  }

  public String getName() {
    return name;
  }

  public String getShortName() {
    return shortName;
  }

  public Comments getComments() {
    return comments;
  }

  public Dirs getDirs() {
    return dirs;
  }

  public Types getTypes() {
    return types;
  }

  private void fixShortNameIfNecessary() {
    if (Strings.isNullOrEmpty(shortName)) {
      shortName = br.com.objectos.comuns.base.Strings
          .whitespaceTo(name, "-")
          .accentsToAscii()
          .toString()
          .toLowerCase();
    }
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public void setComments(Comments comments) {
    this.comments = comments;
  }

  public void setDirs(Dirs dirs) {
    this.dirs = dirs;
  }

  public void setTypes(Types types) {
    this.types = types;
  }

}