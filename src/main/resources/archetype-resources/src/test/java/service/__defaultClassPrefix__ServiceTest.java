#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.dto.${defaultClassPrefix}Entity;
import ${package}.repository.${defaultClassPrefix}Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
class ${defaultClassPrefix}ServiceTest {

    @Mock
    private ${defaultClassPrefix}Repository ${defaultVariablePrefix}Repository;

    @InjectMocks
    private ${defaultClassPrefix}Service unitUnderTest;

    @Test
    void computeData() {
        //Given:
        var mockedEntity = new ${defaultClassPrefix}Entity();
        mockedEntity.set${defaultClassPrefix}Data("it works!");
        var expectedList = new ArrayList<${defaultClassPrefix}Entity>();
        expectedList.add(mockedEntity);
        when(${defaultVariablePrefix}Repository.findAll()).thenReturn(expectedList);

        //When:
        var result = unitUnderTest.findAll();

        //Then
        assertNotNull(result);
        assertEquals("then first element in the resulting List should be the mock from above","it works!", result.getFirst().get${defaultClassPrefix}Data());
        verify(${defaultVariablePrefix}Repository).findAll();
    }
}