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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import br.com.objectos.way.codegen.MethodMetadata;
import br.com.objectos.way.model.ClassJavaWriter;

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

  public List<Class<?>> extractInnerClasses(Class<?> clazz) {
    Constructor<?>[] constructors = clazz.getConstructors();

    return null;
  }

  public List<MethodMetadata> extractMethods(Class<?> clazz) {
    try {
      Method[] methods = clazz.getDeclaredMethods();
      List<MethodMetadata> list = null;
      return list;
    } catch (Exception e) {
      return null;
    }
  }

  public List<String> extractGetters(Class<ClassJavaWriter> class1) {
    return null;
  }

}