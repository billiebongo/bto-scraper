package utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import entity.Carpark;
import entity.Dengue;
import entity.HDB;
import entity.Kindergartens;

public class SupportController {

	public SupportController() {
	
	}
	


	public String formatDate(String date) {
		String[] splited = date.split(" ");
		switch (splited[1]) {
		case "Jan":
			splited[1] = "01";
			break;
		case "Feb":
			splited[1] = "02";
			break;
		case "Mar":
			splited[1] = "03";
			break;
		case "Apr":
			splited[1] = "04";
			break;
		case "May":
			splited[1] = "05";
			break;
		case "Jun":
			splited[1] = "06";
			break;
		case "Jul":
			splited[1] = "07";
			break;
		case "Aug":
			splited[1] = "08";
			break;
		case "Sep":
			splited[1] = "09";
			break;
		case "Oct":
			splited[1] = "10";
			break;
		case "Nov":
			splited[1] = "11";
			break;
		case "Dec":
			splited[1] = "12";
			break;
		default:
			break;
		}
		return splited[2] + "-" + splited[1] + "-" + splited[0];
	}

	public void removeDupAndFormatUnit(ArrayList<HDB> bfArr) {
		for (int k = 0; k < bfArr.size(); k++) {
			for (int j = 0; j < bfArr.size(); j++) {
				if ((j != k) && bfArr.get(j).getBlock().equalsIgnoreCase(bfArr.get(k).getBlock())) {
					bfArr.get(k).setUnits(bfArr.get(k).getUnits() + bfArr.get(j).getUnits());

					bfArr.remove(j);
					// break;
				}
			}
			bfArr.get(k).setUnits(bfArr.get(k).getUnits().substring(0, bfArr.get(k).getUnits().length() - 1));
		}
	}


}
