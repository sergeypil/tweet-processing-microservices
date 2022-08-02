package net.serg.elasticsearch.query.service.business.impl;

import lombok.extern.slf4j.Slf4j;
import net.serg.elasticsearch.model.impl.TwitterIndexModel;
import net.serg.elasticsearch.query.service.business.ElasticsearchQueryService;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModel;
import net.serg.elasticsearch.query.service.model.assembler.ElasticsearchQueryServiceResponseModelAssembler;
import net.serg.elasticsearch.service.ElasticsearchQueryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TwitterElasticsearchQueryService implements ElasticsearchQueryService {

    private final ElasticsearchQueryServiceResponseModelAssembler elasticQueryServiceResponseModelAssembler;

    private final ElasticsearchQueryClient<TwitterIndexModel> elasticQueryClient;

    public TwitterElasticsearchQueryService(ElasticsearchQueryServiceResponseModelAssembler assembler,
                                            ElasticsearchQueryClient<TwitterIndexModel> queryClient) {
        this.elasticQueryServiceResponseModelAssembler = assembler;
        this.elasticQueryClient = queryClient;
    }

    @Override
    public ElasticsearchQueryServiceResponseModel getDocumentById(String id) {
        log.info("Querying elasticsearch by id {}", id);
        return elasticQueryServiceResponseModelAssembler.toModel(elasticQueryClient.getIndexModelById(id));
    }

    @Override
    public List<ElasticsearchQueryServiceResponseModel> getDocumentByText(String text) {
        log.info("Querying elasticsearch by text {}", text);
        return elasticQueryServiceResponseModelAssembler.toModels(elasticQueryClient.getIndexModelByText(text));
    }

    @Override
    public List<ElasticsearchQueryServiceResponseModel> getAllDocuments() {
        log.info("Querying all documents in elasticsearch");
        return elasticQueryServiceResponseModelAssembler.toModels(elasticQueryClient.getAllIndexModels());
    }
}
