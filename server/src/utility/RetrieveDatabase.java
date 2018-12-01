package utility;


import java.sql.*;
import java.util.ArrayList;

import entity.*;


public class RetrieveDatabase extends DatabaseController{
	
	private String username, password;

	
	public RetrieveDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.username  = "root";
		this.password ="P@ssw0rd";
	}
	
	public ArrayList<HDB> getHDB(){
		ArrayList<HDB> hdbList = new ArrayList<HDB>();
		Connection con;
		ResultSet rs = null;
		String query = "SELECT * from hdb order by flat_types asc";
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				HDB h = new HDB(rs.getString("block"),rs.getString("town"),rs.getString("flat_types"),rs.getString("location"),rs.getString("coordinate"),rs.getString("possession_date"),rs.getString("completion_date"),rs.getString("ethnic_quota"),rs.getString("site_plan"),rs.getString("units"));
				  hdbList.add(h);
				}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hdbList;
	}
	
	public ArrayList<HDB> getHDB(int numOfRecords){
        ArrayList<HDB> hdbList = new ArrayList<HDB>();
        Connection con;
        ResultSet rs = null;
        String query = "SELECT * FROM hdb ";
        if(numOfRecords != 0 && numOfRecords < 4)
        {
            query += "ORDER BY RAND() LIMIT " + numOfRecords + ";";
        }
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch (Exception c)
        {
            c.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", username, password);
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                HDB h = new HDB(rs.getString("block"),rs.getString("town"),rs.getString("flat_types"),rs.getString("location"),rs.getString("coordinate"),rs.getString("possession_date"),rs.getString("completion_date"),rs.getString("ethnic_quota"),rs.getString("site_plan"),rs.getString("units"));
                hdbList.add(h);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hdbList;
    }

    public ArrayList<HDB> getHDB(String[] hdbBlockList){
        ArrayList<HDB> hdbList = new ArrayList<HDB>();
        Connection con;
        ResultSet rs = null;
        String query = "SELECT * FROM hdb WHERE block=";
        for (int i = 0; i < hdbBlockList.length; i++) {
            if(i == hdbBlockList.length -1) {
                query += "'" + hdbBlockList[i] +"';";
            }else{
                query += "'" + hdbBlockList[i] + "' OR block =";
            }
        }
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch (Exception c)
        {
            c.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", username, password);
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                HDB h = new HDB(rs.getString("block"),rs.getString("town"),rs.getString("flat_types"),rs.getString("location"),rs.getString("coordinate"),rs.getString("possession_date"),rs.getString("completion_date"),rs.getString("ethnic_quota"),rs.getString("site_plan"),rs.getString("units"));
                hdbList.add(h);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hdbList;
    }
	
	public ResultSet searchHDB(String query){
		Connection con;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	public ArrayList<HDB> getInfo(String query) {
		ArrayList<HDB> DateList = new ArrayList<HDB>();
		ResultSet rs = null;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		while(rs.next()) {
			HDB h = new HDB(rs.getString("block"),rs.getString("town"),rs.getString("flat_types"),rs.getString("location"),rs.getString("coordinate"),rs.getString("possession_date"),rs.getString("completion_date"),rs.getString("ethnic_quota"),rs.getString("site_plan"),rs.getString("units"));
			DateList.add(h);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return DateList;
	}

	public HDB getOneHDB(String block, String flatType){
		HDB h = new HDB();
		Connection con;
		ResultSet rs = null;
		String query = "SELECT * FROM hdb where block = '" + block +"' and flat_types = '" + flatType + "'";
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				h = new HDB(rs.getString("block"),rs.getString("town"),rs.getString("flat_types"),rs.getString("location"),rs.getString("coordinate"),rs.getString("possession_date"),rs.getString("completion_date"),rs.getString("ethnic_quota"),rs.getString("site_plan"),rs.getString("units"));
				}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public ArrayList<HDB> getUptoThreeHDB(int numOfRecords){
        ArrayList<HDB> hdbList = new ArrayList<HDB>();
        Connection con;
        ResultSet rs = null;
        String query = "SELECT * FROM hdb ";
        if(numOfRecords == 3)
        {
            query += "ORDER BY RAND() LIMIT 3;";
        }
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch (Exception c)
        {
            c.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", username, password);
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                HDB h = new HDB(rs.getString("block"),rs.getString("town"),rs.getString("flat_types"),rs.getString("location"),rs.getString("coordinate"),rs.getString("possession_date"),rs.getString("completion_date"),rs.getString("ethnic_quota"),rs.getString("site_plan"),rs.getString("units"));
                hdbList.add(h);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hdbList;
    }
	
	public ArrayList<Carpark> getCP(){
		ArrayList<Carpark> cpList = new ArrayList<Carpark>();
		Connection con;
		ResultSet rs = null;
		String query = "SELECT * FROM Carpark";
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				Carpark cp = new Carpark(rs.getInt("id"),rs.getString("short_term_parking"),rs.getString("car_park_type"),rs.getString("y_coord"),rs.getString("x_coord"),rs.getString("free_parking"),rs.getString("night_parking"),rs.getString("address"),rs.getString("carpark_no"),rs.getString("parking_system_type"));
				  cpList.add(cp);
				}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpList;
	}
	
	public ArrayList<Carpark> getCPByBTO(){
		SupportController support = new SupportController();
		ArrayList<HDB> hdbList = new ArrayList<HDB>();
		ArrayList<Carpark> cpByBTOList = new ArrayList<Carpark>();
		ArrayList<Carpark> result = new ArrayList<Carpark>();
		String[] coor;
		hdbList = getHDB();
		cpByBTOList = getCP();
		for(int i=0;i<cpByBTOList.size();i++) {
			for(int j=0;j<hdbList.size();j++) {
				coor = hdbList.get(j).getCoordinates().split(",");
				if(support.calculateDistance(cpByBTOList.get(i).getX_coord(),cpByBTOList.get(i).getY_coord(),coor[0],coor[1])<0.51) {
					result.add(cpByBTOList.get(i));
					break;
				}
			}
		}
		return result;
	}
	
	public ArrayList<Kindergartens> getK(){
		ArrayList<Kindergartens> kList = new ArrayList<Kindergartens>();
		Connection con;
		ResultSet rs = null;
		String query = "SELECT * FROM Kindergartens";
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				Kindergartens h = new Kindergartens(rs.getString("Name"),rs.getString("X_Coordinate"),rs.getString("Y_Coordinate"));
				  kList.add(h);
				}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kList;
	}
	
	public ArrayList<Kindergartens> getKGByBTO(){
		SupportController support = new SupportController();
		ArrayList<HDB> hdbList = new ArrayList<HDB>();
		ArrayList<Kindergartens> kByBTOList = new ArrayList<Kindergartens>();
		ArrayList<Kindergartens> result = new ArrayList<Kindergartens>();
		String[] coor;
		hdbList = getHDB();
		kByBTOList = getK();
		for(int i=0;i<kByBTOList.size();i++) {
			for(int j=0;j<hdbList.size();j++) {
				coor = hdbList.get(j).getCoordinates().split(",");
				if(support.calculateDistance(kByBTOList.get(i).getX_coor(),kByBTOList.get(i).getY_coor(),coor[0],coor[1])<1.1) {
					result.add(kByBTOList.get(i));
					break;
				}
			}
		}
		return result;
	}
	
	public ArrayList<Dengue> getDA(){
		ArrayList<Dengue> daList = new ArrayList<Dengue>();
		String id;
		String[] x, y;
		Connection con;
		ResultSet rs = null;
		String query = "SELECT * FROM Dengue";
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				id = rs.getString("id");
				x = rs.getString("x_coor").split(",");
				y = rs.getString("y_coor").split(",");
				ArrayList<String> x_coor = new ArrayList<String>();
				ArrayList<String> y_coor = new ArrayList<String>();
				for(int i=0;i<x.length;i++) {
					x_coor.add(x[i]);
					y_coor.add(y[i]);
				}
				Dengue da = new Dengue(id,x_coor,y_coor);
				daList.add(da);
				}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return daList;
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> userList = new ArrayList<User>();
		Connection con;
		ResultSet rs = null;
		String query = "SELECT * from Users";
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				User u = new User(rs.getString("name"),rs.getString("password"));
				userList.add(u);
				}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
