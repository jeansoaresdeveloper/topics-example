package com.redis.example.repository;

import com.redis.example.model.User;
import jakarta.annotation.PostConstruct;
import net.datafaker.Faker;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import static com.redis.example.config.RedisConfiguration.KEY;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private final Faker FAKER = new Faker();
    private final List<User> DATABASE = new ArrayList<>();
    private static final int SIZE_USERS = 50;

    @PostConstruct
    public void setup() {

        for (int i = 0; i < SIZE_USERS; i++) {
            final User user = User.builder()
                    .id((long) i + 1)
                    .name(FAKER.name().name())
                    .email(FAKER.internet().emailAddress())
                    .build();

            DATABASE.add(user);
        }
    }

    @Cacheable(value = KEY)
    public List<User> find() throws InterruptedException {

        Thread.sleep(5000);
        return DATABASE;
    }
}
