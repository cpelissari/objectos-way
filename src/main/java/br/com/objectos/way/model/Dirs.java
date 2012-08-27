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

import java.io.File;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Dirs {

  public static interface Builder extends br.com.objectos.way.Builder<Dirs> {

    String getBaseDir();

    String getSourceDir();

  }

  private final transient File workingDir;

  private String baseDir;

  private String sourceDir;

  public Dirs() {
    workingDir = getWorkingDir();
  }

  Dirs(Builder builder) {
    workingDir = getWorkingDir();

    baseDir = builder.getBaseDir();
    sourceDir = builder.getSourceDir();
  }

  public static Dirs valueOf(String baseDir, String packageName) {
    return new FromBaseDir(baseDir, packageName).build();
  }

  public String getBaseDir() {
    return baseDir;
  }

  public String getSourceDir() {
    return sourceDir;
  }

  public File getBaseDirFile() {
    return new File(workingDir, baseDir);
  }

  public File getSourceDirFile() {
    return new File(workingDir, sourceDir);
  }

  public File getSourceDirFile(String child) {
    File sourceDir = getSourceDirFile();
    return new File(sourceDir, child);
  }

  public void setBaseDir(String baseDir) {
    this.baseDir = baseDir;
  }

  public void setSourceDir(String sourceDir) {
    this.sourceDir = sourceDir;
  }

  private File getWorkingDir() {
    String userDir = System.getProperty("user.dir");
    return new File(userDir);
  }

  private static class FromBaseDir implements Builder {

    private final String baseDir;

    private final String packageName;

    public FromBaseDir(String baseDir, String packageName) {
      this.baseDir = baseDir;
      this.packageName = packageName;
    }

    @Override
    public Dirs build() {
      return new Dirs(this);
    }

    @Override
    public String getBaseDir() {
      return baseDir;
    }

    @Override
    public String getSourceDir() {
      String packageDir = packageName.replaceAll("\\.", "/");
      return String.format("%s/src/main/java/%s", baseDir, packageDir);
    }
  }

}