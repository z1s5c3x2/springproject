import axios from "axios";
import Login from "./Login";
import {useEffect, useState} from "react";


export default function Info(props) {


    let [member, setMember] = useState(null)
    useEffect(() => {
        axios
            .get('/member/get')
            .then( r=> {
                console.log(r.data)
                   setMember(r.data)
                    console.log(member)
            }).catch( e=> {console.log(e)} )

    },[]);
    const inputChange = (e) =>{

       /* // spared operator
        // { ...객체명} , { ...객체명 , 속성명:값 }
        // setMember(changeMember)

        chg.e.target.className
        // 키참조 하나로 할라고?mphone*/

        if(e.target.className == 'mname') setMember({ ...member, mname:e.target.value } )
        else if(e.target.className == 'mphone')  setMember({ ...member, mphone:e.target.value } )
    }
    const onDelete = (e) =>{
        if(window.confirm('정말 탈퇴하시겠습니까?'))
        {
            axios.delete('/member/delete',{params :{'mno':member.mno}})
                .then( r=> { if(r.data){
                    alert('탈퇴 성공')
                    sessionStorage.removeItem('login_token')
                    window.location.href ="/";
                }else{
                    alert('탈퇴 실패')
                }})
                .catch( e=>{console.log(e)})
        }
    }
    let [pwd, setPwd] = useState({pwd1:'',pwd2:''})

    const onPut = (e)=>{
        if(pwd.pwd1== pwd.pwd2)
        {
            let info ={
                mno: member.mno,
                mname: member.mname,
                mpassword: pwd.pwd1,
                mphone: member.mphone
            }
            console.log(info)
            axios
                .put('/member/put',info)
                .then( r=>{
                    if(r.data){
                        sessionStorage.removeItem('login_token')
                        window.location.href ="/";
                    }
                })
                .catch( e=>{console.log(e)})
        }else{
            alert('비밀전호 불일치')
        }
    }
    const inputPwd = (e) =>{
        if(e.target.className == 'mpassword') setPwd({ ...pwd,pwd1:e.target.value})
        else setPwd({ ...pwd,pwd2:e.target.value})
    }
    return (<>
        <div className="loginContainer">
            <h2> 내정보 </h2>
            <form>
                회원 등급  <div> {member != null ? member.mrol : ''}</div>
                이메일 <input disabled={true} type="text " value={member != null ? member.memail: ''} placeholder="@포함 7~30글자"
                                  className="memail"/>

                새비밀번호 : <input type="password" onChange={inputPwd} value={pwd.pwd1} placeholder="특수문자 조합 5~30글자" className="mpassword"/>
                새비밀번호 확인 : <input type="password" onChange={inputPwd} value={pwd.pwd2} placeholder="특수문자 조합 5~30글자" className="mpassword2"/>

                이름 : <input type="text " value={member != null ? member.mname: ''} onChange={ inputChange } placeholder="이름" className="mname"/>
                전화번호 : <input type="text " value={member != null ? member.mphone:''} onChange={ inputChange } placeholder="연락처" className="mphone"/>
                <button onClick={onPut} type="button"> 정보 수정</button>
                <button onClick={onDelete} type="button"> 회원 탈퇴</button>
            </form>
        </div>
    </>)
}