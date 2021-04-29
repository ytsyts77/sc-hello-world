package com.samsungcard.helloworld.sample.emp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDept is a Querydsl query type for Dept
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDept extends EntityPathBase<Dept> {

    private static final long serialVersionUID = -760461245L;

    public static final QDept dept = new QDept("dept");

    public final com.samsungcard.helloworld.global.common.entity.QAuditableEntity _super = new com.samsungcard.helloworld.global.common.entity.QAuditableEntity(this);

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<Emp, QEmp> empList = this.<Emp, QEmp>createList("empList", Emp.class, QEmp.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public QDept(String variable) {
        super(Dept.class, forVariable(variable));
    }

    public QDept(Path<? extends Dept> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDept(PathMetadata metadata) {
        super(Dept.class, metadata);
    }

}

