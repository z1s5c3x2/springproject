import {useState} from "react";

export default function StateMgrComponent(props)
{

    let var1 = 10;


    function var1Inc(){var1 ++}
    function var2Inc(){var2++;setVar2(var2);}

    let asd = useState('훅이란 뭐니')
    
    /*
    * useState 함수에 매개변수 전달하고 2개를 가지는 배열 리턴
    *   useSate  배열
    *       0 : 값
    *       1: 그 값을 수정 할 수 있는 함수bound dipatchSetState
    *  let [ 변수명,set함수명 ]  =useState(초기값)
    * */
    let [var2, setVar2] = useState(10);
    console.log(asd)

    alert('컴포넌트 랜더링');

    let var3 = '텍스트 입력'
    let [var4, setVar4] = useState("텍스트 입력")
    const setVar4chg = (e)=>{setVar4(e.target.value)}

    return(
        <>
            <div>
                {var1}
                <button onClick={var1Inc}> asd </button>
            </div>
            <div>
                {var2}
                <button onClick={var2Inc}> asd </button>
            </div>
            <div>
                <input type="text" value={var3}/>
            </div>
            <div>
                <input type="text" value={var4} onChange={setVar4chg}/>
            </div>
        </>
    )
}