# main-api-server

GitOps 무중단 배포 아키텍처 검증을 위한 메인 백엔드 API 서버입니다.  
배포 전환기(Rollout)에서의 트래픽 유실 방지 및 Graceful Shutdown 처리를 포함하고 있습니다.

## 🛠️ 주요 기술 스택
- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Gradle

## ⚙️ 핵심 구현 사항 (무중단 배포 내결함성)
- **Graceful Shutdown 활성화**
  - `server.shutdown=graceful` 설정을 적용하여 종료 신호(`SIGTERM`) 수신 시 처리 중인 톰캣 스레드 요청을 강제 단절하지 않고 안전하게 완료 후 프로세스를 종료합니다.
- **종료 유예 시간 최적화**
  - `spring.lifecycle.timeout-per-shutdown-phase=30s`를 지정하여, 인프라 레벨의 차단 작업이 완료된 후 남은 잔여 작업을 최대 30초 동안 보장합니다.
- **헬스 체크 엔드포인트**
  - `[GET /api/health]`: 쿠버네티스의 Readiness/Liveness Probe와 연동되어 애플리케이션의 내부 컨텍스트 초기화 완료 시점을 인프라에 제공합니다.
