import {Counter} from './pages/Counter';
import './App.css';

function App() {
  return (
    <table>
    <tr>
      <td><Counter value={1} /></td>
      <td><Counter value={3} /></td>
    </tr>
    <tr>
      <td><Counter value={5} /></td>
      <td><Counter value={8} /></td>
    </tr>
  </table>
  );
}

export default App;
