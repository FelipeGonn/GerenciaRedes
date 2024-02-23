package domain.post.gateway;

import domain.post.entities.Post;

public interface PostGateway {
    void save(final Post aPost);
    Post find(final String anId);
}
