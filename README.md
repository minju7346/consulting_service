# backend_study
> 해당 프로젝트는 2022.02.01~2022.03.18(예정)기간동안 진행하고있으며, 고객 상담 서비스를 Spring MVC로 개발하는 프로젝트입니다.

<br>

**진행방식**

-   매 Iteration마다 코드리뷰 후 코드를 수정한 후, 머지 리퀘스트를 통해 진행됩니다.
-   주차별 개발 이슈 및 스프링 관련 이론 이슈를 진행합니다.
-   모든 진행사항은 GitLab을 통해 관리 됩니다.
  -   https://gitlab.com/minju6577346/backend_study   

<br>

**코딩 컨벤션**

- https://github.com/naver/hackday-conventions-java

<br>

**전체 DB 구조**

![image](https://user-images.githubusercontent.com/58619427/154786021-a3393f1c-d515-4fb7-b756-3ec88b705f12.png)

<br>

**주요 기능**

- 상담 카테고리 트리구조 조회 및 통계
- 사용자 등록, 상태변경, 쿠기를 이용한 로그인 관리
- 인터셉터를 이용한 권한 제어
- 상담 건 자동 분배 
- 특정 시간 별 배치잡을 통한 상담 서비스 제어
