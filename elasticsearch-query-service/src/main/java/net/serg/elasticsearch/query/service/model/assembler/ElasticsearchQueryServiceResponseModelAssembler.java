package net.serg.elasticsearch.query.service.model.assembler;

import net.serg.elasticsearch.model.impl.TwitterIndexModel;
import net.serg.elasticsearch.query.service.controller.ElasticsearchDocumentController;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModel;
import net.serg.elasticsearch.query.service.mapper.ElasticsearchToResponseModelMapper;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ElasticsearchQueryServiceResponseModelAssembler
        extends RepresentationModelAssemblerSupport<TwitterIndexModel, ElasticsearchQueryServiceResponseModel> {

    private final ElasticsearchToResponseModelMapper elasticsearchToResponseModelMapper;

    public ElasticsearchQueryServiceResponseModelAssembler(ElasticsearchToResponseModelMapper transformer) {
        super(ElasticsearchDocumentController.class, ElasticsearchQueryServiceResponseModel.class);
        this.elasticsearchToResponseModelMapper = transformer;
    }

    @Override
    public ElasticsearchQueryServiceResponseModel toModel(TwitterIndexModel twitterIndexModel) {
        ElasticsearchQueryServiceResponseModel responseModel =
                elasticsearchToResponseModelMapper.mapTwitterModelToElasticResponseModel(twitterIndexModel);
        responseModel.add(
                linkTo(methodOn(ElasticsearchDocumentController.class)
                        .getDocumentById((twitterIndexModel.getId())))
                        .withSelfRel());
        responseModel.add(
                linkTo(ElasticsearchDocumentController.class)
                        .withRel("documents"));
        return responseModel;
    }

    public List<ElasticsearchQueryServiceResponseModel> toModels(List<TwitterIndexModel> twitterIndexModels) {
        return twitterIndexModels.stream().map(this::toModel).collect(Collectors.toList());
    }


}

