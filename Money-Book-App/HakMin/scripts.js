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
