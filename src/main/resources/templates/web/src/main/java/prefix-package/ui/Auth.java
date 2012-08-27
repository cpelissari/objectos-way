@{comments.file}
package @{types.packageName}.ui;

import @{types.packageName}.obj.auth.User;

import com.google.inject.ImplementedBy;

@{comments.type}
@ImplementedBy(@{types.prefix}AuthGuice.class)
public interface @{types.prefix}Auth {

  boolean isAuthenticated();

  User getUser();

}