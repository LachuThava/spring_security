package com.service.auth.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.service.auth.Enum.Permission;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;


    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;

    @Column(name = "role_name")
    private String roleName;

    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "role_permissions")
    private List<Permission> permissions;

}
