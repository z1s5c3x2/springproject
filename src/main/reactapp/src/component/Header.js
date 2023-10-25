import {Link} from "react-router-dom";
import  styles from "./css/Header.css";
export default function Header( props ){
    return(<>
        <header>
            <h2> <Link to='/' >이젠리액트 </Link> </h2>
            <ul className="topMenu">
                <li> <Link to='/example' >리액트예제 </Link> </li>
                <li> <Link to='/' > TODO  </Link> </li>
                <li> <Link to='/' > 비회원 게시판 </Link> </li>
                <li> <Link to='/' > 회원 게시판 </Link> </li>

                <li> <Link to='/member/login' >로그인  </Link> </li>
                <li> <Link to='/member/signup' > 회원가입 </Link> </li>
                <li> <Link to='/' > 로그아웃 </Link> </li>
            </ul>
        </header>
        </>)
}
