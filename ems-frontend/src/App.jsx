import { useState } from 'react'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* localhost:3000 */}
            <Route path='/' element={ <ListEmployeeComponent />}></Route>
            {/* localhost:3000/employees */}
            <Route path='/employees' element={ <ListEmployeeComponent /> }></Route>

            <Route path='/addEmployee' element={ <EmployeeComponent /> }></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </div>
  )
}

export default App
