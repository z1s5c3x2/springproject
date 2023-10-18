/*컴포넌트 내부에서 다른 컴포넌트를 호출하는 방법
* 1.같은 jsx 파일이면 import 생략
* 2.다른 jsx 파일이면 import*/
/*
*  jsx 규칙
* return ( <> html문법 </>) : 구역 표시
* 위의 구역에서 js문법을 사용할때는 { js문법 }
* */

function Component4(){

    return (<>
        <input type="text" value="데이터" />
        <ComponentArgs name="유재석" age={30} />
        <ComponentArgs name="강호동" age={40} />
    </>)
}
function ComponentArgs(props){
    //js구역
    console.log(props)
    // return -> jsx구역
    return (<> <div> 컴포넌트4가 전달한 속성 : {props.name} / {props.age} </div>
    </>)
}
export default Component4
