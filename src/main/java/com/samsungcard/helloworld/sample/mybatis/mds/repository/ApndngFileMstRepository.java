package com.samsungcard.helloworld.sample.mybatis.mds.repository;

import com.samsungcard.helloworld.sample.mybatis.mds.entity.ApndngFileMst;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.samsungcard.helloworld.sample.mybatis.mds.repository.ApndngFileMstDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ApndngFileMstRepository {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(apndngFileKey, apndngFileSeq, systemCfcd, userFileNm, userFilePathNm, actulFileNm, actulFilePathNm, fileSize, fileDesc, ipempno, ipdttm, ippgid, ipipad, crempno, crdttm, crpgid, cripad);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ApndngFileMst> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ApndngFileMst> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ApndngFileMstResult")
    Optional<ApndngFileMst> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ApndngFileMstResult", value = {
        @Result(column="APNDNG_FILE_KEY", property="apndngFileKey", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="APNDNG_FILE_SEQ", property="apndngFileSeq", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="SYSTEM_CFCD", property="systemCfcd", jdbcType=JdbcType.CHAR),
        @Result(column="USER_FILE_NM", property="userFileNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_FILE_PATH_NM", property="userFilePathNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTUL_FILE_NM", property="actulFileNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTUL_FILE_PATH_NM", property="actulFilePathNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="FILE_SIZE", property="fileSize", jdbcType=JdbcType.DECIMAL),
        @Result(column="FILE_DESC", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="IPEMPNO", property="ipempno", jdbcType=JdbcType.CHAR),
        @Result(column="IPDTTM", property="ipdttm", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="IPPGID", property="ippgid", jdbcType=JdbcType.VARCHAR),
        @Result(column="IPIPAD", property="ipipad", jdbcType=JdbcType.CHAR),
        @Result(column="CREMPNO", property="crempno", jdbcType=JdbcType.CHAR),
        @Result(column="CRDTTM", property="crdttm", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CRPGID", property="crpgid", jdbcType=JdbcType.VARCHAR),
        @Result(column="CRIPAD", property="cripad", jdbcType=JdbcType.CHAR)
    })
    List<ApndngFileMst> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, apndngFileMst, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, apndngFileMst, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String apndngFileKey_, String apndngFileSeq_) {
        return delete(c -> 
            c.where(apndngFileKey, isEqualTo(apndngFileKey_))
            .and(apndngFileSeq, isEqualTo(apndngFileSeq_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ApndngFileMst record) {
        return MyBatis3Utils.insert(this::insert, record, apndngFileMst, c ->
            c.map(apndngFileKey).toProperty("apndngFileKey")
            .map(apndngFileSeq).toProperty("apndngFileSeq")
            .map(systemCfcd).toProperty("systemCfcd")
            .map(userFileNm).toProperty("userFileNm")
            .map(userFilePathNm).toProperty("userFilePathNm")
            .map(actulFileNm).toProperty("actulFileNm")
            .map(actulFilePathNm).toProperty("actulFilePathNm")
            .map(fileSize).toProperty("fileSize")
            .map(fileDesc).toProperty("fileDesc")
            .map(ipempno).toProperty("ipempno")
            .map(ipdttm).toProperty("ipdttm")
            .map(ippgid).toProperty("ippgid")
            .map(ipipad).toProperty("ipipad")
            .map(crempno).toProperty("crempno")
            .map(crdttm).toProperty("crdttm")
            .map(crpgid).toProperty("crpgid")
            .map(cripad).toProperty("cripad")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ApndngFileMst> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, apndngFileMst, c ->
            c.map(apndngFileKey).toProperty("apndngFileKey")
            .map(apndngFileSeq).toProperty("apndngFileSeq")
            .map(systemCfcd).toProperty("systemCfcd")
            .map(userFileNm).toProperty("userFileNm")
            .map(userFilePathNm).toProperty("userFilePathNm")
            .map(actulFileNm).toProperty("actulFileNm")
            .map(actulFilePathNm).toProperty("actulFilePathNm")
            .map(fileSize).toProperty("fileSize")
            .map(fileDesc).toProperty("fileDesc")
            .map(ipempno).toProperty("ipempno")
            .map(ipdttm).toProperty("ipdttm")
            .map(ippgid).toProperty("ippgid")
            .map(ipipad).toProperty("ipipad")
            .map(crempno).toProperty("crempno")
            .map(crdttm).toProperty("crdttm")
            .map(crpgid).toProperty("crpgid")
            .map(cripad).toProperty("cripad")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ApndngFileMst record) {
        return MyBatis3Utils.insert(this::insert, record, apndngFileMst, c ->
            c.map(apndngFileKey).toPropertyWhenPresent("apndngFileKey", record::getApndngFileKey)
            .map(apndngFileSeq).toPropertyWhenPresent("apndngFileSeq", record::getApndngFileSeq)
            .map(systemCfcd).toPropertyWhenPresent("systemCfcd", record::getSystemCfcd)
            .map(userFileNm).toPropertyWhenPresent("userFileNm", record::getUserFileNm)
            .map(userFilePathNm).toPropertyWhenPresent("userFilePathNm", record::getUserFilePathNm)
            .map(actulFileNm).toPropertyWhenPresent("actulFileNm", record::getActulFileNm)
            .map(actulFilePathNm).toPropertyWhenPresent("actulFilePathNm", record::getActulFilePathNm)
            .map(fileSize).toPropertyWhenPresent("fileSize", record::getFileSize)
            .map(fileDesc).toPropertyWhenPresent("fileDesc", record::getFileDesc)
            .map(ipempno).toPropertyWhenPresent("ipempno", record::getIpempno)
            .map(ipdttm).toPropertyWhenPresent("ipdttm", record::getIpdttm)
            .map(ippgid).toPropertyWhenPresent("ippgid", record::getIppgid)
            .map(ipipad).toPropertyWhenPresent("ipipad", record::getIpipad)
            .map(crempno).toPropertyWhenPresent("crempno", record::getCrempno)
            .map(crdttm).toPropertyWhenPresent("crdttm", record::getCrdttm)
            .map(crpgid).toPropertyWhenPresent("crpgid", record::getCrpgid)
            .map(cripad).toPropertyWhenPresent("cripad", record::getCripad)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ApndngFileMst> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, apndngFileMst, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ApndngFileMst> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, apndngFileMst, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ApndngFileMst> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, apndngFileMst, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ApndngFileMst> selectByPrimaryKey(String apndngFileKey_, String apndngFileSeq_) {
        return selectOne(c ->
            c.where(apndngFileKey, isEqualTo(apndngFileKey_))
            .and(apndngFileSeq, isEqualTo(apndngFileSeq_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, apndngFileMst, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ApndngFileMst record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(apndngFileKey).equalTo(record::getApndngFileKey)
                .set(apndngFileSeq).equalTo(record::getApndngFileSeq)
                .set(systemCfcd).equalTo(record::getSystemCfcd)
                .set(userFileNm).equalTo(record::getUserFileNm)
                .set(userFilePathNm).equalTo(record::getUserFilePathNm)
                .set(actulFileNm).equalTo(record::getActulFileNm)
                .set(actulFilePathNm).equalTo(record::getActulFilePathNm)
                .set(fileSize).equalTo(record::getFileSize)
                .set(fileDesc).equalTo(record::getFileDesc)
                .set(ipempno).equalTo(record::getIpempno)
                .set(ipdttm).equalTo(record::getIpdttm)
                .set(ippgid).equalTo(record::getIppgid)
                .set(ipipad).equalTo(record::getIpipad)
                .set(crempno).equalTo(record::getCrempno)
                .set(crdttm).equalTo(record::getCrdttm)
                .set(crpgid).equalTo(record::getCrpgid)
                .set(cripad).equalTo(record::getCripad);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ApndngFileMst record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(apndngFileKey).equalToWhenPresent(record::getApndngFileKey)
                .set(apndngFileSeq).equalToWhenPresent(record::getApndngFileSeq)
                .set(systemCfcd).equalToWhenPresent(record::getSystemCfcd)
                .set(userFileNm).equalToWhenPresent(record::getUserFileNm)
                .set(userFilePathNm).equalToWhenPresent(record::getUserFilePathNm)
                .set(actulFileNm).equalToWhenPresent(record::getActulFileNm)
                .set(actulFilePathNm).equalToWhenPresent(record::getActulFilePathNm)
                .set(fileSize).equalToWhenPresent(record::getFileSize)
                .set(fileDesc).equalToWhenPresent(record::getFileDesc)
                .set(ipempno).equalToWhenPresent(record::getIpempno)
                .set(ipdttm).equalToWhenPresent(record::getIpdttm)
                .set(ippgid).equalToWhenPresent(record::getIppgid)
                .set(ipipad).equalToWhenPresent(record::getIpipad)
                .set(crempno).equalToWhenPresent(record::getCrempno)
                .set(crdttm).equalToWhenPresent(record::getCrdttm)
                .set(crpgid).equalToWhenPresent(record::getCrpgid)
                .set(cripad).equalToWhenPresent(record::getCripad);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ApndngFileMst record) {
        return update(c ->
            c.set(systemCfcd).equalTo(record::getSystemCfcd)
            .set(userFileNm).equalTo(record::getUserFileNm)
            .set(userFilePathNm).equalTo(record::getUserFilePathNm)
            .set(actulFileNm).equalTo(record::getActulFileNm)
            .set(actulFilePathNm).equalTo(record::getActulFilePathNm)
            .set(fileSize).equalTo(record::getFileSize)
            .set(fileDesc).equalTo(record::getFileDesc)
            .set(ipempno).equalTo(record::getIpempno)
            .set(ipdttm).equalTo(record::getIpdttm)
            .set(ippgid).equalTo(record::getIppgid)
            .set(ipipad).equalTo(record::getIpipad)
            .set(crempno).equalTo(record::getCrempno)
            .set(crdttm).equalTo(record::getCrdttm)
            .set(crpgid).equalTo(record::getCrpgid)
            .set(cripad).equalTo(record::getCripad)
            .where(apndngFileKey, isEqualTo(record::getApndngFileKey))
            .and(apndngFileSeq, isEqualTo(record::getApndngFileSeq))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ApndngFileMst record) {
        return update(c ->
            c.set(systemCfcd).equalToWhenPresent(record::getSystemCfcd)
            .set(userFileNm).equalToWhenPresent(record::getUserFileNm)
            .set(userFilePathNm).equalToWhenPresent(record::getUserFilePathNm)
            .set(actulFileNm).equalToWhenPresent(record::getActulFileNm)
            .set(actulFilePathNm).equalToWhenPresent(record::getActulFilePathNm)
            .set(fileSize).equalToWhenPresent(record::getFileSize)
            .set(fileDesc).equalToWhenPresent(record::getFileDesc)
            .set(ipempno).equalToWhenPresent(record::getIpempno)
            .set(ipdttm).equalToWhenPresent(record::getIpdttm)
            .set(ippgid).equalToWhenPresent(record::getIppgid)
            .set(ipipad).equalToWhenPresent(record::getIpipad)
            .set(crempno).equalToWhenPresent(record::getCrempno)
            .set(crdttm).equalToWhenPresent(record::getCrdttm)
            .set(crpgid).equalToWhenPresent(record::getCrpgid)
            .set(cripad).equalToWhenPresent(record::getCripad)
            .where(apndngFileKey, isEqualTo(record::getApndngFileKey))
            .and(apndngFileSeq, isEqualTo(record::getApndngFileSeq))
        );
    }
}
