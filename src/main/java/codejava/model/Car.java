package codejava.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String mark;

    @Column
    private String color;

    @Column
    private int number;

    public Car(String mark, String color, int number) {
        this.mark = mark;
        this.color = color;
        this.number = number;
    }

}
