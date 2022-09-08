package fiveman.hotelservice.utils;

public class Utilities {
	
	public static boolean checkEmptyString(String result) {
		if(result.isEmpty() || result.trim().isEmpty() || result == null) {
			return false;
		}
		return true;
	}
}
