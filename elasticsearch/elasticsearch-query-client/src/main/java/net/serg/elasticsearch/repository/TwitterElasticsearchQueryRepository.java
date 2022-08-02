package net.serg.elasticsearch.repository;

import net.serg.elasticsearch.model.impl.TwitterIndexModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitterElasticsearchQueryRepository extends ElasticsearchRepository<TwitterIndexModel, String> {

    List<TwitterIndexModel> findByText(String text);
}
