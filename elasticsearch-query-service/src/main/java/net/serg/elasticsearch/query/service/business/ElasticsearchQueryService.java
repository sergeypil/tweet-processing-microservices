package net.serg.elasticsearch.query.service.business;

import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModel;

import java.util.List;

public interface ElasticsearchQueryService {

    ElasticsearchQueryServiceResponseModel getDocumentById(String id);

    List<ElasticsearchQueryServiceResponseModel> getDocumentByText(String text);

    List<ElasticsearchQueryServiceResponseModel> getAllDocuments();
}
