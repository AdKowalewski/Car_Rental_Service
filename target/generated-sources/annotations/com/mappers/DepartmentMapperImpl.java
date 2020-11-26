package com.mappers;

import com.dto.DepartmentDto;
import com.model.Car;
import com.model.Department;
import com.model.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department toEntity(DepartmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( dto.getId() );
        department.setAddress( dto.getAddress() );
        List<Worker> list = dto.getWorkers();
        if ( list != null ) {
            department.setWorkers( new ArrayList<Worker>( list ) );
        }
        List<Car> list1 = dto.getCars();
        if ( list1 != null ) {
            department.setCars( new ArrayList<Car>( list1 ) );
        }

        return department;
    }

    @Override
    public DepartmentDto toDto(Department entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( entity.getId() );
        departmentDto.setAddress( entity.getAddress() );
        List<Worker> list = entity.getWorkers();
        if ( list != null ) {
            departmentDto.setWorkers( new ArrayList<Worker>( list ) );
        }
        List<Car> list1 = entity.getCars();
        if ( list1 != null ) {
            departmentDto.setCars( new ArrayList<Car>( list1 ) );
        }

        return departmentDto;
    }
}
