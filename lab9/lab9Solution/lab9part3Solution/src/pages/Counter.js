import React, {useState} from 'react';

export const Counter = ({value}) => {
  const [counter, setCounter] = useState(0);

  const increment = () => {
     setCounter(counter + value);
  }

  const decrement = () => {
     setCounter(counter - value);
  }

  let component = (
      <table>
        <tr>
          <th><h3>{counter}</h3></th>
        </tr>
        <tr>
          <td><button onClick={increment} >+ {value}</button></td>
          <td><button onClick={decrement} >- {value}</button></td>
        </tr>
      </table>
  );
  return component;
}