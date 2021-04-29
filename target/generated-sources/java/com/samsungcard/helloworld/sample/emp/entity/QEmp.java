package com.samsungcard.helloworld.sample.emp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmp is a Querydsl query type for Emp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmp extends EntityPathBase<Emp> {

    private static final long serialVersionUID = 668206858L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmp emp = new QEmp("emp");

    public final com.samsungcard.helloworld.global.common.entity.QAuditableEntity _super = new com.samsungcard.helloworld.global.common.entity.QAuditableEntity(this);

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QDept dept;

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath lastName = createString("lastName");

    public QEmp(String variable) {
        this(Emp.class, forVariable(variable), INITS);
    }

    public QEmp(Path<? extends Emp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmp(PathMetadata metadata, PathInits inits) {
        this(Emp.class, metadata, inits);
    }

    public QEmp(Class<? extends Emp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dept = inits.isInitialized("dept") ? new QDept(forProperty("dept")) : null;
    }

}

