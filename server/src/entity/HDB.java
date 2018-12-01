package entity;



public class HDB {
	private String block;
	private String town;
	private String flat_type;
	private String location;
	private String coordinates;
	private String possession_date;
	private String completion_date;
	private String ethnic_quota;
	private String site_plan;
	private String units;
	
	public HDB(String block, String town, String flat_type, String location, String coordinates, String possession_date, String completion_date, String ethnic_quota, String site_plan, String units){
		this.block=block;
		this.town=town;
		this.flat_type=flat_type;
		this.location=location;
		this.coordinates=coordinates;
		this.possession_date=possession_date;
		this.completion_date=completion_date;
		this.ethnic_quota=ethnic_quota;
		this.site_plan=site_plan;
		this.units=units;
	}
	
	public HDB(String town, String location) {
		this.town=town;
		this.location=location;
	}
	
	
	public HDB() {
		super();
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getFlat_type() {
		return flat_type;
	}

	public void setFlat_type(String flat_type) {
		this.flat_type = flat_type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getPossession_date() {
		return possession_date;
	}

	public void setPossession_date(String possession_date) {
		this.possession_date = possession_date;
	}

	public String getCompletion_date() {
		return completion_date;
	}

	public void setCompletion_date(String completion_date) {
		this.completion_date = completion_date;
	}

	public String getEthnic_quota() {
		return ethnic_quota;
	}

	public void setEthnic_quota(String ethnic_quota) {
		this.ethnic_quota = ethnic_quota;
	}

	public String getSite_plan() {
		return site_plan;
	}

	public void setSite_plan(String site_plan) {
		this.site_plan = site_plan;
	}

	public void setUnits(String units) {
		this.units = units;
	}
	
	public String getUnits() {
		return units;
	}
}