package com.ssafy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.Promise;

@Repository
public interface PromiseRepository extends JpaRepository<Promise, Long> {

	
	@Query(value = "select * from promise pr where pr.p_id=?1", nativeQuery = true)
	List<Promise>  findByPoliticianId(int pId );

	@Query(value = "select * from promise where P_ID IN ( select * from ((select a.P_ID from promise as a left join politician as b on a.P_ID = b.P_ID where P_PARTY = \"자유한국당\" order by rand() limit 2) as temp ))", nativeQuery = true)
	List<Promise>  findByPromise(int pId );
	//이름 수정
	
}

