import style from '../css/Login.css'
import {Link} from "react-router-dom";
import axios from "axios";

export default function Login(props) {

    function onLogin(e){
        let info = {
            memail : document.querySelector('.memail').value,
            mpassword : document.querySelector('.mpassword').value,
        }
        axios
            .post('/member/login',info)
            .then( r=> {
                if(r.data){ window.location.href='/'}
                else{alert('로그인 실패')}
            })
            .catch(e =>{console.log(e)})
        console.log(info)
    }


    return (<>
        <div className="loginContainer">
            <h2> 로그인 페이지 </h2>
            <form>
                아이디 <input type="text" placeholder="email address" className="memail"/>
                비밀번호 <input type="password" placeholder="password" className="mpassword"/>

                <Link to=''>아이디 찾기</Link>
                <Link to=''>비밀번호 찾기</Link>

                <button onClick={onLogin} type="button"> 로그인</button>
            </form>
        </div>
    </>)
}