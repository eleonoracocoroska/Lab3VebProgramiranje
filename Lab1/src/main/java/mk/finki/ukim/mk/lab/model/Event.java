package mk.finki.ukim.mk.lab.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double popularityScore;



    @ManyToOne
    private Location location;

   /* public Event(String name,String description,double popularityScore) {
        this.name = name;
        this.description=description;
        this.popularityScore=popularityScore;
        //this.category=category;
        this.id=(long)(Math.random()*1000);

    }
    */
    public Event(String name,String description,double popularityScore,Location location)
    {
        this.id=(long)(Math.random()*1000);
        this.name = name;
        this.description=description;
        this.popularityScore=popularityScore;
        this.location=location;

    }

}

