package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

	// Credenciais de acesso ao Banco
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";

	// Endereço do branco, porta e nome da base - localhost: Máquina local nesse caso
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/PONTOPARTIDA";

	
	// Método que retorna uma conexão do tipo Connection. 
	//createConnectionToMySQL é o nome do método, podia ser outro criarConexão
	//throws Exception: Excessão, caso o banco não for encontrado, ele retorna o erro para quem chamou o método 
	//Quem receber o erro o trata da melhor forma possível.
	public static Connection createConnectionToMySQL() throws Exception {

		// Faz com que a clsse seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Cria a variavel de retorno, do tipo connection e atribui a ela a conexão com o banco
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection; //Retorna a conexão completa ou a excessão
	}
	
	
	//Classe principal de execução que chama o método createConnectionToMySQL
	public static void main(String[] args) throws Exception {
		// Cria uma conexão com o banco
		Connection conexao = createConnectionToMySQL();

		// Testa se a conexão é nula
		if (conexao != null) {
			System.out.println(conexao + "\n\n *** Banco conectado com sucesso! *** " + conexao);
			conexao.close();
		}
	}
}
