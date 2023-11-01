import style from '../css/Login.css'
import {Link} from "react-router-dom";
import axios from "axios";

export default function Login(props) {

    function onLogin(e){ console.log(e);
        // 2. axios를 이용한 restApi 로 spring Controller 데이터 전달
        // 3. 데이터구성
        /*let info = {
            memail : document.querySelector('.memail').value ,
            mpassword : document.querySelector('.mpassword').value
        }; console.log(info);*/
        let loginForm = document.querySelectorAll('.loginFrom')[0]
        let loginFormData = new FormData(loginForm)
        // 4. !! AXIOS  통신  [ *SPRING CONTROLLER 매핑 확인후 ]
        axios
            .post( '/member/login' , loginFormData )
            .then( r => {
                if( r.data ){
                    console.log(r)
                    alert('로그인 성공');
                    window.location.href = '/';
                }
                else{  alert('로그인 실패'); }
            }).catch( e => {console.log(e) });
        // CORS policy 오류 발생 해결방안
        // - 스프링 controller 클래스 @CrossOrigin("http://localhost:3000")
    }



    return (<>
        <div className="loginContainer">
            <h3> ReactEzen LOGIN </h3>
            <form className={"loginFrom"}>
                아이디 <input type="text" placeholder="email address" name={"memail"} className="memail"/>
                비밀번호 <input type="password" placeholder="password" name={"mpassword"} className="mpassword"/>

                <Link to=''>아이디 찾기</Link>
                <Link to=''>비밀번호 찾기</Link>

                <button onClick={onLogin} type="button"> 로그인</button>
                <a className="oauthBtn" href={"/oauth2/authorization/kakao"}  > 카카오 로그인</a>
                <a className="oauthBtn" href={"/oauth2/authorization/naver"}  > 네이버 로그인</a>
                <a className="oauthBtn" href={"/oauth2/authorization/google"}  > 구글 로그인</a>
            </form>
        </div>
    </>)
}

/*
* <form>
                아이디 <input type="text" placeholder="email address" className="memail"/>
                비밀번호 <input type="password" placeholder="password" className="mpassword"/>

                <Link to=''>아이디 찾기</Link>
                <Link to=''>비밀번호 찾기</Link>

                <button onClick={onLogin} type="button"> 로그인</button>
            </form>
* */