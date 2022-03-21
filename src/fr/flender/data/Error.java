package fr.flender.data;

public class Error {
	
	public static String errorPermission = "You need to be a administrator to use this command.";
	public static String abilityUniqueUse = "You have already use this ability.";
	public static String abilityUniqueMateNotSpec = "Your mate is alive.";
	public static String unknown(String item) {
		return "This " + item + " is not known";
	}

}
