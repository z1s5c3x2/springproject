
doGet()
function doGet()
{
    $.ajax({
        url:'../phone',
        method:'get',
        data: {},
        success : s=>{
             let html = ``
                    let _t = document.querySelector('.todo_bottom')
                    s.forEach( res =>{
                         html +=
                                `   <div class="todo">
                                             <div class="tcontent"> ${res.pname} </div>
                                             <div class="tcontent"> ${res.pnumber} </div>
                                             <div class="etcbtns">
                                                 <button onclick="doPut(${res.pno})" type="button">수정</button>
                                                 <button onclick="doDelete(${res.pno})" type="button">제거하기</button>
                                             </div>
                                         </div>`
                    }
    
                    )
                    _t.innerHTML = html
        },
        error : e=>{
        }
    
        })
}
function doPost()
{
    $.ajax({
        url:'../phone',
        method:'post',
        contentType : 'application/json',
        data:JSON.stringify({
                                  "pnumber":document.querySelector('.pnumber').value,
                                   "pname":document.querySelector('.pname').value
                            }) ,
        success : s=>{
            console.log(s)
            doGet()
        },
        error : e=>{
            console.log(e)
        }
    
        })
}
function doDelete(pno)
{
     $.ajax({
        url:'/phone?pno='+pno,
        method:'delete',
        data: {},
        success : s=>{
            console.log(s)
            doGet()
        },
        error : e=>{
        }

        })
}
function doPut(pno)
{
    let pname = prompt("이름 입력")
    let pnumber = prompt("전화번호 입력")
    $.ajax({
        url:'../phone',
        method:'put',
        contentType : 'application/json',
        data: JSON.stringify({"pno":pno,"pname":pname,"pnumber":pnumber}),
        success : s=>{
            console.log(s)
            doGet()
        },
        error : e=>{
        }
    
        })
}
