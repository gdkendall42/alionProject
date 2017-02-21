package protoTypeLayout;

public class UserValidationService {

	public boolean isUserValid(String user, String password){
		if(user.equals("asdf")&& password.equals("asdf")){
			return true;
		}
		return false;
	}
}
