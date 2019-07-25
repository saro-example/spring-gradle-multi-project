package web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "user")
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "no", sequenceName = "no_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "no")
    @Column(name = "no")
    long no;

    @Column(name = "name", nullable = false, length = 64)
    String name;
}