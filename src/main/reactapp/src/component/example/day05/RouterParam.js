import {BrowserRouter, Link, Route, Routes, useParams, useSearchParams} from "react-router-dom";
import {useContext, useState} from "react";
/*
*  http url 경로상의 쿼리스트링 매개변수 호출 라이브러리 호출
*  http url 경로상의 경로매개변수 호출 라이브러리 호출
* */
export default function RouterParam(props) {

    return (<>
            <h3> 라우터 매개변수</h3>

            <BrowserRouter>
                    <Routes>
                        <Route path={"/"} element={ <ListPage/>}> </Route>
                        <Route path={"/view1"} element={ <RouterQuery/>}> </Route>
                        <Route path={"/view2/:bno/:value"} element={ <RouterPath/>}> </Route>
                    </Routes>
            </BrowserRouter>
        </>)
}

function ListPage(props){
    const [value, setValue] = useState()
        return(<>
                <h3>목록 페이지 </h3>
            <input type={"text"} onChange={ (e) => { setValue(e.target.value)}}/>
            <Link to={"/view1?bno=1&value="+value} > 상세 페이지쿼리스트링 </Link> <br/>
            <Link to={"/view2/2/"+value} > 상세 페이지경로 </Link>
        </>)
}
function RouterQuery(props)
{
    const [searchParams, setSearchParams] = useSearchParams()
    console.log(searchParams)
    let bno = searchParams.get('bno')
    let value = searchParams.get("value")
    return (<> 상세페이지 쿼리 스트링 bno = {bno} value={value}</>)
}

function RouterPath(props)
{
    //console.log( useParams() )
    let params = useParams()
    let bno = params.bno
    let value = params.value
    return (<> 상세페이지 경로
    bno = {bno}
    value = {value}</>)
}