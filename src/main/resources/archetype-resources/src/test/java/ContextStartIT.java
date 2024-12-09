#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A ContextStartIT.
 *
 * @author Heiko Scherrer
 */
@SpringBootTest
class ContextStartIT {


    @Test
    void contextLoads() {
        assertEquals(this.getClass(), (ContextStartIT.class));
    }
}
