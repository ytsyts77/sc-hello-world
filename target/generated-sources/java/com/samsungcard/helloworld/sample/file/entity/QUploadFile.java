package com.samsungcard.helloworld.sample.file.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUploadFile is a Querydsl query type for UploadFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUploadFile extends EntityPathBase<UploadFile> {

    private static final long serialVersionUID = 787623229L;

    public static final QUploadFile uploadFile = new QUploadFile("uploadFile");

    public final com.samsungcard.helloworld.global.common.entity.QAuditableEntity _super = new com.samsungcard.helloworld.global.common.entity.QAuditableEntity(this);

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath originFileName = createString("originFileName");

    public final StringPath serverFileName = createString("serverFileName");

    public QUploadFile(String variable) {
        super(UploadFile.class, forVariable(variable));
    }

    public QUploadFile(Path<? extends UploadFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUploadFile(PathMetadata metadata) {
        super(UploadFile.class, metadata);
    }

}

