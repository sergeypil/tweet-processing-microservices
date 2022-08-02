package net.serg.elasticsearch.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.serg.config.ElasticConfigData;
import net.serg.config.ElasticsearchQueryConfigData;
import net.serg.elasticsearch.exception.ElasticsearchQueryClientException;
import net.serg.elasticsearch.model.impl.TwitterIndexModel;
import net.serg.elasticsearch.service.ElasticsearchQueryClient;
import net.serg.elasticsearch.util.ElasticsearchQueryUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
@Slf4j
public class TwitterElasticsearchQueryClient implements ElasticsearchQueryClient<TwitterIndexModel> {

    private final ElasticConfigData elasticConfigData;

    private final ElasticsearchQueryConfigData elasticQueryConfigData;

    private final ElasticsearchOperations elasticsearchOperations;

    private final ElasticsearchQueryUtil<TwitterIndexModel> elasticQueryUtil;

    public TwitterElasticsearchQueryClient(ElasticConfigData elasticConfigData,
                                           ElasticsearchQueryConfigData elasticQueryConfigData,
                                           ElasticsearchOperations elasticsearchOperations,
                                           ElasticsearchQueryUtil<TwitterIndexModel> elasticQueryUtil) {
        this.elasticConfigData = elasticConfigData;
        this.elasticQueryConfigData = elasticQueryConfigData;
        this.elasticsearchOperations = elasticsearchOperations;
        this.elasticQueryUtil = elasticQueryUtil;
    }

    @Override
    public TwitterIndexModel getIndexModelById(String id) {
        Query query = elasticQueryUtil.getSearchQueryById(id);
        SearchHit<TwitterIndexModel> searchResult = elasticsearchOperations.searchOne(query, TwitterIndexModel.class,
                IndexCoordinates.of(elasticConfigData.getIndexName()));
        if (searchResult == null) {
            log.error("No document found at elasticsearch with id {}", id);
            throw new ElasticsearchQueryClientException("No document found at elasticsearch with id " + id);
        }
        log.info("Document with id {} retrieved successfully", searchResult.getId());
        return searchResult.getContent();
    }

    @Override
    public List<TwitterIndexModel> getIndexModelByText(String text) {
        Query query = elasticQueryUtil.getSearchQueryByFieldText(elasticQueryConfigData.getTextField(), text);
        return search(query, "{} of documents with text {} retrieved successfully", text);
    }

    @Override
    public List<TwitterIndexModel> getAllIndexModels() {
        Query query = elasticQueryUtil.getSearchQueryForAll();
        return search(query, "{} number of documents retrieved successfully");
    }

    private List<TwitterIndexModel> search(Query query, String logMessage, Object... logParams) {
        SearchHits<TwitterIndexModel> searchResult = elasticsearchOperations.search(query, TwitterIndexModel.class,
                IndexCoordinates.of(elasticConfigData.getIndexName()));
        log.info(logMessage, searchResult.getTotalHits(), logParams);
        return searchResult.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
