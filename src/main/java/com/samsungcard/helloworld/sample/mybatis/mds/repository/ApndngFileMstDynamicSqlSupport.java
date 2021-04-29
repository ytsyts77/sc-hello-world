package com.samsungcard.helloworld.sample.mybatis.mds.repository;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;

public final class ApndngFileMstDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ApndngFileMst apndngFileMst = new ApndngFileMst();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> apndngFileKey = apndngFileMst.apndngFileKey;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> apndngFileSeq = apndngFileMst.apndngFileSeq;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> systemCfcd = apndngFileMst.systemCfcd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userFileNm = apndngFileMst.userFileNm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userFilePathNm = apndngFileMst.userFilePathNm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> actulFileNm = apndngFileMst.actulFileNm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> actulFilePathNm = apndngFileMst.actulFilePathNm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> fileSize = apndngFileMst.fileSize;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileDesc = apndngFileMst.fileDesc;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ipempno = apndngFileMst.ipempno;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> ipdttm = apndngFileMst.ipdttm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ippgid = apndngFileMst.ippgid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ipipad = apndngFileMst.ipipad;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> crempno = apndngFileMst.crempno;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> crdttm = apndngFileMst.crdttm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> crpgid = apndngFileMst.crpgid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> cripad = apndngFileMst.cripad;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ApndngFileMst extends SqlTable {
        public final SqlColumn<String> apndngFileKey = column("APNDNG_FILE_KEY", JDBCType.VARCHAR);

        public final SqlColumn<String> apndngFileSeq = column("APNDNG_FILE_SEQ", JDBCType.CHAR);

        public final SqlColumn<String> systemCfcd = column("SYSTEM_CFCD", JDBCType.CHAR);

        public final SqlColumn<String> userFileNm = column("USER_FILE_NM", JDBCType.VARCHAR);

        public final SqlColumn<String> userFilePathNm = column("USER_FILE_PATH_NM", JDBCType.VARCHAR);

        public final SqlColumn<String> actulFileNm = column("ACTUL_FILE_NM", JDBCType.VARCHAR);

        public final SqlColumn<String> actulFilePathNm = column("ACTUL_FILE_PATH_NM", JDBCType.VARCHAR);

        public final SqlColumn<Long> fileSize = column("FILE_SIZE", JDBCType.DECIMAL);

        public final SqlColumn<String> fileDesc = column("FILE_DESC", JDBCType.VARCHAR);

        public final SqlColumn<String> ipempno = column("IPEMPNO", JDBCType.CHAR);

        public final SqlColumn<Date> ipdttm = column("IPDTTM", JDBCType.TIMESTAMP);

        public final SqlColumn<String> ippgid = column("IPPGID", JDBCType.VARCHAR);

        public final SqlColumn<String> ipipad = column("IPIPAD", JDBCType.CHAR);

        public final SqlColumn<String> crempno = column("CREMPNO", JDBCType.CHAR);

        public final SqlColumn<Date> crdttm = column("CRDTTM", JDBCType.TIMESTAMP);

        public final SqlColumn<String> crpgid = column("CRPGID", JDBCType.VARCHAR);

        public final SqlColumn<String> cripad = column("CRIPAD", JDBCType.CHAR);

        public ApndngFileMst() {
            super("DVC.APNDNG_FILE_MST");
        }
    }
}
