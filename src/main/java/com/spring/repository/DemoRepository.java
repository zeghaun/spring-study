package com.spring.repository;

import com.spring.entity.DemoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */

public interface DemoRepository extends JpaRepository<DemoEntity, String> {

    DemoEntity findById(int id);

    //    @Modifying
//    @Query(value = "update demo set age=?2 where id=?1")
//    int update(int id, int age);
    long count();

    int removeByName(String value);

    @Query(value = "SELECT new com.spring.entity.DemoEntity(d.id,d.name,d.age,d.remark) FROM DemoEntity d")
    List<DemoEntity> getDemoEntityList(Pageable pageable);

    //这里必须加fetch才不会延迟加载，与DemoEntity中的@oneToOne无关，，与实际项目中不一样  奇怪
    @Query(value = "SELECT d " +
            "from DemoEntity d " +
            "LEFT JOIN FETCH d.hibernateEntity t " +
            "where d.id=30")
    DemoEntity getByJoin();


    /**
     * 标准的left join查找书籍
     */
//    @Query("SELECT new com.nd.elibrary.modules.bookmanagement.domain.DetailBook(d.detailBookId,d.bookId,d.libraryId,d.book) " +
//            "FROM DetailBook d " +
//            "LEFT JOIN d.book " +
//            "WHERE d.detailBookId in(:detailBookId)")
//    List<DetailBook> findByDetailBookId(@Param("detailBookId") List<Long> detailBookId);

}
