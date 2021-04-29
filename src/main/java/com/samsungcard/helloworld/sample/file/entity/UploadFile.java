package com.samsungcard.helloworld.sample.file.entity;

import com.samsungcard.helloworld.global.common.entity.AuditableEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "sample", name = "upload_file")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadFile extends AuditableEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serverFileName;

    @Column(nullable = false)
    private String originFileName;

    @Builder
    public UploadFile(String serverFileName, String originFileName) {
        this.serverFileName = serverFileName;
        this.originFileName = originFileName;
    }
}
