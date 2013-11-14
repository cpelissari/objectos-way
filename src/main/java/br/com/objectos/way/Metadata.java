/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Metadata {

  public String extractPackageName(Class<?> className) {
    try {
      Package package_ = className.getPackage();
      String name = package_.getName();
      return name;
    } catch (Exception e) {
      return e.toString();
    }
  }

  public String extractInterfaceName(Class<?> clazz) {
    try {
      String name = clazz.getName();
      return name;
    } catch (Exception e) {
      return e.toString();
    }
  }

  public List<String> extractInnerClasses(Class<?> clazz) {
    return null;
  }

  public List<String> extractMethods(Class<?> clazz) {
    Method[] m = clazz.getMethods();

    return null;
  }

  public List<String> extractGetters(Class<?> clazz) {
    return null;
  }

  private String extraiConteudo(String nameClass) {
    try {
      URL url = Resources.getResource(getClass(), nameClass);
      return Resources.toString(url, Charsets.UTF_8);
    } catch (IOException e) {
      return "";
    }
  }

}