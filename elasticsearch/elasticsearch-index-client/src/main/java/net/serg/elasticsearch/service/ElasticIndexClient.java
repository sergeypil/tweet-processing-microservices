package net.serg.elasticsearch.service;

import net.serg.elasticsearch.model.IndexModel;

import java.util.List;

public interface ElasticIndexClient<T extends IndexModel> {
    List<String> save(List<T> documents);
}
