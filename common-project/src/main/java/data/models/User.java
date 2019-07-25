package data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "un", nullable = false)
    long no;

    @Column(name = "account", nullable = false, length = 64, unique = true)
    String account;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 512)
    String password;

    @Column(name = "mail", nullable = false, length = 64)
    String mail;

    @Column(name = "name", nullable = false, length = 16)
    String name;

    @Column(name = "join_dt", nullable = false)
    Date joinDt;
}