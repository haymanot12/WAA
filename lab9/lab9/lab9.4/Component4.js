
import React from 'react'

function Component4({increOrDecre, count}) {
    let increment = ()=>{
      increOrDecre(count+=8);

    }
    let decrement =()=>{
      increOrDecre(count-=8);
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
