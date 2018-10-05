package com.mckesson.restApi.user;

//import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private Map<String, User> userMap = new HashMap<String, User>();
	
	// A single rest end point was requested so this is being commenting out.
	// This uncommented in order to allow a fetch of all the users - used for dev testing
	/*@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
    public Collection<User> getUsers() {
        return userMap.values();
    }*/
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> putUser(@PathVariable int id, @Valid @RequestBody User user) {   
    	
        user.setId(id);
        user.setLastModified(new Date());
        userMap.put(getMapKey(id), user);
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    private String getMapKey(int id) {
    	return String.valueOf(id);
    }
}
