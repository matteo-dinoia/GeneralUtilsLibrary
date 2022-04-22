package utils;

import utils.settings.ConstantsManager;

public class Test {
	public static void main(String arg[]) {
		ConstantsManager.addDefaultConstantsThenReadFromFile(null);
		ConstantsManager.debugPrintValue();
	}
}
