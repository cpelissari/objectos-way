@{comments.file}
package @{types.packageName}.ui;

import br.com.objectos.comuns.sitebricks.WebSession;
import @{types.packageName}.obj.auth.User;

import com.google.inject.Inject;

@{comments.type}
class @{types.prefix}AuthGuice implements @{types.prefix}Auth {

  private final WebSession session;

  @Inject
  public @{types.prefix}AuthGuice(WebSession session) {
    this.session = session;
  }

  @Override
  public boolean isAuthenticated() {
    return getUser() != null;
  }

  @Override
  public User getUser() {
    return session.get(User.class);
  }

}