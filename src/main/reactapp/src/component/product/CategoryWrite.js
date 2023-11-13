import axios from 'axios';
import { useEffect, useState } from 'react';
import Category from './Category';
import ProductWrite from "./ProductWrite";

export default function CategoryWrite( props ){


    // 1. 카테고리 등록 AXIOS // 등록버튼을 클릭했을 때
    const addCategory = e =>{
        const info = { pcName : document.querySelector('.pcName').value }
        axios.post( '/product/category', info ).then( r => {
            console.log(r.data)
            if( r.data ){
                alert("카테고리등록성공");
                props.printCategory()
            } else {
                alert("카테고리등록실패")
            }
        })
            .catch( e =>
                console.log(e)
            )
    }



    // 컴포넌트가 처음 열렸을 때(탄생했을 때) 카테고리 출력
    useEffect( ()=>{ props.printCategory() } , [] )

    // 3. 카테고리 수정 AXIOS // 수정버튼 클릭했을 때()
    const updateCategory = (e, pcNo) =>{
        const info = { pcNo : pcNo, pcName : "" }
        axios.put( '/product/category', info ).then( r => {
            console.log(r.data)
        })
            .catch( e =>
                console.log(e)
            )
    }

    // 4. 카테고리 삭제 AXIOS // 삭제버튼 클릭했을 때
    const deleteCategory = (e, pcNo) =>{
        axios.delete( '/product/category', { params : { pcNo : pcNo } } ).then( r => {
            props.printCategory()
        })
            .catch( e =>
                console.log(e)
            )
    }
    return (<>

        <div style={{ width : '300px' , margin : '0 auto' }}>
            <h3> 카테고리 등록 </h3>
            <form>
                <input type="text" className="pcName" placeholder="등록할카테고리명" />
                <button type="button" onClick={ addCategory }> 등록 </button>
            </form>

            <h3> 카테고리 출력 </h3>
            {
                props.categoryList.map( c =>{
                    {/* Category 컴포넌트에 객체 전달 */}
                    return <Category category={c} deleteCategory={deleteCategory} />
                })
            }
        </div>


    </>)
}