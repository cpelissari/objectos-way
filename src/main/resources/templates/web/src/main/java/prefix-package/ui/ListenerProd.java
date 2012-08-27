@{comments.file}
package @{types.packageName}.ui;

import br.com.objectos.comuns.sitebricks.StageUI;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

@{comments.type}
public class @{types.prefix}ListenerProd extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new @{types.prefix}ModuleBootstrap(StageUI.PRODUCTION));
  }

}