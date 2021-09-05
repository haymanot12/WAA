
import React from 'react'

function Component3({increOrDecre, count}) {
    let increment = ()=>{
      increOrDecre(count+=5);

    }
    let decrement =()=>{
      increOrDecre(count-=5);
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
