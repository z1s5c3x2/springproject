/*
* 컴포넌트 들을 연결하는 최상위 컴포넌트
*
* */
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Main from "./Main";
import Header from "./Header";
import Footer from "./Footer";
import Component2 from "./example/day01/2_component";
import Component3 from "./example/day01/3_component";
import Component4 from "./example/day01/4_component";
import CssComponent from "./example/day02/1_componentCss";
import CommentList from "./example/day02/CommentList";
import Component1 from "./example/day01/1_component";
import ExampleList from "./example/ExampleList";
import TodoList from "./assignment/assignment1/TodoList";
import Component5 from "./assignment/assignment2/5_component";
import Login from "./member/Login";
import Signup from "./member/Signup";
import AxiosComponent from "./example/day04/AxiosComponent";
import Info from "./member/Info";
import BoardList from "./board/BoardList";
import BoardWrite from "./board/BoardWrite";
import BoardView from "./board/BoardView";
import BoardUpdate from "./board/BoardUpdate";
import ProductAdmin from "./product/ProductAdmin";
import {createContext, useContext, useRef} from "react";
import {useSnackbar} from "notistack";

/*리액트 context 변수*/
export const SocketContext = createContext()

export default function Index(props ){

    const {enqueueSnackbar} = useSnackbar();
    // 2. 웹 소켓
    // ========================== 소켓 ===========================
    let clientSocket = useRef(null)
    if(!clientSocket.current)
    {
        clientSocket.current = new WebSocket("ws://localhost:80/chat")
        clientSocket.current.onopen = (e) => { console.log( e )}
        clientSocket.current.onerror = (e) => { console.log( e )}
        clientSocket.current.onclose = (e) => {console.log( e )}
        clientSocket.current.onmessage = (e) => { enqueueSnackbar('this is a success message!',{variant :'success'}) }
    }



    return(<>
        <div className="webContainer">
            <SocketContext.Provider value={clientSocket}>
                <BrowserRouter>
                    <Header> </Header>

                    <Routes>

                        <Route path='/' element={<Main/>}></Route>

                        <Route path='/example' element={<ExampleList/>}></Route>
                        <Route path='/example/day01/1_component' element={<Component1/>}></Route>
                        <Route path='/example/day01/2_component' element={<Component2/>}></Route>
                        <Route path='/example/day01/3_component' element={<Component3/>}></Route>
                        <Route path='/example/day01/4_component' element={<Component4/>}></Route>
                        <Route path='/example/day02/1_componentCss' element={<CssComponent/>}></Route>
                        <Route path='/example/day02/CommentList' element={<CommentList/>}></Route>

                        <Route path='/assignment/assignment1/TodoList' element={<TodoList/>}></Route>
                        <Route path='/assignment/assignment2/5_component' element={<Component5/>}></Route>
                        <Route path='/example/day04/AxiosComponent' element={<AxiosComponent/>}></Route>
                        <Route path='/login' element={<Login/>}> </Route>
                        <Route path='/signup' element={<Signup/>}> </Route>
                        <Route path='/Info' element={<Info/>}> </Route>
                        <Route path={"/board/list"} element={<BoardList/>}> </Route>
                        <Route path={"/board/write"} element={<BoardWrite/>}> </Route>
                        <Route path={"/board/view"} element={<BoardView/>}> </Route>
                        <Route path={"/board/update"} element={<BoardUpdate/>}> </Route>
                        <Route path={"/admin/product"} element={<ProductAdmin/>}> </Route>


                    </Routes>

                    <Footer></Footer>
                </BrowserRouter>
            </SocketContext.Provider>
        </div>
    </>)
}