package com.springmvc.controller;

import com.springmvc.pojo.People;
import com.springmvc.service.PeopleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/helloWorld")//,produces = MediaType.APPLICATION_JSON_VALUE
public class HelloWorldRestController {

    private static final Logger LOGGER = Logger.getLogger(HelloWorldRestController.class);
    @Autowired
    PeopleService userService;  //Service which will do all data retrieval/manipulation work
 
    @RequestMapping(value = "/test")
    @ResponseBody
    public void test(){
        LOGGER.info("test helloWorldRestController.");
    }

    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<People>> listAllUsers() {
        List<People> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<People>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<People>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<People> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        People user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<People>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody People user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<People> updateUser(@PathVariable("id") long id, @RequestBody People user) {
        System.out.println("Updating User " + id);

        People currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<People>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<People> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        People user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<People>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<People> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<People>(HttpStatus.NO_CONTENT);
    }
 
}