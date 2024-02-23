package domain.shared.exceptions;
//caso tenha alguma exceção, vai retornar uma mensagem
public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }
}
