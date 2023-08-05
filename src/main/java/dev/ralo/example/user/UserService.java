package dev.ralo.example.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public UserEntity save(UserEntity userEntity) {
        //TODO: Encrypt password before saving
        return userRepository.save(userEntity);
    }

    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public Collection<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
