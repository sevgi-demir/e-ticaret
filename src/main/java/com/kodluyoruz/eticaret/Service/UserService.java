package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.UserRequestDto;
import com.kodluyoruz.eticaret.Model.User;
import com.kodluyoruz.eticaret.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author sevgidemir
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequestDto userRequestDTO) {
        User user = new User();
        user.setEmail(userRequestDTO.getEmail());
        user.setMobile(userRequestDTO.getMobile());
        user.setName(userRequestDTO.getName());
        return userRepository.save(user);
    }

    public List<User> getAllUsers (){
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent() ? user.get() : null;
    }

    public String deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "Record Deleted!!";
        }
        return null;
    }
}
