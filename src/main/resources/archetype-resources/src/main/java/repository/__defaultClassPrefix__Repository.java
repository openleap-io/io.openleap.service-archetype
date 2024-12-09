#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.dto.${defaultClassPrefix}Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/*
use the Repository which fits your database
 */
public interface ${defaultClassPrefix}Repository extends JpaRepository<${defaultClassPrefix}Entity, Long>
{
    List<${defaultClassPrefix}Entity> findAll();

    ${defaultClassPrefix}Entity findById(long id);

    void deleteById(long id);

    boolean existsById(long id);
}
