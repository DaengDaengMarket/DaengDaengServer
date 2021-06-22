# <div align="center">댕댕마켓</div>

<<<<<<< HEAD
<!-- heading -->
# 백엔드

- Java
- Spring Boot
- Mysql
- JPA

<img width="1014" alt="도구 툴" src="https://justinnn980.github.io/devtoop.png">

<details>
<summary>1주차</symmary>

>계획설정 및 Restful API

BackEnd Plan

<img width="1014" alt="백엔드 계획표" src="https://justinnn980.github.io/backplan.png">

</details>



<details>
<summary>2주차</summary>
오프라인으로 만나서 초기 설정 완료
>bulid.gradle 모듈설치와 설정 공유

>DTO -> Service -> Entity(JPA)

>DB테이블 만들기, mysql 연동 

>상품,회원 상품이미지,채팅방,채팅메세지,찜,리뷰,신고 광고 테이블(Entity) 및 <br/> 더미값 추가 완료


공지사항 CRUD
>JAVA spring boot CRUD교육
</details>





<details>
 <summary>3주차</summary>

>홈 화면 데이터 뿌려주기

- 상품등록, 수정, 삭제, 상세

_________
>Spring Boot를 이용한 JWT 인증, 인가 구현

- 인증은 Request를 보낸 User가 누구인지? 올바른 User인지 확인하는 과정
- 인가는 Request가 수행하고자 하는 행동이 허가된 행동인지를 확인하는 과정

__________
>회원가입 기능 구현

### [수정사항]
1. MySQL쿼리를 보기 위해 JPA 방언처리를 했고
2. requestBuilder를 Entity로 변환하기 위해 User Entity에 생성자 및 builder 추가
3. UserController의 URI 오타 수정(/user -> /users)

### [추가사항]
1. requestDto 추가
2. 이메일 중복검사 exception 추가
3. JPA(entityManager)를 사용하는 repository 추가(회원가입과 이메일로 회원들 찾기)
4. 회원가입, 중복 체크 단위 테스트 및 Controller API 테스트

![스크린샷 2021-06-26 오전 3 13 23](https://user-images.githubusercontent.com/68089565/123473444-8819cb00-d633-11eb-92f0-0b3f0f5ed761.png)

<img width="1014" alt="스크린샷 2021-06-26 오전 3 44 03" src="https://user-images.githubusercontent.com/68089565/123473493-9b2c9b00-d633-11eb-902a-cab98b0006e2.png">

## API TEST CODE
> 아래와 같이 작성 시 랜덤 포트에서도 테스트가 가능하고 api의 기능이 정상 작동하는지(HTTP상태코드, 결과값)를 확인 가능합니다.

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private JPAUserRepository jpaUserRepository;

    @Test
    @Transactional
    public void 회원가입_API() throws Exception {
        //given
        String email = "ssss@ss.ss";
        String tel = "010234534634";
        UserRequestDto dto = new UserRequestDto();
        UserRequestDto userDto = dto.builder()
                .email(email)
                .password("1234")
                .nickname("닉넴")
                .concern(BigCategory.BIG)
                .tel(tel)
                .build();
        String url = "http://localhost:" + port + "/users";

        //when
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, userDto, String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).hasSizeGreaterThan(0);

        List<User> findUserByEmail = jpaUserRepository.findByEmail(email);
        assertThat(findUserByEmail.get(0).getEmail()).isEqualTo(email);
        assertThat(findUserByEmail.get(0).getTel()).isEqualTo(tel);
    }
} 

```
#### 결과
![스크린샷 2021-06-26 오전 3 45 35](https://user-images.githubusercontent.com/68089565/123473484-9667e700-d633-11eb-8995-23fe540e5abc.png)
</details>

<details>
<summary>4주차</summary>

>프론트엔드와 백엔드 연동

- 회원가입하고 로그인만 연동

> 광고 부분 CRUD

> 마이페이지 조회 구현
(판매정보, 구매정보, 리뷰, 동네인증)
- 아직 동네인증은 구현하지 않았습니다

> 홈화면, 마이페이지 페이징 구현

> 리뷰작성 구현

</details>

<details>
<summary>5주차</summary>

>프론트엔드와 백엔드 연동

- 상품, 공지사항, 광고

- 마이페이지(동네인증까지), 홈화면, 리뷰작성 프론트와 연동 예정

>로그인에 따른 네비바 및 페이지 접속
</details>

<details>
<summary>6주차</summary>
=======
### <div align="center">애견인들의 중고거래 플랫폼</div>


<div align="center">이제 댕댕마켓으로 거래하라
</div>  


<img src="" />  




## 댕댕마켓 기능


#### 사용자


- 상품 등록,수정,삭제 그리고 거래상태


- 마이페이지(동네인증,수정,거래 목록조회)


- 신고하기


- 채팅 기능




#### 관리자

- 공지사항, 신고글 관리, 홈화면 광고관리
<br/>  

## UI/UX
완성되면 업로드😂😂😂
<br />


## DataBase
수정필요
<div>
<img src="" align="left" height="450" width="1100" />    
</div> 



## API DOCS
완성되면 업로드😂😂😂
<br />

## 개발 스택


### Front-End

- Vuex
- Redux


### Back-End

- Java
- Spring Boot
- Mysql
- JPA

<br/>  

## 개발 내용
수정필요
<details>
<summary>1주차</summary> 

### Implements

- 

### Issue

- 



</details>

<details>
<summary>2주차</summary> 


### Implements

- 




</details>

<details>
 <summary>3주차</summary>


- 

### Implements



</details>


<details>
 <summary>4주차</summary>

- 
</details>


<details>
 <summary>5주차</summary>

- 테스트 및 오류해결
>>>>>>> 6635e9c (Update README.md)
</details>


<details>
<<<<<<< HEAD
<summary>7주차</summary>
테스트 및 버그 수정
</details>


<br/>

=======
 <summary>6주차</summary>

- 테스트 및 오류해결
</details>


<details>
 <summary>7주차</summary>

- 테스트 및 오류해결
</details>
>>>>>>> 6635e9c (Update README.md)


## 파트 소개
| 이름  |  메인 역할  |
|:----:|:-------:|
| [강경민](https://github.com/kangkyoungmin) | `프론트엔드` |
| [장성필](https://github.com/hackjap) | `프론트엔드` |
| [김준현](https://github.com/whitejh) | `프론트엔드` |
| [백성규](https://github.com/sunggyupaik) | `백엔드` |
| [송영섭](https://github.com/LastCow9000)  | `백엔드` |
| [박준철](https://github.com/godtaehee)  | `백엔드` |  
