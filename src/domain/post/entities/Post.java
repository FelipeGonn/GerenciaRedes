package domain.post.entities;

import domain.shared.aggregatte.AggregatteRoot;
import domain.shared.entities.Entity;
import domain.shared.exceptions.DomainException;

import java.util.Date;
import java.util.UUID;

public class Post extends Entity implements AggregatteRoot {

    private String title;
    private User user;
    private String content;
    private Date post_time;

    //objeto Post
    private Post(final String id, final String title, final User user, final String content,
                 final Date post_time){
        super(id);
        this.title = title;
        this.user = user;
        this.content = content;
        this.post_time = post_time;

        this.validate();
    }

    public static Post create(final String aTitle, final String aContent,
                              final Date aPost_time, final User aUser){
        return new Post(
                UUID.randomUUID().toString(),
                aTitle, aUser, aContent, aPost_time
        );
    }

    public static Post with(final String anId, final String aTitle, final User aUser,
                            final String aContent, final Date aPost_time){
        return new Post(anId,aTitle,aUser,aContent,aPost_time);
    }

    //validação dos requisitos
    protected void validate() {
        if (this.getId() == null) {
            throw new DomainException("Post id is required");
        }

        if (this.title == null || this.title.isEmpty()) {
            throw new DomainException("Post title is required");
        }

        if (this.content == null || this.content.isEmpty()) {
            throw new DomainException("Post content is required");
        }

        if (this.title.length() > 50){
            throw new DomainException("Title is too long");
        }

        if (this.content.length() > 250){
            throw new DomainException("Content is too long");
        }
    }

    //acesso a informação
    public String getTitle(){
        return title;
    }

    public User getUser(){
        return user;
    }

    public String getContent(){
        return content;
    }

    public Date getPost_time(){
        return post_time;
    }
}
