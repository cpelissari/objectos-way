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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class TesteDeCriarJavaWriter {

  private CriarJavaWriter write;

  @BeforeMethod
  public void setup() {
    write = new CriarJavaWriter();
  }

  public void comentario_inicio() {
    String path = "/codegen/ComentarioInicio.java";

    String res = write.criaComentarioInicio();

    assertGen(res, path);
  }

  public void pacote() {
    String path = "/codegen/Pacote.java";

    String res = write.criarPacote();

    assertGen(res, path);
  }

  public void import_test() {
    String path = "/codegen/Import.java";

    String res = write.criarImport();

    assertGen(res, path);
  }

  public void comentario_autor() {
    String path = "/codegen/ComentarioAutor.java";

    String res = write.criarComentarioAutor();

    assertGen(res, path);
  }

  public void classe() {
    String path = "/codegen/Classe.java";

    String res = write.criarClasse();

    assertGen(res, path);
  }

  public void implements_() {
    String path = "/codegen/Implements.java";

    String res = write.criarImplements();

    assertGen(res, path);
  }

  public void variaveis() {
    String path = "/codegen/Variaveis.java";

    String res = write.criarVariaveis();

    assertGen(res, path);
  }

  public void contrutor() {
    String path = "/codegen/Construtor.java";

    String res = write.criarConstrutor();

    assertGen(res, path);
  }

  public void anotacao() {
    String path = "/codegen/Anotacao.java";

    String res = write.criarAnotacao();

    assertGen(res, path);
  }

  public void metodo_insert() {
    String path = "/codegen/MetodoInsert.java";

    String res = write.criarMetodoInsert();

    assertGen(res, path);
  }

  public void getters() {
    String path = "/codegen/Getters.java";

    String res = write.criarGetters();

    assertGen(res, path);
  }

  private void assertGen(String res, String path) {
    String prova = extraiConteudo(path);
    if (!res.equals(path)) {
      System.out.println(res);
      System.out.println("======================");
      System.out.println(prova);
      System.out.println("_____________________________________________________________");
    }
    assertThat(res, equalTo(prova));
  }
  private String extraiConteudo(String path) {
    try {
      URL url = Resources.getResource(getClass(), path);
      return Resources.toString(url, Charsets.UTF_8);
    } catch (IOException e) {
      return "";
    }
  }

}