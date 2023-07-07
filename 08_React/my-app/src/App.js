import './App.css';

// components 폴더의 Exam1.js를 가져와서 사용
// 사용할 때 이름을 Ex1으로 지정
import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';

import PropsEx from './components/R01_props';
import State1 from './components/R02_state1';
import State2 from './components/R03_state2';
import State3 from './components/R04_state3';
import TodoList1 from './components/R05_todolist1';
import ContextApi from './components/R06_context_api'

function App() {
  /* jsx 표기법 = 자바스크립트 + xml */
  
      // 리액트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있음
      // -> 여러 요소를 반환하고 싶을 때는 부모 요소로 묶어줘야 함
  return (

    /* fragment ( <> </> ) : 반환되는 요소를 감쌀 때 사용, 해석 안됨 (th:block)과 유사하다고 생각하면 됨 */
    <>
    {/* jsx 주석 */}
      {/* <h1>Hello React!</h1>
      <div>와 리액트다</div> */}
      {/* <Ex1 /> */}
      {/* <Ex2 /> */}

{/*  <PropsEx name={'홍길동'} />
    <PropsEx name={'김길동'} />
    <PropsEx name={'박재격'} /> */}

    {/* R02_state1 */}
    {/* <State1/> */}


    {/* R03_state2*/}
    {/* <State2 init={100}/> */}

    {/* R04_state3*/}
    {/* <hr/>   */}
    {/* <State3/> */}


    {/* R05_todolist1 */}
    {/* <TodoList1/> */}

    {/* R06_context_api */}
    <ContextApi/>

    </>
  );
}

export default App;
