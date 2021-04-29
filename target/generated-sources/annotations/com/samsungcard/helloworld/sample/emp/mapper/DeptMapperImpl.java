package com.samsungcard.helloworld.sample.emp.mapper;

import com.samsungcard.helloworld.sample.emp.dto.DeptDto;
import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (AdoptOpenJDK)"
)
@Component
public class DeptMapperImpl implements DeptMapper {

    @Override
    public DeptDto toDeptDto(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        String name = null;

        name = dept.getName();

        DeptDto deptDto = new DeptDto( name );

        deptDto.setId( dept.getId() );
        deptDto.setEmpList( empListToEmpDtoList( dept.getEmpList() ) );

        return deptDto;
    }

    @Override
    public List<DeptDto> toDeptDto(List<Dept> deptList) {
        if ( deptList == null ) {
            return null;
        }

        List<DeptDto> list = new ArrayList<DeptDto>( deptList.size() );
        for ( Dept dept : deptList ) {
            list.add( toDeptDto( dept ) );
        }

        return list;
    }

    @Override
    public Dept toEntity(DeptDto deptDto) {
        if ( deptDto == null ) {
            return null;
        }

        String name = null;

        name = deptDto.getName();

        Dept dept = new Dept( name );

        dept.setId( deptDto.getId() );
        if ( dept.getEmpList() != null ) {
            List<Emp> list = empDtoListToEmpList( deptDto.getEmpList() );
            if ( list != null ) {
                dept.getEmpList().addAll( list );
            }
        }

        return dept;
    }

    @Override
    public List<Dept> toEntity(List<DeptDto> deptDtoList) {
        if ( deptDtoList == null ) {
            return null;
        }

        List<Dept> list = new ArrayList<Dept>( deptDtoList.size() );
        for ( DeptDto deptDto : deptDtoList ) {
            list.add( toEntity( deptDto ) );
        }

        return list;
    }

    protected EmpDto empToEmpDto(Emp emp) {
        if ( emp == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        String email = null;

        firstName = emp.getFirstName();
        lastName = emp.getLastName();
        email = emp.getEmail();

        EmpDto empDto = new EmpDto( firstName, lastName, email );

        empDto.setId( emp.getId() );

        return empDto;
    }

    protected List<EmpDto> empListToEmpDtoList(List<Emp> list) {
        if ( list == null ) {
            return null;
        }

        List<EmpDto> list1 = new ArrayList<EmpDto>( list.size() );
        for ( Emp emp : list ) {
            list1.add( empToEmpDto( emp ) );
        }

        return list1;
    }

    protected Emp empDtoToEmp(EmpDto empDto) {
        if ( empDto == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        String email = null;

        firstName = empDto.getFirstName();
        lastName = empDto.getLastName();
        email = empDto.getEmail();

        Dept dept = null;

        Emp emp = new Emp( firstName, lastName, email, dept );

        emp.setId( empDto.getId() );

        return emp;
    }

    protected List<Emp> empDtoListToEmpList(List<EmpDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Emp> list1 = new ArrayList<Emp>( list.size() );
        for ( EmpDto empDto : list ) {
            list1.add( empDtoToEmp( empDto ) );
        }

        return list1;
    }
}
