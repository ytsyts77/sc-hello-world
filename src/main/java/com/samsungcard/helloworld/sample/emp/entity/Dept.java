package com.samsungcard.helloworld.sample.emp.entity;

import com.samsungcard.helloworld.global.common.entity.AuditableEntity;
import com.samsungcard.helloworld.global.common.message.UserMessage;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "sample", name = "dept")
@Getter
@Setter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dept extends AuditableEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "dept")
    private final List<Emp> empList = new ArrayList<>();

    @Builder
    public Dept(String name) {
        Assert.hasText(name, UserMessage.REQUIRED.with("부서명"));
        this.name = name;
    }

    public void updateName(String name) {
        Assert.hasText(name, UserMessage.REQUIRED.with("부서명"));
        this.name = name;
    }
}
