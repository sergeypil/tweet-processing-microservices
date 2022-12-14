package net.serg.elasticsearch.query.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticsearchQueryServiceRequestModel {
    private String id;
    @NotEmpty
    private String text;
}
