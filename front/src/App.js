import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import MyMenu from './components/Menu';
import './styles/app.css';
import Header from './components/Header';
import Home from './components/Home';
import Sala from './components/Sala';
import Paroquiano from './components/Paroquiano';

function App() {
  return (
    <Router>
      <div>
        <MyMenu></MyMenu>
        <Header></Header>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/sala" element={<Sala />} />
          <Route path='/paroquiano' element={<Paroquiano></Paroquiano>}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;