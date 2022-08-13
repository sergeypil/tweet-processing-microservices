package net.serg.elasticsearch.query.service.business;



import net.serg.elasticsearch.query.service.dataaccess.entity.UserPermission;

import java.util.List;
import java.util.Optional;

public interface QueryUserService {

    Optional<List<UserPermission>> findAllPermissionsByUsername(String username);
}
