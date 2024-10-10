package methods;

import pojo.ExistingUserLogin;
import pojo.NewUser;

public class MethodsDef {

	public static NewUser newUser(String fname, String lname, String useremail, String userPassword,
			String confirmUserPass, String mobNum) {
		NewUser user = new NewUser();
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setUserEmail(useremail);
		user.setUserPassword(userPassword);
		user.setConfirmPassword(userPassword);
		user.setUserMobile(mobNum);
		return user;               //---> it will return the object to the NewUser class

	}

	public static ExistingUserLogin updateUser(String userEmail, String password) {
		ExistingUserLogin login = new ExistingUserLogin();
		login.setUserEmail(userEmail);
		login.setUserPassword(password);
		return login;              //---> it will return the object to the ExistingUserLogin class
	}

}
