package com.example.test2.controller;

import com.example.test2.exception.ResourceNotFoundException;
import com.example.test2.model.Product;
import com.example.test2.model.User;
import com.example.test2.persitences.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    private UserResponse userResponse;

    public UserController(UserResponse userResponse){
        this.userResponse = userResponse;
    }

    @GetMapping
    public List<User> getAll(){
       List<User> lst = userResponse.findAll();
       return lst;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") int userId)
            throws ResourceNotFoundException {
        User user = userResponse.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId,"",""));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("addUser")
    public void createProduct(@RequestBody User user) {
         userResponse.save(user);

    }

    @DeleteMapping("deleteUser/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int userId)
            throws ResourceNotFoundException {
        User user = userResponse.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId,"",""));

        userResponse.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("updateUser/{id}")
    public  ResponseEntity<User> updateUser(
            @PathVariable(value = "id") int userId,
            @Validated
            @RequestBody User userDetails
    ) throws ResourceNotFoundException{
        User user = userResponse.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId,"",""));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        final User updateUser = userResponse.save(user);
    return  ResponseEntity.ok(updateUser);
    }


}
