import axios from 'axios';
import { useEffect, useState } from 'react';

export default function Category( props ){
    // props : 속성객체{ 키 : 값, 키 : 값 }

    console.log( props )
    // props 객체의 category 키 호출  => value
    const category = props.category
    console.log( category )
    return (<>
        <div>
            <div> {category.pcName} </div>
            <div>
                <button type="button"> 수정 </button>
                <button type={"button"} onClick={ (e) => {props.deleteCategory(e,category.pcNo)}} > 삭제 </button>
            </div>
        </div>
    </>)
}