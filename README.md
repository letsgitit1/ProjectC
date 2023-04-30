# ProjectC
![1](https://user-images.githubusercontent.com/105581415/235371569-1eb1f5b6-641e-4a42-aa6e-9539a4635020.png)
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
    - 상품 찜하기 ( 기여도 100%)
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

![2](https://user-images.githubusercontent.com/105581415/235371732-6a92198d-404a-411e-85e9-9f3754227ae3.png)

---

## 개발 환경

![10](https://user-images.githubusercontent.com/105581415/235371832-a48a813d-1661-415e-871f-4cf0d0208af4.png)
---

## 회의 내용

[3차 프로젝트](https://www.notion.so/3-cfbc3023da5648669ea3c7e88ba88993) 

---

## ERD

![3](https://user-images.githubusercontent.com/105581415/235371730-bdabf305-14b7-4749-8e73-a44cd05a1db3.png)

## Logic Process

![4](https://user-images.githubusercontent.com/105581415/235371728-fffdf571-b0b6-44e6-810d-dc4c35dc3d49.png)

## 기능 설명

### 자동차 대여 기능

![5](https://user-images.githubusercontent.com/105581415/235371726-e2f96f36-074d-45e9-80a0-18efc059de04.png)

- 구매자 대여 화면입니다.
- 화면에는 판매자가 맵에 등록한 상품들이 마커로 표시됩니다.
- 마커를 클릭하면 자동차의 대여 정보가 화면에 보이게 됩니다.
- 원하는 장소를 검색하면 지도의 포커스가 검색한 장소로 이동하게 되면 현재 위치 버튼을 클릭하여 현재 위치로 이동하게 됩니다.
- 찜하기 버튼을 누르면 해당 자동차를 찜할 수 있게 됩니다.
- 1:1채팅을 누르면 판매자와 채팅을 통하여 실시간 소통이 가능해지며 대여를 누르면 대여가 확정됨과 동시에 지도에 마커가 사라지고 대여를 성공한 회원은 반납하기 버튼이 활성화됩니다.

---

### 반납하기 및 결제 기능

![6](https://user-images.githubusercontent.com/105581415/235371725-e283dda3-8a67-4c2f-99ea-fb32c75258c0.png)

- 반납 버튼을 누른 뒤 alert 창에 있는 확인 버튼을 누르면 결제 페이지로 이동합니다.
- 결제 해야할 정보들이 나오고 결제하기를 누르면 토스 페이먼츠 위젯이 나옵니다.
- 자동차 대여에 대한 정보를 가져오며 원하는 결제 수단으로 결제를 해줍니다.
- 결제 완료 alert 창이 뜬 뒤 메인으로 이동합니다.

---

### 자동차 공유(판매)하기

![7](https://user-images.githubusercontent.com/105581415/235371724-0decf0d6-c7ad-4f6a-a5d7-76257f1d7eb4.png)

- 자동차를 판매등록한 판매자가 지도에 마커를 등록하기 위한 페이지입니다.
- 판매 버튼을 누르게 되면 마커의 정보가 저장됩니다.
- 성공적으로 마커를 저장하였다면 판매가 확징되었다는 alert 창이 뜹니다.
- 구매 페이지로 이동합니다.

### 반납 1시간전 회원에게 알림 문자보내기

![8](https://user-images.githubusercontent.com/105581415/235371723-6873f7ff-0673-4c3c-b62b-fcd1ba10c26d.png)

- @Scheduled를 사용해서 매 시간 정각에 위의 메소드를 실행하게 했습니다.
- 반납을 하지 않은 회원의 리스트를 가져옵니다.
- 반납을 하지 않은 회원의 리스트를 가져온 뒤 반납 기한이 1시간일 때 문자를 보냅니다.
- 반납을 하지 않은 회원의 리스트를 가져온 뒤 반납 기한이 1시간일 때 문자를 보냅니다.
- 만약 반납시간이 0보다 작으면 반납 기한이 지난 것이기 때문에 문자내용을 바꿔서 보냅니다.

### 알림문자

![9](https://user-images.githubusercontent.com/105581415/235371721-43f188dd-7f76-4046-8bda-9af84df24fb1.png)

알림은 위의 사진과 같이 나옵니다.

---

## 프로젝트 소감

- 우선 조장을 맡아서 많은 책임감 지난번 프로젝트를 경험삼아 처음으로 깃을 사용하면서 많은 어려움을 겪었습니다.
- 하지만 이러한 경험들을 해볼 수 있기 때문에 성장을 할 수 있는 기회가 됐다 생각했습니다.
- 처음에는 깃을하면서 소스코드들도 많이 날리고 많은 오류들로 인해서 힘들었지만 점차 팀원들과 소통하고 협력하면서 개발자로서의 역량을 키울 수 있는 좋은 기회가 되었던 것 같습니다.