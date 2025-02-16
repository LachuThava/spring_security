package com.service.auth.Entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@Table(name="authentication_role")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authentication_role_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Long createdAt;

    private Long updatedAt;

}
