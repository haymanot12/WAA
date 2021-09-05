import './App.css';
import React, {useState} from 'react';
import {UpperComponent1} from './pages/UpperComponent1'
import {UpperComponent2} from './pages/UpperComponent2'
import {UpperComponent3} from './pages/UpperComponent3'
import {UpperComponent4} from './pages/UpperComponent4'
import Component1 from './pages/Component1'
import Component2 from './pages/Component2'
import Component3 from './pages/Component3'
import Component4 from './pages/Component4'


function App() {
 
  let [count1, setcount1] = useState(0);
  let [count2, setcount2] = useState(0);
  let [count3, setcount3] = useState(0);
  let [count4, setcount4] = useState(0);
  
  return (
  
    <table>
        
      <th><tr><UpperComponent1 count1={count1}/></tr><tr><Component1 increOrDecre={setcount1} count1={count1}/></tr> 
      <tr><UpperComponent3 count3={count3} /></tr><tr><Component3 increOrDecre3={setcount3} count3={count3}/></tr>
      </th>
      <th> 
      <tr><UpperComponent2 count2={count2}/></tr><tr><Component2  increOrDecre2={setcount2} count2={count2}/></tr>
      <tr><UpperComponent4 count4={count4}/></tr><tr><Component4  increOrDecre4={setcount4} count4={count4}/></tr>
      </th>     
        </table>
  );
}

export default App;
