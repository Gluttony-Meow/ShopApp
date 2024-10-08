package com.project.shopapp.controllers;

import com.project.shopapp.dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
//@Validated
public class CategoryController {
    //show all cateogries
    @GetMapping("") //http://localhost:8088/api/v1/categories?page=1&limit=10
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page")   int page,
            @RequestParam("limit")  int limit
    ){
        return ResponseEntity.ok(String.format("getAllCategories,page =%d,limit =%d",page,limit));
    }
    @PostMapping("")
    public ResponseEntity<?> insertCategories(@Valid @RequestBody CategoryDTO categoryDTO,
                                                   BindingResult result){
        if(result.hasErrors()){
             List<String> errorMessages = result.getFieldErrors()
                                    .stream()
                                    .map(FieldError::getDefaultMessage)
                                    .toList();
             return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("insert"+categoryDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategories(@PathVariable Long id){
        return ResponseEntity.ok("update"+id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable Long id){
        return ResponseEntity.ok("delete Category with id ="+id);
    }
}
