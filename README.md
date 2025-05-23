![Copy of schedule](https://github.com/user-attachments/assets/f0183c25-f826-468d-82d5-fc9c7aafbd12)

<img width="852" alt="README1" src="https://github.com/user-attachments/assets/e2004bd2-46b7-4a22-99f0-caef686b7600" />
<img width="804" alt="README2" src="https://github.com/user-attachments/assets/c69e732e-3726-4dab-b92b-866ee3f4c46a" />

# 📅 Schedule Management App

Spring Boot 기반의 일정 관리 및 회원 인증 애플리케이션입니다. 세션을 활용한 로그인, 유저 CRUD, 일정 생성 등의 기능을 제공합니다.

## 📁 프로젝트 구조

com.example.schedule
├── commom # 상수 정의
├── config # 필터 등록 등 Spring 설정
├── controller # REST API 컨트롤러
├── dto # 요청/응답 DTO 객체
├── entity # JPA 엔티티 클래스
├── filter # 인증 필터 
├── repository # JPA 레포지토리
├── service # 비즈니스 로직 계층
└── ScheduleApplication # 메인 애플리케이션


## 🚀 주요 기능

### 🔐 사용자 인증
- 회원가입 (`POST /users/signup`)
- 로그인 (`POST /users/login`) – 세션 기반
- 로그아웃 (`POST /users/session-logout`)
- 인증된 사용자만 API 접근 가능 (LoginFilter 사용)

### 🧾 유저 API
- 전체 조회: `GET /users`
- 단건 조회: `GET /users/{userId}`
- 비밀번호 수정: `PUT /users/{userId}`
- 유저 삭제: `DELETE /users/{userId}`

### 📆 일정 API
- 일정 생성, 조회 등 (ScheduleController 참고)

## ✅ 예외 처리
- 401: 인증 실패 (이메일/비밀번호 불일치)
- 400: 입력값 검증 실패 (@Valid + @NotBlank 등)

## 📎 설정

### application.yml (예시)
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/schedule_db
    username: root
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
