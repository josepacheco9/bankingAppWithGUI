package mp;

//import bank.ConnectionManager;

public class BaseModel {
	protected int id;
	protected static final ConnectionManager db = ConnectionManager.getDbCon();
	
	public int getId() {
		return this.id;
	}
}