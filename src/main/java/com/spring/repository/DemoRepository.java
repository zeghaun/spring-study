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

    //
    @Query(value = "SELECT new com.spring.entity.DemoEntity(d.id,d.name,t.key,t.value) " +
            "from DemoEntity d " +
            "LEFT JOIN d.hibernateEntity t " +
            "where d.id=30")
    DemoEntity getByJoin();


    DemoEntity findByName(String name);
    /**
     * 标准的left join查找书籍,可以批量查找
     * 1.使用new和d（entity）是走不一样的规则，使用d是可以正常的使用FETCH
     * 2.使用new 那么lazy和EAGER都没有用了，会直接left join 加载一次加载,毕竟t要马上加载
     * 3.如果你使用fetch,那么fetch左边的连接对象(拥有者)一定要出现在select后，select d ***,所以（1）才成立
     * 4.配置完oneToOne的，findByName普通的查询也会left join忧伤
     */
//    @Query("SELECT new com.nd.elibrary.modules.bookmanagement.domain.DetailBook(d.detailBookId,d.bookId,d.libraryId,d.book) " +
//            "FROM DetailBook d " +
//            "LEFT JOIN d.book t" +
//            "WHERE d.detailBookId in(:detailBookId)")
//    List<DetailBook> findByDetailBookId(@Param("detailBookId") List<Long> detailBookId);

}
