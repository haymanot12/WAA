
import React from 'react'

function Component2({increOrDecre2, count2}) {
    let increment = ()=>{
      increOrDecre2(count2+=3);

    }
    let decrement =()=>{
      increOrDecre2(count2-=3);
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
