#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.dto.${defaultClassPrefix}Entity;
import ${package}.repository.${defaultClassPrefix}Repository;
import lombok.RequiredArgsConstructor;
import org.ameba.annotation.TxService;
import java.util.List;

@TxService
@RequiredArgsConstructor
public class ${defaultClassPrefix}Service {

    private final ${defaultClassPrefix}Repository ${defaultVariablePrefix}Repository;

    public List<${defaultClassPrefix}Entity> findAll() {
        //fetch data from repositories
        var ${defaultVariablePrefix}Data = ${defaultVariablePrefix}Repository.findAll();
        /*

        work with data

         */
        return ${defaultVariablePrefix}Data;
    }

    public ${defaultClassPrefix}Entity findById(long id) {
        //fetch data from repositories
        var ${defaultVariablePrefix}Data = ${defaultVariablePrefix}Repository.findById(id);
        /*

        work with data

         */
        return ${defaultVariablePrefix}Data;
    }

     public void deleteById(long id) {
        /*

        work with data

         */
        ${defaultVariablePrefix}Repository.deleteById(id);
    }

    public ${defaultClassPrefix}Entity save(${defaultClassPrefix}Entity data)
    {
        /*

        work with data

         */
        return ${defaultVariablePrefix}Repository.save(data);
    }

    public boolean exists(long id)
    {
        return ${defaultVariablePrefix}Repository.existsById(id);
    }

}
