package edu.du.sbproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDateTime regdate;

    @Column(nullable = false)
    private String role;

    @PrePersist
    public void prePersist() {
        this.role = this.role == null ? "USER" : this.role;
    }

    public Member(String email, String password, String name, LocalDateTime now) {
    }
}
