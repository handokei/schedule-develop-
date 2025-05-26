![Copy of schedule](https://github.com/user-attachments/assets/f0183c25-f826-468d-82d5-fc9c7aafbd12)

<img width="852" alt="README1" src="https://github.com/user-attachments/assets/e2004bd2-46b7-4a22-99f0-caef686b7600" />
<img width="804" alt="README2" src="https://github.com/user-attachments/assets/c69e732e-3726-4dab-b92b-866ee3f4c46a" />

# 📅 일정관리 App(Develop)

Spring Boot 기반의 일정 관리 및 회원 인증 애플리케이션입니다. 세션을 활용한 로그인, 유저 CRUD, 일정 생성 등의 기능을 제공합니다.

## 📁 프로젝트 구조

src/main/java/com/example/schedule/
├── common/                # 상수(Const) 정의
├── config/                # 필터 등록 관련 설정
├── controller/            # REST API 컨트롤러
├── dto/                   # 요청/응답용 DTO
├── entity/                # JPA 엔티티 정의
├── filter/                # 로그인 필터
├── repository/            # JPA 리포지토리
└── service/               # 비즈니스 로직 처리

src/main/resources/
├── application.yml        # DB 및 기타 설정
└── static/                # 정적 자원 (미사용 시 비어있을 수 있음)



## 🚀 제공 기능
사용자 관련
회원가입 (/users/signup)

로그인 및 세션 저장 (/users/login)

사용자 전체 조회 / 단일 조회

비밀번호 수정 / 계정 삭제

✅ 일정 관련
일정 생성

일정 조회 (단일/전체)

일정 수정 / 삭제
(해당 기능은 schedule 엔티티 기준으로 구현)

✅ 인증
로그인 시 HttpSession 기반 인증 처리

인증 필요 API는 커스텀 필터(LoginFilter)를 통해 제어

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


 📎 기타 알아두면 좋은 점
Validation 강력 적용

@NotBlank, @Size, @Pattern 등으로 필드 검증

예: 비밀번호는 대소문자, 숫자, 특수문자 포함

예외 처리

@Valid + Spring의 MethodArgumentNotValidException 자동 핸들링

로그인 실패 시 401 Unauthorized 반환

세션 인증 설계

로그인 성공 시 HttpSession에 로그인 사용자 저장

커스텀 필터로 비로그인 사용자 차단


