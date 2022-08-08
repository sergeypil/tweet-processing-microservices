package net.serg.elasticsearch.util;

import lombok.extern.slf4j.Slf4j;
import net.serg.elasticsearch.model.IndexModel;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Slf4j
public class ElasticsearchQueryUtil<T extends IndexModel> {

    public Query getSearchQueryById(String id) {
        return new NativeSearchQueryBuilder()
                .withIds(Collections.singleton(id))
                .build();
    }

    public Query getSearchQueryByFieldText(String field, String text) {
        log.info("Field from config: {}", field);
        return new NativeSearchQueryBuilder()
                .withQuery(new BoolQueryBuilder()
                        .must(QueryBuilders.matchQuery(field, text)))
                .build();
    }

    public Query getSearchQueryForAll() {
        return new NativeSearchQueryBuilder()
                .withQuery(new BoolQueryBuilder()
                        .must(QueryBuilders.matchAllQuery()))
                .build();
    }
}

