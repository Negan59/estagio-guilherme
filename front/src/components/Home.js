import React from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import '../styles/home.css';

const Home = () => {
  const handleDateChange = (date) => {
    console.log('Data selecionada:', date);
  };

  return (
    <div className="home-container">
      <h1 className="home-title">Bem-vindo à Página Inicial</h1>
      <div className="calendar-container">
        <Calendar onChange={handleDateChange} />
      </div>
    </div>
  );
};

export default Home;