package domain.user.gateway;

import domain.user.entities.User;

public interface UserGateway {
    void save(User user);
    User find(String anId);
}
