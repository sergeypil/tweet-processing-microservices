package net.serg.elasticsearch.query.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticsearchQueryServiceResponseModelV2 extends RepresentationModel<ElasticsearchQueryServiceResponseModelV2> {
    private Long id;
    private Long userId;
    private String text;
    private String text2;
}
