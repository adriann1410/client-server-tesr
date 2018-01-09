package projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {
	
	public boolean checkDriver(String driver) {
		// LADOWANIE STEROWNIKA
		System.out.print("Sprawdzanie sterownika:");
		try {
			Class.forName(driver).newInstance();
			return true;
		} catch (Exception e) {
			System.out.println("Blad przy ladowaniu sterownika bazy!");
			return false;
		}
	}
	
	public Connection getConnection(String kindOfDatabase, String adres, int port, String userName, String password) {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		try {
			conn = DriverManager.getConnection(kindOfDatabase + adres + ":" + port + "/",
					connectionProps);
		} catch (SQLException e) {
			System.out.println("B³¹d po³¹czenia z baz¹ danych! " + e.getMessage() + ": " + e.getErrorCode());
			System.exit(2);
		}
		System.out.println("Po³¹czenie z baz¹ danych: ... OK");
		return conn;
	}
	
	public Connection connectToDatabase(String kindOfDatabase, String adress,
			String dataBaseName, String userName, String password) {
		System.out.print("\nLaczenie z baz¹ danych:");
		String baza = kindOfDatabase + adress + "/" + dataBaseName;

		java.sql.Connection connection = null;
		try {
			connection = DriverManager.getConnection(baza, userName, password);
		} catch (SQLException e) {
			System.out.println("Blad przy po³¹czeniu z baz¹ danych!");
			System.exit(1);
		}
		return connection;
	}
	
	Statement createStatement(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("B³¹d createStatement! " + e.getMessage() + ": " + e.getErrorCode());
			System.exit(3);
		}
		return null;
	}
	
	int executeUpdate(Statement s, String sql) {
		try {
			return s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Zapytanie nie wykonane! " + e.getMessage() + ": " + e.getErrorCode());
		}
		return -1;
	}
	
	ResultSet executeQuery(Statement s, String sql) {
		try {
			return s.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Zapytanie nie wykonane! " + e.getMessage() + ": " + e.getErrorCode());
		}
		return null;
	}
	
	 String[] getPytania(ResultSet r) {
		ResultSetMetaData rsmd;
		String[] wynik = new String[4];
		try {
			rsmd = r.getMetaData();
			int i=0;
			while (r.next()) {
					Object obj = r.getObject(1);
						wynik[i] = obj.toString();
						i++;					
			}
		} catch (SQLException e) {
			System.out.println("Bl¹d odczytu z bazy! " + e.getMessage() + ": " + e.getErrorCode());
		}
		return wynik;
	}
	
	 String[] getOdpowiedzi(ResultSet r) {
		ResultSetMetaData rsmd;
		String[] wynik = new String[4];
		try {
			rsmd = r.getMetaData();
			int numcols = rsmd.getColumnCount();
			while (r.next()) {
			for (int i = 1; i <= numcols; i++) {
				Object obj = r.getObject(i);
					wynik[i-1] = obj.toString();
			}
			}
		} catch (SQLException e) {
			System.out.println("Bl¹d odczytu z bazy! " + e.getMessage() + ": " + e.getErrorCode());
		}
		return wynik;
	}
	
	 String getKlucz(ResultSet r) {
		String wynik = new String();
		ResultSetMetaData rsmd;
		try {
			rsmd = r.getMetaData();
			while (r.next()) {
					Object obj = r.getObject(1);
						wynik += obj.toString();											
			}
		} catch (SQLException e) {
			System.out.println("Bl¹d odczytu z bazy! " + e.getMessage() + ": " + e.getErrorCode());
		}
		
		return wynik;
	}
	
	int getNewId(Statement st){
		int id = 0;
		ResultSet r = executeQuery(st, "SELECT count(*) FROM uzytkownicy;");
		ResultSetMetaData rsmd;
		try {
			rsmd = r.getMetaData();
			int numcols = rsmd.getColumnCount();
			while (r.next()) {
			for (int i = 1; i <= numcols; i++) {
				Object obj = r.getObject(i);
					id = Integer.parseInt(obj.toString());
			}
			}
		} catch (SQLException e) {
			System.out.println("Bl¹d odczytu z bazy! " + e.getMessage() + ": " + e.getErrorCode());
		}		
		return id;
	}
	 
	
	 void closeConnection(Connection connection, Statement s) {
		System.out.print("\nZamykanie polaczenia z baz¹:");
		try {
			s.close();
			connection.close();
		} catch (SQLException e) {
			System.out
					.println("Bl¹d przy zamykaniu pol¹czenia z baz¹! " + e.getMessage() + ": " + e.getErrorCode());;
			System.exit(4);
		}
		System.out.print(" zamkniêcie OK");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Database data = new Database();
		
		if (data.checkDriver("com.mysql.jdbc.Driver"))
			System.out.println(" ... OK");
		else
			System.exit(1);
		
		Connection con = data.getConnection("jdbc:mysql://", "localhost", 3306, "root", "");
		Statement st = data.createStatement(con);
		
		if (data.executeUpdate(st, "USE projektBaza;") == 0)
			System.out.println("Baza wybrana");
		else {
			System.out.println("Baza nie istnieje! Tworzymy bazê: ");
			if (data.executeUpdate(st, "create Database projektBaza;") == 1)
				System.out.println("Baza utworzona");
			else
				System.out.println("Baza nieutworzona!");
			if (data.executeUpdate(st, "USE projektBaza;") == 0)
				System.out.println("Baza wybrana");
			else
				System.out.println("Baza niewybrana!");
		}
		// Tworzenie bazy danych
		if (data.executeUpdate(st,
				"CREATE TABLE pytania ( id INT NOT NULL, pytanie VARCHAR(100) NOT NULL, PRIMARY KEY (id) );") == 0)
			System.out.println("Tabela utworzona");
		else
			System.out.println("Tabela nie utworzona!");
		if (data.executeUpdate(st,
				"CREATE TABLE odpowiedzi ( id INT NOT NULL, id_pytania INT NOT NULL, odp1 VARCHAR(100) NOT NULL,"
		+ " odp2 VARCHAR(100) NOT NULL, odp3 VARCHAR(100) NOT NULL, odp4 VARCHAR(100) NOT NULL, PRIMARY KEY (id),"
		+ " FOREIGN KEY (id_pytania) REFERENCES pytania (id));") == 0)
			System.out.println("Tabela utworzona");
		else
			System.out.println("Tabela nie utworzona!");
		if (data.executeUpdate(st,
				"CREATE TABLE klucz ( id INT NOT NULL, id_pytania INT NOT NULL, poprawna_odp VARCHAR(100) NOT NULL, PRIMARY KEY (id),"
				+ "FOREIGN KEY (id_pytania) REFERENCES pytania (id));") == 0)
			System.out.println("Tabela utworzona");
		else
			System.out.println("Tabela nie utworzona!");
		if (data.executeUpdate(st,
				"CREATE TABLE uzytkownicy ( id INT NOT NULL, odp1 INT, odp2 INT,odp3 INT, odp4 INT, PRIMARY KEY (id));") == 0)
			System.out.println("Tabela utworzona");
		else
			System.out.println("Tabela nie utworzona!");
		// Dodawanie odpowiedzi i pytañ do bazy
		
		data.executeUpdate(st, "INSERT INTO pytania VALUES(1, 'Jaki kolor ma niebo?');");
		data.executeUpdate(st, "INSERT INTO odpowiedzi VALUES(1, 1, 'niebieski', 'czerwony', 'zolty', 'fioletowy');");
		data.executeUpdate(st, "INSERT INTO pytania VALUES(2, 'czy java jest super?');");
		data.executeUpdate(st, "INSERT INTO odpowiedzi VALUES(2, 2, 'tak', 'nie', 'jeszcze jak', 'nie wiem');");
		data.executeUpdate(st, "INSERT INTO pytania VALUES(3, 'najlepsza uczelnia w krakowie?');");
		data.executeUpdate(st, "INSERT INTO odpowiedzi VALUES(3, 3, 'pk', 'agh', 'uj', 'uek');");
		data.executeUpdate(st, "INSERT INTO pytania VALUES(4, 'czy ala ma kota?');");
		data.executeUpdate(st, "INSERT INTO odpowiedzi VALUES(4, 4, 'tak', 'nie', 'jeszcze jak', 'nie wiem');");
		data.executeUpdate(st, "INSERT INTO klucz VALUES(1,1,1);");
		data.executeUpdate(st, "INSERT INTO klucz VALUES(2,2,1);");
		data.executeUpdate(st, "INSERT INTO klucz VALUES(3,3,1);");
		data.executeUpdate(st, "INSERT INTO klucz VALUES(4,4,4);");
		

		
	}

}




