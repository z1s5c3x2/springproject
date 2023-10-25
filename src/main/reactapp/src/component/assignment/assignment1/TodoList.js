import style from './todo.css'
import Todo from "./Todo";

function TodoList(props) {
    let response = [{tcontent: "자바 배우기"},
        {tcontent: "리액트 배우기"},
        {tcontent: "파이썬 배우기"},
        {tcontent: "스프링 배우기"}]
    return (<>
        <div className="todowrap">
            <h1> 나만의 할일 목록 </h1>
            <div className="todo_top">
                <input className="tcontent" type="text"/>
                <button type="button"> 등록</button>
            </div>

            <div className="todo_bottom">
                {
                    response.map(r => {
                        return (<Todo tcontent={r.tcontent}/>)
                    })
                }
            </div>
        </div>
    </>);
}

export default TodoList;

