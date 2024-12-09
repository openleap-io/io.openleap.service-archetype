#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.ameba.annotation.EnableAspects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication()
@EnableAspects(propagateRootCause = true)
public class ${defaultClassPrefix}ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(${defaultClassPrefix}ServiceApplication.class, args);
    }
}
