/*컴포넌트 내부에서 다른 컴포넌트를 호출하는 방법
* 1.같은 jsx 파일이면 import 생략
* 2.다른 jsx 파일이면 import*/
/*
*  jsx 규칙
* return ( <> html문법 </>) : 구역 표시
* 위의 구역에서 js문법을 사용할때는 { js문법 }
* */

function Component5(){

    return (<>

        <PrintBook writer="유재석" name="이것이 자바다" price={30000} />
        <PrintBook writer="강호동" name="이것이 파이썬" price={25000} />
        <PrintBook writer="신동엽" name="이것이 리액트" price={28000} />
    </>)
}
function PrintBook(props){
    //js구역
    console.log(props)
    // return -> jsx구역
    return (<> <div>
        <h1>도서명:{props.name}</h1>
        저자:{props.writer}/소비자가격:{props.price}
    </div>
    </>)
}
export default Component5
