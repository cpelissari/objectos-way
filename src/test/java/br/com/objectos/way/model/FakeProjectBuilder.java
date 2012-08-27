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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class FakeProjectBuilder implements Project.Builder {

  private String group;

  private String name;

  private String shortName;

  private String baseDir = ".";

  @Override
  public Project build() {
    return new Project(this);
  }

  public FakeProjectBuilder group(String group) {
    this.group = group;
    return this;
  }

  public FakeProjectBuilder name(String name) {
    this.name = name;
    return this;
  }

  public FakeProjectBuilder shortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public FakeProjectBuilder baseDir(String baseDir) {
    this.baseDir = baseDir;
    return this;
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
    return baseDir;
  }

}