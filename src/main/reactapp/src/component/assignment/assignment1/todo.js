function ToDo(props) {
    return (<>
        <div className="todo">
            <div className="tcontent"> {props.tcontent} </div>
            <div className="etcbtns">
                <button>"상태변경"</button>
                <button>"제거하기"</button>
            </div>
        </div>
    </>);
}

export default ToDo;
