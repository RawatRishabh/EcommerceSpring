package com.example.EcommerceSpring.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse
{
     private int status;
     private String message;
     private LocalDateTime dateTime;

     public ErrorResponse(int status, String message, LocalDateTime dateTime)
     {
         this.status = status;
         this.message = message;
         this.dateTime = dateTime;
     }
}
