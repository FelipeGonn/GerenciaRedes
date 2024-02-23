package usecase.user.find;

import domain.user.gateway.UserGateway;
import usecase.exceptions.NotfoundException;
import usecase.Usecase;

public class FindUserUseCase implements Usecase<FindUserInputDTO, FindUserOutputDTO> {

    private final UserGateway UserGateway;

    private FindUserUseCase(UserGateway UserGateway) {
        this.UserGateway = UserGateway;
    }

    public static FindUserUseCase create(final UserGateway aGateway) {
        return new FindUserUseCase(aGateway);
    }

    @Override
    public FindUserOutputDTO execute(FindUserInputDTO input) {
        var aUser = UserGateway.find(input.id());

        if(aUser == null) {
            throw new NotfoundException("User not found");
        }

        return new FindUserOutputDTO(
                aUser.getId(),
                aUser.getName(),
                aUser.getEmail(),
                aUser.getPassword(),
                aUser.getNickname());
    }

}

