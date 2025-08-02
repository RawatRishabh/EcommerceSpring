package com.example.EcommerceSpring.entity;

// Importing JPA for using @ID, @Column annotation , uses for mapped class to the db structure
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Instant is a class which comes from Java Time API, represent the timestamp in UTC
import java.time.Instant;

// JPA annotation, which is used to define the base class that contains the common fields
// Unlike @Entity > it does not get db table
// Uses for separate the repetitive field occurs in the entity

// It will work when you enable the JPA-auditing in the main application
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity
{

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it tells auto-increment the value of id in the DB.
   private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
   private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
   private Instant updatedAt;

    // below methods us automatically called before the entity save for the first time
    @PrePersist
   public void onCreate()
   {
       Instant now = Instant.now();
       this.createdAt = now;
       this.updatedAt = now;
   }

   @PreUpdate
   public void onUpdate()
  {
     this.updatedAt = Instant.now();
  }
}
