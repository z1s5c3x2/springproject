import axios from "axios";
import {Form, Link, useSearchParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {Button} from "@mui/material";

export default function BoardUpdate(props){
    const [searchPrams,setSearchParams] = useSearchParams()
    const bno = searchPrams.get("bno")
    const [board, setBoard] = useState({})
    useEffect(() => {
        axios.get('/board/doGet',{params:{bno:bno}})
            .then( r=> {
                setBoard(r.data)
        })
            .catch(e =>{
                console.log( e )
            })
    }, []);

    const putBtn = (e)=>{
        const boardForm = document.querySelectorAll('.boardForm')[0]
        const boardFormData = new FormData(boardForm)
        boardFormData.set('bno',bno)

        axios
            .put("/board",boardFormData)
            .then( (r) =>{
                if(r.data){alert("수정 성공")
                window.location.href = '/board/view?bno='+bno}
                else{alert("수정 실패")}
            })
            .catch( e=> {
                console.log( e )
            })
    }

    const inputBoard = (e) =>{

        if(e.target.className == "btitle")
        {
            setBoard( {...board,btitle:e.target.value} )
        }else{
            setBoard( {...board,bcontent:e.target.value} )
        }

    }
    return (<>
        <div>
            <form className={"boardForm"}>
            <h3> 게시물 수정{bno}</h3>
            제목 : <input type={"text"} value={board.btitle} onChange={inputBoard} name="btitle" className={"btitle"}/> <br/>
            내용 : <textarea value={board.bcontent} onChange={inputBoard} name={"bcontent"} className={"bcontent"}> </textarea>
            <Button type={"button"} onClick={putBtn}> 수정 </Button>
            </form>
        </div>
    </>)
}