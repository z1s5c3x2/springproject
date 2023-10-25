import axios from "axios";
import Login from "./Login";


export default function Signup(props) {

    const onSignup = (e)=>{
        let info ={
            "memail" : document.querySelector('.memail').value,
            "mphone" : document.querySelector('.mphone').value,
            "mname": document.querySelector('.mname').value,
            "mpassword":document.querySelector('.mpassword').value
        }
        axios
            .post('/member/post',info)
            .then(r=>{
                if(r.data){ window.location.href='/member/Login'}
                else{alert('가입 실패')}
            })
            .catch(e =>{console.log(e)})
    }

    return (<>
        <div className="loginContainer">
        <h2> 회원가입 페이지 </h2>
        <form>
            이메일[아이디] : <input type="text " placeholder="@포함 7~30글자" className="memail"/>
            비밀번호 : <input type="password" placeholder="특수문자 조합 5~30글자" className="mpassword"/>
            비밀번호 확인 : <input type="password" placeholder="특수문자 조합 5~30글자" className="mpassword2"/>
            이름 : <input type="text " placeholder="이름"className="mname"/>
            전화번호 : <input type="text " placeholder="연락처" className="mphone"/>
            <button onClick={onSignup} type="button"> 회원가입</button>
        </form>
        </div>
    </>)
}