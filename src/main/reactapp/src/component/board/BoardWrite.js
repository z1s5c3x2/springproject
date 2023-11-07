import axios from "axios";
import {Link} from "react-router-dom";

export default function BoardWrite(props){

    const boardWrite = (e) =>{
        let boardForm = document.querySelectorAll('.boardForm')[0]
        let boardFormData = new FormData(boardForm)

        axios.post("/board",boardFormData)
            .then( result => {

                //console.log(result)
                window.location.href="/board/list"
            })
    }

    return (<>
        <div>
            <h3> 게시물 쓰기</h3>
            <form className={"boardForm"}>
                <input type={"text"} placeholder={"제목"} name={"btitle"}/>
                <textarea name={"bcontent"} placeholder={"내용"}> </textarea>
                {/*파일:  <input type="file" name="bfile"/>*/}
                <button type={"button"} onClick={boardWrite}> </button>
                

            </form>
        </div>
    </>)
}