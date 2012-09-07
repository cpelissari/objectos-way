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

import br.com.objectos.comuns.cli.AbstractCliModule;
import br.com.objectos.comuns.cli.MainCommand;
import br.com.objectos.way.command.help.HelpCommandModule;
import br.com.objectos.way.command.web.WebCommandModule;

import com.google.inject.multibindings.MapBinder;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class WayCommandModule extends AbstractCliModule {

  @Override
  protected String getDefaultMainCommand() {
    return HelpCommand.NAME;
  }

  @Override
  protected void bindMainCommands(MapBinder<String, MainCommand> commands) {
    commands.addBinding(HelpCommand.NAME).to(HelpCommand.class);
    commands.addBinding(WebCommand.NAME).to(WebCommand.class);
  }

  @Override
  protected void installCommands() {
    install(new HelpCommandModule());
    install(new WebCommandModule());
  }

}