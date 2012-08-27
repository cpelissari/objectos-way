@{comments.file}
package @{types.packageName}.ui;

import br.com.objectos.comuns.sitebricks.Bricks;

import com.google.inject.Inject;

@{comments.type}
public class @{types.prefix}BricksProd extends @{types.prefix}BricksGuice {

  @Inject
  public @{types.prefix}BricksProd(@{types.prefix}Auth auth, Bricks bricks) {
    super(auth, bricks);
  }

  @Override
  public String getImgUrl() {
    return getBaseUrl() + "/img";
  }

}