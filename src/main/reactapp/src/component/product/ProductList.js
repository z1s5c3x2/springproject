import axios from "axios";
import {useEffect, useState} from "react";


export default function ProductList(props)
{
    const [productList, setProductList] = useState([]);

    const onProductAll = (e) =>{
        axios
            .get("/product")
            .then( (r) => {
                console.log( r.data )
                setProductList(r.data)
             })
            .catch( (e) =>{
                console.log( e )
            })
    }
    useEffect(() => {
        onProductAll();
    }, []);
    return ( <>
        <h3> 제품 목록 </h3>
        <table style={{width:"100%"}}>
            <tr>
                <th> 제품번호 </th> <th> 대표 이미지 </th>
                <th> 카테고리명 </th> <th> 제품명 </th>
                <th> 제품 가격 </th> <th> 상태 </th>
                <th> 재고 </th> <th> 비고 </th>
            </tr>
            {
                productList.map( p=>{
                    return( <>
                        <tr>
                            <td> {p.pno} </td> <td>  <img src={"http://localhost:80/static/media/"+p.imgList[0].uuidFileName}/></td>
                            <td> {p.categoryDto.pcName} </td> <td> {p.pname} </td>
                            <td> {p.pprice.toLocaleString()} </td> <td> {p.pstate} </td>
                            <td> {p.pstock} </td> <td> {p.pcomment} </td>
                        </tr>
                    </>)
                })
            }
        </table>
    </>)
}