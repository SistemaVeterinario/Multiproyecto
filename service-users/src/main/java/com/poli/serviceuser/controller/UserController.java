package com.poli.serviceuser.controller;

import com.poli.serviceuser.entities.User;
import com.poli.serviceuser.service.UserService;
import com.poli.serviceuser.utils.ErrorMessage;
import com.poli.serviceuser.utils.Response;
import com.poli.serviceuser.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final ResponseBuilder builder;
    @PostMapping
    public Response save(@RequestBody User booking, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage((result)));
        }
        userService.save(booking);
        return builder.success(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        User booking = userService.findById(id);
        if(booking==null){
            return ResponseEntity.notFound().build();
        }
        userService.delete(booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> bookings = userService.findAll();
        if(bookings.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        User booking = userService.findById(id);
        if(booking==null){
            return builder.success(null);
        }
        return builder.success(booking);
    }

    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .message(errors)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try{
            json = objectMapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }
}
