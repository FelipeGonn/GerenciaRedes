package usecase.user.add;

public record AddUserOutputDTO(
        String id,
        String name,
        String email,
        String password,
        String nickname) {

}
