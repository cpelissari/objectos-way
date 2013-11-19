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

import static com.google.common.collect.Lists.transform;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.objectos.way.codegen.MethodMetadata;

import com.google.common.base.Function;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
public class Metadata {

  private final Class<?> clazz;

  public static Metadata of(Class<?> clazz) {
    return new Metadata(clazz);
  }

  private Metadata(Class<?> clazz) {
    this.clazz = clazz;
  }

  private String extractPackageName(Class<?> className) {
    try {
      Package package_ = className.getPackage();
      String name = package_.getName();
      return name;
    } catch (Exception e) {
      return e.toString();
    }
  }

  private String extractClassName(Class<?> clazz) {
    try {
      String name = clazz.getName();
      return name;
    } catch (Exception e) {
      return e.toString();
    }
  }

  private List<Class<?>> extractInnerClasses(Class<?> clazz) {
    Class<?>[] innerClasses = clazz.getDeclaredClasses();

    List<Class<?>> list = Arrays.asList(innerClasses);
    return list;
  }

  private List<MethodMetadata> extractMethods(Class<?> clazz) {
    Method[] methods = clazz.getDeclaredMethods();
    List<Method> listMethods = Arrays.asList(methods);

    List<MethodMetadata> listMetadata = transform(listMethods, new ToMethodMetadata());

    return listMetadata;
  }

  private List<MethodMetadata> extractGetters(Class<?> clazz2) {
    Method[] methods = clazz2.getDeclaredMethods();
    List<Method> listMethods = Arrays.asList(methods);

    List<MethodMetadata> listMetadata = transform(listMethods, new ToMethodMetadata());
    List<MethodMetadata> aux = new ArrayList<MethodMetadata>();

    for (int i = 0; i < methods.length; i++) {
      MethodMetadata item = listMetadata.get(i);
      if (item.isGetter()) {
        aux.add(item);
      }
    }
    return aux;
  }

  private static final class ToMethodMetadata implements Function<Method, MethodMetadata> {
    @Override
    public MethodMetadata apply(Method input) {
      return new MethodMetadata(input);
    }
  }

  public String getPackageName() {
    return extractPackageName(clazz);
  }

  public String getClassName() {
    return extractClassName(clazz);
  }

  public List<Class<?>> getInnerClasses() {
    return extractInnerClasses(clazz);
  }

  public List<MethodMetadata> getMethods() {
    return extractMethods(clazz);
  }

  public List<MethodMetadata> getGetters() {
    return extractGetters(clazz);
  }

}