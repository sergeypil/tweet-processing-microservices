package net.serg.elasticsearch.query.web.client.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.serg.config.ElasticsearchQueryWebClientConfigData;
import net.serg.elasticsearch.query.web.client.exception.ElasticQueryWebClientException;
import net.serg.elasticsearch.query.web.client.model.ElasticQueryWebClientRequestModel;
import net.serg.elasticsearch.query.web.client.model.ElasticQueryWebClientResponseModel;
import net.serg.elasticsearch.query.web.client.service.ElasticQueryWebClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class TwitterElasticQueryWebClient implements ElasticQueryWebClient {

    private final WebClient.Builder webClientBuilder;

    private final ElasticsearchQueryWebClientConfigData elasticsearchQueryWebClientConfigData;

    public TwitterElasticQueryWebClient(@Qualifier("webClientBuilder") WebClient.Builder clientBuilder,
                                        ElasticsearchQueryWebClientConfigData webClientConfigData) {
        this.webClientBuilder = clientBuilder;
        this.elasticsearchQueryWebClientConfigData = webClientConfigData;
    }

    @Override
    public List<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel requestModel) {
        log.info("Querying by text {}", requestModel.getText());
        return getWebClient(requestModel)
                .bodyToFlux(ElasticQueryWebClientResponseModel.class)
                .collectList()
                .block();
    }

    private WebClient.ResponseSpec getWebClient(ElasticQueryWebClientRequestModel requestModel) {
        return webClientBuilder
                .build()
                .method(HttpMethod.valueOf(elasticsearchQueryWebClientConfigData.getQueryByText().getMethod()))
                .uri(elasticsearchQueryWebClientConfigData.getQueryByText().getUri())
                .accept(MediaType.valueOf(elasticsearchQueryWebClientConfigData.getQueryByText().getAccept()))
                .body(BodyInserters.fromPublisher(Mono.just(requestModel), createParameterizedTypeReference()))
                .retrieve()
                .onStatus(
                        httpStatus -> httpStatus.equals(HttpStatus.UNAUTHORIZED),
                        clientResponse -> Mono.just(new BadCredentialsException("Not authenticated!")))
                .onStatus(
                        HttpStatus::is4xxClientError,
                        cr -> Mono.just(new ElasticQueryWebClientException(cr.statusCode().getReasonPhrase())))
                .onStatus(
                        HttpStatus::is5xxServerError,
                        cr -> Mono.just(new Exception(cr.statusCode().getReasonPhrase())));
    }


    private <T> ParameterizedTypeReference<T> createParameterizedTypeReference() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
