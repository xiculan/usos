/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xicu.usos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author xicu
 *
 *
 */
public class Aux_ci {

    static String login = "xicu";

    static String url_local = "jdbc:mysql://127.0.0.1/java_mysql";

    static String url_rasp136 = "jdbc:mysql://192.168.1.136:3306/gestf?serverTimezone=UTC";
//	static String url_debian2 = "jdbc:mysql://192.168.191.138/dolibarr?serverTimezone=UTC";
    static String url_debian2 = "jdbc:mysql://192.168.191.138/dolibarr";

    Properties data = new Properties();
//	data.load(new FileInputStream("data.properties"));

    static String directoryName = System.getProperty("user.dir");
    static String RutaData = directoryName + System.getProperty("file.separator") + "data.properties";

    public static String PassCi = "ControlIntegral5685";
    public static String Pass136 = "Swed1212*";

    // ***********************************************************************
    public String proba_ci() {
        String msg = null;
        Connection conn = null;

        try {

            //String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
            
            String dbUrl = "user=sa;" + "password=PassCi  jdbc:sqlserver://192.168.191.141:1433;" 
            + "databaseName=INTEGRAL;" + PassCi + ";encrypt=true;" + "trustServerCertificate=true;";
            
            String user = "sa";
            String pass = "secret";
            String dbURL = null;
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return msg;
    }

    public Connection conectar_ci() {
        Connection conexion = null;
        //String PassCi = data.getProperty("PassCi");
        //System.out.println(PassCi);
        //System.out.println(RutaData);

        String connectionUrl = "jdbc:sqlserver://192.168.191.141:1433;" + "databaseName=INTEGRAL;" + "user=sa;"
                + "password=" + PassCi + ";encrypt=true;" + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        System.out.println(connectionUrl);
        try {
            conexion = DriverManager.getConnection(connectionUrl);
            /*
			 * DatabaseMetaData meta = con.getMetaData(); ResultSet res =
			 * meta.getTables(null, null, null, new String[] {"TABLE"});
			 * System.out.println("List of tables: "); while (res.next()) {
			 * System.out.println( "   "+res.getString("TABLE_CAT") +
			 * ", "+res.getString("TABLE_SCHEM") + ", "+res.getString("TABLE_NAME") +
			 * ", "+res.getString("TABLE_TYPE") + ", "+res.getString("REMARKS")); }
			 * res.close();
			 * 
			 * con.close();
             */
            return conexion;
        } catch (Exception ex) {
            // JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
            System.out.println("no se ha realizado la conexion");
        }
        return null;
    }

    public ResultSet consulta1_ci(String query) throws SQLException {
        ResultSet resultSet = null;
        Connection cone = null;
        cone = this.conectar_ci();
        Statement statement = cone.createStatement();
        {
            // Create and execute a SELECT SQL statement.
            //String selectSql = "SELECT * FROM integral.dbo.articulos WHERE cod_familia = 'EKT'";
            System.out.println(query);
            resultSet = statement.executeQuery(query);
            // Print results from select statement
            //while (resultSet.next()) {
            //System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            //}

            return resultSet;

        }

    }

    public String comprobar_sql_server(String url, String driver) {
        String userName = "sa";
        String password = "ControlIntegral5685";
        // String url =
        //"jdbc:sqlserver://192.168.1.141\\SQLEXPRESS;databaseName=INTEGRAL2";
//		String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=INTEGRAL2";
        Connection conn = null;

        try {
            Class.forName(driver);
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            /*
			 * try { conn = DriverManager.getConnection(url, userName, password);
			 * 
			 * // Conntction conn = DriverManager.getConnection(url, userName, password);
			 * return "Conexion establecida"; } catch (Exception e) { System.out.println(e);
			 * }
             */
        } catch (Exception e1) {
            System.out.println(e1);
            // return e1;
        }
        return conn.toString();
    }

    public Connection conectar_gestf_local() {
        String MySQLURL = "jdbc:mysql://localhost:3306/gestf?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        String message = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                message = "conection done";
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

       // return message;
        return null;
    }
    public String conectar_gestf_remot() {
        String MySQLURL = "jdbc:mysql://192.168.1.154:3306/gestf?useSSL=false";
        String databseUserName = "xicu";
        String databasePassword = "Swed1212";
        Connection con = null;
        String message = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                message = "conection done";
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }
    public String check_ci_connection() {
        String connectionUrl = "jdbc:sqlserver://192.168.191.141:1433;" + "databaseName=INTEGRAL;" + "user=sau;"
                + "password=" + PassCi + ";encrypt=true;" + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        String MySQLURL = "jdbc:mysql://localhost:3306/gestf?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        return con.toString();
    }

}
