/**
 * 
 */
package de.mthoma.demowebapp.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import de.mthoma.demowebapp.data.UserDataAccess;

/**
 * @author mthoma
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


	@Autowired
	private UserDataAccess userDataAccess;

	/**
	 * TODO
	 */
	@Override
	public Authentication authenticate(Authentication authentication) {

		final String alias = authentication.getName();
		final String password = authentication.getCredentials().toString();
		
		if(this.userDataAccess.verifyLogin(alias, password)) {
			
			final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			grantedAuthorities.add(new SimpleGrantedAuthority("USER_ROLE"));
			
			final UserDetails userDetails = new User(alias, password, grantedAuthorities);
			
			return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);
			
		} else {
			throw new AuthenticationCredentialsNotFoundException("Username or password was not accepted");
		}
	}

	/**
	 * Returns true if the given authentication is of class {@link UsernamePasswordAuthenticationToken}. 
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
