package telran.forum.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;

import telran.forum.configoration.UserAccountConfiguration;
import telran.forum.dao.UserAccountRepository;
import telran.forum.dto.UserAccountDto;
import telran.forum.dto.UserProfileDto;
import telran.forum.dto.UserRegisterDto;
import telran.forum.exeptions.UserExistException;
import telran.forum.model.UserAccount;

public class UserAccountServiceImpl implements UserAccountService{

	@Autowired
	UserAccountRepository repository;
	
	@Autowired
	UserAccountConfiguration configuration;
	@Override
	public UserProfileDto addUser(UserRegisterDto dto, String auth) {
		UserAccountDto dto2=configuration.tokenDecode(auth);
		if(repository.existsById(dto2.getLogin()))
		{
			throw new UserExistException();
		}
		UserAccount account=UserAccount.builder()
				.login(dto2.getLogin())
				.password(dto2.getPassword())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.role("User")
				.expDate(LocalDateTime.now().
						plusDays(configuration.getExPeriod()))
				.build();
		Set<String>roleSet=new HashSet<String>();
		roleSet.add("User");
		repository.save(account);
		return new UserProfileDto(dto2.getLogin(),dto.getFirstName(),dto.getLastName(), roleSet);
	}

}
