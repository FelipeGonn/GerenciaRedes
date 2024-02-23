package domain.shared.policies;
//politica de validação
public interface Policy <T>{
    void validate(T entity);
}
