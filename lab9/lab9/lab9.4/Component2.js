
import React from 'react'

function Component2({increOrDecre, count}) {
    let increment = ()=>{
      increOrDecre(count+=3);

    }
    let decrement =()=>{
      increOrDecre(count-=3);
    }

  return (
    <div>
      <header>
        <p>
            <button onClick={increment}>+3</button>
            <button onClick={decrement}>-3</button>
        </p>
      </header>
    </div>
  );
}

export default Component2;
