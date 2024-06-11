package quinstreet.config;

import org.aeonbits.owner.ConfigFactory;

public class GeneralConfigImpl {
        public static GeneralConfig config = ConfigFactory.create(GeneralConfig.class, System.getProperties());
}
