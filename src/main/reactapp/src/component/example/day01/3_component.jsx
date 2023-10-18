/*컴포넌트 내부에서 다른 컴포넌트를 호출하는 방법
* 1.같은 jsx 파일이면 import 생략
* 2.다른 jsx 파일이면 import*/

function Component3(){

    return (<> <h3> 컴포넌트3 컴포넌트에서 작성된 html</h3>
    <CreateTag />
        {/*다른 함수를 호출하는 방법*/}

    <input />
        {CreateTag()}
    </>)
}
function CreateTag()
{
    return (<> <div> 내가 만든태그 컴포넌트에서 작성된 html </div> </>)
}
export default Component3
