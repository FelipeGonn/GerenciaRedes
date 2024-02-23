package usecase.post.find;

import domain.post.entities.User;

import java.util.Date;

public record FindPostOutputDTO(
        String id,
        String title,
        String content,
        User user,
        Date post_time) {

}