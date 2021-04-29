package com.samsungcard.helloworld.sample.emp.entity;

import com.samsungcard.helloworld.global.common.entity.AuditableEntity;
import com.samsungcard.helloworld.global.common.message.UserMessage;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(schema = "sample", name = "emp")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Emp extends AuditableEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @Builder
    public Emp(String firstName, String lastName, String email, Dept dept) {
        Assert.hasText(firstName, UserMessage.REQUIRED.with("이름"));
        Assert.hasText(lastName, UserMessage.REQUIRED.with("성"));
        Assert.hasText(email, UserMessage.REQUIRED.with("이메일"));

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dept = dept;
    }

    public void updateName(String firstName, String lastName) {
        Assert.hasText(firstName, UserMessage.REQUIRED.with("이름"));
        Assert.hasText(lastName, UserMessage.REQUIRED.with("성"));

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void updateEmail(String email) {
        Assert.hasText(email, UserMessage.REQUIRED.with("이메일"));

        this.email = email;
    }
}
