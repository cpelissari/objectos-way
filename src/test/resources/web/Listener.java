
package br.com.objectos.waytest.ui;

import br.com.objectos.comuns.sitebricks.StageUI;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;


public class WayTestListener extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new WayTestModuleBootstrap(StageUI.DEVELOPMENT));
  }

}