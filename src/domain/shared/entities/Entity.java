package domain.shared.entities;
//necessariamente, uma entidade só precisa ter o id
public abstract class Entity {
    protected String id;

    protected Entity(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    protected abstract void validate();
}
