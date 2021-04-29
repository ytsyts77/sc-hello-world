package com.samsungcard.helloworld.sample.mybatis.mds.service;


import com.samsungcard.helloworld.sample.mybatis.mds.exception.DataNotFoundException;
import com.samsungcard.helloworld.sample.mybatis.mds.repository.ApndngFileMstDynamicSqlSupport;
import com.samsungcard.helloworld.sample.mybatis.mds.repository.ApndngFileMstRepository;
import com.samsungcard.helloworld.sample.mybatis.mds.entity.ApndngFileMst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
@RequiredArgsConstructor
public class ApndngFileMstService {
    private final ApndngFileMstRepository apndngFileMstRepository;

    public ApndngFileMst get(String apndngFileKey, String apndngFileSeq) {
        return apndngFileMstRepository
                .selectByPrimaryKey(apndngFileKey, apndngFileSeq)
                .orElseThrow(() -> new DataNotFoundException("key 에 해당하는 데이터를 찾을 수 없습니다."));
    }

    public List<ApndngFileMst> get(String _apndngFileKey) {
        return apndngFileMstRepository.select(c ->
                c.where(ApndngFileMstDynamicSqlSupport.apndngFileKey, isEqualTo(_apndngFileKey)));
    }
}
