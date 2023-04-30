# ProjectC
![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/44c7f4ba-ce2d-4c6a-853e-7b19077283e0/Untitled.png)

## Git hub 주소

[https://github.com/letsgitit1/ProjectC.git](https://github.com/letsgitit1/ProjectC.git)

## 요약

- 실시간1:1 자동차 공유 웹사이트입니다 .
회원가입, 실시간 채팅 , 좋아요 , 만족도 매너지수 ), 실시간 자동차 위
치 반납 위치 , 빌리는 위치 ), 관리자 , 자동차 등록 , 개인에 대한 후기
남기기 , 결제 등 다양한 기능들을 제공합니다

---

## **역할**

- 프로젝트 전체 인원 4명
- **정지호 (조장)**
    - 문자 메시지 서비스 구현 ( 기여도 100%)
    - Header,Footer,메인화면 구현 ( 기여도 100%)
    - KAKAO MAP 커스터마이징 ( 기여도 50%)
    - 토스 페이먼츠 API로 결제 구현 ( 기여도 100%)
- **김상훈**
    - 소켓으로 채팅 구현
    - 필터로 오류페이지 구현
    - 관리자 페이지 매출 엑셀 다운 구현
- **이동해**
    - STMP API로 비밀번호 찾기 구현
    - 로그인, 마이페이지 자동차페이지 구현
    - AJAX로 회원가입 구현
- **조경현**
    - KAKAO MAP API로 대여 및 반납 구현
    - KAKAO MAP 커스터마이징

---

## 프로젝트 기획 일정

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f7bc3cf5-1c11-4cb6-833a-9233f0de8c3e/Untitled.png)

---

## 개발 환경

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c6dfa79a-b473-4521-96a2-847e17df74d2/Untitled.png)

---

## 회의 내용

[3차 프로젝트](https://www.notion.so/3-cfbc3023da5648669ea3c7e88ba88993) 

---

## ERD

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/aa52a08c-d32c-4b56-bdc7-414c320b907f/Untitled.png)

## Logic Process

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4b65d034-fa98-4de8-8d8e-7df0e9ea060b/Untitled.png)

## 기능 설명

### 자동차 대여 기능

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ce2208a0-2d4f-466b-a6a4-d4b3c3d350fd/Untitled.png)

- 구매자 대여 화면입니다.
- 화면에는 판매자가 맵에 등록한 상품들이 마커로 표시됩니다.
- 마커를 클릭하면 자동차의 대여 정보가 화면에 보이게 됩니다.
- 원하는 장소를 검색하면 지도의 포커스가 검색한 장소로 이동하게 되면 현재 위치 버튼을 클릭하여 현재 위치로 이동하게 됩니다.
- 찜하기 버튼을 누르면 해당 자동차를 찜할 수 있게 됩니다.
- 1:1채팅을 누르면 판매자와 채팅을 통하여 실시간 소통이 가능해지며 대여를 누르면 대여가 확정됨과 동시에 지도에 마커가 사라지고 대여를 성공한 회원은 반납하기 버튼이 활성화됩니다.

---

### 반납하기 및 결제 기능

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/25b4f933-4cbd-4329-9a5d-a4ffaff4a829/Untitled.png)

- 반납 버튼을 누른 뒤 alert 창에 있는 확인 버튼을 누르면 결제 페이지로 이동합니다.
- 결제 해야할 정보들이 나오고 결제하기를 누르면 토스 페이먼츠 위젯이 나옵니다.
- 자동차 대여에 대한 정보를 가져오며 원하는 결제 수단으로 결제를 해줍니다.
- 결제 완료 alert 창이 뜬 뒤 메인으로 이동합니다.

---

### 자동차 공유(판매)하기

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9e69dc43-d316-4b80-89d2-a7eafa3fe8b6/Untitled.png)

- 자동차를 판매등록한 판매자가 지도에 마커를 등록하기 위한 페이지입니다.
- 판매 버튼을 누르게 되면 마커의 정보가 저장됩니다.
- 성공적으로 마커를 저장하였다면 판매가 확징되었다는 alert 창이 뜹니다.
- 구매 페이지로 이동합니다.

### 반납 1시간전 회원에게 알림 문자보내기

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7f1e24d7-b695-4783-afbd-c1aedd1987bd/Untitled.png)

- @Scheduled를 사용해서 매 시간 정각에 위의 메소드를 실행하게 했습니다.
- 반납을 하지 않은 회원의 리스트를 가져옵니다.
- 반납을 하지 않은 회원의 리스트를 가져온 뒤 반납 기한이 1시간일 때 문자를 보냅니다.
- 반납을 하지 않은 회원의 리스트를 가져온ㄷ ㅟ 반납 기한이 1시간일 때 문자를 보냅니다.
- 만약 반납시간이 0보다 작으면 반납 기한이 지난 것이기 때문에 문자내용을 바꿔서 보냅니다.

### 알림문자

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/561773c5-6b67-4d97-b6c4-e6980f7ad8e5/Untitled.png)

알림은 위의 사진과 같이 나옵니다.

---

## 프로젝트 소감

- 우선 조장을 맡아서 많은 책임감 지난번 프로젝트를 경험삼아 처음으로 깃을 사용하면서 많은 어려움을 겪었습니다.
- 하지만 이러한 경험들을 해볼 수 있기 때문에 성장을 할 수 있는 기회가 됐다 생각했습니다.
- 처음에는 깃을하면서 소스코드들도 많이 날리고 많은 오류들로 인해서 힘들었지만 점차 팀원들과 소통하고 협력하면서 개발자로서의 역량을 키울 수 있는 좋은 기회가 되었던 것 같습니다.

---

 [이전 페이지 돌아가기](https://www.notion.so/8440f77f7e364b47a24ce70e8752d6a6)

- ◀ 이전 페이지 돌아가기 버튼 만드는 법
    
    ① 이전 페이지 Projects 블럭의 :: 을 눌러 링크를 복사해주세요.
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/21550824-6b3a-47bb-93e3-452950b922ef/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/21550824-6b3a-47bb-93e3-452950b922ef/Untitled.png)
    
    ② [이전 페이지 돌아가기] 텍스트에 복사한 링크를 넣어주세요.  
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/85498a31-bc2c-4cda-aafb-386f95efdeb7/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/85498a31-bc2c-4cda-aafb-386f95efdeb7/Untitled.png)
