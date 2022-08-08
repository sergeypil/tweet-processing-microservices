package net.serg.elasticsearch.query.web.client.service;

import net.serg.elasticsearch.query.web.client.model.ElasticQueryWebClientRequestModel;
import net.serg.elasticsearch.query.web.client.model.ElasticQueryWebClientResponseModel;

import java.util.List;

public interface ElasticQueryWebClient {

    List<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel requestModel);
}
