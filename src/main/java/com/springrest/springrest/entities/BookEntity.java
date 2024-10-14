package com.springrest.springrest.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springrest.springrest.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
@Table(name = "book")
public final class BookEntity {
    @Id @NotNull @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private long isbn ;
    @NotNull @NotEmpty
    private String author ;
    private Genre book_type ;
    private String book_name ;
    private long price ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Version
    private Long version ;

    @PrePersist
    protected void onCreate() {
        created = new Date();
        updated = new Date();
    }

    // This method is called before the entity is updated in the database (updates the updated field)
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
