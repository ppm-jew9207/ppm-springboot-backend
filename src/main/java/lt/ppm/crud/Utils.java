package lt.ppm.crud;

public class Utils {

	
	public static String nameToUpperCase(String name) {
		name = name.substring(0,1).toUpperCase()+name.substring(1);
		return name;
	}
	public static String nameToLowerCase(String name) {
		name = name.substring(0,1).toLowerCase()+name.substring(1);
		return name;
	}
}
