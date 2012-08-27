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

import java.util.Map;

import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ExecutorGuice implements Executor {

  private final Map<String, MainCommand> commandMap;

  @Inject
  public ExecutorGuice(Map<String, MainCommand> commandMap) {
    this.commandMap = commandMap;
  }

  @Override
  public void execute(String... _args) {
    Args args = new Args(_args);

    String commandKey = HelpCommand.NAME;

    for (String key : commandMap.keySet()) {
      if (args.contains(key)) {
        commandKey = key;
        break;
      }
    }

    MainCommand command = commandMap.get(commandKey);
    command.execute(args.remove(commandKey));
  }

}