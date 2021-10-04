package za.ac.nwu.ac.account_system.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.account_system.account",
        "za.ac.nwu.ac.account_system.config",
        "za.ac.nwu.ac.account_system"
})
public class WebConfig {
}
