package usecase;

public interface Usecase<InputDto, OutputDto>{
    
    OutputDto execute(InputDto inputDto);

}
