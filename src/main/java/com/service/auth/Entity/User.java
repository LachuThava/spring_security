package com.service.auth.Entity;

import com.service.auth.Enum.Gender;
import lombok.*;
import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String  email;

    private String name;

    private Gender gender;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Role> role;

    private Integer age;

    private String password;

    private String address;


}
