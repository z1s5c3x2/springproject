import Category from "./Category";
import axios from "axios";

export default function ProductWrite(props)
{

    const onProductAdd = e => {
        let productForm = document.querySelectorAll(".productForm")[0]
        let productFormData = new FormData(productForm)
        axios
            .post("/product",productFormData)
            .then( (r) => {
                if( r.data)
                {
                    alert("제품 등록 성공")
                    productForm.reset();
                }else{alert("제품 등록 실패")}

             })
            .catch( (e) =>{
                console.log( e )
            })
    }


    console.log( props.categoryList )
    return ( <>
        <div style={ { width:"300px",margin:"0 auto"}}>
        <h3> 제품 등록 </h3>
        <form className={"productForm"}>
            <select name={"pcNo"}>
                {
                    props.categoryList.map( c =>{
                        return <option value={c.pcNo}> {c.pcName}</option>
                    })
                }
            </select>
            <input type="text" name="pName" placeholder="제품명" /> <br/>
            <textarea name="pComment" placeholder="제품설명" /> <br/>
            <input type="text" name="pPrice" placeholder="제품가격" /> <br/>
            <input type="text" name="pStock" placeholder="초기재고" /> <br/>

            <input type="file" name="fileList" multiple /> <br/>
            <button type="button" onClick={onProductAdd} > 등록 </button>

        </form>
        </div>
    </>)
}