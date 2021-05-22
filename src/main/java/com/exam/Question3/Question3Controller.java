package com.exam.Question3;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Question3Controller {

	private List<String> dataList = Arrays.asList("test", "testing", "testing123");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getString(@RequestParam(value="test") String test) {
		for (String s : dataList) {
			if (s.equals(test)) {
				return test;
			}
		}

		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "item not found"
				);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addString(@RequestParam(value="test") String test) {
		dataList.add(test);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateString(@RequestParam(value="oldTest") String oldTest,
			@RequestParam(value="test") String test) {
		Integer index = null;
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).equals(oldTest) == true) {
				index = i;
			}
		}

		if (index == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "String not found"
					);
		}

		dataList.set(index, test);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteString(@RequestParam(value="test") String test) {
		dataList.remove(test);
	}
}
