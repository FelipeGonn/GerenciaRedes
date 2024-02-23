package usecase.user.add;

import domain.user.entities.User;
import domain.user.gateway.UserGateway;
import usecase.Usecase;

public class AddUserUsecase implements Usecase<AddUserInputDTO, AddUserOutputDTO> {

    private final UserGateway UserGateway;

    private AddUserUsecase(UserGateway UserGateway) {
        this.UserGateway = UserGateway;
    }

    public static AddUserUsecase create(final UserGateway aGateway) {
        return new AddUserUsecase(aGateway);
    }

    @Override
    public AddUserOutputDTO execute(final AddUserInputDTO input) {

        final var aUser = User.create(
                input.name(),
                input.email(),
                input.password(),
                input.nickname());

        UserGateway.save(aUser);

        return new AddUserOutputDTO(
                aUser.getId(),
                aUser.getName(),
                aUser.getEmail(),
                aUser.getNickname(),
                aUser.getPassword());

    }

}
