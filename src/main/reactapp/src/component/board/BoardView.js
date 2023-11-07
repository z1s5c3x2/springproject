import axios from "axios";
import {Link, useSearchParams} from "react-router-dom";
import {Button} from "@mui/material";
import {useEffect, useState} from "react";


export default function BoardView(props){
    const [searchPrams,setSearchParams] = useSearchParams()
    const bno = searchPrams.get("bno")
    console.log( bno )
    const login = JSON.parse(sessionStorage.getItem("login_token"));
    const loginMno = login != null ? login.mno : null;

    const [board, setBoard] = useState({})
    

    const onGet = (e) =>{
        axios.get("/board/doGet",{params:{bno:bno} })
            .then( r =>{
                console.log( r.data )
                setBoard(r.data)
            })
            .catch( e=>{console.log( e )})
    }

    useEffect(() => {
        onGet()
    }, []);

    const onDelete = (e) =>{
        axios.delete("/board",{params:{bno:bno} })
            .then( r=> {
                if(r.data){alert('게시글 삭제 성공'); window.location.href='/board/list'}
                else{alert('삭제 실패')}
            })
            .catch( e => { console.log( e )})

    }
    return(<>
        <h3> 게시글 상세 보기 </h3>
        <div>  {board.btitle}</div>
        <div> {board.bcontent}</div>
        {
            board.mno == loginMno ?
                (<>  <Button type={"button"} onClick={onDelete}> 삭제 </Button>
                    <Link to={'/board/update?bno='+bno}> <button type={"button"}> 수정 </button></Link></>) :
                (<> </>)
        }

    </>)
}