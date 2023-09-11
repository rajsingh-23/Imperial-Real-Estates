package application;

public class Query {
	public static String insertNewUser = "INSERT INTO Users (Name, Password, PhoneNo, Email, DOB, Country, State, City, Pincode, Gender, Picture, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static String authUser = "SELECT UserID, Password, Name, Picture FROM Users WHERE UserID = ? AND Password = ?";
	public static String insertProperty = "INSERT INTO Properties (PropertyImage, Name, OwnerID, Type, Status, Size, Price, Country, State, City, Pincode,PC) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	public static String ownedProperty = "SELECT * FROM Properties WHERE OwnerID=?";
	public static String searchProperty = "SELECT * FROM Properties WHERE OwnerID<>? AND (Status='SALE' or Status='RENT');";
	public static String changeStatuss = "UPDATE Properties SET Status='SALE', Price=? WHERE PropertyID=?";
	public static String removeFromSale = "UPDATE Properties SET Status='OWNED' WHERE PropertyID=?";
	public static String showDetails = "SELECT * FROM Properties WHERE PropertyID=?";
	public static String getUser = "SELECT * FROM Users WHERE UserID=?";
	public static String onSale = "SELECT PropertyID FROM Properties WHERE OwnerID=? AND Status='Sale'";
//	public static String createTable = "create table _?_m (mo int auto_increment primary key, message varchar(250),who int);";
//	public static String insertm = "insert into perry (message,who) values(?,?);";
//	public static String insertn = "insert into badri (message, who) values(?,?);";
//	public static String notiperry = "select distinct who from perry";
//	public static String perrym = "select * from perry";
	public static String insertmessage = "insert into messages (message) value(?)";
	public static String getmessage = "select * from messages order by mo";
	public static String getPC = "select PC from Properties";
	public static String searchType = "select * from Properties where (Status='SALE' or Status='RENT') and OwnerID<>? and Type=?";
	public static String changeStatusr = "UPDATE Properties SET Status='RENT', Price=? WHERE PropertyID=?";
	public static String ownedPropertyR = "SELECT * FROM Properties WHERE OwnerID=? AND Status='RENT'";
	public static String addtenent = "insert into tenents values(?,?,?)";
	public static String addwish = "Insert into whistlist values(?,?);";
	public static String wishlist = "select * from whistlist where uid=?";
}
