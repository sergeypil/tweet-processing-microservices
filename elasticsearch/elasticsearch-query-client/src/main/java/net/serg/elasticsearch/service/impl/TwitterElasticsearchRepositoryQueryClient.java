package net.serg.elasticsearch.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.serg.elasticsearch.exception.ElasticsearchQueryClientException;
import net.serg.elasticsearch.model.impl.TwitterIndexModel;
import net.serg.elasticsearch.repository.TwitterElasticsearchQueryRepository;
import net.serg.elasticsearch.service.ElasticsearchQueryClient;
import net.serg.util.CollectionsUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TwitterElasticsearchRepositoryQueryClient implements ElasticsearchQueryClient<TwitterIndexModel> {

    private final TwitterElasticsearchQueryRepository twitterElasticsearchQueryRepository;

    public TwitterElasticsearchRepositoryQueryClient(TwitterElasticsearchQueryRepository repository) {
        this.twitterElasticsearchQueryRepository = repository;
    }

    @Override
    public TwitterIndexModel getIndexModelById(String id) {
        Optional<TwitterIndexModel> searchResult = twitterElasticsearchQueryRepository.findById(id);
        log.info("Document with id {} retrieved successfully",
                searchResult.orElseThrow(() ->
                        new ElasticsearchQueryClientException("No document found at elasticsearch with id " + id)).getId());
        return searchResult.get();
    }

    @Override
    public List<TwitterIndexModel> getIndexModelByText(String text) {
        List<TwitterIndexModel> searchResult = twitterElasticsearchQueryRepository.findByText(text);
        log.info("{} of documents with text {} retrieved successfully", searchResult.size(), text);
        return searchResult;
    }

    @Override
    public List<TwitterIndexModel> getAllIndexModels() {
        List<TwitterIndexModel> searchResult =
                CollectionsUtil.getInstance().getListFromIterable(twitterElasticsearchQueryRepository.findAll());
        log.info("{} number of documents retrieved successfully", searchResult.size());
        return searchResult;
    }
}
