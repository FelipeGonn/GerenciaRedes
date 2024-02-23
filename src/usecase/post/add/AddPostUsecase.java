package usecase.post.add;

import domain.post.entities.Post;
import domain.post.gateway.PostGateway;
import usecase.Usecase;

public class AddPostUsecase implements Usecase<AddPostInputDTO, AddPostOutputDTO> {

    private final PostGateway PostGateway;

    private AddPostUsecase(PostGateway PostGateway) {
        this.PostGateway = PostGateway;
    }

    public static AddPostUsecase create(final PostGateway aGateway) {
        return new AddPostUsecase(aGateway);
    }

    @Override
    public AddPostOutputDTO execute(final AddPostInputDTO input) {

        final var aPost = Post.create(
                input.title(),
                input.content(),
                input.post_time(),
                input.user());

        PostGateway.save(aPost);

        return new AddPostOutputDTO(
                aPost.getId(),
                aPost.getTitle(),
                aPost.getUser(),
                aPost.getContent(),
                aPost.getPost_time());
    }

}

