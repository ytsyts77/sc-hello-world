package com.samsungcard.helloworld.global.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditableEntity is a Querydsl query type for AuditableEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAuditableEntity extends EntityPathBase<AuditableEntity<?>> {

    private static final long serialVersionUID = -1969990014L;

    public static final QAuditableEntity auditableEntity = new QAuditableEntity("auditableEntity");

    public final SimplePath<Object> createdBy = createSimple("createdBy", Object.class);

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final SimplePath<Object> lastModifiedBy = createSimple("lastModifiedBy", Object.class);

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAuditableEntity(String variable) {
        super((Class) AuditableEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAuditableEntity(Path<? extends AuditableEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAuditableEntity(PathMetadata metadata) {
        super((Class) AuditableEntity.class, metadata);
    }

}

