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
package br.com.objectos.way.command.help;

import java.lang.annotation.Annotation;

import br.com.objectos.comuns.cli.AbstractCommandModule;
import br.com.objectos.comuns.cli.Command;
import br.com.objectos.comuns.cli.CommandKey;

import com.google.inject.multibindings.MapBinder;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class HelpCommandModule extends AbstractCommandModule {

  @Override
  protected Class<? extends Annotation> getAnnotation() {
    return Help.class;
  }

  @Override
  protected CommandKey getDefaultKey() {
    return Help.WEB;
  }

  @Override
  protected void bindCommands(MapBinder<CommandKey, Command> commands) {
    commands.addBinding(Help.WEB).to(HelpWebCommand.class);
  }

}