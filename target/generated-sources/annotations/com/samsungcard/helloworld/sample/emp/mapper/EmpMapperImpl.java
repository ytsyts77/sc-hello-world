package com.samsungcard.helloworld.sample.emp.mapper;

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
public class EmpMapperImpl implements EmpMapper {

    @Override
    public EmpDto toEmpDto(Emp emp) {
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

    @Override
    public List<EmpDto> toEmpDto(List<Emp> emp) {
        if ( emp == null ) {
            return null;
        }

        List<EmpDto> list = new ArrayList<EmpDto>( emp.size() );
        for ( Emp emp1 : emp ) {
            list.add( toEmpDto( emp1 ) );
        }

        return list;
    }

    @Override
    public Emp toEntity(EmpDto empDto) {
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

    @Override
    public List<Emp> toEntity(List<EmpDto> empDto) {
        if ( empDto == null ) {
            return null;
        }

        List<Emp> list = new ArrayList<Emp>( empDto.size() );
        for ( EmpDto empDto1 : empDto ) {
            list.add( toEntity( empDto1 ) );
        }

        return list;
    }
}
