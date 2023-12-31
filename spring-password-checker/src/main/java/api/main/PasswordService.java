package api.main;
import org.springframework.stereotype.Service;
@Service
public class PasswordService implements IPasswordService  
{

	@Override
	public Boolean isStrongPassword(String password) {
		Boolean isUpper = false,isLower = false,isDigit = false;
		for(char i: password.toCharArray()){

			if(Character.isUpperCase(i)){
				isUpper = true;
			}
			if(Character.isLowerCase(i)){
				isLower = true;
			}
			if(Character.isDigit(i)){
				isDigit = true;
			}
		}
		Boolean res = (password.length()>=6 && password.length()<=20 && isUpper && isLower && isDigit)? true : false;
		return res;
	}

}
