<template>
  <div class="container">
    <h1>사용 내역</h1>
    <form id="account-form">
      <div class="form-group">
        <label for="date">날짜</label>
        <input type="date" id="date" name="date" required />
      </div>
      <div class="form-group">
        <label for="description">상세 내용</label>
        <input
          type="text"
          id="description"
          name="description"
          placeholder="텍스트를 입력해주세요"
          required
        />
      </div>
      <div class="form-group">
        <label for="type">분류</label>
        <select id="type" name="type">
          <option value="income">수입</option>
          <option value="expense">지출</option>
        </select>
      </div>
      <div class="form-group">
        <label for="tag">태그</label>
        <select id="tag" name="tag"></select>
      </div>
      <div class="form-group">
        <label for="amount">금액</label>
        <input
          type="number"
          id="amount"
          name="amount"
          placeholder="금액을 입력해주세요"
          required
        />
      </div>
      <button type="submit">저장</button>
      <button type="button" id="cancel-btn" class="cancel-button">취소</button>
    </form>
  </div>
</template>
<script>
document.addEventListener('DOMContentLoaded', () => {
  const typeSelect = document.getElementById('type');
  const tagSelect = document.getElementById('tag');

  // 수입/지출 분류가 변경될 때마다 태그 선택 옵션을 업데이트
  typeSelect.addEventListener('change', () => {
    const selectedType = typeSelect.value;

    // 태그 선택 옵션 초기화
    tagSelect.innerHTML = '';

    // 수입인 경우
    if (selectedType === 'income') {
      addOptions(tagSelect, incomeTags);
    }
    // 지출인 경우
    else if (selectedType === 'expense') {
      addOptions(tagSelect, expenseTags);
    }
  });

  // 태그 선택 옵션 추가 함수
  function addOptions(selectElement, options) {
    options.forEach((option) => {
      const optionElement = document.createElement('option');
      optionElement.value = option.value;
      optionElement.textContent = option.label;
      selectElement.appendChild(optionElement);
    });
  }

  // 초기 설정: 수입 태그로 초기화
  addOptions(tagSelect, incomeTags);

  const accountForm = document.getElementById('account-form');
  const cancelBtn = document.getElementById('cancel-btn');

  // 취소 버튼 클릭 시 입력 내용 초기화
  cancelBtn.addEventListener('click', () => {
    accountForm.reset();
  });

  // 폼 제출 이벤트 핸들러
  accountForm.addEventListener('submit', (event) => {
    event.preventDefault(); // 기본 제출 동작 방지

    // 입력된 데이터 가져오기
    const date = document.getElementById('date').value;
    const description = document.getElementById('description').value;
    const type = document.getElementById('type').value;
    const tag = document.getElementById('tag').value;
    const amount = parseInt(document.getElementById('amount').value); // 숫자로 변환

    // 데이터를 JSON 형식으로 만들기 (금액에 천단위 구분 기호 적용)
    const jsonData = {
      date: date,
      details: description,
      category: type === 'income' ? '수입' : '지출',
      tags: [tag],
      amount: numberWithCommas(amount), // 숫자 형식에 천단위 구분 기호 적용
    };

    // 기존 데이터 불러오기
    let existingData = [];
    const existingDataString = localStorage.getItem('accountData');
    if (existingDataString) {
      existingData = JSON.parse(existingDataString);
    }

    // 새 데이터 추가
    existingData.push(jsonData);

    // 업데이트된 데이터 저장
    localStorage.setItem('accountData', JSON.stringify(existingData));

    // 폼 초기화
    accountForm.reset();

    // JSON 파일 다운로드
    downloadJsonFile(existingData, 'accountData.json');

    alert('데이터가 저장되었습니다.');
  });
});

// 숫자에 천단위 구분 기호 추가하는 함수
function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}

// 태그 선택 옵션 데이터 (수입/지출에 따라 다름)
const incomeTags = [
  { value: 'edu', label: '월급' },
  { value: 'food', label: '용돈' },
  { value: 'home', label: '이자' },
  { value: 'culture', label: '이월' },
  { value: 'etc', label: '기타' },
];

const expenseTags = [
  { value: 'expense1', label: '식비' },
  { value: 'expense2', label: '교통' },
  { value: 'expense3', label: '주거,통신' },
  { value: 'expense4', label: '문화생활' },
  { value: 'expense5', label: '교육' },
  { value: 'expense6', label: '적금' },
  { value: 'expense7', label: '기타' },
];
</script>

<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f0f0f0;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.container {
  background-color: white;
  padding: 20px;
  border: 2px solid #f1c40f;
  border-radius: 5px;
  width: 50%;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 20px; /* Adjusted margin for uniform spacing */
}

label {
  display: block;
  margin-bottom: 10px; /* Adjusted margin for uniform spacing */
}

input,
select,
button {
  width: 100%;
  padding: 10px;
  margin-top: 10px; /* Adjusted margin for uniform spacing */
  box-sizing: border-box;
}

button {
  background-color: #27ae60;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 20px; /* Ensure button has a consistent margin */
}

button:hover {
  background-color: #2ecc71;
}

.cancel-button {
  background-color: #ffffff; /* 하얀 배경 */
  color: #000000; /* 검은 텍스트 */
  border: 1px solid #000000; /* 검은 테두리 */
  padding: 5px 10px; /* 내부 여백 */
  cursor: pointer; /* 마우스 오버 시 커서 모양 */
}

.cancel-button:hover {
  background-color: #dddddd; /* 마우스 오버 시 배경색 변경 */
}
</style>
