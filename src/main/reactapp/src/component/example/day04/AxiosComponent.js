/*
* axios react 라이브러리
* 터미널
*  npm install axios / 리액트 프로젝트내에서 설치
*
* 컴포넌트에서 사용
*  import
* */

import axios from "axios";

export default function AxiosComponent(props){

    // default function
    function function1(e)
    {
        console.log(e)
    }
    // arrow function
    const function2 =   (e) => {
        console.log(e)
    }
    function doGet(){
        axios.get('https://jsonplaceholder.typicode.com/posts').then( res=>{
            console.log(res)
        })
        axios.get('https://jsonplaceholder.typicode.com/posts/1')
            .then(result => {console.log(result)})

        axios
            .get('https://jsonplaceholder.typicode.com/comments?postId=1')
            .then(result => {console.log(result)})
        axios.get('https://jsonplaceholder.typicode.com/comments',{params :{
            'postId':1
        }})
            .then(result => {console.log(result.data)})
    }
    function doPost()
    {
        let saveInfo = { title: 'foo', body: 'bar',  userId: 1, }
        axios
            .post('https://jsonplaceholder.typicode.com/posts',saveInfo)
            .then(r=>{console.log(r.data)})
    }
    function doPut()
    {
        let updateInfo = {  id: 1,  title: 'updateFoo',  body: 'updateBar',   userId: 1 }
        axios
            .put('https://jsonplaceholder.typicode.com/posts/1',updateInfo)
            .then( result => {console.log(result.data)})
    }
    function doDelete()
    {
        axios
            .delete('https://jsonplaceholder.typicode.com/posts/1')
            .then(result => {console.log(result.data)})
    }

    const function3 =  (e,data) => {console.log(e);console.log(data)}

    return ( <>
        <h3> axios 테스트</h3>
        <button type="Button" onClick={function1}> func1 </button>
        <button type="Button" onClick={function2}> func2 </button>
        <button type="Button" onClick={e=> function3(e,3) }> func3 </button>

        <button type="button" onClick={doGet}> doget AXIOS </button>
        <button type="button" onClick={doPost}> doPost AXIOS </button>
        <button type="button" onClick={doPut}> doPut AXIOS </button>
        <button type="button" onClick={doDelete}> doDelete AXIOS </button>

    </>)
}