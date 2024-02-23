package usecase.user.add;

public record AddUserInputDTO(
        String name,
        String email,
        String password,
        String nickname) {

}