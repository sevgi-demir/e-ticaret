package com.kodluyoruz.eticaret.Controller;
import com.kodluyoruz.eticaret.Dto.UserRequestDto;
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

    @GetMapping("/save")
    public User savePerson(@RequestBody UserRequestDto user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllPersons() {
        return userService.getAllUsers();
    }

    @GetMapping("/userId")
    public ResponseEntity<?> getUser(@PathVariable int userId){
        User user =  userService.getUser(userId);
        return ( user != null )
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Record Not Found!");
    }

    @DeleteMapping("/userId")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        String res =  userService.deleteUser(userId);
        return ( res != null )
                ? new ResponseEntity<>(res, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Record Not Found!");
    }
}
