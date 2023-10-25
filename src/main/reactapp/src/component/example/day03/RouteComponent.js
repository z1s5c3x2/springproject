import {BrowserRouter,Routes,Route,Link}  from 'react-router-dom';
import Component1 from "../day01/1_component";
import Component2 from "../day01/2_component";
import Component3 from "../day01/3_component";
import Component4 from "../day01/4_component";

function RouteComponent(props)
{

    return ( <>

        <BrowserRouter>
            <StaticComponent></StaticComponent>
            <Routes>
                <Route path="/day01/1_component" element={<Component1/>}/>
                <Route path="/day01/2_component" element={<Component2/>}/>
                <Route path="/day01/3_component" element={<Component3/>}/>
                <Route path="/day01/4_component" element={<Component4/>}/>
            </Routes>
        </BrowserRouter>
    </> )
}
function StaticComponent(props)
{
    return (<>
        <div>
            <a href="/day01/1_component"> 컴포넌트1 </a>
            <a href="/day01/2_component"> 컴포넌트2 </a>
            <a href="/day01/3_component"> 컴포넌트3 </a>
            <a href="/day01/4_component"> 컴포넌트4 </a>
        </div>
        <div>
            <Link to='/day01/1_component'> 컴포넌트1 </Link>
            <Link to='/day01/2_component'> 컴포넌트2 </Link>
            <Link to='/day01/3_component'> 컴포넌트3 </Link>
            <Link to='/day01/4_component'> 컴포넌트4 </Link>
        </div>
    </>)
}
export default RouteComponent;


/*
*  라우터 가상 url 만들기
*  실제 라우터: 연결 경로를 자도응로 전환해주는 기계
* 리액트 라우터 : 가상 경로 [url]를 만들어서 컴포넌트를 전환해주는 라이브러리
* */