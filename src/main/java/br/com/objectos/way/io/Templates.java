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
import java.io.FileInputStream;
import java.io.IOException;

import org.mvel2.templates.TemplateRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.objectos.way.model.Dirs;
import br.com.objectos.way.model.Project;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Templates {

  private static final Logger logger = LoggerFactory.getLogger(Templates.class);

  private final File templateBaseDir;

  private final String templateBaseDirPath;

  private final Project project;

  private Templates(File templateBaseDir, Project project) {
    this.templateBaseDir = templateBaseDir;
    this.templateBaseDirPath = templateBaseDir.getAbsolutePath();
    this.project = project;
  }

  public static Builder foundAtBaseDir(File templateBaseDir) {
    return new Builder(templateBaseDir);
  }

  public void parseAll() {
    parseAllDir(templateBaseDir);
  }

  private void parseAllDir(File dir) {
    for (File child : dir.listFiles()) {
      if (child.isDirectory()) {
        parseAllDir(child);

      } else {
        parse(child);

      }
    }
  }

  public File parse(File template) {
    try {
      Preconditions.checkArgument(template.isFile());
      String text = templateToString(template);

      File dest = destinationFileOf(template);

      Files.write(text, dest, Charsets.UTF_8);

      return dest;
    } catch (IOException e) {
      logger.error("Error trying to write result file: " + template, e);
      throw new TemplateException(e);
    }
  }

  private String templateToString(File template) {
    try {
      FileInputStream templateStream = Files.newInputStreamSupplier(template).getInput();
      Object result = TemplateRuntime.eval(templateStream, project);
      return result.toString();
    } catch (IOException e) {
      logger.error("Could not parse template file: " + template, e);
      throw new TemplateException(e);
    }
  }

  private File destinationFileOf(File template) {
    Dirs dirs = project.getDirs();

    return new TemplateSed(templateBaseDirPath, template, project)
        .getFileAt(dirs.getBaseDirFile());
  }

  public static class Builder {

    private final File templateBaseDir;

    private Builder(File templateBaseDir) {
      this.templateBaseDir = Preconditions.checkNotNull(templateBaseDir);
    }

    public Templates forProject(Project project) {
      Preconditions.checkNotNull(project);
      return new Templates(templateBaseDir, project);
    }

  }

}