package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Address;
import edu.miu.cs545.project.onlinestore.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository public interface AdminRepository extends CrudRepository<Admin, Long> {

}
