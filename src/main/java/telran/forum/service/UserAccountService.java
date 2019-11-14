package telran.forum.service;

import telran.forum.dto.UserProfileDto;
import telran.forum.dto.UserRegisterDto;

public interface UserAccountService {

	public UserProfileDto addUser(UserRegisterDto dto,String auth);
}
