@{comments.file}
package @{types.packageName}.ui;

import br.com.objectos.comuns.sitebricks.Bricks;

import com.google.inject.ImplementedBy;

@{comments.type}
@ImplementedBy(@{types.prefix}BricksGuice.class)
public interface @{types.prefix}Bricks extends @{types.prefix}Auth, Bricks {

  String getImgUrl();

}