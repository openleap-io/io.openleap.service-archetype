#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.dto.${defaultClassPrefix}Entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ApplicationTest
class ${defaultClassPrefix}ControllerDocumentation {

    @Autowired
    private ObjectMapper om;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation, WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation)).build();
    }

    @Test
    void shall_find_data_at_index() throws Exception {
        // arrange

        // act
        mockMvc.perform(get("/api/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(document("${artifactId}-index", preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
        ;

        // assert
    }

    @Test
    void shall_read_all_recources() throws Exception {
        // arrange

        // act
        mockMvc.perform(get("/api/data")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(document("${artifactId}-data-read", preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
        ;

        // assert
    }

    @Test
    void shall_read_single_recource() throws Exception {
        // arrange
        var toCreate = new ${defaultClassPrefix}Entity();
        toCreate.set${defaultClassPrefix}Data("new data");
        mockMvc.perform(post("/api/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(toCreate)));

        // act
        mockMvc.perform(get("/api/data/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(document("${artifactId}-data-read", preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
        ;

        // assert
    }

    @Test
    void shall_not_read_missing_recource() throws Exception {
        // arrange

        // act
        mockMvc.perform(get("/api/data/42")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(document("${artifactId}-data-not-existing", preprocessResponse(prettyPrint())))
                .andExpect(status().isNotFound())
        ;

        // assert
    }

    @Test
    void shall_create_recource() throws Exception {
        // arrange
        var toCreate = new ${defaultClassPrefix}Entity();
        toCreate.set${defaultClassPrefix}Data("new data");

        // act
        mockMvc.perform(post("/api/data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(toCreate)))
                .andDo(document("${artifactId}-data-create", preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
        ;

        // assert
    }

    @Test
    void shall_not_update_missing_resource() throws Exception {
        // arrange
        var toUpdate = new ${defaultClassPrefix}Entity();
        toUpdate.set${defaultClassPrefix}Data("new data");

        // act
        mockMvc.perform(put("/api/data/42")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(toUpdate)))
                .andDo(document("${artifactId}-data-update", preprocessResponse(prettyPrint())))
                .andExpect(status().isNotFound())
        ;

        // assert
    }

    @Test
    void shall_update_existing_recource() throws Exception {
        // arrange
        var toCreate = new ${defaultClassPrefix}Entity();
        toCreate.set${defaultClassPrefix}Data("old data");
        mockMvc.perform(post("/api/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(toCreate)));

        var toUpdate = new ${defaultClassPrefix}Entity();
        toUpdate.set${defaultClassPrefix}Data("new data");

        // act
        mockMvc.perform(put("/api/data/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(toUpdate)))
                .andDo(document("${artifactId}-data-update", preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
        ;

        // assert
    }

    @Test
    void shall_delete_recource() throws Exception {
        // arrange
        var data = "data to delete";

        // act
        mockMvc.perform(delete("/api/data/42")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(data)))
                .andDo(document("${artifactId}-data-delete", preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
        ;

        // assert
    }
}