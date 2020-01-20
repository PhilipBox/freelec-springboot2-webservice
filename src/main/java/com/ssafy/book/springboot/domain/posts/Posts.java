package com.ssafy.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복 어노테이션
@NoArgsConstructor // 롬복 어노테이션
@Entity // JPA 어노테이션
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
/* JPA 어노테이션

    @Entity
        - 테이블과 링크될 클래스임을 나타냄.
        - 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭함.
        - ex) SalesManager.java -> sales_manager table

    @Id
        - 해당 테이블의 PK 필드를 나타냄.

    @GeneratedValue
        - PK의 생성 규칙을 나타냄.
        - 스프링부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.

    @Column
        - 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
        - 사용하는 이유는, 기본값 이외 추가로 변경이 필요한 옵션이 있으면 사용한다.
        - 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex:title),
            타입을 TEXT로 변경하고 싶거나(ex:content) 등의 경우에 사용된다.

    @NoArgsConstructor
        - 기본 생성자 자동 추가
        - public Posts(){}와 같은 효과

    @Getter
        - 클래스 내 모든 필드의 Getter 메소드를 자동생성

    @Builder
        - 해당 클래스의 빌더 패턴 클래스를 생성
        - 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함

    <중요>
    Posts 클래스에는 Setter 메소드가 없다.
    자바빈 규약을 생각하면서 Getter/Setter를 무작정 생성하는 경우가 있는데,
    이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지
    코드상으로 명확하게 구분할 수가 없어, 차후 기능변경 시 정말 복잡해진다.

    <<그래서 Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.>>
    대신, 해당 필드의 값 변경이 필요함녀 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.


 */
