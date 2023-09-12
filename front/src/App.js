import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import MyMenu from './components/Menu';
import './styles/app.css';
import Header from './components/Header';
import Home from './components/Home';
import Sala from './components/Sala/Sala';
import Paroquiano from './components/Paroquiano/Paroquiano';
import Pastoral from './components/Pastoral/Pastoral';
import Local from './components/Local/Local';
import TipoAtividade from './components/TipoAtividade/TipoAtividade'
import Aluguel from './components/Aluguel/Aluguel';
import Evento from './components/Evento/Evento';
import Funcionario from './components/Funcionario/Funcionario';
import Padre from './components/Padre/Padre';
import ItensSalaoParoquial from './components/ItensSalaoParoquial/ItensSalaoParoquial';

function App() {
  return (
    <Router>
      <div>
        <MyMenu></MyMenu>
        <Header></Header>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/aluguel" element={<Aluguel />} />
          <Route path="/evento" element={<Evento />} />
          <Route path="/funcionario" element={<Funcionario />} />
          <Route path="/itemsalao" element={<ItensSalaoParoquial />} />
          <Route path="/local" element={<Local />} />
          <Route path="/sala" element={<Sala />} />
          <Route path='/padre' element={<Padre></Padre>}></Route>
          <Route path='/paroquiano' element={<Paroquiano></Paroquiano>}></Route>
          <Route path='/pastoral' element={<Pastoral></Pastoral>}></Route>
          <Route path='/tipoatividade' element={<TipoAtividade></TipoAtividade>}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;