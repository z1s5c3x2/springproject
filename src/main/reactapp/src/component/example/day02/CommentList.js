import Commnet from "./Comment";
function CommentList( props ){
    let response = [{name:'유재석',content:'안녕하세요3'},
        {name:'강호동',content:'안녕하세요1'},
        {name:'신동엽',content:'안녕하세요2'}]

    return(<>
        <div className="CommentListBox">
            {
                response.map( c=>{
                    return (<Commnet name={ c.name } content={ c.content } />)
                })
            }
        </div>
    </>);
}
export default CommentList ;