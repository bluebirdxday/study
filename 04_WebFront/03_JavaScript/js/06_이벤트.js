
// 인라인 이벤트 모델 확인하기
function test1(el){  // el == elemnet == 전달받은 요소
    el.style.backgroundColor = 'black';
    el.style.color = 'white';
}


// 고전 이벤트 모델 확인하기
// 아이디가 'test2a'인 요소를 얻어오기
console.log(document.getElementById("test2a").onclick);
// -> null 출력 (아직 click했을 때 동작할 함수(이벤트 핸들러)가 없음)


document.getElementById("test2a").onclick = function(){
    // function(){}  : 익명 함수 (이름이 없는 함수)
    //                          재사용 목적이 아닌 특정 이벤트에 대한 기능을 만들 때 주로 사용

    alert("고전 이벤트 모델로 출력된 내용입니다.");
}

// test2a의 클릭 이벤트 동작 제거(이벤트 제거)
document.getElementById("test2b").onclick = function(){
    document.getElementById("test2a").onclick = null;
    alert("이벤트를 제거하였습니다.");
}


// 고전 이벤트 모델 단점 확인하기
// -> 한 요소에 여러 이벤트 핸들러를 연결할 수 없음
//      왜? 마지막으로 작성한 핸들러가 앞서 작성된 핸들러를 덮어씌움

const c = document.getElementById("test2c");  // 버튼 요소를 얻어옴
c.onclick = function(){
    c.style.backgroundColor = 'pink';   // 배경색 핑크
}

c.onclick = function(){
    c.style.fontSize = '40px';   // 폰트 크기 40px
}


// 표준 이벤트 모델 확인하기
/* 
    [표준 이벤트 모델 작성 방법]

    요소.addEventListener(감지할 이벤트, 이벤트 핸들러);

    ex) test3.addEventListener("click", function(){ });

*/
const test3 = document.getElementById("test3");

// #test3 클릭 시 width를 20px만큼 증가
test3.addEventListener("click", function(){
    // 요소.clientWidth : 요소의 너비 (CSS로 지정된 값도 읽어옴, read only)
    // 요소.clientHeight : 요소의 높이 (CSS로 지정된 값도 읽어옴, read only)

    test3.style.width = test3.clientWidth + 20 + "px";
});

// 중간에 코드 2만줄....

test3.addEventListener("click", function(){
    // this : 이벤트가 발생한 요소 (여기서는 #test3)
    this.style.height = test3.clientHeight + 20 + "px";
});


test3.addEventListener("click", function(e){
    // 이벤트 핸들러의 매개변수 e 또는 event 
    // -> 현재 발생한 이벤트에 대한 모든 정보를 담고 있는 객체 == 이벤트 객체

    // e.target : 이벤트가 발생한 현재 요소 (==this)

    const currentWidth = e.target.clientWidth;

    // 현재 너비가 500px을 초과하면 너비/높이를 200px로 초기화
    if(currentWidth > 500-20){
        e.target.style.width = "200px";
        e.target.style.height = "200px";
    }
});


const num1 = document.getElementById("firstValue");
const num2 = document.getElementById("secondValue");
// const op = document.querySelectorAll(".op");
const opList = document.getElementsByClassName("op");

// for of 구문 (향상된 for문)
//  -> 배열(Array), 유사 배열(HTMLCollection, NodeList, ...)
//       위와 같이 배열 형태의 요소를 순타 접근하는 용도의 반복문
for(let op of opList){
    op.addEventListener("click", function(e){
        document.getElementById("result").innerText 
            = new Function("return " + Number(num1.value) 
                                                        + e.target.innerText 
                                                        + Number(num2.value))();
    });
}


const boxList = document.getElementsByClassName("box");
const colorList = document.getElementsByClassName("color");
// keyup 이벤트 사용하기 (red의 경우 keydown을 쓰면 re까지만 읽어옴)

for(let i=0; i<colorList.length; i++){
    
    // input 태그 i번째 키가 올라갈 때 == 입력된 후
    colorList[i].addEventListener("keyup", function(e){
        boxList[i].style.backgroundColor = e.target.value;
    });
}



// a태그 기본 이벤트 제거
document.getElementById("moveGoogle").addEventListener("click", function(e){
    
    // e : 이벤트 객체
    e.preventDefault(); // -> 기본값 막기
});


// form태그 기본 이벤트 제거1
// -> submit 버튼을 없애고
//      일반 button이 클릭되었을 때 조건이 맞으면 submit 하게 만들기
// document.getElementById("btn").addEventListener("click", function(e){
//     const id = document.querySelector("[name='id']").value;
//     const pw = document.querySelector("[name='pw']").value;

//     if(id=='user01' && pw=='pass01'){
//         // 아이디, 비밀번호가 일치할 때 form 태그 제출

//         // submit() : form태그 제출
//         document.testForm.submit();
//     }

// });


// form태그 기본 이벤트 제거2 (인라인 이벤트 모델)
function fnCheck(){
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;

    if(id=='user01' && pw=='pass01'){
        // 아이디, 비밀번호가 일치할 때 form 태그 제출
        return true;    // true를 반환해서 제출 수행
    }

    return false;   // false를 반환해서 제출을 막음
}


// form태그 기본 이벤트 제거3 (표준 이벤트 모델)
// -> name이 testForm인 form 태그에서 submit 이벤트가 발생 했을 때
document.testForm.addEventListener("submit", function(e){
    
    // e : 이벤트 객체
    e.preventDefault();     // 기본 이벤트 막기
    
});

