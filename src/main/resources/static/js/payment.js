// 현재 날짜를 생성
  let currentDate = new Date();
  
  // 날짜를 YYYY-MM-DD 형식으로 변환
  let year = currentDate.getFullYear();
  let month = ("0" + (currentDate.getMonth() + 1)).slice(-2);
  let day = ("0" + currentDate.getDate()).slice(-2);
  let today = year + "-" + month + "-" + day;
  
  // input의 value에 현재 날짜를 넣음
  document.getElementById("return-date").value = today;
  ;
  
//대여 시작 시간
  var rentStartTime = new Date(document.getElementById("rent-date").value);

  // 현재 시간
  var now = new Date();

  // 대여 시간 계산 (밀리초 단위)
  var rentTime = now.getTime() - rentStartTime.getTime();

  // 대여 시간 계산 (시간 단위)
  var rentHours = Math.floor(rentTime / (1000 * 60 * 60));

  // 대여 시간 출력
  document.getElementById('rent-hour').value = rentHours;