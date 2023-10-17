
function postTest()
{

    $.ajax({
    url:'../todo',
    method:'post',
    contentType : 'application/json',
    data:JSON.stringify({
                          	"tcontent":document.querySelector('.tcontent').value,
                            "tstate":false
                        }) ,
    success : s=>{
        console.log(s)
        getTest()
    },
    error : e=>{
        console.log(e)
    }

    })
}
getTest()
function getTest()
{
    $.ajax({
    url:'../todo',
    method:'get',
    data: {},
    success : s=>{
         let html = ``
                let _t = document.querySelector('.todo_bottom')
                s.forEach( res =>{
                     html +=
                            `   <div class="${res.tstate ? 'todo successTodo' : "todo"}">
                                         <div class="tcontent"> ${res.tcontent} </div>
                                         <div class="etcbtns">
                                             <button onclick="putTest(${res.tno},${res.tstate})" type="button">상태변경</button>
                                             <button onclick="deleteTest(${res.tno})" type="button">제거하기</button>
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

function putTest(_tno,_ts)
{
    $.ajax({
    url:'../todo',
    method:'put',
    contentType : 'application/json',
    data: JSON.stringify({"tno":_tno,"tstate":_ts}),
    success : s=>{
        console.log(s)
        getTest()
    },
    error : e=>{
    }

    })
}
function deleteTest(_t)
{
    $.ajax({
    url:'/todo?tno='+_t,
    method:'delete',
    data: {},
    success : s=>{
        console.log(s)
        getTest()
    },
    error : e=>{
    }

    })
}