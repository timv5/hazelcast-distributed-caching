package com.hazelcast.caching.service.impl;

import com.hazelcast.caching.model.Users;
import com.hazelcast.caching.repository.UserRepository;
import com.hazelcast.caching.service.dao.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CachePut(value = "showcaseCache", key = "#user")
    @Override
    public Users save(Users user) {
        Users savedUser = null;
        try {
            savedUser = this.userRepository.save(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return savedUser;
    }

    @Cacheable(value = "showcaseCache", key = "#id", unless = "#result == null")
    @Override
    public Optional<Users> getUser(Long id) {
        Optional<Users> optionalUsers = Optional.empty();
        try {
            optionalUsers = this.userRepository.findById(id);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return optionalUsers;
    }

    @CacheEvict(value = "showcaseCache", key = "#user")
    @Override
    public Users deleteUser(Users user) {
        try {
            this.userRepository.delete(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }

        return user;
    }
}
