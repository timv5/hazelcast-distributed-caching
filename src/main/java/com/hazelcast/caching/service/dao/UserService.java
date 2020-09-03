package com.hazelcast.caching.service.dao;

import com.hazelcast.caching.model.Users;

import java.util.Optional;

public interface UserService {

    Users save(Users users);

    Optional<Users> getUser(final Long id);

    Users deleteUser(Users user);

}
