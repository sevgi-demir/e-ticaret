package com.kodluyoruz.eticaret.Service;
import com.kodluyoruz.eticaret.Dto.UserRequestDto;
import com.kodluyoruz.eticaret.Dto.UserResponseDto;
import com.kodluyoruz.eticaret.Model.User;
import com.kodluyoruz.eticaret.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sevgidemir
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public User saveUser(UserRequestDto userRequestDTO) {
        /*User user = new User();
        user.setEmail(userRequestDTO.getEmail());
        user.setMobile(userRequestDTO.getMobile());
        user.setName(userRequestDTO.getName());*/

        User user=this.modelMapper.map(userRequestDTO,User.class);
        return userRepository.save(user);
    }

    public List<UserResponseDto> getAllUsers (){
        List<User> users=this.userRepository.findAll();
        List<UserResponseDto> userResponseDtoList=new ArrayList<>();
        for (User user : users) {
            UserResponseDto userResponseDto=this.modelMapper.map(user,UserResponseDto.class);
            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
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
