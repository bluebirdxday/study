
document.getElementById("apply").addEventListener("click", ()=>{
    
    const size = Number(document.getElementById("size").value);
    const color = document.getElementById("color").value;
    const content = document.getElementById("content");

    content.setAttribute("style", `color: ${color}; font-size: ${size}px;`);
});


document.getElementById("registration").addEventListener("click", ()=>{

    const p = document.createElement("p");
    const result = document.getElementById("result");
    const content = document.getElementById("content");

    p.innerText = content.value;
    p.setAttribute("style", content.getAttribute("style"));
    
    result.append(p);
});

