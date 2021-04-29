package com.samsungcard.helloworld.sample.jpa.member.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "sample", name = "team")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "team_name", nullable = false, unique = true)
    private String teamName;

    @OneToMany(mappedBy = "team")
    private final List<Member> members = new ArrayList<>();
}
