package com.springmvc.controller;

import com.springmvc.pojo.People;
import com.springmvc.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value="/testRestful")
public class TestRestController {
    @Autowired
    PeopleService peopleService;

    /**
     * Retrieve All Users
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<People>> listAllUser(){
        List<People> users = peopleService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<People>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<People>>(users,HttpStatus.OK);
    }

    /**
     * Retrieve Single User
     * @param id
     * @return
     */
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<People> getUser(@PathVariable("id") long id){
        System.out.println("fetching user with id"+id);
        People user = peopleService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<People>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/user",method=RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody People user, UriComponentsBuilder ucBuilder){
        System.out.println("Creating User " + user.getUsername());
        if (peopleService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        peopleService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<People> updateUser(@PathVariable("id") long id, @RequestBody People user) {
        System.out.println("Updating User " + id);

        People currentUser = peopleService.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser.setAddress(user.getAddress());

        peopleService.updateUser(currentUser);
        return new ResponseEntity<People>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<People> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        People user = peopleService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
        }

        peopleService.deleteUserById(id);
        return new ResponseEntity<People>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Users --------------------------------------------------------

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<People> deleteAllUsers() {
        System.out.println("Deleting All Users");

        peopleService.deleteAllUsers();
        return new ResponseEntity<People>(HttpStatus.NO_CONTENT);
    }
}
