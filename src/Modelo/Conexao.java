package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	// CONEXÃO COM O BANCO DE DADOS DERBY (JAVADB)
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
					System.out.println("Tabela jogador já existe...");
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
					System.out.println("Tabela pergunta já existe...");
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
							"('Uma das soluções para se diminuir o aquecimento global é:'), " +
							"('O lixo é um problema mundial e muitos materiais levam anos para se decomporem. Os vidros:'), " +
							"('A queima de lixo libera até 27 metais pesados e gases. Isso contribui para a formação:'), " +
							"('O aquecimento global é:'), " +
							"('Definimos como energia sustentável:'), " +
							"('O que é Reciclagem?'), " +
							"('Como separar corretamente seu lixo?'), " +
							"('O que é coleta seletiva?'), " +
							"('O que fazer com o lixo eletrônico – pilhas, baterias e equipamentos quebrados?'), " +
							"('Uma das formas de colaborar com a preservação do meio ambiente é reduzir a produção de resíduos. Mas como?'), " +
							"('Como consumir de forma consciente?'), " +
							"('Como preservar árvores e florestas?'), " +
							"('Qual dos elementos abaixo não é utilizado como fonte de energia?'), " +
							"('Indique uma vantagem da energia solar'), " +
							"('Qual é o maior ser vivo do mundo?'), " +
							"('O fenômeno atmosférico designado por El-Niño tem origem em que oceano?'), " +
							"('Qual é a percentagem de poluição que entra nos oceanos e tem origem em atividades humanas terrestres?'), " +
							"('A camada de ozônio é uma importante barreira contra que tipo de radiação solar?'), " +
							"('Maior fonte geradora de energia elétrica no Brasil.'), " +
							"('Podemos afirmar que são consequências da Globalização:'), " +
							"('O que Não podemos afirmar sobre o combustível Biodiesel.'), " +
							"('Quais fatores contribuem para o acelerado crescimento urbano no Brasil?'), " +
							"('Não é fonte de energia renovável:'), " +
							"('Qual das gestões apresentadas é responsável pela administração do exercício de atividades econômicas e sociais na utilização de recursos naturais?'), " +
							"('Qual a cor da lixeira específica para o metal?'), " +
							"('O Brasil é exemplo em reciclagem de:'), " +
							"('Qual destes é um método de preservação ambiental?'), " +
							"('A Lei da Política Nacional do Meio Ambiente tem por objetivo:'), " +
							"('Defina “Ambiente Espoliado”')");
					System.out.println("Tabela pergunta e seus registros foram criados com sucesso...");
				}
			}


			try
			{
				// VERIFICAR SE TABELA RESPOSTA EXISTE
				final String SQL_RESPOSTA = "select * from resposta";
				ResultSet resultSet = statement.executeQuery(SQL_RESPOSTA);
				if(resultSet.next())
					System.out.println("Tabela resposta já existe...");
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
							"('A - Separar os materiais recicláveis do lixo orgânico', true, 1), " +
							"('B - Juntar todos os lixos em um só saco', false, 1), " +
							"('C - Armazenar somente lixo orgânico', false, 1), " +
							"('D - nda', false, 1), " + 
							"('A - Diminuir o uso de combustíveis fósseis e aumentar o de biocombustíveis', true, 2), " +
							"('B - Utilizar ao máximo energia através de termoelétricas', false, 2), " +
							"('C - Apoiar a prática de desmatamento nas florestas', false, 2), " +
							"('D - nda', false, 2), " + 
							"('A - Levam 90 anos', false, 3), " +
							"('B - Levam 2 mil anos', true, 3), " +
							"('C - Levam 4 mil anos', false, 3), " +
							"('D - Levam 10 anos', false, 3), " + 
							"('A - De tempestades', false, 4), " +
							"('B - De queimadas', false, 4), " +
							"('C - Da chuva ácida', true, 4), " +
							"('D - nda', false, 4), " + 
							"('A - O gasto excessivo de água', false, 5), " +
							"('B - Um fenômeno climático decorrente de causas naturais e humanas', true, 5), " +
							"('C - Quando a temperatura dos oceanos diminui', false, 5), " +
							"('D - nda', false, 5), " + 
							"('A - Quando diminuímos o gasto de energia elétrica', false, 6), " +
							"('B - A energia que pode ser utilizada sem danos ao meio ambiente', true, 6), " +
							"('C - A energia que é gerada através do vento', false, 6), " +
							"('D - nda', false, 6), " + 
							"('A - “Jogar fora” o lixo produzido.', false, 7), " +
							"('B - Coletar todo tipo de material existente em lixos recicláveis.', false, 7), " +
							"('C - Nome dado para todo o processo do lixo após seu descarte.', false, 7), " +
							"('D - Processo de transformação de materiais usados em novos produtos para consumo.', true, 7), " + 
							"('A - Juntar tudo na lixeira, pois os prédios já fazem o trabalho de separação.', false, 8), " +
							"('B - Separar o lixo orgânico (restos de alimentos, papel sujo, etc) dos resíduos sólidos (como plástico, vidro, papel, metal, etc).', true, 8), " +
							"('C - Deixar plásticos sujos junto com lixo orgânico.', false, 8), " +
							"('D - Juntar todo tipo de lixo e descartar em ponto de coleta.', false, 8), " + 
							"('A - Processo de separação e recolhimento dos resíduos para o reaproveitamento por meio de reciclagem.', true, 9), " +
							"('B - Destinação de resíduos para lixões e aterros.', false, 9), " +
							"('C - Processo de envio de todo lixo produzido para cooperativas ou entrega para catadores de rua.', false, 9), " +
							"('D - A escolha aleatória do melhor lixo produzido.', false, 9), " + 
							"('A - Recolher, organizar e armazenar em casa o máximo de tempo que der.', false, 10), " +
							"('B - Juntar com plásticos e metais.', false, 10), " +
							"('C - Jogar no lixo comum.', false, 10), " +
							"('D - Procurar locais específicos para seu descarte.', true, 10), " + 
							"('A - Optando pela compra de produtos com embalagens recicláveis.', false, 11), " +
							"('B - Reutilizando os materiais e objetos sempre que possível.', false, 11), " +
							"('C - Apoiando iniciativas de reciclagem.', false, 11), " +
							"('D - Todas as anteriores.', true, 11), " + 
							"('A - Trocando todos os nossos objetos sempre que um novo do mesmo tipo for lançado.', false, 12), " +
							"('B - Usar a mangueira para lavar o quintal e o carro.', false, 12), " +
							"('C - Utilizando os recursos naturais para satisfazer nossas necessidades e das gerações futuras.', true, 12), " +
							"('D - Adquirindo qualquer tipo de produto se for barato.', false, 12), " + 
							"('A - Construindo uma casa na árvore.', false, 13), " +
							"('B - Reciclando papéis, jornais e revistas.', true, 13), " +
							"('C - Reutilizando metais e vidros.', false, 13), " +
							"('D - Indo em parques.', false, 13), " + 
							"('A - Água corrente', false, 14), " +
							"('B - Petróleo', false, 14), " +
							"('C - Barra de ferro', true, 14), " +
							"('D - Sol', false, 14), " + 
							"('A - Não polui.', true, 15), " +
							"('B - Não é renovável.', false, 15), " +
							"('C - É eficaz em qualquer clima.', false, 15), " +
							"('D - É disponível a todo momento.', false, 15), " + 
							"('A - Lula-gigante (Architeuthis spp.)', false, 16), " +
							"('B - Fungo (Armillaria ostoyae)', false, 16), " +
							"('C - Baleia-azul (Balaenoptera musculus)', false, 16), " +
							"('D - Sequóia gigante (Sequoiadendron giganteum)', true, 16), " + 
							"('A - Pacífico', true, 17), " +
							"('B - Índico', false, 17), " +
							"('C - Ártico', false, 17), " +
							"('D - Atlântico', false, 17), " + 
							"('A - 1%', false, 18), " +
							"('B - 10%', false, 18), " +
							"('C - 45%', false, 18), " +
							"('D - 80%', true, 18), " + 
							"('A - Micro-ondas', false, 19), " +
							"('B - Infra-vermelhos', false, 19), " +
							"('C - Gama', false, 19), " +
							"('D - Ultra-violetas', true, 19), " + 
							"('A - Usinas de carvão mineral.', false, 20), " +
							"('B - Usinas Nucleares.', false, 20), " +
							"('C - Usinas hidroelétricas.', true, 20), " +
							"('D - Usinas de carvão vegetal, da queima de madeira.', false, 20), " + 
							"('A - Os países ricos ficarão mais pobres, pois seus recursos são escassos.', false, 21), " +
							"('B - Não haverá fusão de culturas, e nem domínio dos ricos sobre os pobres.', false, 21), " +
							"('C - Os países pobres ficam mais pobres, pois não possuem meios para concorrer. ', true, 21), " +
							"('D - Os países pobres ficam mais pobres, pois não possuem meios para concorrer.', false, 21), " + 
							"('A - Combustível renovável, de origem vegetal.', false, 22), " +
							"('B - A Mamona é uma fonte desse tipo de combustível.', false, 22), " +
							"('C - Combustível não renovável, assim como o petróleo.', true, 22), " +
							"('D - É menos poluente que os derivados de petróleo.', false, 22), " + 
							"('A - Êxodo rural', false, 23), " +
							"('B - Imigração', false, 23), " +
							"('C - Êxodo urbano', true, 23), " +
							"('D - Nda', false, 23), " + 
							"('A - Energia solar passiva', true, 24), " +
							"('B - Energia nuclear', false, 24), " +
							"('C - Energia Geotérmica', false, 24), " +
							"('D - Nda', false, 24), " + 
							"('A - Gestão ecológica', false, 25), " +
							"('B - Gestão política', false, 25), " +
							"('C - Gestão de recursos ambientais', true, 25), " +
							"('D - Nda', false, 25), " +
							"('A - Laranja', false, 26), " +
							"('B - Azul', false, 26), " +
							"('C - Amarela', true, 26), " +
							"('D - Verde', false, 26), " +
							"('A - Papel para uso escolar', false, 27), " +
							"('B - Lata de alumínio', true, 27), " +
							"('C - Garrafas plásticas (PET)', false, 27), " +
							"('D - Nda', false, 27), " +
							"('A - Reflorestamento', true, 28), " +
							"('B - Desmatamento', false, 28), " +
							"('C - Destilação', false, 28), " +
							"('D - Nda', false, 28), " +
							"('A - Fiscalizar a utilização da coleta seletiva nos bairros', false, 29), " +
							"('B - Incentivar o estudo às questões ambientais e o uso da tecnologia em prol delas', true, 29), " +
							"('C - Controle potencial da emissão de gases em indústrias de grande porte', false, 29), " +
							"('D - Nda', false, 29), " +
							"('A - Ambiente ou faixa ambiental que possui multi características', false, 30), " +
							"('B - Ambiente originado de ações humanas', false, 30), " +
							"('C - Ambiente que possui recursos naturais escassos por uso excessivo ilegalmente', true, 30), " +
							"('D - Nda', false, 30)");
					System.out.println("Tabela resposta e seus registros foram criados com sucesso...");
				}
			}
			
			System.out.println("Conexão aberta!!! "+ conn);
			return conn;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"Driver Derby (JavaDB) não foi encontrado " + e.getMessage());

		} catch (SQLException e) {
			throw new SQLException("Erro ao conectar "
					+ "com a base de dados" + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				System.out.println("Fechada a conexão com o banco de dados");
			}

		} catch (Exception e) {
			System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
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
			System.out.println("Não foi possível fechar o statement " + e.getMessage());
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
			System.out.println("Não foi possível fechar o ResultSet " + e.getMessage());
		}
	}
		
}