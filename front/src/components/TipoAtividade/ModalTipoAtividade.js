import React, { useState } from 'react';
import axios from 'axios';

const ModalTipoAtividade = ({ onClose }) => {
  const [nome, setNome] = useState('');
  const [status, setStatus] = useState(false);
  const [erro, setErro] = useState('');

  const handleNomeChange = (event) => {
    setNome(event.target.value);
  };

  const handleStatusChange = (event) => {
    setStatus(event.target.checked);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/api/tipoatividade', {
        nome,
        status,
      });
      // Lógica adicional, se necessário
      onClose();
    } catch (error) {
      console.error('Erro ao adicionar tipo de atividade:', error);
      setErro('Erro ao adicionar tipo de atividade. Por favor, tente novamente.');
    }
  };

  return (
    <div className="modal">
      <div className="modal-content">
        <h2>Adicionar Tipo de Atividade</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="nome">Nome:</label>
            <input type="text" id="nome" value={nome} onChange={handleNomeChange} />
          </div>
          <div className="form-group">
            <label htmlFor="status">Status:</label>
            <input type="checkbox" id="status" checked={status} onChange={handleStatusChange} />
          </div>
          {erro && <div className="mensagem-erro">{erro}</div>}
          <div className="buttons">
            <button type="submit" className="btn-salvar">
              Salvar
            </button>
            <button type="button" className="btn-fechar" onClick={onClose}>
              Fechar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ModalTipoAtividade;
