import logo from '../../../logo.svg'
import style from './Comment.css'
function Commnet( props ){
    

    return(<>
        <div className="Wrap">
            <div >
                <img src={logo} className="pimg" />
            </div>
            <div className="commentBox">
                <div className="commentName"> {props.name} </div>
                <div className="commentContent"> {props.content} </div>
            </div>
        </div>
    </>);
}
export default Commnet ;