package com.skcet.liveConcert.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.skcet.liveConcert.model.Audience;
import com.skcet.liveConcert.service.ConcertService;


@RestController
@CrossOrigin("*")  //allow every origin from another port  @crossOrgin("http://localhost:3000)  -> allow only this origin
@RequestMapping("/api/v1/controller")
public class ConcertController {
	
	private static final Logger logger=LoggerFactory.getLogger(ConcertController.class);
       @Autowired
       private ConcertService concertService;
       
       @PostMapping("/add")
       public ResponseEntity<String> addValue(@RequestBody Audience audience)
       {
    	   boolean dataSaved = concertService.addValue(audience);
    	   if(dataSaved) {
   			return ResponseEntity.status(200).body("Value added successfully!");
   		}else {
   			return ResponseEntity.status(404).body("Something went wrong!");
   		}
       }
       
       @GetMapping("/get")
   	public ResponseEntity<List<Audience>> getUser(){
    	   System.out.println("sop");
    	   logger.info("harinisri the legend");
    	   logger.debug("debug pannu");
    	   logger.warn("warning kudu");
    	   logger.error("valkka nadagama");
   		return ResponseEntity.status(200).body(concertService.getValue());
   	}
       
       
       @PutMapping("/put/{id}")
   	public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody Audience audience)
   	{
   		boolean ConcertData=concertService.updateConcert(id, audience);
   		if(ConcertData)
   		{
   			return ResponseEntity.status(200).body("updated successfully");
   		}
   		else
   		{
   			return ResponseEntity.status(404).body("not updated successfully");
   		}
//   		return null;
   	}
       @DeleteMapping("/delete")
      	public ResponseEntity<String> deleteConcert(@RequestParam Long id)
      	{
      		boolean userData=concertService.deleteConcert(id);
      		if(userData)
      		{
      			return ResponseEntity.status(200).body("deleted successfully");
      		}
      		else
      		{
      			return ResponseEntity.status(404).body("not deleted successfully");
      		}
//      		return null;
      	}
       
//       @DeleteMapping("/delete")
//   	public ResponseEntity<String> deleteConcert(@RequestParam Long eventId)
//   	{
//   		boolean concertDeleted=concertService.deleteConcert(eventId);
//   		if(concertDeleted)
//   		{
//   			return ResponseEntity.status(200).body("deleted successfully");
//   		}
//   		else
//   		{
//   			return ResponseEntity.status(404).body("No records found");
//   		}
//   	}
       
       
       
       @GetMapping("/getpagewithSort")
   	public ResponseEntity<Page<Audience>> getPagewithsort(
   			@RequestParam(defaultValue = "0") int offset, 
   			@RequestParam(defaultValue = "3") int limit,
   			@RequestParam(defaultValue = "name") String sortField,
   			@RequestParam(defaultValue = "asc") String sortOrder
   	        )
   	{
   		PageRequest pagerequest=PageRequest.of(offset, limit,Sort.by(Sort.Direction.fromString(sortOrder),sortField));
   		Page<Audience> audience=concertService.getPagesWithSort(pagerequest);
   		if(audience.getTotalElements()>0)
   		{
   			return ResponseEntity.status(200).body(audience);
   		}
   		else
   		{
   			return ResponseEntity.status(404).body(null);
   		}
   	}
       
       @GetMapping("/getAllQuery")
       public ResponseEntity<List<Audience>> getAllQuery()
       {
    	   return ResponseEntity.status(200).body( concertService.getAllQuery());
       }
       
       @GetMapping("/getQueryByEmail")
       public ResponseEntity<Audience> getQueryByEmail(@RequestParam String email)
       {
    	   return ResponseEntity.status(200).body( concertService.getQueryByEmail(email));
       }
       
       @PutMapping("/updateQuery/{name}/{id}")
       public void updateName(@PathVariable String name,@PathVariable Long id)
       {
    	   concertService.updateNameQuery(name, id);
       }
       
       @DeleteMapping("/deleteQuery/{id}")
   	    public ResponseEntity<String> deleteQuery(@PathVariable Long id) {
   		int flag = concertService.deleteQuery(id);
   		if(flag == 1)
   			return ResponseEntity.status(200).body("Record deleted successfully!");
   		else
   			return ResponseEntity.status(200).body("Something went wrong!");
   	   }
       
       
}
