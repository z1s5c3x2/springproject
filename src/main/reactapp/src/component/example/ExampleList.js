import {Link} from "react-router-dom";
import Component1 from "./day01/1_component";

export default function ExampleList( props ){
    return(<>
        <div
            style={ {display:'flex',justifyContent:'space-between' }}
        >

            <Link to='/example/day01/1_component' > 컴포넌트 1 예제 </Link>
            <Link to='/example/day01/2_component' > 컴포넌트 2 예제 </Link>
            <Link to='/example/day01/3_component' > 컴포넌트 3 예제 </Link>
            <Link to='/example/day01/4_component' > 컴포넌트 4 예제 </Link>
            <Link to='/example/day02/1_componentCss' > 컴포넌트Css 예제 </Link>
            <Link to='/example/day02/CommentList' > 댓글리스트 예제 </Link>
            <Link to='/assignment/assignment1/TodoList' > 과제1 </Link>
            <Link to='/assignment/assignment2/5_component' > 과제2 </Link>
            <Link to='/example/day04/AxiosComponent' > axios 예제 </Link>
            
            
        </div>
    </>)
}