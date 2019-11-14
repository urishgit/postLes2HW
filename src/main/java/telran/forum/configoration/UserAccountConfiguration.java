package telran.forum.configoration;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import telran.forum.dto.UserAccountDto;



@Configuration
@ManagedResource

public class UserAccountConfiguration {
	@Value("${exp.value}")
int exPeriod;

	
	@ManagedAttribute
	public int getExPeriod() {
		return exPeriod;
	}
	
	public UserAccountDto tokenDecode(String auth)
	{
		int pos=auth.indexOf(" ");
		String token=auth.substring(pos+1);
		byte[]decodeBytes=Base64.getDecoder().decode(token);
		String code=new String(decodeBytes);
		String [] reStrings=code.split(":");
		return new UserAccountDto(reStrings[0],reStrings[1]);
	}
	
}
