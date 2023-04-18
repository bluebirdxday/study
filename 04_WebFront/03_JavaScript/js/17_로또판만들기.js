const lottoBoard = document.getElementById("lottoBoard");

document.getElementById("createBtn").addEventListener("click", ()=>{

    lottoBoard.innerHTML = "";  // 이전에 생성된 내용을 모두 삭제
                                                        // 클릭할 때마다 계속 번호가 생성되는 걸 방지
    
    for(let i=1; i<46; i++){
        // 로또판에 들어갈 div 요소 생성
        const div = document.createElement("div");
        

        div.innerText = i;

        // div에 number 클래스 추가
        div.classList.add("number");

        // div가 클릭 되었을 때 배경색 변경/제거
        // + 6개 넘으면 클릭 불가
        div.addEventListener("click", e=>{

            // active 클래스가 있다면 제거
            if(e.target.classList.contains("active")){
                // e.target.classList.remove("active");
                e.target.classList.toggle("active");
            }else{
                // active 클래스 없으면 추가
                // e.target.classList.add("active");

                // active 클래스를 가진 요소가 6개 이상인 경우
                if(document.getElementsByClassName("active").length>=6){
                    alert("6개까지만 선택할 수 있습니다");
                    return;
                }

                e.target.classList.toggle("active");
            }

        });

        lottoBoard.append(div);
    }

});