package com.hami.serve.repo;

import com.hami.serve.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long>{
}
