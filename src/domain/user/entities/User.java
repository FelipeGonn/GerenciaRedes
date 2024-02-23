package domain.user.entities;

import domain.shared.aggregatte.AggregatteRoot;
import domain.shared.entities.Entity;
import domain.shared.exceptions.DomainException;

import java.util.UUID;

public class User extends Entity implements AggregatteRoot {

    private String name;
    private String email;
    private String password;
    private String nickname;

    private User(String id, String name, String email, String password, String nickname){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;

        this.validate();
    }

    //método para criar um usuário
    public static User create(String name, String email, String password, String nickname) {
        return new User(UUID.randomUUID().toString(),
                name,
                email,
                password,
                nickname);
    }

    public static User with(String id, String name, String email, String password, String nickname){
        return new User(
                id,
                name,
                email,
                password,
                nickname);
    }

    //verificações se é nulo
    protected void validate(){
        if(this.getId() == null){
            throw new DomainException("Product id is required");
        }

        if(this.name == null || this.name.isEmpty()){
            throw new DomainException("User name is required");
        }

        if(this.email == null || this.email.isEmpty()) {
            throw new DomainException("User email is required");
        }

        if(this.password == null || this.password.isEmpty()) {
            throw new DomainException("User password is required");
        }

        if(this.nickname == null || this.nickname.isEmpty()) {
            throw new DomainException("User nickname is required");
        }
    }

    //acessos a informação
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getNickname(){
        return nickname;
    }
}
