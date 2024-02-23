package domain.post.entities;

import domain.shared.entities.Entity;
import domain.shared.exceptions.DomainException;

public class User extends Entity {

    private String nickname;

    //objeto usuário do post
    private User(String id, String nickname){
        super(id);
        this.nickname = nickname;
        this.validate();
    }

    //criação do usuário do post
    public static User with(String id, String nickname){
        return new User(id,nickname);
    }

    //acesso a informação
    public String getNickname(){
        return nickname;
    }

    //validação
    @Override
    protected void validate(){
        if(this.getId() == null){
            throw new DomainException("User id is required");
        }

        if(this.nickname == null){
            throw new DomainException("User nickname is required");
        }
    }
}
