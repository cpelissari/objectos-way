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
package br.com.objectos.way.command.web;

import java.lang.annotation.Annotation;

import br.com.objectos.way.command.AbstractCommandModule;
import br.com.objectos.way.command.Command;
import br.com.objectos.way.command.CommandKey;
import br.com.objectos.way.command.help.Help;

import com.google.inject.multibindings.MapBinder;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class WebCommandModule extends AbstractCommandModule {

  @Override
  protected Class<? extends Annotation> getAnnotation() {
    return Web.class;
  }

  @Override
  protected CommandKey getDefaultKey() {
    return Help.WEB;
  }

  @Override
  protected void bindCommands(MapBinder<CommandKey, Command> commands) {
    commands.addBinding(Web.INIT).to(WebInitCommand.class);
  }

}