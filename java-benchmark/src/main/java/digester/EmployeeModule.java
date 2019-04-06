package digester;

import org.apache.commons.digester3.binder.AbstractRulesModule;

import java.util.Properties;

public class EmployeeModule {

    private static class DefaultConfigModule extends AbstractRulesModule {
        @Override
        protected void configure() {

            forPattern("pool-config/defaults/pool-properties").createObject()
                    .ofType(Properties.class);
            forPattern("pool-config/defaults/pool-properties/property")
                    .callMethod("put").withParamCount(2)
                    .withParamTypes(Object.class, Object.class).then()
                    .callParam().fromAttribute("name").ofIndex(0).then()
                    .callParam().ofIndex(1);

        }
    }

}
