package com.samsungcard.helloworld.sample.jpa.member.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(schema = "sample", name = "member")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}
