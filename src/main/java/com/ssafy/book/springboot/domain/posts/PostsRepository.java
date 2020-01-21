package com.ssafy.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
/*
    보통 MyBatis에서 DAO라고 불리는 DB Layer 접근자.
    JPA에선 Repository라고 부르며 Interface로 생성한다.
    단순히 인터페이스를 생성하고,
        JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.

    <<@Repository를 추가할 필요도 없다!>>
    주의해야 할 점은, Entity 클래스와 기본 Entity Repository는 함꼐 위치해야 하는 점!
    둘은 아주 밀접한 관계이고, Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없다.

    ''추후에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면,
    이때 Entity 클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리한다.''
 */
