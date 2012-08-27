/*
 * Way.java criado em 26/08/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way;

import br.com.objectos.way.command.Executor;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Way {

  private final Executor executor;

  @Inject
  public Way(Executor executor) {
    this.executor = executor;
  }

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new WayModule());
    Way way = injector.getInstance(Way.class);
    way.run(args);
  }

  private void run(String[] args) {
    executor.execute(args);
  }

}