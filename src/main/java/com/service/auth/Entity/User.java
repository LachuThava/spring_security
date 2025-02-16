package com.service.auth.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.auth.Enum.Gender;
import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String  email;

    private String name;

    private Gender gender;


    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,targetEntity = AuthenticationRole.class,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<AuthenticationRole> authenticationRoles;

    private Integer age;

    private String password;

    private String address;


}
