package net.serg.elasticsearch.query.service.security;

import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceRequestModel;
import net.serg.elasticsearch.query.service.model.ElasticsearchQueryServiceResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Component
public class QueryServicePermissionEvaluator implements PermissionEvaluator {

    private static final String SUPER_USER_ROLE = "APP_SUPER_USER_ROLE";

    private final HttpServletRequest httpServletRequest;

    public QueryServicePermissionEvaluator(HttpServletRequest request) {
        this.httpServletRequest = request;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean hasPermission(Authentication authentication,
                                 Object targetDomain,
                                 Object permission) {
        if (isSuperUser()) {
            return true;
        }
        if (targetDomain instanceof ElasticsearchQueryServiceRequestModel) {
            return preAuthorize(authentication, ((ElasticsearchQueryServiceRequestModel) targetDomain).getId(), permission);
        } else if (targetDomain instanceof ResponseEntity || targetDomain == null) {
            if (targetDomain == null) {
                return true;
            }
            List<ElasticsearchQueryServiceResponseModel> responseBody =
                    ((ResponseEntity<List<ElasticsearchQueryServiceResponseModel>>) targetDomain).getBody();
            Objects.requireNonNull(responseBody);
            return postAuthorize(authentication, responseBody, permission);
        }
        return false;
    }


    @Override
    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId,
                                 String targetType,
                                 Object permission) {
        if (isSuperUser()) {
            return true;
        }
        if (targetId == null) {
            return false;
        }
        return preAuthorize(authentication, (String) targetId, permission);
    }

    private boolean preAuthorize(Authentication authentication, String id, Object permission) {
        TwitterQueryUser twitterQueryUser = (TwitterQueryUser) authentication.getPrincipal();
        PermissionType userPermission = twitterQueryUser.getPermissions().get(id);
        return hasPermission((String) permission, userPermission);
    }

    private boolean postAuthorize(Authentication authentication,
                                  List<ElasticsearchQueryServiceResponseModel> responseBody,
                                  Object permission) {
        TwitterQueryUser twitterQueryUser = (TwitterQueryUser) authentication.getPrincipal();
        for (ElasticsearchQueryServiceResponseModel responseModel : responseBody) {
            PermissionType userPermission = twitterQueryUser.getPermissions().get(responseModel.getId());
            if (!hasPermission((String) permission, userPermission)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasPermission(String requiredPermission, PermissionType userPermission) {
        return userPermission != null && requiredPermission.equals(userPermission.getType());
    }

    private boolean isSuperUser() {
        return httpServletRequest.isUserInRole(SUPER_USER_ROLE);
    }
}
