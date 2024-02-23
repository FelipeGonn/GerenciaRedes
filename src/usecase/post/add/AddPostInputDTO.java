package usecase.post.add;

import domain.post.entities.User;

import java.util.Date;

public record AddPostInputDTO(
        String title,
        User user,
        String content,
        Date post_time) {

}
