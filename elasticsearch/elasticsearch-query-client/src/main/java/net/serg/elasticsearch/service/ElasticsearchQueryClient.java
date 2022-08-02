package net.serg.elasticsearch.service;

import net.serg.elasticsearch.model.IndexModel;

import java.util.List;

public interface ElasticsearchQueryClient<T extends IndexModel> {

    T getIndexModelById(String id);

    List<T> getIndexModelByText(String text);

    List<T> getAllIndexModels();
}
