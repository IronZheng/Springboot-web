package com.hami.serve.repo;

import com.hami.serve.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Log,Long>{
}
