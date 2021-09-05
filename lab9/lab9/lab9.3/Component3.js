
import React from 'react'

function Component3({increOrDecre3, count3}) {
    let increment = ()=>{
      increOrDecre3(count3+=5);

    }
    let decrement =()=>{
      increOrDecre3(count3-=5);
    }

  return (
    <div>
      <header>
        <p>
            <button onClick={increment}>+5</button>
            <button onClick={decrement}>-5</button>
        </p>
      </header>
    </div>
  );
}

export default Component3;
