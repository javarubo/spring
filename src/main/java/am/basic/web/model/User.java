package am.basic.web.model;

import lombok.Data;
import net.bytebuddy.build.Plugin;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "user", schema = "test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, length = 32)
    private long id;

    private String name;

    private String surname;

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private List<Action> action;

    @Size(max = 78, min = 2, message = "fhgfhgdf")
    private String code;

    @NotBlank
    private String age;


}

