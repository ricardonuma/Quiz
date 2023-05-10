package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	// CONEX�O COM O BANCO DE DADOS DERBY (JAVADB)
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:quiz;create=true";
	public static Connection getConexao() throws SQLException, ClassNotFoundException {

		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(JDBC_URL);
			Statement statement = conn.createStatement();

			try
			{
				// VERIFICAR SE TABELA JOGADOR EXISTE
				final String SQL_JOGADOR = "select * from jogador";
				ResultSet resultSet = statement.executeQuery(SQL_JOGADOR);
				if (resultSet.next())
					System.out.println("Tabela jogador j� existe...");
			}
			catch(SQLException ex)
			{
				if(ex.getSQLState().contains("42X05"))
				{
					// CRIA TABELA JOGADOR
					conn.createStatement().execute("create table jogador" +
							" (ID_JOGADOR INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
							" NOME varchar(15), SCORE integer)");
					System.out.println("Tabela jogador foi criada com sucesso...");
				}
			}


			try
			{
				// VERIFICAR SE TABELA PERGUNTA EXISTE
				final String SQL_PERGUNTA = "select * from pergunta";
				ResultSet resultSet = statement.executeQuery(SQL_PERGUNTA);
				if(resultSet.next())
					System.out.println("Tabela pergunta j� existe...");
			}
			catch(SQLException ex)
			{
				if(ex.getSQLState().contains("42X05"))
				{
					// CRIA TABELA PERGUNTA
					conn.createStatement().execute("create table pergunta" +
							" (ID_PERGUNTA INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
							" PERGUNTA CLOB(4 K))");
					conn.createStatement().execute("insert into pergunta (PERGUNTA) values " +
							"('Mais da metade do lixo de nossa casa pode ser reciclado. Para contribuir com isso devemos:'), " +
							"('Uma das solu��es para se diminuir o aquecimento global �:'), " +
							"('O lixo � um problema mundial e muitos materiais levam anos para se decomporem. Os vidros:'), " +
							"('A queima de lixo libera at� 27 metais pesados e gases. Isso contribui para a forma��o:'), " +
							"('O aquecimento global �:'), " +
							"('Definimos como energia sustent�vel:'), " +
							"('O que � Reciclagem?'), " +
							"('Como separar corretamente seu lixo?'), " +
							"('O que � coleta seletiva?'), " +
							"('O que fazer com o lixo eletr�nico � pilhas, baterias e equipamentos quebrados?'), " +
							"('Uma das formas de colaborar com a preserva��o do meio ambiente � reduzir a produ��o de res�duos. Mas como?'), " +
							"('Como consumir de forma consciente?'), " +
							"('Como preservar �rvores e florestas?'), " +
							"('Qual dos elementos abaixo n�o � utilizado como fonte de energia?'), " +
							"('Indique uma vantagem da energia solar'), " +
							"('Qual � o maior ser vivo do mundo?'), " +
							"('O fen�meno atmosf�rico designado por El-Ni�o tem origem em que oceano?'), " +
							"('Qual � a percentagem de polui��o que entra nos oceanos e tem origem em atividades humanas terrestres?'), " +
							"('A camada de oz�nio � uma importante barreira contra que tipo de radia��o solar?'), " +
							"('Maior fonte geradora de energia el�trica no Brasil.'), " +
							"('Podemos afirmar que s�o consequ�ncias da Globaliza��o:'), " +
							"('O que N�o podemos afirmar sobre o combust�vel Biodiesel.'), " +
							"('Quais fatores contribuem para o acelerado crescimento urbano no Brasil?'), " +
							"('N�o � fonte de energia renov�vel:'), " +
							"('Qual das gest�es apresentadas � respons�vel pela administra��o do exerc�cio de atividades econ�micas e sociais na utiliza��o de recursos naturais?'), " +
							"('Qual a cor da lixeira espec�fica para o metal?'), " +
							"('O Brasil � exemplo em reciclagem de:'), " +
							"('Qual destes � um m�todo de preserva��o ambiental?'), " +
							"('A Lei da Pol�tica Nacional do Meio Ambiente tem por objetivo:'), " +
							"('Defina �Ambiente Espoliado�')");
					System.out.println("Tabela pergunta e seus registros foram criados com sucesso...");
				}
			}


			try
			{
				// VERIFICAR SE TABELA RESPOSTA EXISTE
				final String SQL_RESPOSTA = "select * from resposta";
				ResultSet resultSet = statement.executeQuery(SQL_RESPOSTA);
				if(resultSet.next())
					System.out.println("Tabela resposta j� existe...");
			}
			catch(SQLException ex)
			{
				if(ex.getSQLState().contains("42X05"))
				{
					// CRIA TABELA RESPOSTA
					conn.createStatement().execute("create table resposta" +
							" (ID_RESPOSTA INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
							" RESPOSTA CLOB(1 K), RESPOSTA_CERTA boolean, ID_PERGUNTA INTEGER)");
					conn.createStatement().execute("insert into resposta (RESPOSTA, RESPOSTA_CERTA, ID_PERGUNTA) values " +
							"('A - Separar os materiais recicl�veis do lixo org�nico', true, 1), " +
							"('B - Juntar todos os lixos em um s� saco', false, 1), " +
							"('C - Armazenar somente lixo org�nico', false, 1), " +
							"('D - nda', false, 1), " + 
							"('A - Diminuir o uso de combust�veis f�sseis e aumentar o de biocombust�veis', true, 2), " +
							"('B - Utilizar ao m�ximo energia atrav�s de termoel�tricas', false, 2), " +
							"('C - Apoiar a pr�tica de desmatamento nas florestas', false, 2), " +
							"('D - nda', false, 2), " + 
							"('A - Levam 90 anos', false, 3), " +
							"('B - Levam 2 mil anos', true, 3), " +
							"('C - Levam 4 mil anos', false, 3), " +
							"('D - Levam 10 anos', false, 3), " + 
							"('A - De tempestades', false, 4), " +
							"('B - De queimadas', false, 4), " +
							"('C - Da chuva �cida', true, 4), " +
							"('D - nda', false, 4), " + 
							"('A - O gasto excessivo de �gua', false, 5), " +
							"('B - Um fen�meno clim�tico decorrente de causas naturais e humanas', true, 5), " +
							"('C - Quando a temperatura dos oceanos diminui', false, 5), " +
							"('D - nda', false, 5), " + 
							"('A - Quando diminu�mos o gasto de energia el�trica', false, 6), " +
							"('B - A energia que pode ser utilizada sem danos ao meio ambiente', true, 6), " +
							"('C - A energia que � gerada atrav�s do vento', false, 6), " +
							"('D - nda', false, 6), " + 
							"('A - �Jogar fora� o lixo produzido.', false, 7), " +
							"('B - Coletar todo tipo de material existente em lixos recicl�veis.', false, 7), " +
							"('C - Nome dado para todo o processo do lixo ap�s seu descarte.', false, 7), " +
							"('D - Processo de transforma��o de materiais usados em novos produtos para consumo.', true, 7), " + 
							"('A - Juntar tudo na lixeira, pois os pr�dios j� fazem o trabalho de separa��o.', false, 8), " +
							"('B - Separar o lixo org�nico (restos de alimentos, papel sujo, etc) dos res�duos s�lidos (como pl�stico, vidro, papel, metal, etc).', true, 8), " +
							"('C - Deixar pl�sticos sujos junto com lixo org�nico.', false, 8), " +
							"('D - Juntar todo tipo de lixo e descartar em ponto de coleta.', false, 8), " + 
							"('A - Processo de separa��o e recolhimento dos res�duos para o reaproveitamento por meio de reciclagem.', true, 9), " +
							"('B - Destina��o de res�duos para lix�es e aterros.', false, 9), " +
							"('C - Processo de envio de todo lixo produzido para cooperativas ou entrega para catadores de rua.', false, 9), " +
							"('D - A escolha aleat�ria do melhor lixo produzido.', false, 9), " + 
							"('A - Recolher, organizar e armazenar em casa o m�ximo de tempo que der.', false, 10), " +
							"('B - Juntar com pl�sticos e metais.', false, 10), " +
							"('C - Jogar no lixo comum.', false, 10), " +
							"('D - Procurar locais espec�ficos para seu descarte.', true, 10), " + 
							"('A - Optando pela compra de produtos com embalagens recicl�veis.', false, 11), " +
							"('B - Reutilizando os materiais e objetos sempre que poss�vel.', false, 11), " +
							"('C - Apoiando iniciativas de reciclagem.', false, 11), " +
							"('D - Todas as anteriores.', true, 11), " + 
							"('A - Trocando todos os nossos objetos sempre que um novo do mesmo tipo for lan�ado.', false, 12), " +
							"('B - Usar a mangueira para lavar o quintal e o carro.', false, 12), " +
							"('C - Utilizando os recursos naturais para satisfazer nossas necessidades e das gera��es futuras.', true, 12), " +
							"('D - Adquirindo qualquer tipo de produto se for barato.', false, 12), " + 
							"('A - Construindo uma casa na �rvore.', false, 13), " +
							"('B - Reciclando pap�is, jornais e revistas.', true, 13), " +
							"('C - Reutilizando metais e vidros.', false, 13), " +
							"('D - Indo em parques.', false, 13), " + 
							"('A - �gua corrente', false, 14), " +
							"('B - Petr�leo', false, 14), " +
							"('C - Barra de ferro', true, 14), " +
							"('D - Sol', false, 14), " + 
							"('A - N�o polui.', true, 15), " +
							"('B - N�o � renov�vel.', false, 15), " +
							"('C - � eficaz em qualquer clima.', false, 15), " +
							"('D - � dispon�vel a todo momento.', false, 15), " + 
							"('A - Lula-gigante (Architeuthis spp.)', false, 16), " +
							"('B - Fungo (Armillaria ostoyae)', false, 16), " +
							"('C - Baleia-azul (Balaenoptera musculus)', false, 16), " +
							"('D - Sequ�ia gigante (Sequoiadendron giganteum)', true, 16), " + 
							"('A - Pac�fico', true, 17), " +
							"('B - �ndico', false, 17), " +
							"('C - �rtico', false, 17), " +
							"('D - Atl�ntico', false, 17), " + 
							"('A - 1%', false, 18), " +
							"('B - 10%', false, 18), " +
							"('C - 45%', false, 18), " +
							"('D - 80%', true, 18), " + 
							"('A - Micro-ondas', false, 19), " +
							"('B - Infra-vermelhos', false, 19), " +
							"('C - Gama', false, 19), " +
							"('D - Ultra-violetas', true, 19), " + 
							"('A - Usinas de carv�o mineral.', false, 20), " +
							"('B - Usinas Nucleares.', false, 20), " +
							"('C - Usinas hidroel�tricas.', true, 20), " +
							"('D - Usinas de carv�o vegetal, da queima de madeira.', false, 20), " + 
							"('A - Os pa�ses ricos ficar�o mais pobres, pois seus recursos s�o escassos.', false, 21), " +
							"('B - N�o haver� fus�o de culturas, e nem dom�nio dos ricos sobre os pobres.', false, 21), " +
							"('C - Os pa�ses pobres ficam mais pobres, pois n�o possuem meios para concorrer. ', true, 21), " +
							"('D - Os pa�ses pobres ficam mais pobres, pois n�o possuem meios para concorrer.', false, 21), " + 
							"('A - Combust�vel renov�vel, de origem vegetal.', false, 22), " +
							"('B - A Mamona � uma fonte desse tipo de combust�vel.', false, 22), " +
							"('C - Combust�vel n�o renov�vel, assim como o petr�leo.', true, 22), " +
							"('D - � menos poluente que os derivados de petr�leo.', false, 22), " + 
							"('A - �xodo rural', false, 23), " +
							"('B - Imigra��o', false, 23), " +
							"('C - �xodo urbano', true, 23), " +
							"('D - Nda', false, 23), " + 
							"('A - Energia solar passiva', true, 24), " +
							"('B - Energia nuclear', false, 24), " +
							"('C - Energia Geot�rmica', false, 24), " +
							"('D - Nda', false, 24), " + 
							"('A - Gest�o ecol�gica', false, 25), " +
							"('B - Gest�o pol�tica', false, 25), " +
							"('C - Gest�o de recursos ambientais', true, 25), " +
							"('D - Nda', false, 25), " +
							"('A - Laranja', false, 26), " +
							"('B - Azul', false, 26), " +
							"('C - Amarela', true, 26), " +
							"('D - Verde', false, 26), " +
							"('A - Papel para uso escolar', false, 27), " +
							"('B - Lata de alum�nio', true, 27), " +
							"('C - Garrafas pl�sticas (PET)', false, 27), " +
							"('D - Nda', false, 27), " +
							"('A - Reflorestamento', true, 28), " +
							"('B - Desmatamento', false, 28), " +
							"('C - Destila��o', false, 28), " +
							"('D - Nda', false, 28), " +
							"('A - Fiscalizar a utiliza��o da coleta seletiva nos bairros', false, 29), " +
							"('B - Incentivar o estudo �s quest�es ambientais e o uso da tecnologia em prol delas', true, 29), " +
							"('C - Controle potencial da emiss�o de gases em ind�strias de grande porte', false, 29), " +
							"('D - Nda', false, 29), " +
							"('A - Ambiente ou faixa ambiental que possui multi caracter�sticas', false, 30), " +
							"('B - Ambiente originado de a��es humanas', false, 30), " +
							"('C - Ambiente que possui recursos naturais escassos por uso excessivo ilegalmente', true, 30), " +
							"('D - Nda', false, 30)");
					System.out.println("Tabela resposta e seus registros foram criados com sucesso...");
				}
			}
			
			System.out.println("Conex�o aberta!!! "+ conn);
			return conn;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"Driver Derby (JavaDB) n�o foi encontrado " + e.getMessage());

		} catch (SQLException e) {
			throw new SQLException("Erro ao conectar "
					+ "com a base de dados" + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				System.out.println("Fechada a conex�o com o banco de dados");
			}

		} catch (Exception e) {
			System.out.println("N�o foi poss�vel fechar a conex�o com o banco de dados " + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn, PreparedStatement stmt) {

		try {
			if (conn != null) {
				fechaConexao(conn);
			}
			if (stmt != null) {
				System.out.println("close stmt " + stmt.isClosed());
				stmt.close();
				System.out.println("Statement fechado com sucesso");
			}


		} catch (Exception e) {
			System.out.println("N�o foi poss�vel fechar o statement " + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {

		try {
			if (conn != null || stmt != null) {
				fechaConexao(conn, stmt);
			}
			if (rs != null) {
				rs.close();
				System.out.println("ResultSet fechado com sucesso");
			}


		} catch (Exception e) {
			System.out.println("N�o foi poss�vel fechar o ResultSet " + e.getMessage());
		}
	}
		
}