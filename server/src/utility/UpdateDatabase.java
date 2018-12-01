package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import entity.*;

public class UpdateDatabase extends DatabaseController{
	
	private String username, password;

	public UpdateDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.username  = "root";
		this.password ="P@ssw0rd";
	}

	public void getHDBFromSrouce() {
		SupportController support = new SupportController();
		try {
			@SuppressWarnings("resource")
			BufferedReader b = new BufferedReader(new FileReader("python/hdb.txt"));
			String readLine = "";
			ArrayList<HDB> bfArr = new ArrayList<HDB>();
			while ((readLine = b.readLine()) != null) { // for each bulding make object
				String[] bf = readLine.split("\\*\\*");

				bfArr.add(new HDB(bf[0], bf[1], bf[4], bf[5], bf[6], bf[7], bf[8], bf[9], bf[10], bf[11]));
			}
			support.removeDupAndFormatUnit(bfArr);

			for (int k1 = 0; k1 < bfArr.size(); k1++) {
				support.formatDate(bfArr.get(k1).getCompletion_date());
				bfArr.get(k1).setPossession_date(support.formatDate(bfArr.get(k1).getPossession_date().substring(0,
						bfArr.get(k1).getPossession_date().length() - 12)));
				storeHDB(bfArr.get(k1).getBlock(), bfArr.get(k1).getTown(), bfArr.get(k1).getFlat_type(),
						bfArr.get(k1).getLocation(), bfArr.get(k1).getCoordinates(), bfArr.get(k1).getPossession_date(),
						bfArr.get(k1).getCompletion_date(), bfArr.get(k1).getEthnic_quota(),
						bfArr.get(k1).getSite_plan(), bfArr.get(k1).getUnits());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public ArrayList<Carpark> getCarparkFromSrouce(String uri, ArrayList<Carpark> cData) {
		SupportController support = new SupportController();
		ObjectMapper mapper = new ObjectMapper();

		try {
			URL url = new URL(uri);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

			Scanner scan = new Scanner(conn.getInputStream());
			scan.useDelimiter("\\A");
			String buffer = scan.hasNext() ? scan.next() : "";
			String buffer1 = null, test;
			buffer1 = buffer.substring(buffer.indexOf("records") + 11, buffer.length());
			buffer1 = buffer1.substring(0, buffer1.indexOf("_links") - 4);
			if (buffer1.equals("")) {
				return cData;
			} else {

				test = buffer.substring(buffer.indexOf("next") + 8, buffer.length());
				test = test.substring(0, test.indexOf("}, ") - 1);

				String[] buffers = buffer1.split("}, ");

				scan.close();
				for (int i = 0; i < buffers.length; i++) {
					buffers[i] += "}";
					try {
						// Convert JSON string to Object
						Carpark c = new Carpark();
						c = mapper.readValue(buffers[i], Carpark.class);

						try {
							String[] latlong = support.getLatLongPositions("Singapore " + c.getAddress());
							c.setX_coord(latlong[0]);
							c.setY_coord(latlong[1]);
						} catch (Exception e) {
							e.printStackTrace();

						}
						cData.add(c);
					} catch (JsonGenerationException e) {
						e.printStackTrace();
					} catch (JsonMappingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return getCarparkFromSrouce("https://data.gov.sg/" + test, cData);
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return cData;
	}


	public void storeHDB(String block, String town, String flat_type, String location, String coordinates, String possession_date, String completion_date, String ethnic_quota, String site_plan, String units){
		String query = "INSERT INTO hdb(`block`, `town`, `flat_types`, `location`, `coordinate`, `completion_date`, `ethnic_quota`, `site_plan`, `units`, `possession_date`) VALUES ('"+
		block+"', '"+town+"', '"+flat_type+"', '"+location+"', '"+coordinates+"', '"+completion_date+"', '"+ethnic_quota+"', '"+site_plan+"', '"+units+"', '"+possession_date+"')";
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	


	
}