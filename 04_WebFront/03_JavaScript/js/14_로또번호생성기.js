

document.getElementById("createBtn").addEventListener("click", ()=>{

    const arr = [];
    const divs = document.getElementById("container").children;
    // const divs = document.querySelectorAll("#container>div");
    

    while(arr.length<6){
        
        const random = Math.floor(Math.random()*45)+1;
        
        
        if(arr.indexOf(random)===-1){
            arr.push(random);
        }
    
        arr.sort( (a,b) => a-b );
    }


    for(let i=0; i<arr.length; i++){
        divs[i].innerText = arr[i];
    }

    
});