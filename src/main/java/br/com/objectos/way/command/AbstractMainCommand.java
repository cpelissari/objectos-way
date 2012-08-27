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
package br.com.objectos.way.command;

import java.lang.annotation.Annotation;

import com.google.inject.Injector;
import com.google.inject.Key;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class AbstractMainCommand implements MainCommand {

  private final Injector injector;

  public AbstractMainCommand(Injector injector) {
    this.injector = injector;
  }

  @Override
  public final void execute(Args args) {
    Class<? extends Annotation> annotation = getAnnotation();
    Key<CommandExecutor> key = Key.get(CommandExecutor.class, annotation);
    CommandExecutor executor = injector.getInstance(key);
    executor.execute(args);
  }

}