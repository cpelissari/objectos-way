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

import static br.com.objectos.way.model.FakeUsers.USER_A;
import static br.com.objectos.way.model.Yamls.newYaml;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class GlobalYamlTest {

  public void global_dump() {
    Global global = global()
        .user(USER_A)
        .build();

    Yaml yaml = newYaml();
    String res = yaml.dump(global);

    assertThat(res, equalTo("user:\n  email: a@objectos.com.br\n  name: User A\n"));
  }

  public void global_read() {
    Global global = global()
        .user(USER_A)
        .build();

    Yaml yaml = newYaml();
    String data = yaml.dump(global);
    Global res = yaml.loadAs(data,
        Global.class);

    User user = res.getUser();
    assertThat(user.getName(), equalTo(USER_A.getName()));
    assertThat(user.getEmail(), equalTo(USER_A.getEmail()));
  }

  private FakeGlobalBuilder global() {
    return new FakeGlobalBuilder();
  }

}