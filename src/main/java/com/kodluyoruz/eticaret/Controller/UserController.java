package com.kodluyoruz.eticaret.Controller;
import com.kodluyoruz.eticaret.Dto.UserRequestDto;
import com.kodluyoruz.eticaret.Dto.UserResponseDto;
import com.kodluyoruz.eticaret.Model.User;
import com.kodluyoruz.eticaret.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author sevgidemir
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String savePerson(@RequestBody UserRequestDto user) {
        this.userService.saveUser(user);
        return "User login successful!";
    }

    @GetMapping("/getAll")
    public List<UserResponseDto> getAllPersons() {
        return userService.getAllUsers();
    }

    @GetMapping("/fetchById")
    public ResponseEntity<?> getUser(@RequestParam int userId){
        User user =  userService.getUser(userId);
        return ( user != null )
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Record Not Found!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam int userId){
        String user =  userService.deleteUser(userId);
        return ( user != null )
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Record Not Found!");
    }
}
