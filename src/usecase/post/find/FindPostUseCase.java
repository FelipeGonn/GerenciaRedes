package usecase.post.find;

import domain.post.gateway.PostGateway;
import usecase.Usecase;
import usecase.exceptions.NotfoundException;

public class FindPostUseCase implements Usecase<FindPostInputDTO, FindPostOutputDTO> {
    private final PostGateway PostGateway; // Atributo para armazenar uma instância de PostGateway

    // Construtor privado que recebe um PostGateway como parâmetro
    private FindPostUseCase(PostGateway PostGateway) {
        this.PostGateway = PostGateway; // Inicializa o atributo PostGateway com o valor recebido
    }

    // Método estático para criar uma instância de FindPostUseacse
    public static FindPostUseCase create(final PostGateway aGateway) {
        return new FindPostUseCase(aGateway); // Retorna uma nova instância de FindPostUseacse com o PostGateway fornecido
    }

    // Implementação do método execute da interface Usecase
    @Override
    public FindPostOutputDTO execute(FindPostInputDTO input) {
        // Chama o método find do PostGateway, passando o ID do post recebido como parâmetro
        var aPost = PostGateway.find(input.id());

        // Verifica se o post foi encontrado (se aPost não for null)
        if(aPost == null) {
            // Se não foi encontrado, lança uma exceção NotfoundException com a mensagem "Post not found"
            throw new NotfoundException("Post not found");
        }

        // Se o post foi encontrado, cria um novo FindPostOutputDTO com os dados do post e o retorna
        return new FindPostOutputDTO(
                aPost.getId(),
                aPost.getTitle(),
                aPost.getContent(),
                aPost.getUser(),
                aPost.getPost_time());
    }

}
