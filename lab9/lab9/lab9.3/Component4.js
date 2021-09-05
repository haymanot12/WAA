
import React from 'react'

function Component4({increOrDecre4, count4}) {
    let increment = ()=>{
      increOrDecre4(count4+=8);

    }
    let decrement =()=>{
      increOrDecre4(count4-=8);
    }

  return (
    <div>
      <header>
        <p>
            <button onClick={increment}>+8</button>
            <button onClick={decrement}>-8</button>
        </p>
      </header>
    </div>
  );
}

export default Component4;
