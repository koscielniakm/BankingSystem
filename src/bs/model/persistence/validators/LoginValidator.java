package bs.model.persistence.validators;

import java.util.Date;

import bs.model.config.Finals;
import bs.model.persistence.entities.LoginEntity;

public class LoginValidator implements DaoValidator<LoginEntity> {

	@Override
	public boolean validateBeforeCreate(LoginEntity obj) {
		if (obj == null) return false;
		if (validateIp(obj.getIp()) &&
			validateDate(obj.getDate()))
			return true;
		return false;
	}

	@Override
	public boolean validateBeforeUpdate(LoginEntity obj) {
		if (obj == null) return false;
		if (validateIp(obj.getIp()) &&
			validateDate(obj.getDate()))
			return true;
		return false;
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		if (id < 0) return false;
		else return true;
	}

	private boolean validateIp(String ip) {
		if (ip == null) return false;
		if (ip.length() > Finals.DB_LOGIN_IP_LENGTH) return false;
		return true;
	}
	
	private boolean validateDate(Date date) {
		if (date == null) return false;
		return true;
	}
	
}
