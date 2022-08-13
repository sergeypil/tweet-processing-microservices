package net.serg.elasticsearch.query.service.security;

import net.serg.config.ElasticsearchQueryServiceConfigData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Qualifier("elasticsearch-query-service-audience-validator")
@Component
public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

    private final ElasticsearchQueryServiceConfigData elasticsearchQueryServiceConfigData;

    public AudienceValidator(ElasticsearchQueryServiceConfigData configData) {
        this.elasticsearchQueryServiceConfigData = configData;
    }

    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        if (jwt.getAudience().contains(elasticsearchQueryServiceConfigData.getCustomAudience())) {
            return OAuth2TokenValidatorResult.success();
        } else {
            OAuth2Error audienceError =
                    new OAuth2Error("invalid_token", "The required audience " +
                            elasticsearchQueryServiceConfigData.getCustomAudience() + " is missing!",
                            null);
            return OAuth2TokenValidatorResult.failure(audienceError);
        }
    }
}
