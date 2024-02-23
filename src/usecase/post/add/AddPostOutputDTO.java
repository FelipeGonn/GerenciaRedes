package usecase.post.add;

import domain.post.entities.User;

import java.util.Date;

public record AddPostOutputDTO(
        String id,
        String title,
        User user,
        String content,
        Date post_time) {

}