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
package br.com.objectos.way.io;

import java.io.File;

import br.com.objectos.way.model.Project;
import br.com.objectos.way.model.Types;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class TemplateSed {

  private final String templateBaseDir;

  private final File template;

  private final Project project;

  public TemplateSed(String templateBaseDir, File template, Project project) {
    this.templateBaseDir = templateBaseDir;
    this.template = template;
    this.project = project;
  }

  public String get() {
    String baseDir = getBaseDir();
    String fileName = getFileName();
    return baseDir + '/' + fileName;
  }

  public File getFileAt(File parent) {
    File file = new File(parent, get().substring(1));
    File parentFile = file.getParentFile();
    parentFile.mkdirs();
    return file;
  }

  private String getBaseDir() {
    String parent = template.getParent();
    int beginIndex = parent.indexOf(templateBaseDir);

    String baseDir = parent.substring(beginIndex + templateBaseDir.length());
    return filterBaseDirIfNecessary(baseDir);
  }

  private String getFileName() {
    String name = template.getName();

    if (name.endsWith(".java")) {
      Types types = project.getTypes();
      name = types.getPrefix() + name;
    }

    return name;
  }

  private String filterBaseDirIfNecessary(String baseDir) {
    Iterable<String> parts = Splitter.on("/").split(baseDir);
    Iterable<String> filtered = Iterables.transform(parts, new Filter());
    return Joiner.on("/").join(filtered);
  }

  private class Filter implements Function<String, String> {
    @Override
    public String apply(String input) {
      if (input.contains("prefix-package")) {
        Types types = project.getTypes();
        String packageName = types.getPackageName();
        String packageDir = packageName.replaceAll("\\.", "/");
        return input.replaceAll("prefix-package", packageDir);

      } else if (input.contains("prefix-shortname")) {
        String shortName = project.getShortName();
        return input.replaceAll("prefix-shortname", shortName);

      } else {
        return input;

      }
    }
  }

}