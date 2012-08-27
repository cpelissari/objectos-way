@{comments.file}
package @{types.packageName}.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import br.com.objectos.comuns.relational.jdbc.RelationalJdbcModuleBuilder;
import br.com.objectos.comuns.sitebricks.ObjectosComunsSitebricksModule;
import br.com.objectos.comuns.sitebricks.StageUI;
import br.com.objectos.comuns.sql.JdbcCredentials;
import br.com.objectos.comuns.sql.PropertiesJdbcCredentialsProvider;

import com.google.common.io.InputSupplier;
import com.google.common.io.Resources;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.name.Names;

@{comments.type}
class @{types.prefix}ModuleBootstrap extends AbstractModule {

  private final StageUI stage;

  public @{types.prefix}ModuleBootstrap(StageUI stageUI) {
    this.stage = stageUI;
  }

  @Override
  protected void configure() {
    install(new ObjectosComunsSitebricksModule());

    Provider<JdbcCredentials> credentialsProvider;
    credentialsProvider = new PropertiesJdbcCredentialsProvider(getClass());

    install(new RelationalJdbcModuleBuilder()
        .withC3P0(credentialsProvider)
        .withMysql()
        .build());

    Properties properties = loadProperties();
    String versao = properties.getProperty("way.uuid", "UNKNOWN");
    bind(String.class).annotatedWith(Names.named("way.uuid")).toInstance(versao);

    install(new @{types.prefix}ModuleUI(stage));
  }

  private Properties loadProperties() {
    try {

      URL url = Resources.getResource(getClass(), "/@{shortName}.properties");
      InputSupplier<InputStream> inputSupplier = Resources.newInputStreamSupplier(url);
      InputStream input = inputSupplier.getInput();
      Properties properties = new Properties();
      properties.load(input);
      return properties;

    } catch (IOException e) {

      return new Properties();

    }
  }

}