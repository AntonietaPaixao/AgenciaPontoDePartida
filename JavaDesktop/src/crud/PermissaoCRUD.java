package crud;

import java.util.Scanner;
import model.Permissoao;
import dao.PermissaoDAO;

public class PermissaoCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PermissaoDAO permDao = new PermissaoDAO();
		Scanner in = new Scanner(System.in);

		int oP = 0;
		int posicao = 0;
		String tipoPermissao = "";

		do {
			System.out.println("=== Permissao CRUD ===");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Consultar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Deletar");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				//CADASTRAR
				System.out.println("Digite o tipo do Acesso/Permissão: ");
				tipoPermissao = in.next();

				Permissoao permissao1 = new Permissoao(tipoPermissao);
				permDao.save(permissao1);

				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				//LISTAR
				for (Permissoao perm : permDao.getPermissaoList()) {
					System.out.println(
							"ID: " + perm.getIdPermissao() + "Tipo de Acesso/Permissao: " + perm.getTipoPermissao());
				}
				System.out.println("Listagem finalizada!");
				break;

			case 3:
				//ATUALIZAR
				System.out.println("Digite o ID da Permissão que deseja atualizar: ");
				posicao = in.nextInt();
				System.out.println("Digite o novo tipo de acesso: ");
				tipoPermissao = in.next();

				Permissoao perm2 = new Permissoao(tipoPermissao);
				permDao.update(perm2);

				System.out.println("Informações atualizadas! " + perm2.getTipoPermissao());
				break;

			case 4:
				//CONSULTAR POR ID
				System.out.println("Digite o ID de Permissao: ");
				posicao = in.nextInt();

				Permissoao perm3 = permDao.getPermissaoById(posicao);
				System.out.println(
						"ID: " + perm3.getIdPermissao() + "Tipo de Acesso/Permissao: " + perm3.getTipoPermissao());
				break;
				
			case 5:
				//DELETAR POR ID
				System.out.println("Digite o ID da Permissão que deseja consultar: ");
				posicao = in.nextInt();

				permDao.deleteById(posicao);
				break;

			default:
				System.out.println(oP != 0 ? "Opção inválida, digite novamente." : "");
				break;
			}

		} while (oP != 0);

		System.out.println("Finalizado.");
		in.close();
	}

}