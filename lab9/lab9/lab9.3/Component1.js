import React from 'react'


function Component1({increOrDecre,count1}) {


    let increment = ()=>{
      increOrDecre(count1++);

    }
    let decrement =()=>{

     increOrDecre(count1--);
    
    }

  return (
    <div>
      <header>
        <p>
            <button onClick={increment}>+1</button>
            <button onClick={decrement}>-1</button>
        </p>
      </header>
    </div>
  );
}

export default Component1;
