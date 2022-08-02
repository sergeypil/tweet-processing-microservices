package net.serg.elasticsearch.query.service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import net.serg.elasticsearch.query.service.business.ElasticsearchQueryService;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceRequestModel;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModel;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModelV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/documents", produces = "application/vnd.api.v1+json")
@Slf4j
public class ElasticsearchDocumentController {

    private final ElasticsearchQueryService elasticsearchQueryService;

    public ElasticsearchDocumentController(ElasticsearchQueryService queryService) {
        this.elasticsearchQueryService = queryService;
    }

    @Operation(summary = "Get all elastic documents.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                             schema = @Schema(implementation = ElasticsearchQueryServiceResponseModel.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<ElasticsearchQueryServiceResponseModel>> getAllDocuments() {
        List<ElasticsearchQueryServiceResponseModel> response = elasticsearchQueryService.getAllDocuments();
        log.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Get elastic document by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ElasticsearchQueryServiceResponseModel.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ElasticsearchQueryServiceResponseModel>
    getDocumentById(@PathVariable @NotEmpty String id) {
        ElasticsearchQueryServiceResponseModel elasticQueryServiceResponseModel = elasticsearchQueryService.getDocumentById(id);
        log.debug("Elasticsearch returned document with id {}", id);
        return ResponseEntity.ok(elasticQueryServiceResponseModel);
    }

    @Operation(summary = "Get elastic document by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response.", content = {
                    @Content(mediaType = "application/vnd.api.v2+json",
                            schema = @Schema(implementation = ElasticsearchQueryServiceResponseModelV2.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping(value = "/{id}", produces = "application/vnd.api.v2+json")
    public @ResponseBody
    ResponseEntity<ElasticsearchQueryServiceResponseModelV2>
    getDocumentByIdV2(@PathVariable @NotEmpty String id) {
        ElasticsearchQueryServiceResponseModel elasticsearchQueryServiceResponseModel = elasticsearchQueryService.getDocumentById(id);
        ElasticsearchQueryServiceResponseModelV2 responseModelV2 = getV2Model(elasticsearchQueryServiceResponseModel);
        log.debug("Elasticsearch returned document with id {}", id);
        return ResponseEntity.ok(responseModelV2);
    }

    @Operation(summary = "Get elastic document by text.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ElasticsearchQueryServiceResponseModel.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @PostMapping("/get-document-by-text")
    public @ResponseBody
    ResponseEntity<List<ElasticsearchQueryServiceResponseModel>>
    getDocumentByText(@RequestBody @Valid ElasticsearchQueryServiceRequestModel elasticQueryServiceRequestModel) {
        List<ElasticsearchQueryServiceResponseModel> response =
                elasticsearchQueryService.getDocumentByText(elasticQueryServiceRequestModel.getText());
        log.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }

    private ElasticsearchQueryServiceResponseModelV2 getV2Model(ElasticsearchQueryServiceResponseModel responseModel) {
        ElasticsearchQueryServiceResponseModelV2 responseModelV2 = ElasticsearchQueryServiceResponseModelV2.builder()
                .id(Long.parseLong(responseModel.getId()))
                .userId(responseModel.getUserId())
                .text(responseModel.getText())
                .text2("Version 2 text")
                .build();
        responseModelV2.add(responseModel.getLinks());
        return responseModelV2;

    }


}
