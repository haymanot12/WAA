import React from 'react';

export const ButtonComponent = ({message}) => {
  const displayAlert = () => {
    alert(message);
  }

  let buttonComponent = (
     <button onClick={displayAlert} >Say {message}</button>
  );
  return buttonComponent;
}