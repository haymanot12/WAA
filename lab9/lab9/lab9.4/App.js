import './App.css';
import React, {useState} from 'react';
import {UpperComponent1} from './pages/UpperComponent1'
//import {UpperComponent2} from './pages/UpperComponent2'
import Component1 from './pages/Component1'
import Component2 from './pages/Component2'
import Component3 from './pages/Component3'
import Component4 from './pages/Component4'


function App() {
 
  let [count, setcount] = useState(0);
  
  return (
  
    <table>
        <tr ><UpperComponent1 count = {count}/></tr>

      <th><tr><UpperComponent1 count={count}/></tr><tr><Component1 increOrDecre={setcount} count={count}/></tr> 
      <tr><UpperComponent1 count={count}/></tr><tr><Component3 increOrDecre={setcount} count={count}/></tr>
      </th>
      <th> 
        <tr><UpperComponent1 count={count}/></tr><tr><Component2  increOrDecre={setcount} count={count}/></tr>
      <tr><UpperComponent1 count={count}/></tr><tr><Component4  increOrDecre={setcount} count={count}/></tr>
      </th>     
        </table>
  );
}

export default App;
