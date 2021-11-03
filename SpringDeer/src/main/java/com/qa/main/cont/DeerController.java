package com.qa.main.cont;


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


	
	private DeerService service;

	public DeerController(DeerService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/hello")
	public String greeting() {
		return "hello world";
	}
	
   //add a deer to the arraylist
	@PostMapping("/create")
	public ResponseEntity<Deer> createDeer(@RequestBody Deer newDeer) {
		Deer responsebody  = this.service.createDeer(newDeer);
		
		return new ResponseEntity<Deer>(responsebody, HttpStatus.CREATED);
	}
	
	//replace a deer
	@PutMapping("replace/{myIndex}")
	public ResponseEntity<Deer> replaceDeer(@PathVariable Integer myIndex, @RequestBody Deer newDeer){
		System.out.println("Replacing Deer with id " + myIndex + " with " + newDeer);
		
		Deer inThereNow = this.service.replaceDeer(myIndex, newDeer);
		return new ResponseEntity<Deer>(inThereNow, HttpStatus.ACCEPTED);
		
	}
	
	//show a single deer
	@GetMapping("/get/{myIndex}")
	public Deer getMyDeer(@PathVariable Integer myIndex){
		Deer myDeer = this.service.getDeer(myIndex);
		return myDeer;
	}
	
	//show the whole arraylist contents
	@GetMapping("/getThemAll")
	public ResponseEntity<List<Deer>> getThemAll(){
		
		return ResponseEntity.ok(this.service.getDeer());
	}
	
	//remove a deer from the herd
	@DeleteMapping("/remove/{myIndex}")
	public ResponseEntity<Deer> removeDeer(@PathVariable Integer myIndex){
		System.out.println("Removing Deer with id " + myIndex);
		
		boolean worked = this.service.removeDeer(myIndex);
		if (worked) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//clear the herd
	//@DeleteMapping("/emptyHerd")
	//public ResponseEntity<Deer> emptyHerd() {
		//this.service.clear();
		//return ResponseEntity.ok(null);
	//}
	
	
	
	
	
	
	
	
}
