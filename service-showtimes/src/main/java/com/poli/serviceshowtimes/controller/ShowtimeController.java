package com.poli.serviceshowtimes.controller;

import com.poli.serviceshowtimes.entities.Showtime;
import com.poli.serviceshowtimes.service.ShowtimeService;
import com.poli.serviceshowtimes.utils.ErrorMessage;
import com.poli.serviceshowtimes.utils.Response;
import com.poli.serviceshowtimes.utils.ResponseBuilder;
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
@RequestMapping("/showtimes")
public class ShowtimeController {


    private final ShowtimeService showtimeService;
    private final ResponseBuilder builder;
    @PostMapping
    public Response save(@RequestBody Showtime showtime, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage((result)));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findById(id);
        if(showtime ==null){
            return ResponseEntity.notFound().build();
        }
        showtimeService.delete(showtime);
        return ResponseEntity.ok(showtime);
    }

    @GetMapping
    public ResponseEntity<List<Showtime>> findAll(){
        List<Showtime> bookings = showtimeService.findAll();
        if(bookings.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findById(id);
        if(showtime ==null){
            return builder.success(null);
        }
        return builder.success(showtime);
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
