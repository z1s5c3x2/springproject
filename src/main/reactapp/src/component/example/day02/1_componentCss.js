import style from './com.css';
export default function CssComponent(props)
{
    //1 css를 객체에 속성으로 선언하기
    const cssStyle = {
        backgroundColor : '#c4b5fd',
        width : '500px',height : '200px', margin: '0 auto'
    }
    return (<>
        <div style={cssStyle}> css적용방법1 </div>
        <div style={{
            backgroundColor : 'silver',
            width : '500px',height : '200px', margin: '0 auto'
        }} > css적용방법2 </div>
        <div class="box3"> css적용방법3 </div>
    </>);
}