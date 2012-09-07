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
package br.com.objectos.way.model;

import br.com.objectos.comuns.etc.AbstractEtcModule;
import br.com.objectos.comuns.etc.model.Global;
import br.com.objectos.comuns.etc.model.User;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class WayModelModule extends AbstractEtcModule {

  @Override
  protected void configureEtc() {
    bindConfigClass(Global.class);
    bindConfigClass(br.com.objectos.comuns.etc.model.Dirs.class);
    bindConfigClass(User.class);

    bindConfigClass(Project.class);
    bindConfigClass(Comments.class);
    bindConfigClass(Dirs.class);
    bindConfigClass(Types.class);
  }

}