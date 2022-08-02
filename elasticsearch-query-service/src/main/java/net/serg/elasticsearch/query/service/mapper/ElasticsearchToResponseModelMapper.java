package net.serg.elasticsearch.query.service.mapper;

import net.serg.elasticsearch.model.impl.TwitterIndexModel;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElasticsearchToResponseModelMapper {

    public ElasticsearchQueryServiceResponseModel mapTwitterModelToElasticResponseModel(TwitterIndexModel twitterIndexModel) {
        return ElasticsearchQueryServiceResponseModel
                .builder()
                .id(twitterIndexModel.getId())
                .userId(twitterIndexModel.getUserId())
                .text(twitterIndexModel.getText())
                .createdAt(twitterIndexModel.getCreatedAt())
                .build();
    }

    public List<ElasticsearchQueryServiceResponseModel> getResponseModels(List<TwitterIndexModel> twitterIndexModels) {
        return twitterIndexModels.stream().map(this::mapTwitterModelToElasticResponseModel).collect(Collectors.toList());
    }
}
