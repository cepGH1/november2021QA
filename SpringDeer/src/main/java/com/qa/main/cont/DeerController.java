package com.qa.main.cont;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeerController {

	//because no database
	private List<Deer> herd = new ArrayList<>();
	
	@GetMapping("/hello")
	public String greeting() {
		return "hello world";
	}
	
   //add a deer to the arraylist
	@PostMapping("/create")
	public Deer createDeer(@RequestBody Deer newDeer) {
		this.herd.add(newDeer);
		return this.herd.get(herd.size()-1);
	}
	
	//replace a deer
	@PutMapping("replace/{myIndex}")
	public ResponseEntity<Deer> replaceDeer(@PathVariable Integer myIndex, @RequestBody Deer newDeer){
		this.herd.set(myIndex, newDeer);
		Deer inThereNow = this.herd.get(myIndex);
		return new ResponseEntity<Deer>(inThereNow, HttpStatus.CREATED);
		
	}
	
	//show a single deer
	@GetMapping("/get/{myIndex}")
	public Deer getMyDeer(@PathVariable Integer myIndex){
		Deer myDeer = this.herd.get(myIndex);
		return myDeer;
	}
	
	//show the whole arraylist contents
	@GetMapping("/getThemAll")
	public ResponseEntity<List<Deer>> getThemAll(){
		
		return ResponseEntity.ok(this.herd);
	}
	
	//remove a deer from the herd
	@DeleteMapping("/remove/{myIndex}")
	public ResponseEntity<Deer> removeDeer(@PathVariable int myIndex){
		Deer removedDeer = herd.remove(myIndex);
		return new ResponseEntity<Deer>(removedDeer, HttpStatus.ACCEPTED);
	}
	
	//clear the herd
	@DeleteMapping("/emptyHerd")
	public ResponseEntity<Deer> emptyHerd() {
		this.herd.clear();
		return ResponseEntity.ok(null);
	}
	
	
	
	
	
	
	
	
}
