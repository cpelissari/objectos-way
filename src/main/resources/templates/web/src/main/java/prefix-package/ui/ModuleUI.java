@{comments.file}
package @{types.packageName}.ui;

import br.com.objectos.comuns.sitebricks.AbstractModuleUI;
import br.com.objectos.comuns.sitebricks.StageUI;

import @{types.packageName}.ui.bricks.@{types.prefix}Head;
import @{types.packageName}.ui.bricks.@{types.prefix}HeadProd;

import com.caucho.quercus.servlet.QuercusServlet;
import com.google.inject.Scopes;

@{comments.type}
class @{types.prefix}ModuleUI extends AbstractModuleUI {

  public @{types.prefix}ModuleUI(StageUI stage) {
    super(stage);
  }

  @Override
  protected void bindCommon() {
    bind(QuercusServlet.class).in(Scopes.SINGLETON);
  }

  @Override
  protected void bindApi() {
  }

  @Override
  protected void bindBricks() {
    if (isStageDevelopment()) {
      embed(@{types.prefix}Head.class).as("Head");
    }

    if (isStageProduction()) {
      bind(@{types.prefix}Bricks.class).to(@{types.prefix}BricksProd.class);
      embed(@{types.prefix}HeadProd.class).as("Head");
    }
  }

  @Override
  protected void bindPages() {
  }

  @Override
  protected void preFilters(ExtendedServletModule m) {
  }

  @Override
  protected void customServlets(ExtendedServletModule m) {
    m.customServe("*.php").with(QuercusServlet.class);
  }

}
