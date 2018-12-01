package utility;

import java.util.ArrayList;

import entity.Carpark;
import entity.Dengue;
import entity.Kindergartens;

public class DailyUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateDatabase update = new UpdateDatabase();
		DeleteDatabase delete = new DeleteDatabase();
		
		//daily update btos information
		delete.deleteDB("hdb");
		update.getHDBFromSrouce();


	}

}
