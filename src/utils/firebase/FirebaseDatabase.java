package utils.firebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseDatabase {

	@SuppressWarnings("deprecation")
	public FirebaseDatabase() {

		FileInputStream serviceAccount;
		FirebaseOptions options;
		try {
			serviceAccount = new FileInputStream("/home/matteo/Documents/000-Programmazione/EclipseWorkspace/000000-ProgramParts/src/utils/firebase/database.json");
			options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .build();
			FirebaseApp.initializeApp(options);
		}
		catch (FileNotFoundException e) {  e.printStackTrace();
		}catch (IOException e) {   e.printStackTrace();}
	}
	
	public static void main(String[] args) {
		new FirebaseDatabase();
	}

}
