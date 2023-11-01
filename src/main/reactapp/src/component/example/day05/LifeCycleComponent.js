import {useEffect, useState} from "react";

export default function LifeCycleComponent()
{
    let [value, setValue] = useState(0);
    const valueUpdate = (e) => {value++; setValue(value)}

    let [value2, setValue2] = useState(0)
    const value2Update = (e) => { value2++; setValue2(value2)}

    useEffect(() => {
        console.log('1이펙') //생성 , 업데이트
    });

    useEffect(() => {
        console.log('2efc') // 생성
    },[]);

    useEffect(() => {
        console.log('3efc') // 생성 특정 상태 업데이트
    },[value2]);
    return (
        <>
            <div> {value} </div>
            <button onClick={valueUpdate}> + </button>
            <div> {value2} </div>
            <button onClick={value2Update}> + </button>
        </>
    )
}

/*
*
* 1 탄생[mounting] ----> 업데이트[updating] ----->                제거  [unMount]
       |                     |
1 함수/컴포넌트 생성            |
*     |                     |
2.함수/컴포넌트 호출		1. setState() : 상태 변경되었을때
*        |               2.forceUpdate() : 강제랜더링
*        |               3. new props : props가 변경되었을때
*        |                                           |
* 3.     |          가상 DOM Update/root.render |
*
 4. 컴포넌트 탄생			컴포넌트 업데이트

[mounting]
useEffect ( ()=> {} )
useEffect ( ()=> {},[] )
useEffect ( ()=> {},[변수명] )


[updating]
useEffect ( ()=> {} )
useEffect ( ()=> {},[useState변수명] )
*
* */