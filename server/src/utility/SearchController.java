package utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.*;

public class SearchController {
	private RetrieveDatabase retrieve;
	private ArrayList<HDB> hdbList;

	public ArrayList<HDB> getHdbList() {
		return hdbList;
	}

	public SearchController() {
		retrieve = new RetrieveDatabase();
		hdbList = new ArrayList<HDB>();
		init();
	}

	public void init() {
		ResultSet rs = null;
		rs = retrieve.searchHDB("SELECT * from hdb order by flat_types asc");
		try {
			while (rs.next()) {
				hdbList.add(new HDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HDB> searchHDBs(String param, int i) {
		ArrayList<HDB> result = new ArrayList<HDB>();
		ResultSet rs = null;
		String sql = "";
		if (i == 0)
			sql = "SELECT block,town,flat_types,location, coordinate, possession_date,completion_date, ethnic_quota,site_plan,units from hdb where flat_types like'"
					+ param + "' order by flat_types asc";
		else if (i == 1)
			sql = "SELECT block,town,flat_types,location, coordinate, possession_date,completion_date, ethnic_quota,site_plan,units from hdb where units like'%"
					+ param + "%' order by flat_types asc";
		rs = retrieve.searchHDB(sql);
		try {
			while (rs.next()) {
				result.add(new HDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<String> getTowns() {
		ArrayList<String> result = new ArrayList<String>();
		ResultSet rs = null;
		rs = retrieve.searchHDB("SELECT DISTINCT(town) AS town from hdb ORDER BY town ASC");

		try {
			while (rs.next()) {
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<String> getTowns(String param, int i) {
		ArrayList<String> result = new ArrayList<String>();
		ResultSet rs = null;
		String sql = "";
		if (i == 0)
			sql = "SELECT DISTINCT(town) AS town  from hdb where flat_types LIKE '" + param + "' ORDER BY town ASC";
		else if (i == 1)
			sql = "SELECT DISTINCT(town) AS town  from hdb where units LIKE '%" + param + "%' ORDER BY town ASC";
		rs = retrieve.searchHDB(sql);
		try {
			while (rs.next()) {
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<HDB> getLocations() {
		ArrayList<HDB> result = new ArrayList<HDB>();
		ResultSet rs = null;
		rs = retrieve.searchHDB("SELECT DISTINCT town,location from hdb ORDER BY town ASC");

		try {
			while (rs.next()) {
				result.add(new HDB(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<HDB> getLocations(String param, int i) {
		ArrayList<HDB> result = new ArrayList<HDB>();
		ResultSet rs = null;
		String sql = "";
		if (i == 0)
			sql = "SELECT DISTINCT town,location from hdb where flat_types LIKE '" + param + "' ORDER BY town ASC";
		else if (i == 1)
			sql = "SELECT DISTINCT town,location from hdb where units LIKE '%" + param + "%' ORDER BY town ASC";
		rs = retrieve.searchHDB(sql);
		try {
			while (rs.next()) {
				result.add(new HDB(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
