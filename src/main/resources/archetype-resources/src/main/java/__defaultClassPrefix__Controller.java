#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.dto.${defaultClassPrefix}Entity;
import ${package}.service.${defaultClassPrefix}Service;
import lombok.RequiredArgsConstructor;
import org.ameba.http.MeasuredRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@MeasuredRestController
@RequiredArgsConstructor
public class ${defaultClassPrefix}Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(${defaultClassPrefix}Controller.class);

	private final ${defaultClassPrefix}Service ${defaultVariablePrefix}Service;

	@GetMapping("/")
	public ResponseEntity<String> index()
	{
		return ResponseEntity.ok("Here we go!!!");
	}

	@GetMapping("/data")
	public ResponseEntity<List<${defaultClassPrefix}Entity>> read()
	{
		//get data from business logic and assemble a response
		var result = ${defaultVariablePrefix}Service.findAll();
		return ResponseEntity.ok(result);
	}

	@GetMapping("/data/{id}")
	public ResponseEntity<${defaultClassPrefix}Entity> readOne(@PathVariable long id)
	{
		//get data from business logic and assemble a response
		var result = ${defaultVariablePrefix}Service.findById(id);
		if(result == null)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(result);
		}
	}

	@PostMapping("/data")
	public ResponseEntity<${defaultClassPrefix}Entity> create(@RequestBody ${defaultClassPrefix}Entity dataToCreate) {
		/*
			create requested dataset here
		 */
		var result = ${defaultVariablePrefix}Service.save(dataToCreate);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/data/{id}")
	public ResponseEntity<${defaultClassPrefix}Entity> update(@PathVariable long id, @RequestBody ${defaultClassPrefix}Entity dataToUpdate) {
		/*
			update requested dataset here
		 */
		if(${defaultVariablePrefix}Service.exists(id))
		{
			dataToUpdate.setId(id);
			var result = ${defaultVariablePrefix}Service.save(dataToUpdate);
			return ResponseEntity.ok(result);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/data/{id}")
	public ResponseEntity<String> delete(@PathVariable long id)
	{
		/*
		delete requested dataset here
		 */
		${defaultVariablePrefix}Service.deleteById(id);
		return ResponseEntity.ok("removed: " + id);
	}
}
