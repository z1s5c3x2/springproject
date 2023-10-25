import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

import App from './App';
import reportWebVitals from './reportWebVitals';
/*import Component1 from "./component/example/day01/1_component.jsx";
import Component2 from "./component/example/day01/2_component";
import Component3 from "./component/example/day01/3_component";
import Component4 from "./component/example/day01/4_component";
import Component5 from "./component/example/day01/5_component";
import CssComponent from "./component/example/day02/1_componentCss";
import CommentList from "./component/example/day02/CommentList";
import ToDoList from "./component/assignment/assignment1/todoList";
import RouteComponent from "./component/example/day04/RouteComponent";*/
import Index from "./component/Index";

//3 내가 만든 컴포넌트 (jsx파일내 함수) 호출


// inddx.html에 div id =root dom객체 호출
const root = ReactDOM.createRoot(document.getElementById('root'));
// 리액트 랜더링 ( JSX -> html 변환)
//root.render(<React.StrictMode> <Component1 /> </React.StrictMode>);
//root.render(<React.StrictMode> <Component2 /> </React.StrictMode>);
//root.render(<React.StrictMode> <Component3 /> </React.StrictMode>);
//root.render(<React.StrictMode> <Component4 /> </React.StrictMode>);
root.render(<React.StrictMode> <Index /> </React.StrictMode>);


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
