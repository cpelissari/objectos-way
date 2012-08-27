@{comments.file}
package @{types.packageName}.ui;

import br.com.objectos.comuns.sitebricks.Bricks;
import br.com.objectos.comuns.sitebricks.MetaPageScript;
import br.com.objectos.comuns.sitebricks.Page;
import @{types.packageName}.obj.auth.User;

import com.google.inject.Inject;

@{comments.type}
class @{types.prefix}BricksGuice implements @{types.prefix}Bricks {

  private final @{types.prefix}Auth auth;

  private final Bricks bricks;

  @Inject
  public @{types.prefix}BricksGuice(@{types.prefix}Auth auth, Bricks bricks) {
    this.auth = auth;
    this.bricks = bricks;
  }

  @Override
  public boolean isAuthenticated() {
    return auth.isAuthenticated();
  }

  @Override
  public User getUser() {
    return auth.getUser();
  }

  @Override
  public String getBaseUrl() {
    return bricks.getBaseUrl();
  }

  @Override
  public String getImgUrl() {
    return getBaseUrl() + "/factoring-js/img";
  }

  @Override
  public Page pageOf(MetaPageScript script) {
    return bricks.pageOf(script);
  }

}