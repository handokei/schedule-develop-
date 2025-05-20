package service;


import dto.SignUpRequestDto;
import dto.SignUpResponseDto;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String password, String userEmail) {

        User user = new User(userName, password, userEmail);
        User saveUser = userRepository.save(user);
        return new SignUpResponseDto(saveUser.getUserId(),saveUser.getUserName(),saveUser.getUserEmail());
    }


}
