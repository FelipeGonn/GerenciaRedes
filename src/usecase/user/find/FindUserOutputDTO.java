package usecase.user.find;

public record FindUserOutputDTO(
        String id,
        String name,
        String email,
        String password,
        String nickname) {

}
